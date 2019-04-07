package com.example.cy.bean;

import com.example.cy.enums.OrderStatusEnum;

import javax.persistence.Column;
import java.math.BigDecimal;

public class Transaction extends BasePo{
    /** 订单号 */
    @Column(length = 255)
    private String orderId;

    @Column(length = 255)
    private Long userrId;   //用户Id

    /** 买家名字. */
    @Column(length = 255)
    private String userName; //用户名

    /** 买家电话. */
    @Column(length = 255)
    private String userPhone;  //用户手机

    @Column(length = 255)
    private String userIdCard;  //用户身份证

    @Column(length = 255)
    private Long carId;         //车辆id

    @Column(length = 255)
    private String carName;       //汽车名

    @Column(length = 255)
    private String carBrand;     //汽车品牌

    @Column(length = 255)
    private String carType;       //类型

    @Column(length = 255)
    private String carColor;        //颜色

    @Column(length = 255)
    private Long carRent;           //租金

    @Column(length = 255)
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    @Column(length = 255)
    private Integer leaseDay;   //租赁天数

    @Column(length = 255)
    private BigDecimal buyerAmount; /** 订单总金额. */
}
