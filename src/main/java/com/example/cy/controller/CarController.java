package com.example.cy.controller;


import com.alibaba.fastjson.JSON;
import com.example.cy.bean.Car;
import com.example.cy.bean.FileInfo;
import com.example.cy.bean.User;
import com.example.cy.bean.input.CarInput;
import com.example.cy.bean.query.CarQuery;
import com.example.cy.bean.query.UserQuery;
import com.example.cy.dao.CarDao;
import com.example.cy.dao.FileInfoDao;
import com.example.cy.service.CarService;
import com.example.cy.utils.BeansUtil;
import com.example.cy.utils.Calibration;
import com.example.cy.utils.ResponseInfo;
import com.example.cy.utils.page.CommonResponsePage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Slf4j
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarDao carDao;
    @Autowired
    private CarService carService;
    @Autowired
    private FileInfoDao fileInfoDao;

    /**
     * 模糊查询
     * @param carDescribe
     * @return
     */
    @PostMapping("/fuzzyQuery")
    private ResponseInfo<?> fuzzyQuery(String carDescribe){
        List<CarQuery> carQueries=new ArrayList<>();
        carQueries=carService.fuzzy(carDescribe);
        if (Calibration.isNotEmpty(carQueries)){
            return ResponseInfo.success(carQueries);
        }
        return ResponseInfo.error("抱歉！！！没有相关信息");
    }

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
        try {
            Car car1=carService.saveCar(car);
        }catch (Exception e){
            return ResponseInfo.success("添加失败");
        }
        return ResponseInfo.success("添加成功");
    }

    /**
     * 查询车辆详细信息
     * @param jsonStr
     * @return
     */
    @GetMapping("/info")
    public ResponseInfo<?> findCarById(String jsonStr){
//        List< Car > carList = new ArrayList< Car >();
//        if (StringUtils.isNotBlank(jsonStr)) {
//            carList = JSON.parseArray(jsonStr, Car.class);
//        }
//        Car car=carList.get(0);
        Car oldCar=carDao.findCarById(7L);
        List<FileInfo> fileInfos=fileInfoDao.findByCar_Id(7L);

        oldCar.setCarImgUrl(fileInfos);
        if(Calibration.isNotEmpty(oldCar)){
            return ResponseInfo.success(oldCar);
        }
        return ResponseInfo.error("查询失败");
    }


    /**
     * 热门推荐
     * @return
     */
    @GetMapping("/findByVogue")
    public ResponseInfo<?> findByVogue(){
        List<Car> cars=new ArrayList<>();
        List<CarQuery> carQueries=new ArrayList<>();
        Sort sort = new Sort(Sort.Direction.DESC, "heatValue");
        cars = carDao.findAll(sort);

        carQueries= carToCarQuery(cars);
        return ResponseInfo.success(carQueries);

    }

    /**
     * 与众不同

     * @return
     */
    @GetMapping("/findByDifferent")
    public ResponseInfo<?> findByDifferent() {
        List<Car> cars=new ArrayList<>();
        List<CarQuery> carQueries=new ArrayList<>();
        Sort sort = new Sort(Sort.Direction.ASC, "heatValue");
        cars = carDao.findAll(sort);
        carQueries= carToCarQuery(cars);
        return ResponseInfo.success(carQueries);

    }

    /**
     * 最新上架
     * @param
     * @param
     * @return
     */
    @GetMapping("/findByLatest")
    public ResponseInfo<?> findByLatest () {
        List<Car> cars=new ArrayList<>();
        List<CarQuery> carQueries=new ArrayList<>();
        Sort sort = new Sort(Sort.Direction.DESC, "createdDate");
        cars = carDao.findAll(sort);
        carQueries= carToCarQuery(cars);
        return ResponseInfo.success(carQueries);

    }



        /**
         * 猜你喜欢
         * @param
         * @param
         * @return
         */
    @GetMapping("/findByInterest")
    public ResponseInfo<?> findByInterest(String s){
        List<CarQuery> carQueryList=new ArrayList<>();
        if(StringUtils.isNotEmpty(s)){
             return carService.findLike(s);
        }else {
            List<Car> cars=carService.findAll();
            carQueryList= carToCarQuery(cars);
            return ResponseInfo.success(checkCar(carQueryList));
        }

    }

        /**
         * @Author able-liu
         * @Description /获取汽车并分页可提供指定查询分页
         * @Param
         * @return
         **/
        @RequestMapping(value = "/findCar", method = RequestMethod.GET)
        public ResponseInfo<?> AllfindAllAndPage (@PageableDefault(page = 1, size = 5) Pageable pageable,
                CarInput car){
            int pageNumber = pageable.getPageNumber();
            pageNumber = pageNumber <= 0 ? 1 : pageNumber;
            Pageable page = new PageRequest(pageNumber - 1, pageable.getPageSize(), Sort.Direction.DESC, "id");
            CommonResponsePage<CarQuery> datas = carService.findCarAndPage(page, car);
            return ResponseInfo.success(datas);
        }


    /**
     * 整理车辆字段
     * @param car
     * @return
     */
    private CarQuery packResultDataForCarQuery(Car car){
        CarQuery newCar=new CarQuery();
        newCar.setId(car.getId());
        newCar.setCarId(car.getCarId());
        newCar.setCarBrand(car.getCarBrand());
        newCar.setCarName(car.getCarName());
        if(Calibration.isNotEmpty(car.getCarImgUrl())){
            List<FileInfo> fileInfos=car.getCarImgUrl();
            newCar.setFileInfoUrl(fileInfos.get(0).getUrl());
        }
        newCar.setState(car.getState());
        newCar.setCarType(car.getCarType());
        newCar.setColor(car.getColor());
        newCar.setHeatValue(car.getHeatValue());
        newCar.setRent(car.getRent());
        newCar.setCreatedDate(car.getCreatedDate());
        return newCar;

    }

    /**
     * 校验车辆状态
     * @param carQueries
     * @return
     */
    private List<CarQuery> checkCar(List<CarQuery> carQueries){
        List<CarQuery> List=new ArrayList<>();
        for(CarQuery carQuery:carQueries){
            if (carQuery.getState().equals(0)){
                List.add(carQuery);
            }
        }
        return List;

    }

    /**
     * Car转换成CarQuery,并取前五条数据
     * @param cars
     * @return
     */
    private List<CarQuery> carToCarQuery(List<Car> cars){
        List<CarQuery> carQueries=new ArrayList<>();
        List<CarQuery> carQueryList=new ArrayList<>();
        for (Car car:cars){
            CarQuery carQuery=packResultDataForCarQuery(car);
            carQueries.add(carQuery);
        }
        carQueryList=  checkCar(carQueries).subList(0,5);
        return carQueryList;

    }


}
