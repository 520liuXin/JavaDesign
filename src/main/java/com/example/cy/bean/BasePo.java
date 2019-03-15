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

    @Column(name = "created_by")
    private String createdBy;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_date")
    private Date updatedDate;
}
