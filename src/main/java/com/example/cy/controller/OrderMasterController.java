package com.example.cy.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.cy.bean.Car;
import com.example.cy.bean.FileInfo;
import com.example.cy.bean.OrderMaster;
import com.example.cy.bean.User;
import com.example.cy.bean.input.OrderMasterInput;
import com.example.cy.bean.query.OrderMasterQuery;
import com.example.cy.dao.CarDao;
import com.example.cy.dao.OrderMasterDao;
import com.example.cy.dao.UserDao;
import com.example.cy.enums.CarEnum;
import com.example.cy.enums.OrderStatusEnum;
import com.example.cy.enums.SendCarEnum;
import com.example.cy.security.SecurityUtils;
import com.example.cy.service.AlipayService;
import com.example.cy.service.CarService;
import com.example.cy.service.OrderMasterService;
import com.example.cy.utils.Calibration;
import com.example.cy.utils.DateUtils;
import com.example.cy.utils.ResponseInfo;
import com.example.cy.utils.page.CommonResponsePage;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderMasterController {


    @Autowired
    private UserDao userDao;

    @Autowired
    private CarDao carDao;

    @Autowired
    private OrderMasterService orderMasterService;

    @Autowired
    private OrderMasterDao orderMasterDao;

    @Autowired
    private AlipayService alipayService;

    @Autowired
    private CarService carService;



    /**
     * @Author able-liu
     * @Description 生成订单
     * @Param
     * @return
     **/

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public ModelAndView createOrder( @RequestBody JSONObject params)throws Exception{
        OrderMaster orderMaster=new OrderMaster();

        String carId=params.getString("id");
        String  startTime=params.getString("startTime");
        String  endTime=params.getString("endTime");
        String detailedAddress=params.getString("address");
        String price=params.getString("price");
        if(detailedAddress.isEmpty()){
            orderMaster.setSendCar(SendCarEnum.NO.getCode());
        }else {
            orderMaster.setDetailedAddress(detailedAddress);
            orderMaster.setSendCar(SendCarEnum.YES.getCode());
        }
        orderMaster.setDetailedAddress(detailedAddress);
        orderMaster.setSendCar(SendCarEnum.YES.getCode());

        User user=SecurityUtils.getUser();
        if(user==null){
            ResponseInfo.error("用户未登录，请登录");
        }
        userToOrder(user,orderMaster);
        Car car=carDao.findCarById(Long.parseLong(carId));
        carToOeder(car,orderMaster);

        Date StartTime=DateUtils.strToDate(startTime);
        Date EndTime=DateUtils.strToDate(endTime);

        int days=DateUtils.daysBetween(StartTime,EndTime);
        if (days<=0){
            ResponseInfo.error("租赁时间不可小于0天");
        }

        orderMaster.setLeaseDay(days);
        orderMaster.setStartDate(StartTime);
        orderMaster.setEndDate(EndTime);
        orderMaster.setBuyerAmount(Long.parseLong(price));

        orderMasterService.creatOrder(orderMaster);
        ModelAndView mv = new ModelAndView();
        String orderId=orderMaster.getOrderId();
        //mv.addObject("orderMaster", orderId);
       mv.setViewName("redirect:/alipay/pay?orderId="+orderId+"");
        return mv;
    }


    /**
     * 修改订单
     * @param orderMaster
     * @return
     */
    @RequestMapping(value = "/updataOrder", method = RequestMethod.POST)
    public ResponseInfo<?> updataOrder(OrderMaster orderMaster){

        OrderMaster oldOrderMaster=orderMasterDao.findByOrderId(orderMaster.getOrderId());
        if(oldOrderMaster==null){
            return ResponseInfo.error("订单不存在");
        }
        OrderMaster newdata=orderMasterService.updataOrder(orderMaster);
        if(newdata==null){
            return ResponseInfo.error("更新失败");
        }
        return ResponseInfo.success("更新成功");


    }


    /**
     * 删除订单
     * @param
     * @return
     */
    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    public ResponseInfo<?> deleteOrder(@RequestBody JSONObject params) {

        String orderId=params.getString("orderId");
        OrderMaster oldOrderMaster = orderMasterDao.findByOrderId(orderId);
        if (oldOrderMaster == null) {
            return ResponseInfo.error("订单不存在");
        }
        if(!OrderStatusEnum.FINISH.getCode().equals(oldOrderMaster.getOrderStatus())){
            return ResponseInfo.error("订单未完成，不可删除订单");
        }
        try {
            orderMasterService.deleteOrder(oldOrderMaster);
        } catch (Exception e) {
           return ResponseInfo.error("删除失败");
        }
       return ResponseInfo.success("删除成功");
    }


    /***
     * 还车
     * @param
     * @return
     */
    @Transactional
    @RequestMapping(value = "/repayCar", method = RequestMethod.POST)
    public ResponseInfo<?> repayCar(@RequestBody JSONObject params) {

        String orderId=params.getString("orderId");
        OrderMaster oldOrderMaster = orderMasterDao.findByOrderId(orderId);
        if (oldOrderMaster == null) {
            return ResponseInfo.error("订单不存在");
        }
       int i =DateUtils.daysBetween(oldOrderMaster.getEndDate(),new Date());
        if (SecurityUtils.getUser().getAdmin().equals(2L)) {
            if(i>0){
                return  ResponseInfo.error("租赁时间超长，请于管理员联系付清租赁费用才可还车！！！");
            }
        }
        try{
            oldOrderMaster.setOrderStatus(OrderStatusEnum.FINISH.getCode());
            orderMasterService.updataOrder(oldOrderMaster);
            Car newcar=carDao.findCarById(oldOrderMaster.getCarId());
            newcar.setState(CarEnum.STSTE_NO_RENT_OUT.getCode());
            carService.updataCar(newcar);
            return ResponseInfo.success("还车成功");
        }catch (Exception e){
            return ResponseInfo.error("还车失败，请稍后重试");
        }

    }




    /**
     * @Author able-liu
     * @Description /获取订单并分页可提供指定查询分页
     * @Param
     * @return
     **/
    @RequestMapping(value = "/findAllAndPage", method = RequestMethod.GET)
    public ResponseInfo<?> findOrderAndPage (@PageableDefault(page = 1, size = 4) Pageable pageable, OrderMasterInput input){
        int pageNumber = pageable.getPageNumber();
        pageNumber = pageNumber <= 0 ? 1 : pageNumber;
        User user=SecurityUtils.getUser();
        if(user.getAdmin().equals(2L)){
            input.setUserId(user.getId());
        }
        Pageable page = new PageRequest(pageNumber - 1, pageable.getPageSize(), Sort.Direction.DESC, "createdDate");
        CommonResponsePage<OrderMasterQuery> datas = orderMasterService.findOrderMasterAndPage(page, input);
        return ResponseInfo.success(datas);
    }


    private OrderMaster userToOrder(User user,OrderMaster orderMaster){
        orderMaster.setUserId(user.getId());
        orderMaster.setUserIdCard(user.getIdCard());
        orderMaster.setUserName(user.getUsername());
        orderMaster.setUserPhone(user.getPhone());
        return orderMaster;
    }

    private OrderMaster carToOeder(Car car,OrderMaster orderMaster){
        orderMaster.setCarBrand(car.getCarBrand());
        orderMaster.setCarColor(car.getColor());
        orderMaster.setCarId(car.getId());
        orderMaster.setCarName(car.getCarName());
        orderMaster.setCarRent(car.getRent());
        orderMaster.setCarType(car.getCarType());
        orderMaster.setCarDescribe(car.getCarDescribe());
        if(Calibration.isNotEmpty(car.getCarImgUrl())){
            List<FileInfo> fileInfos=car.getCarImgUrl();
            orderMaster.setCarImgUrl(fileInfos.get(0).getUrl());
        }

        return orderMaster;
    }


}
