package com.example.cy.bean.query;

import com.example.cy.bean.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserQuery  {

    private Long id;


    private  String username;

    private String phone;


    private String imgurl;

    private String admin;

    private String sex;

    private  String idCard;

    private String email;

    private Date createdDate;






}