package com.example.cy.service.impl;

import com.example.cy.bean.Car;
import com.example.cy.bean.User;
import com.example.cy.bean.query.UserQuery;
import com.example.cy.dao.CarDao;
import com.example.cy.service.CarService;
import com.example.cy.utils.Calibration;
import com.example.cy.utils.page.CommonResponsePage;
import com.example.cy.utils.page.VenusPageVO;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.unit.DataUnit;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
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
        return newCar;
    }

    @Override
    public Car head_value(Car car) {
        Car newCar=packResultData(car);
        newCar.setHeatValue(car.getHeatValue()+100);
        carDao.save(newCar);
        return newCar;
    }


    @Override
    public void deleteCar(Car car) {
        carDao.delete(car);

    }

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public CommonResponsePage<Car> findCarAndPage(Integer page, Integer size, Car car) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        Specification<Car> specification = packSpecification(car);
        Page<Car> pages = carDao.findAll(specification, pageable);
        List<Car> cars = pages.getContent();
        CommonResponsePage<Car> responsePage = new CommonResponsePage<>();
        responsePage.setPagemeta(new VenusPageVO().init(pages));
        if (CollectionUtils.isEmpty(cars)) {
            responsePage.setItems(new ArrayList<>());
            return responsePage;
        }
        List<Car> carList=new ArrayList<>(cars.size());
        for(Car car1 : cars){
            carList.add(car1);
        }
        responsePage.setItems(carList);
        return responsePage;
    }


    private Specification<Car> packSpecification(Car car) {
        Specification<Car> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(StringUtils.isNotBlank(car.getCarId())){
                predicates.add(criteriaBuilder.equal(root.get("carId").as(String.class), car.getCarId()));
            }
            if(StringUtils.isNotBlank(car.getCarBrand())){
                predicates.add(criteriaBuilder.equal(root.get("carBrand").as(String.class), car.getCarBrand()));
            }
            if(StringUtils.isNotBlank(car.getCarName())){
                predicates.add(criteriaBuilder.equal(root.get("carName").as(String.class), car.getCarName()));
            }
            if(StringUtils.isNotBlank(car.getCarType())){
                predicates.add(criteriaBuilder.equal(root.get("carType").as(String.class), car.getCarType()));
            }
            if(StringUtils.isNotBlank(car.getColor())){
                predicates.add(criteriaBuilder.equal(root.get("color").as(String.class), car.getColor()));
            }
            if(car.getRent()!=null){
                predicates.add(criteriaBuilder.equal(root.get("rent").as(String.class), car.getRent()));
            }
            if(car.getHeatValue()!=null){
                predicates.add(criteriaBuilder.equal(root.get("heatValue").as(String.class), car.getHeatValue()));
            }
            if(car.getState()!=null){
                predicates.add(criteriaBuilder.equal(root.get("state").as(String.class), car.getState()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        return specification;
    }


    private Car packResultData(Car car){
        Car newCar=new Car();
        newCar.setId(car.getId());
        newCar.setCarId(car.getCarId());
        newCar.setCarBrand(car.getCarBrand());
        newCar.setCarName(car.getCarName());
        newCar.setFileInfos(car.getFileInfos());
        newCar.setCarType(car.getCarType());
        newCar.setColor(car.getColor());
        newCar.setUpdatedDate(new Date());
        newCar.setHeatValue(car.getHeatValue());
        newCar.setRent(car.getRent());
        return newCar;

    }

}
