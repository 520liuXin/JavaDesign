package com.example.cy.utils;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Dreamhai
 * @desc
 * @date 2018-06-08 0:31
 */
@Slf4j
public class FileUtils {

    public static final String BASE_PATH = "";

    /**
     * 获取文件系统分隔符
     * @return
     */
    public static String getFileSeparator(){
        return  System.getProperty("file.separator");
    }

    /**
     * 获取文件保存的文件夹
     * 1.
     * @return
     */
    public static String getFolder(){
        String dateStr = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String timeStr = new SimpleDateFormat("HHmmss").format(new Date());
        return   getFileSeparator() + dateStr + getFileSeparator() + timeStr+getFileSeparator();
    }

    /**
     * 获取随机文件名
     * @return
     */
    public static String getFileName(){
        return UUIDUtil.getUid("FL_" , 17) ;
    }

    /**
     * 返回文件名后缀
     * @param fileName
     * @return
     */
    public static String getFileNameSub(String fileName){
        return  fileName.substring(fileName.lastIndexOf("."),fileName.length());
    }

    /**
     * 文件上传
     *
     * @param file
     * @param filePath
     * @param fileName
     * @throws Exception
     */
    //TODO 这样上传,如果文件过大,会导致内存溢出
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * 匹配文件的后缀
     * @param fileName
     * @param exts
     * @return
     */
    public static boolean match(String fileName, String... exts) {
        if (StringUtils.isEmpty(fileName)) {
            return false;
        }
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        for (String ext1 : exts) {
            if (ext.equals(ext1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 文件路径取md5
     * @param path
     * @return
     */
    public static String md5File(String path) {
        String value = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[4096];
            int length;
            while ((length = fis.read(buffer, 0, 4096)) != -1) {
                md.update(buffer, 0, length);
            }
            value = Hex.encodeHexString(md.digest());
        } catch (NoSuchAlgorithmException | IOException e) {
            log.error("calc md5 failed", e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    log.error("close resource failed");
                }
            }
        }

        return value;
    }


}
