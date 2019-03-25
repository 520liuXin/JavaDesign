package com.example.cy.bean;

import com.example.cy.enums.CarEnum;
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
    private Long rent;   //租金

    @Column(length = 255)
    private Long heatValue=100L;    //热度值

//    @Column(length = 255)
//    private Integer carNumber;  //库存数量

    @OneToMany(fetch = FetchType.LAZY,targetEntity=FileInfo.class,mappedBy="car")
    private List<FileInfo> fileInfos=new ArrayList<>();  //汽车图片

    private Integer state=CarEnum.STSTE_NO_RENT_OUT.getCode();
}
