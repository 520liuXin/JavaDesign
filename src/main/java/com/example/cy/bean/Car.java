package com.example.cy.bean;

import com.example.cy.enums.CarEnum;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
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
    private Integer carNumber;  //库存数量


    @Column(length = 255)
    private Long rent;   //租金

    @OneToMany(fetch = FetchType.LAZY,targetEntity=FileInfo.class,mappedBy="car")
    private Set<FileInfo> fileInfos=new HashSet<>();  //汽车图片

    @Column(length = 255)
    private Long heatValue=CarEnum.NEW_HEAT_VALUE.getCode();    //热度值
}
