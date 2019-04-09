package com.example.cy.bean.input;

import lombok.Data;

import java.util.Date;
@Data
public class UserInput {


    private Long id;


    private  String username;

    private String phone;


    private String imgurl;

    private String admin;

    private String sex;

    private  String idCard;

    private Date starCreateDate;  //最开始创建时间

    private Date endCreateDate;  //最后创建时间（用于查询某时间段新增用户）

}
