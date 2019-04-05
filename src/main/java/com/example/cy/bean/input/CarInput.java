package com.example.cy.bean.input;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
@Data
public class CarInput {



    private String carName;       //汽车名


    private String carId;        //车牌



    private String carBrand;     //汽车品牌



    private String carType;       //类型

    private Integer state;  //车辆状态

    private String color;        //颜色


    private Long rent;   //租金

    private Long minRent;  //最小租金

    private Long maxRent;   //最大租金（用于查询一定范围内租金）

    private Date starCreateDate;  //最开始创建时间

    private Date endCreateDate;  //最后创建时间（用于查询某时间段上架车辆）




}
