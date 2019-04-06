package com.example.cy.service.impl;

import com.example.cy.bean.Car;
import com.example.cy.bean.FileInfo;
import com.example.cy.bean.User;
import com.example.cy.bean.input.CarInput;
import com.example.cy.bean.query.CarQuery;
import com.example.cy.bean.query.UserQuery;
import com.example.cy.dao.CarDao;
import com.example.cy.service.CarService;
import com.example.cy.utils.BeansUtil;
import com.example.cy.utils.Calibration;
import com.example.cy.utils.ResponseInfo;
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
import java.util.*;

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
    public List<CarQuery> findAllToCarQuery() {
        List<CarQuery> carQueryList=new ArrayList<>();
        List<Car> cars=this.findAll();
        for (Car car:cars){
            carQueryList.add( packResultDataForCarQuery(car));
        }
        return carQueryList;
    }

    @Override
    public List<CarQuery> fuzzy(String carDescribe) {
        List<Car> cars =new ArrayList<>();
        cars=carDao.findByCarDescribeLike("%"+carDescribe+"%");
        List<CarQuery> carQueries=new ArrayList<>();
        if(Calibration.isNotEmpty(cars)){

            for (Car car:cars){
                CarQuery carQuery=  packResultDataForCarQuery(car);
                carQueries.add(carQuery);
            }
            return carQueries;
        }
        return carQueries;

    }

    @Override
    public ResponseInfo<?> findLike(String s) {
        List<CarQuery> carQueryList=new ArrayList<>();
        String[] strarr = s.split(",");
        List<CarQuery> carQueries=new ArrayList<>();

        for(String carDescribe:strarr){
            carQueries=this.fuzzy(carDescribe);
            for(CarQuery carQuery:carQueries){
                carQueryList.add(carQuery);
            }
        }
        if(Calibration.isNotEmpty(carQueryList)){
            HashSet h = new HashSet(carQueryList);
            carQueryList.clear();
            carQueryList.addAll(h);
            if(carQueryList.size()<4){
                List<CarQuery> carQueries1=this.findAllToCarQuery();
                List<CarQuery> listAll = new ArrayList<>();
                listAll.addAll(carQueryList);
                listAll.addAll(carQueries1);
                listAll = new ArrayList<CarQuery>(new LinkedHashSet<>(listAll));
                return ResponseInfo.success(listAll);
            }
            return ResponseInfo.success(carQueryList);

        }else {
            carQueryList=this.findAllToCarQuery();
            return ResponseInfo.success(carQueryList);
        }
    }

    @Override
    public CommonResponsePage<CarQuery> findCarAndPage(Pageable pageable, CarInput car) {

        Specification<Car> specification = packSpecification(car);
        Page<Car> pages = carDao.findAll(specification, pageable);
        List<Car> cars = pages.getContent();
        CommonResponsePage<CarQuery> responsePage = new CommonResponsePage<>();
        responsePage.setPagemeta(new VenusPageVO().init(pages));
        if (CollectionUtils.isEmpty(cars)) {
            responsePage.setItems(new ArrayList<>());
            return responsePage;
        }
        List<CarQuery> carList=new ArrayList<>(cars.size());
        for(Car car1 : cars){
            carList.add(packResultDataForCarQuery(car1));
        }
        responsePage.setItems(carList);
        return responsePage;
    }


    private Specification<Car> packSpecification(CarInput car) {
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

            if (Objects.nonNull(car.getStarCreateDate()) && Objects.nonNull(car.getEndCreateDate())) {
                predicates.add(criteriaBuilder.between(root.get("createdDate"), car.getStarCreateDate(),
                        car.getEndCreateDate()));
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


    private CarQuery packResultDataForCarQuery(Car car){
        CarQuery newCar=new CarQuery();
        newCar.setId(car.getId());
        newCar.setCarId(car.getCarId());
        newCar.setCarBrand(car.getCarBrand());
        newCar.setCarName(car.getCarName());
        if(Calibration.isNotEmpty(car.getFileInfos())){
            List<FileInfo> fileInfos=car.getFileInfos();
            newCar.setFileInfoUrl(fileInfos.get(0).getUrl());
        }
        newCar.setCarType(car.getCarType());
        newCar.setColor(car.getColor());
        newCar.setHeatValue(car.getHeatValue());
        newCar.setRent(car.getRent());
        newCar.setCreatedDate(car.getCreatedDate());
        return newCar;

    }

}
