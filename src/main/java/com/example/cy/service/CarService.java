package com.example.cy.service;



import com.example.cy.bean.Car;
import com.example.cy.utils.page.CommonResponsePage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    Car saveCar(Car car);

    Car updataCar(Car car);

    Car head_value(Car car);

    void deleteCar(Car car);

    List<Car> findAll();

    CommonResponsePage<Car> findCarAndPage(Integer page, Integer size, Car car);
}
