package com.example.cy.controller;


import com.alibaba.fastjson.JSON;
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
    @PostMapping("/info")
    public ResponseInfo<?> findCarById(String jsonStr){
        List< Car > carList = new ArrayList< Car >();
        if (StringUtils.isNotBlank(jsonStr)) {
            carList = JSON.parseArray(jsonStr, Car.class);
        }
        Car car=carList.get(0);
        Car oldCar=carDao.findCarById(car.getId());
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
    public ResponseInfo<?> findByVogue(@PageableDefault(page = 1, size = 5) Pageable pageable,CarInput car){
        int pageNumber = pageable.getPageNumber();
        pageNumber = pageNumber <= 0 ? 1 : pageNumber;
        Pageable page = new PageRequest(pageNumber-1, pageable.getPageSize(), Sort.Direction.DESC, "heatValue");
        CommonResponsePage<CarQuery> datas=carService.findCarAndPage(page,car);
        List<CarQuery> carQueryList=new ArrayList<>();
        carQueryList=datas.getItems();
        return ResponseInfo.success(carQueryList);
    }

    /**
     * 与众不同
     * @param pageable
     * @param car
     * @return
     */
    @GetMapping("/findByDifferent")
    public ResponseInfo<?> findByDifferent(@PageableDefault(page = 1, size = 5) Pageable pageable,CarInput car) {
        int pageNumber = pageable.getPageNumber();
        pageNumber = pageNumber <= 0 ? 1 : pageNumber;
        Pageable page = new PageRequest(pageNumber - 1, pageable.getPageSize(), Sort.Direction.ASC, "heatValue");
        CommonResponsePage<CarQuery> datas = carService.findCarAndPage(page, car);
        List<CarQuery> carQueryList=new ArrayList<>();
        carQueryList=datas.getItems();
        return ResponseInfo.success(carQueryList);
    }

    /**
     * 最新上架
     * @param pageable
     * @param
     * @return
     */
    @GetMapping("/findByLatest")
    public ResponseInfo<?> findByLatest (@PageableDefault(page = 1, size = 5) Pageable pageable) {
        CarInput car=new CarInput();
        int pageNumber = pageable.getPageNumber();
        pageNumber = pageNumber <= 0 ? 1 : pageNumber;
        Pageable page = new PageRequest(pageNumber - 1, pageable.getPageSize(), Sort.Direction.DESC, "createdDate");
        CommonResponsePage<CarQuery> datas = carService.findCarAndPage(page, car);
        List<CarQuery> carQueryList=new ArrayList<>();
        carQueryList=datas.getItems();
        return ResponseInfo.success(carQueryList);
    }



        /**
         * 猜你喜欢
         * @param
         * @param
         * @return
         */
    @GetMapping("/findByInterest")
    public ResponseInfo<?> findByInterest(@PageableDefault(page = 1, size = 5) Pageable pageable,String s){
        List<CarQuery> carQueryList=new ArrayList<>();
        if(StringUtils.isNotEmpty(s)){
             return carService.findLike(s);
        }else {
            List<Car> cars=carService.findAll();
            for (Car car:cars){
                carQueryList.add( packResultDataForCarQuery(car));
            }
            return ResponseInfo.success(carQueryList);
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
