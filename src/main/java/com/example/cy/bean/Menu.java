package com.example.cy.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity(name="menu")
public class Menu  extends BasePo{


    @Column(length = 255)
    private String name;

    @Column(length = 255)
    private String url;

    @Column(length = 255)
    private String icon;

    @Column(length = 255)
    private Integer parentId;


}
