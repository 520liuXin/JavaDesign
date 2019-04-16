package com.example.cy.bean;

import com.alibaba.fastjson.annotation.JSONField;

import com.example.cy.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.InputStream;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Car.class)
    @JoinColumn(name = "carId",referencedColumnName = "id")
    private Car car;

    @Override
    public String toString() {
        return "FileInfo{" +
                "resourceId='" + resourceId + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileOriginName='" + fileOriginName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", url='" + url + '\'' +
                ", fileType='" + fileType + '\'' +
                ", size=" + size +
                ", valid=" + valid +
                ", isDelete=" + isDelete +
                ", uploadTime='" + uploadTime + '\'' +
                ", deleteTime='" + deleteTime + '\'' +
                ", content=" + content +
                ", car=" + car +
                '}';
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileOriginName() {
        return fileOriginName;
    }

    public void setFileOriginName(String fileOriginName) {
        this.fileOriginName = fileOriginName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
    }

    public InputStream getContent() {
        return content;
    }

    public void setContent(InputStream content) {
        this.content = content;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}


