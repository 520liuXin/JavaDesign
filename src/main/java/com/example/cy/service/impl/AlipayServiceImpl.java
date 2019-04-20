package com.example.cy.service.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.example.cy.bean.Car;
import com.example.cy.bean.OrderMaster;
import com.example.cy.config.AlipayConfig;
import com.example.cy.dao.CarDao;
import com.example.cy.service.AlipayService;
import com.example.cy.service.CarService;
import com.example.cy.utils.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class AlipayServiceImpl implements AlipayService {
    @Autowired
    private CarDao carDao;
    @Autowired
            private CarService carService;

    // 获取配置文件的信息
    String app_id = AlipayConfig.app_id;
    String private_key = AlipayConfig.private_key;
    String notify_url = AlipayConfig.notify_url;
    String return_url = AlipayConfig.return_url;
    String url = AlipayConfig.url;
    String charset = AlipayConfig.charset;
    String format = AlipayConfig.format;
    String public_key = AlipayConfig.public_key;
    String signtype = AlipayConfig.signtype;

    @Override
    public void pay(HttpServletRequest request, HttpServletResponse response, OrderMaster orderMaster) throws Exception{

        String subject = "租车费用"; // 订单名称
        Car car=carDao.findCarById(orderMaster.getCarId());
        String body =car.getCarDescribe(); // 商品描述

        // 封装请求客户端
        AlipayClient client = new DefaultAlipayClient(url, app_id, private_key, format, charset, public_key, signtype);

        // 支付请求
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);
        AlipayTradePayModel model = new AlipayTradePayModel();
        model.setProductCode("FAST_INSTANT_TRADE_PAY"); // 设置销售产品码
        model.setOutTradeNo(orderMaster.getOrderId()); // 设置订单号
        model.setSubject(subject); // 订单名称
        model.setTotalAmount(orderMaster.getBuyerAmount()+""); // 支付总金额
        model.setBody(body); // 设置商品描述
        alipayRequest.setBizModel(model);

        String form = client.pageExecute(alipayRequest).getBody(); // 生成表单

        response.setContentType("text/html;charset=" + charset);
        response.getWriter().write(form); // 直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();

    }
    @Transactional
    @Override
    public ResponseInfo<?> notifyUrl(HttpServletRequest request) throws Exception{
        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, public_key, charset, signtype); // 调用SDK验证签名

        if (signVerified) { // 验证成功 更新订单信息
            System.out.println("异步通知成功");
            // 商户订单号
            String out_trade_no = request.getParameter("out_trade_no");
            // 交易状态
            String trade_status = request.getParameter("trade_status");
            // 修改数据库

            return ResponseInfo.success("支付成功");
        } else {
            System.out.println("异步通知失败");
            return ResponseInfo.success("支付失败");
        }
    }
}
