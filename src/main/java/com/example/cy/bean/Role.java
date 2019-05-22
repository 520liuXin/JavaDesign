package com.example.cy.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;


@Data
@Entity(name="role")
public class Role extends BasePo{
    private Long roleId;

    @Column(length = 255)
    private String roleName;

}
