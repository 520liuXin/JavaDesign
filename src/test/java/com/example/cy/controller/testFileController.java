package com.example.cy.controller;

import com.example.cy.CyApplication;
import com.example.cy.bean.Car;
import com.example.cy.bean.FileInfo;
import com.example.cy.dao.FileInfoDao;
import com.example.cy.service.CarService;
import com.example.cy.service.FileInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = {CyApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class testFileController {



    @Autowired
    private FileInfoDao fileInfoDao;

    @Test
//    @Ignore
    public void testAddFile(){
        for(int i=0;i<10;i++){
            FileInfo fileInfo=new FileInfo();
            fileInfo.setUrl("随你填咯");
            fileInfo.setSize(20L);//这个不能为空
            fileInfoDao.save(fileInfo);
        }





    }




}
