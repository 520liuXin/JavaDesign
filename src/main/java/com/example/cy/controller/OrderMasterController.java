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
import com.example.cy.enums.SendCarEnum;
import com.example.cy.security.SecurityUtils;
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
import org.springframework.web.bind.annotation.*;

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



    /**
     * @Author able-liu
     * @Description 生成订单
     * @Param
     * @return
     **/

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public  ResponseInfo<?> createOrder(@RequestBody JSONObject params){
        OrderMaster orderMaster=new OrderMaster();

        String username=params.getString("username");
        String carId=params.getString("id");
        String  startTime=params.getString("startTime");
        String  endTime=params.getString("endTime");
        String getCar=params.getString("getCar");
        String detailedAddress=params.getString("address");
        String price=params.getString("price");

        if(detailedAddress.isEmpty()){
            orderMaster.setSendCar(SendCarEnum.NO.getCode());
        }
        orderMaster.setDetailedAddress(detailedAddress);
        orderMaster.setSendCar(SendCarEnum.YES.getCode());

        User user=userDao.findUser(username);
        userToOrder(user,orderMaster);
        Car car=carDao.findCarById(Long.parseLong(carId));
        carToOeder(car,orderMaster);

        Date StartTime=DateUtils.strToDate(startTime);
        Date EndTime=DateUtils.strToDate(endTime);

        int days=DateUtils.daysBetween(StartTime,EndTime)+1;
        if (days<=0){
            ResponseInfo.error("租赁时间不可小于0天");
        }

        orderMaster.setLeaseDay(days);
        orderMaster.setStartDate(StartTime);
        orderMaster.setEndDate(EndTime);
        orderMaster.setBuyerAmount(days*orderMaster.getCarRent());

        orderMasterService.creatOrder(orderMaster);
        return ResponseInfo.success(orderMaster);
    }




    /**
     * @Author able-liu
     * @Description 取消订单
     * @Param
     * @return
     **/


    @GetMapping("/info")
    public ResponseInfo<?> orderinfo(){
        User user=SecurityUtils.getUser();
        List<OrderMasterQuery> list=orderMasterService.findOrderByUserId(user.getId());
         return ResponseInfo.success(list);
    }


    /**
     * @Author able-liu
     * @Description /获取订单并分页可提供指定查询分页
     * @Param
     * @return
     **/
    @RequestMapping(value = "/findAllAndPage", method = RequestMethod.GET)
    public ResponseInfo<?> AllfindAllAndPage (@PageableDefault(page = 1, size = 5) Pageable pageable, OrderMasterInput input){
        int pageNumber = pageable.getPageNumber();
        pageNumber = pageNumber <= 0 ? 1 : pageNumber;
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
        if(Calibration.isNotEmpty(car.getCarImgUrl())){
            List<FileInfo> fileInfos=car.getCarImgUrl();
            orderMaster.setCarImgUrl(fileInfos.get(0).getUrl());
        }
        return orderMaster;
    }


}
