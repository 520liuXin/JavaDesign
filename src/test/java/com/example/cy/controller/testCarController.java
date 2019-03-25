package com.example.cy.controller;

import com.example.cy.CyApplication;
import com.example.cy.bean.Car;
import com.example.cy.bean.FileInfo;
import com.example.cy.service.CarService;
import com.example.cy.service.FileInfoService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = {CyApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class testCarController {

    @Autowired
    private CarService carService;

    @Autowired
    private FileInfoService fileInfoService;

    @Test
    @Ignore
    public void testAddCar(){
        List<FileInfo> fileInfos=new ArrayList<>();
        FileInfo fileInfo=new FileInfo();
        fileInfo.setUrl("testurl");
        FileInfo fileInfo1=new FileInfo();
        fileInfo1.setUrl("test1url");

        fileInfos.add(fileInfo);
        fileInfos.add(fileInfo1);

        for(int i=0;i<10;i++){
            Car car=new Car();
            car.setColor("红色");
            car.setRent(200L);
            car.setCarType("SUV");
            car.setCarName("奔驰A100");
            car.setCarId("湘A154611"+i);
            car.setCarBrand("奔驰");
            car.setFileInfos(fileInfos);
            Car newCar=carService.saveCar(car);
        }





    }




}
