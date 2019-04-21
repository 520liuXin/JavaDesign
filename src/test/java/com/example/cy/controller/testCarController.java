package com.example.cy.controller;

import com.example.cy.CyApplication;
import com.example.cy.bean.Car;
import com.example.cy.bean.FileInfo;
import com.example.cy.dao.CarDao;
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

import javax.transaction.Transactional;
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
    private CarDao carDao;
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

        for(int i=0;i<5;i++){
            Car car=new Car();
            car.setColor("中国红");
            car.setRent(200L);
            car.setCarType("WCC");
            car.setCarName("尼桑");
//            car.setCarId("湘A154611"+i);
            car.setCarBrand("尼桑GTR36");
            car.setCarImgUrl(fileInfos);
            car.setCarDescribe("全新梅赛德斯奔驰");
            car.setDisplacement("1.4");
            car.setDriveWay("后驱");
            car.setEngine("800P");
            car.setFuelConsumption("7L");
            Car newCar=carService.saveCar(car);
        }


        }

    @Transactional
    @Test
    public void testUpdataCar() {
        List<FileInfo> fileInfos = new ArrayList<>();
        FileInfo fileInfo = new FileInfo();
        fileInfo.setUrl("testurl");
        FileInfo fileInfo1 = new FileInfo();
        fileInfo1.setUrl("test1url");

        fileInfos.add(fileInfo);
        fileInfos.add(fileInfo1);
        Car car = new Car();
        car.setId(21L);
        car.setColor("中国红");
        car.setRent(200L);
        car.setCarType("WCC");
        car.setCarName("尼桑");
        car.setCarBrand("尼桑GTR36");
        car.setCarImgUrl(fileInfos);
        car.setCarDescribe("全新梅赛德斯奔驰");
        car.setDisplacement("1.4");
        car.setDriveWay("后驱");
        car.setEngine("800P");
        car.setFuelConsumption("7L");
        car.setState(1111);
    //   carDao.updateCarState(car.getId(),1);

    }


}
