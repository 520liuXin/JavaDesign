package com.example.cy.bean;

import com.example.cy.enums.CarEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity(name="car")
public class Car extends BasePo{

    @Column(length = 255)
    private String carName;       //汽车名

    @Column(length  =255)
    private String carId;        //车牌


    @Column(length = 255)
    private String carBrand;     //汽车品牌


    @Column(length = 255)
    private String carType;       //类型


    @Column(length = 255)
    private String color;        //颜色

    @Column(length = 255)
    private Long rent;   //租金/售价

    @Column(length = 255)
    private Long heatValue=100L;    //热度值

    @Column(length = 255)
    private String carSource;   //车辆来源 1.个人车辆，2.店家直营

    private Long sourceUserId;   //添加车辆用户

    //@JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,targetEntity=FileInfo.class,mappedBy="car")
    private List<FileInfo> carImgUrl=new ArrayList<>();  //汽车图片

    private Integer state=CarEnum.STSTE_NO_RENT_OUT.getCode();//车辆状态

    private String displacement;  //排量 （ 1.4L~1.5L）

    private String fuelConsumption; //油耗 （15L）

    private String engine;  //发动机（200匹）

    private String driveWay;// 驱动方式（四驱）

    private String ridingNumber; //可程人数 （五人）

    private String carDescribe;  //车辆描述

    private String fuzzyQuery;//适用于模糊查询



}
