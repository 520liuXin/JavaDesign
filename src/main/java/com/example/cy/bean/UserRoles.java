package com.example.cy.bean;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity(name="user_role")
public class UserRoles extends BasePo{

    private Long userId;

    private Long roleId;


}
