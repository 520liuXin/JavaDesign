package com.example.cy.bean;

import com.example.cy.enums.OrderStatusEnum;
import com.example.cy.enums.SendCarEnum;
import javafx.beans.property.SimpleLongProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity(name="order_master")
public class OrderMaster extends BasePo{

    /** 订单号 */
    @Column(length = 255)
    private String orderId;

    @Column(length = 255)
    private Long userId;   //用户Id

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
    private String carImgUrl;  //车辆图片

    @Column(length = 255)
    private Long carRent;           //租金

    @Column(length = 255)
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    @Column(length = 255)
    private Integer leaseDay;   //租赁天数

    private Date startDate;  //车辆租赁起始时间

    private Date endDate; //车辆租赁终止时间

    private String detailedAddress; //详细地址

    private Integer sendCar=SendCarEnum.NO.getCode();  // 是否送车上门（if true 加50块钱）

    @Column(length = 255)
    private Long buyerAmount; /** 订单总金额. */

}
