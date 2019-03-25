package com.example.cy.bean;

import com.alibaba.fastjson.annotation.JSONField;

import com.example.cy.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.InputStream;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "file_info")
public class FileInfo extends BasePo {

    //文件资源ID ，绑定业务来源的ID
    @NonNull
    @Column(name = "resource_id")
    private String resourceId;

    @NonNull//上传后的文件名
    @Column(name = "file_name")
    private String fileName;

    @NonNull//原文件名
    @Column(name = "file_origin_name")
    private String fileOriginName;

    @JsonIgnore//文件路径
    @Column(name = "file_path")
    private String filePath;

    @Column(name = "url")
    private String url;

    @JsonIgnore//文件类型
    @Column(name = "file_type")
    private String fileType;

    @Column(nullable = false, name = "size")
    private Long size; //文件大小

    // 文件是否后效 true/1: 有效 ; false/0 : 无效
    @JsonIgnore
    @Column(length = 2, name = "valid")
    private Boolean valid = true;

    // 是否删除文件
    @JsonIgnore
    @Column(length = 2, name = "is_delete")
    private Boolean isDelete = false;

    @NonNull//文件上传时间
    @Column(name = "upload_time")
    private String uploadTime = DateUtils.getDateString(new Date());

    @NonNull//文件删除时间
    @Column(name = "delete_time")
    private String deleteTime;

    @JSONField(serialize = false)
    @Transient
    private InputStream content;


    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Car.class)
    @JoinColumn(name = "carId",referencedColumnName = "id")
    private Car car;


}


