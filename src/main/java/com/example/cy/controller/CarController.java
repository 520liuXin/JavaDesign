package com.example.cy.controller;


import com.alibaba.fastjson.JSON;
import com.example.cy.bean.Car;
import com.example.cy.dao.CarDao;
import com.example.cy.service.CarService;
import com.example.cy.utils.Calibration;
import com.example.cy.utils.ResponseInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarDao carDao;
    @Autowired
    private CarService carService;


    /**
     * @Author able-liu
     * @Description 添加车辆
     * @Param
     * @return
     **/
    @PostMapping("/add")
    public ResponseInfo<?> AddUser(String jsonStr){
        List< Car > carList = new ArrayList< Car >();
        if (StringUtils.isNotBlank(jsonStr)) {
            carList = JSON.parseArray(jsonStr, Car.class);
        }
        Car car=carList.get(0);
        Car oldCarr=carDao.findCarByCarId(car.getCarId());
        if(Calibration.isNotEmpty(oldCarr)){
            return ResponseInfo.error("车辆存在，请修改");
        }
        try {
            Car car1=carService.saveCar(car);
        }catch (Exception e){
            return ResponseInfo.success("添加失败");
        }
        return ResponseInfo.success("添加成功");
    }



}
