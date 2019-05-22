package com.example.cy.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity(name="role_menu")
public class RoleMenus extends BasePo{


    private Long roleId;


    private Long menuId;
}
