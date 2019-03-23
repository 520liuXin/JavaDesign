package com.example.cy.service.impl;

import com.example.cy.bean.Car;
import com.example.cy.dao.CarDao;
import com.example.cy.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.unit.DataUnit;

import java.util.Date;
import java.util.List;
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;
    @Override
    public Car saveCar(Car car) {
        Car newCar=packResultData(car);
        newCar.setCreatedDate(new Date());
        carDao.save(newCar);
        return newCar;
    }

    @Override
    public Car updataCar(Car car) {
        Car newCar=packResultData(car);
        carDao.save(newCar);
        return null;
    }

    @Override
    public void deleteCar(Car car) {
        carDao.delete(car);

    }

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }


    private Car packResultData(Car car){
        Car newCar=new Car();
        newCar.setId(car.getId());
        newCar.setCarId(car.getCarId());
        newCar.setCarBrand(car.getCarBrand());
        newCar.setCarName(car.getCarName());
        newCar.setCarNumber(car.getCarNumber());
        newCar.setFileInfos(car.getFileInfos());
        newCar.setCarType(car.getCarType());
        newCar.setColor(car.getColor());
        newCar.setUpdatedDate(new Date());
        newCar.setHeatValue(car.getHeatValue());
        newCar.setRent(car.getRent());
        return newCar;

    }

}
