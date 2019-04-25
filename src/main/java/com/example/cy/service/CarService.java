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

    /**
     * 模糊查询
     * @param
     * @return
     */
    List<CarQuery> fuzzy(String fuzzy);

    /**
     *猜你喜欢
     * @param s
     * @return
     */
    ResponseInfo<?> findLike(String s);

    CommonResponsePage<CarQuery> findCarAndPage(Pageable pageable, CarInput car);
}
