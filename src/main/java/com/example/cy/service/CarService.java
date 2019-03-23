package com.example.cy.service;



import com.example.cy.bean.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    Car saveCar(Car car);

    Car updataCar(Car car);

    void deleteCar(Car car);

    List<Car> findAll();

}
