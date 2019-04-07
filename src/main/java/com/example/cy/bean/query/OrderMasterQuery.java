package com.example.cy.bean.query;

import com.example.cy.enums.OrderStatusEnum;

import javax.persistence.Column;
import java.util.Date;

public class OrderMasterQuery {
    private String orderId;//订单号

    private String userName; //用户名

    private String carName;       //汽车名

    private String carImgUrl;  //车辆图片

    private Long carRent;           //租金

    private Long userrId;   //用户Id

    private Long carId;         //车辆id

    private Integer orderStatus ;//状态

    private Integer leaseDay;   //租赁天数

    private Date startDate;  //车辆租赁起始时间

    private Date endDate; //车辆租赁终止时间

    private Long buyerAmount; /** 订单总金额. */
}
