package com.example.cy.service;



import com.example.cy.bean.Car;
import com.example.cy.bean.input.CarInput;
import com.example.cy.bean.query.CarQuery;
import com.example.cy.utils.ResponseInfo;
import com.example.cy.utils.page.CommonResponsePage;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    Car saveCar(Car car);

    Car updataCar(Car car);

    Car head_value(Car car);

    void deleteCar(Car car);

    List<Car> findAll();

    List<CarQuery> findAllToCarQuery();

    List<CarQuery> fuzzy(String carDescribe);

    ResponseInfo<?> findLike(String s);

    CommonResponsePage<CarQuery> findCarAndPage(Pageable pageable, CarInput car);
}
