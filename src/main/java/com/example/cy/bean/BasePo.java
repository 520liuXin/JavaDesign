package com.example.cy.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@Data
@MappedSuperclass
public class BasePo implements Serializable {
    private static final long serialVersionUID = 0x20161228;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JSONField(format="yyyy-MM-dd")
    @Column(name = "created_date")
       private Date createdDate;

    @JSONField(format="yyyy-MM-dd")
    @Column(name = "updated_date")
    private Date updatedDate;
}
