package com.example.cy.service.impl;



import com.example.cy.bean.FileInfo;
import com.example.cy.config.UploadConfigure;
import com.example.cy.dao.FileInfoDao;
import com.example.cy.exception.BusinessException;
import com.example.cy.service.FileInfoService;
import com.example.cy.utils.DateUtils;
import com.example.cy.utils.FileUtils;
import com.example.cy.utils.ResponseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.List;


/**
 * @author Dreamhai
 * @desc
 * @date 2018-06-08 11:20
 */
@Slf4j
@Service
public class FileInfoServiceImpl implements FileInfoService {

    @Autowired
    private FileInfoDao fileInfoDao;

    @Resource
    private UploadConfigure uploadConfigure;

    /**
     * 上传文件
     *
     * @param file
     * @return
     * @throws BusinessException
     */
    @Transactional
    public ResponseInfo<?> upload(MultipartFile file) throws BusinessException {
        //基础路径  E:/springboot-upload/image/
        String basePath = uploadConfigure.getBasePath();
        //获取文件保存路径 \20180608\113339\
        String folder = FileUtils.getFolder();
        // 获取前缀为"FL_" 长度为20 的文件名  FL_eUljOejPseMeDg86h.png
        String fileName = FileUtils.getFileName() + FileUtils.getFileNameSub(file.getOriginalFilename());

        try {
            // /home/ableliu/file/20190225/112214
            Path filePath = Files.createDirectories(Paths.get(basePath, folder));
            log.info("path01-->{}", filePath);

            //写入文件  /home/ableliu/file/20190225/112214\FL_eUljOejPseMeDg86h.png
            Path fullPath = Paths.get(basePath, folder, fileName);
            log.info("fullPath-->{}", fullPath);
            // /home/ableliu/file/20190225/112214\FL_eUljOejPseMeDg86h.png
            Files.write(fullPath, file.getBytes(), StandardOpenOption.CREATE);

            //保存文件信息
            FileInfo fileInfo = new FileInfo();
            fileInfo.setFileOriginName(file.getOriginalFilename());
            fileInfo.setFileType(file.getContentType());
            fileInfo.setSize(file.getSize());
            fileInfo.setUrl(fullPath.toString());
            fileInfo.setFileName(fileName);
            fileInfo.setFilePath(filePath.toString());

            fileInfoDao.save(fileInfo);
        } catch (Exception e) {
            Path path = Paths.get(basePath, folder);
            log.error("写入文件异常,删除文件。。。。", e);
            try {
                Files.deleteIfExists(path);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return ResponseInfo.error(e.getMessage());
        }

        return ResponseInfo.success("上传成功");
    }

    /**
     * 文件上传，返回Fileinfo
     * @param file
     * @return
     * @throws BusinessException
     */

    @Transactional
    public FileInfo AddFile(MultipartFile file) throws BusinessException {
        //基础路径  E:/springboot-upload/image/
        String basePath = uploadConfigure.getBasePath();
        //获取文件保存路径 \20180608\113339\
        String folder = FileUtils.getFolder();
        // 获取前缀为"FL_" 长度为20 的文件名  FL_eUljOejPseMeDg86h.png
        String fileName = FileUtils.getFileName() + FileUtils.getFileNameSub(file.getOriginalFilename());

        try {
            // /home/ableliu/file/20190225/112214
            Path filePath = Files.createDirectories(Paths.get(basePath, folder));
            log.info("path01-->{}", filePath);

            //写入文件  /home/ableliu/file/20190225/112214\FL_eUljOejPseMeDg86h.png
            Path fullPath = Paths.get(basePath, folder, fileName);
            log.info("fullPath-->{}", fullPath);
            // /home/ableliu/file/20190225/112214\FL_eUljOejPseMeDg86h.png
            Files.write(fullPath, file.getBytes(), StandardOpenOption.CREATE);

            //保存文件信息
            FileInfo fileInfo = new FileInfo();
            fileInfo.setFileOriginName(file.getOriginalFilename());
            fileInfo.setFileType(file.getContentType());
            fileInfo.setSize(file.getSize());
            fileInfo.setUrl(fullPath.toString());
            fileInfo.setFileName(fileName);
            fileInfo.setFilePath(filePath.toString());

            fileInfoDao.save(fileInfo);
            return fileInfo;
        } catch (Exception e) {
            Path path = Paths.get(basePath, folder);
            log.error("写入文件异常,删除文件。。。。", e);
            try {
                Files.deleteIfExists(path);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return new FileInfo();
        }


    }


    /**
     * 文件下载
     *
     * @param fileName
     * @param res
     * @throws BusinessException
     * @throws UnsupportedEncodingException
     */
    public void downloadFile(String fileName, HttpServletResponse res) throws BusinessException, UnsupportedEncodingException {
        if (fileName == null) {
            throw new BusinessException("1001", "文件名不能为空");
        }

        // 通过文件名查找文件信息
        FileInfo fileInfo = fileInfoDao.findByFileName(fileName);
        log.info("fileInfo-->{}", fileInfo);
        if (fileInfo == null) {
            throw new BusinessException("2001", "文件名不存在");
        }

        //设置响应头
        res.setContentType("application/force-download");// 设置强制下载不打开
        res.addHeader("Content-Disposition", "attachment;fileName=" +
                new String(fileInfo.getFileOriginName().getBytes("gbk"), "iso8859-1"));// 设置文件名
        res.setHeader("Context-Type", "application/xmsdownload");

        //判断文件是否存在
        File file = new File(Paths.get(fileInfo.getFilePath(), fileName).toString());
        if (file.exists()) {
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = res.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                log.info("下载成功");
            } catch (Exception e) {
                e.printStackTrace();
                throw new BusinessException("9999", e.getMessage());
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 文件查看
     */
    public FileInfo getImage(String fileName) throws IOException {
        log.info("fileName-->{}", fileName);
        FileInfo fileInfo = fileInfoDao.findByFileNameAndValid(fileName, true);
        if (fileInfo == null) {
            return null;
        }
        Path path = Paths.get(fileInfo.getFilePath(), fileInfo.getFileName());
        log.info("path-->{}", path);
        fileInfo.setContent(Files.newInputStream(path));
        return fileInfo;
    }

    /**
     * 根据资源id查询文件信息
     * @param resourceId
     * @return
     * @throws BusinessException
     */
    public ResponseInfo<?> findFileList(String resourceId) throws BusinessException {
        if (resourceId == null){
            throw new BusinessException("1001","资源id不能为空");
        }
        // 根据资源id查询文件信息
        return ResponseInfo.success(fileInfoDao.findByResourceId(resourceId));
    }


    /**
     * 逻辑删除文件
     * @param fileName
     * @return
     * @throws BusinessException
     */
    public ResponseInfo<?> deleteFile(String fileName) throws BusinessException{
        if (fileName ==  null){
            throw new BusinessException("1001","文件名不能为空");
        }
        FileInfo fileInfo = fileInfoDao.findByFileName(fileName);
        if (fileInfo == null){
            throw new BusinessException("2001","文件名:"+fileName+" 不存在");
        }
        // 逻辑删除文件
        fileInfo.setDelete(true);
        fileInfo.setDeleteTime(DateUtils.getDateString(new Date()));
        return ResponseInfo.success(fileInfo);
    }

    /**
     * 每天执行一次,清除无效图片
     */
    @Scheduled(cron = "0 0 0 1/1 * ? ")
    public void deleteValidFalse() {
        //定时删除无效图片信息
        List<FileInfo> fileInfos = fileInfoDao.findByValid(false);
        fileInfoDao.deleteAll(fileInfos);
        log.info("本次删除数据:{}",fileInfos);
    }

    public ResponseInfo<?> findAll(){
        List<FileInfo> fileInfos = fileInfoDao.findAll();
        return ResponseInfo.success(fileInfos);

    }

}
