package com.example.cy.controller;


import com.example.cy.bean.FileInfo;
import com.example.cy.exception.BusinessException;
import com.example.cy.service.FileInfoService;
import com.example.cy.utils.FileUtils;
import com.example.cy.utils.ResponseInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


/**
 * 文件操作
 */
@Slf4j
@RestController
@RequestMapping(value = "api/file")
public class FileController {

    @Autowired
    private FileInfoService fileInfoService;

    /**
     * 文件上传
     * 1. 文件上传后的文件名
     * 2. 上传后的文件路径 , 当前年月日时 如:2019022201  2019年2月22日 01时
     * 3. file po 类需要保存文件信息 ,旧名 ,大小 , 上传时间 , 是否删除 ,
     *
     * @param file
     *
     * @return
     */
    @PostMapping("uploadFile")
    public ResponseInfo<?> uploadFile(@RequestParam("file") MultipartFile file) throws Exception{
        // 判断文件是否为空
        if (file.isEmpty()) {
            return ResponseInfo.error("文件不能为空");
        }
        try {
            return fileInfoService.upload(file);
        } catch (BusinessException e) {
            return e.getResponse();
        }
    }

    /**
     * 文件下载
     * @param fileName
     * @param res
     */
    @RequestMapping(value = "/downloadFile/{fileName}")
    public void downloadFile(@PathVariable("fileName") String fileName, HttpServletResponse res) throws Exception{
        try {
            fileInfoService.downloadFile(fileName, res);
        } catch (BusinessException e) {
            e.getResponse();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件查看
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> view(@RequestParam("fileName") String fileName) throws Exception{
        FileInfo fileInfo = null;
        try {
            fileInfo = fileInfoService.getImage(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (fileInfo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        HttpHeaders header = new HttpHeaders();
        if (FileUtils.match(fileInfo.getFileName(), "jpg", "png", "gif", "bmp", "tif")) {
            header.setContentType(MediaType.IMAGE_JPEG);
        } else if (FileUtils.match(fileInfo.getFileName(), "html", "htm")) {
            header.setContentType(MediaType.TEXT_HTML);
        } else if (FileUtils.match(fileInfo.getFileName(), "pdf")) {
            header.setContentType(MediaType.APPLICATION_PDF);
        } else {
            header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        }
        header.add("X-Filename", fileInfo.getFileName());
        header.add("X-URL", fileInfo.getUrl());

        return new ResponseEntity<>(new InputStreamResource(fileInfo.getContent()), header, HttpStatus.OK);
    }

    /**
     * 文件列表查询
     */
    @RequestMapping(value = "/find")
    public ResponseInfo<?> findList(@RequestParam("resourceId") String resourceId) throws Exception{
        try {
            return fileInfoService.findFileList(resourceId);
        }catch (BusinessException e){
           return e.getResponse();
        }
    }

    /**
     * 所有文件查询
     */
    @RequestMapping(value = "/findAll")
    public ResponseInfo<?> findList() throws Exception{
        return fileInfoService.findAll();

    }

    /**
     * 逻辑删除文件
     */
    @RequestMapping(value = "/deleteFile")
    public ResponseInfo<?> deleteFile(@RequestParam("fileName") String fileName) throws Exception{
        try {
            return fileInfoService.deleteFile(fileName);
        }catch (BusinessException e){
           return e.getResponse();
        }
    }

}
