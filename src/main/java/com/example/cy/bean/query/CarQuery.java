package com.example.cy.bean.query;

import com.example.cy.bean.FileInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class CarQuery {


    private Long id;

    private String carName;       //汽车名

    private String carId;        //车牌

    private String fileInfoUrl;  //汽车图片

    private String carBrand;     //汽车品牌


    private String carType;       //类型


    private String color;        //颜色
    private String carSource;   //车辆来源 1.个人车辆，2.店家直营

    private Long rent;   //租金

    private Integer state;
    private String engine;  //发动机（200匹）

    private Long heatValue;  //热度值

    private Date createdDate; //创建时间


}
