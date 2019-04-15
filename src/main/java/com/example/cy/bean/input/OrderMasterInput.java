package com.example.cy.bean.input;

import lombok.Data;

import java.util.Date;

@Data
public class OrderMasterInput {
    private String orderId;//订单号

    private String userName; //用户名

    private String carName;       //汽车名


    private Long carRent;           //租金

    private Long userId;   //用户Id

    private Long carId;         //车辆id

    private Integer orderStatus ;//状态

    private Date createdDate;

    private Date startDate;  //订单创建开始时间

    private Date endDate; //订单创建结束时间（用于查询一定时间内订单）

    private Long buyerAmount; /** 订单总金额. */
}
