package com.example.cy.dao;


import com.example.cy.bean.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Dreamhai
 * @desc
 * @date 2018-06-08 12:33
 */
public interface FileInfoDao extends JpaRepository<FileInfo, Long> {

    FileInfo findByFileName(String fileName);

    FileInfo findByFileNameAndValid(String fileName, Boolean valid);

    List<FileInfo> findByValid(Boolean valid);

    List<FileInfo> findByResourceId(String resourceId);

    List<FileInfo> findByCar_Id(Long id);

    /**
     * 通过原文件名查找已上传文件
     * @param fileOriginName
     * @return
     */
    List<FileInfo> findByFileOriginName(String fileOriginName);
}
