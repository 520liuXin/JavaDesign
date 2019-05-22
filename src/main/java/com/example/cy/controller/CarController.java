package com.example.cy.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.cy.bean.Car;
import com.example.cy.bean.FileInfo;
import com.example.cy.bean.User;
import com.example.cy.bean.input.CarInput;
import com.example.cy.bean.query.CarQuery;
import com.example.cy.bean.query.UserQuery;
import com.example.cy.dao.CarDao;
import com.example.cy.dao.FileInfoDao;
import com.example.cy.enums.CarEnum;
import com.example.cy.exception.BusinessException;
import com.example.cy.security.SecurityUtils;
import com.example.cy.service.CarService;
import com.example.cy.service.FileInfoService;
import com.example.cy.utils.BeansUtil;
import com.example.cy.utils.Calibration;
import com.example.cy.utils.RandomDataUtil;
import com.example.cy.utils.ResponseInfo;
import com.example.cy.utils.page.CommonResponsePage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private FileInfoService fileInfoService;


    private String store="店家直营";

    private String personal="个人卖家";


    /**
     * 模糊查询
     * @param
     * @return
     */
    @RequestMapping(value = "/fuzzyQuery", method = RequestMethod.POST)
    private ResponseInfo<?> fuzzyQuery(@RequestBody JSONObject params){
        String carInfo = params.getString("carInfo");
        List<CarQuery> carQueries=new ArrayList<>();
        carQueries=carService.fuzzy(carInfo);
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


   @RequestMapping (value="/add",method = RequestMethod.POST)
    public ResponseInfo<?> AddUser(@RequestParam("files") MultipartFile[] file,Car car)throws BusinessException {
        try {
            if(Calibration.isNotEmpty(car)){
                Car newCar=carService.saveCar(car);
                System.out.println(newCar.toString());
                fileInfoService.batchUpload(file,newCar);
            }

        }catch (Exception e){
            return ResponseInfo.success("添加失败");
        }
        return ResponseInfo.success("添加成功");
    }

    /**
     * 查询车辆详细信息
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public ResponseInfo<?> findCarById(@RequestBody JSONObject params){
        Long idInfo = Long.parseLong(params.getString("id"));
        Car oldCar=carDao.findCarById(idInfo);

        List<FileInfo> fileInfos=fileInfoDao.findByCar_Id(idInfo);

        oldCar.setCarImgUrl(fileInfos);

        if(Calibration.isNotEmpty(oldCar)){
            return ResponseInfo.success(oldCar);
        }
        return ResponseInfo.error("查询失败");
    }


//
//    /**
//     * @Author able-liu
//     * @Description 店家直营
//     * @Param
//     * @return
//     **/
//    @ResponseBody
//    @GetMapping("/store")
//    public ResponseInfo<?> store(){
//        RandomDataUtil randomDataUtil=new RandomDataUtil();
//        List<Car> cars=new ArrayList<>();
//        List<CarQuery> carQueries=new ArrayList<>();
//
//        cars = carDao.findByCarSource(store);
//        if(cars.size()>20){
//            cars=  randomDataUtil.generateRandomDataNoRepeat(cars,20);
//        }
//        carQueries= randomCarToCarQuery(cars);
//        return ResponseInfo.success(carQueries);
//
//    }
//
//
//
//    /**
//     * @Author able-liu
//     * @Description 个人卖家
//     * @Param
//     * @return
//     **/
//    @ResponseBody
//    @GetMapping("/personal")
//    public ResponseInfo<?> personal(){
//        RandomDataUtil randomDataUtil=new RandomDataUtil();
//        List<Car> cars=new ArrayList<>();
//        List<CarQuery> carQueries=new ArrayList<>();
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
//        cars = carDao.findByCarSource(personal);
//        if(cars.size()>20){
//            cars=  randomDataUtil.generateRandomDataNoRepeat(cars,20);
//        }
//        carQueries= randomCarToCarQuery(cars);
//        return ResponseInfo.success(carQueries);
//
//    }




    /**
     * 热门推荐
     * @return
     */
    @ResponseBody
    @GetMapping("/findByVogue")
    public ResponseInfo<?> findByVogue(){
        List<Car> cars=new ArrayList<>();
        List<CarQuery> carQueries=new ArrayList<>();
        Sort sort = new Sort(Sort.Direction.DESC, "heatValue");
        cars = carDao.findAll(sort);
        if(cars.size()>30){
            carQueries= carToCarQuery(cars.subList(0,20));
        }else {
            carQueries= carToCarQuery(cars);
        }
        return ResponseInfo.success(carQueries);

    }

    /**
     * 与众不同

     * @return
     */
    @ResponseBody
    @GetMapping("/findByDifferent")
    public ResponseInfo<?> findByDifferent() {
        RandomDataUtil randomDataUtil=new RandomDataUtil();
        List<Car> cars=new ArrayList<>();
        List<CarQuery> carQueries=new ArrayList<>();
        Sort sort = new Sort(Sort.Direction.ASC, "heatValue");
        cars = carDao.findAll(sort);
        if(cars.size()>30){
            cars=  randomDataUtil.generateRandomDataNoRepeat(cars,20);
        }
        carQueries= randomCarToCarQuery(cars);
        return ResponseInfo.success(carQueries);

    }

    /**
     * 最新上架
     * @param
     * @param
     * @return
     */
    @ResponseBody
    @GetMapping("/findByLatest")
    public ResponseInfo<?> findByLatest () {
        List<Car> cars=new ArrayList<>();
        List<CarQuery> carQueries=new ArrayList<>();
        Sort sort = new Sort(Sort.Direction.DESC, "createdDate");
        cars = carDao.findAll(sort);
        if(cars.size()>30){
            carQueries= carToCarQuery(cars.subList(0,20));
        }else {
            carQueries= carToCarQuery(cars);
        }
        return ResponseInfo.success(carQueries);

    }



        /**
         * 猜你喜欢
         * @param
         * @param
         * @return
         */
        @ResponseBody
    @GetMapping("/findByInterest")
    public ResponseInfo<?> findByInterest(){
        List<CarQuery> carQueryList=new ArrayList<>();
        String like=SecurityUtils.getUser().getLabel();
        if(StringUtils.isNotEmpty(like)){
             return carService.findLike(like);
        }else {
            List<Car> cars=carService.findAll();
            carQueryList= randomCarToCarQuery(cars);
            return ResponseInfo.success(carQueryList);
        }

    }

        /**
         * @Author able-liu
         * @Description /获取汽车并分页可提供指定查询分页
         * @Param
         * @return
         **/
        @ResponseBody
        @RequestMapping(value = "/findCar", method = RequestMethod.GET)
        public ResponseInfo<?> AllfindAllAndPage (@PageableDefault(page = 1, size = 20) Pageable pageable,
                CarInput car){
            int pageNumber = pageable.getPageNumber();
            if(car.getSourceUserId()!=null){
                car.setSourceUserId(SecurityUtils.getUser().getId());
                car.setState(0);
            }
            pageNumber = pageNumber <= 0 ? 1 : pageNumber;
            car.setState(CarEnum.STSTE_NO_RENT_OUT.getCode());
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
        newCar.setCarSource(car.getCarSource());
        newCar.setColor(car.getColor());
        newCar.setHeatValue(car.getHeatValue());
        newCar.setRent(car.getRent());
        newCar.setCreatedDate(car.getCreatedDate());
        newCar.setEngine(car.getEngine());
        return newCar;

    }

    /**
     * 校验车辆状态
     * @param carQueries
     * @return
//     */
//    private List<CarQuery> checkCar(List<CarQuery> carQueries){
//        List<CarQuery> List=new ArrayList<>();
//        for(CarQuery carQuery:carQueries){
//            if (carQuery.getState().equals(0)){
//                List.add(carQuery);
//            }
//        }
//        return List;
//
//    }

    /**
     * Car转换成CarQuery,并取前五条数据,
     * @param cars
     * @return
     */
    private List<CarQuery> carToCarQuery(List<Car> cars){
        List<CarQuery> carQueries=new ArrayList<>();
        List<CarQuery> carQueryList=new ArrayList<>();
        for (Car car:cars){
            if(car.getState().equals(0)){
                CarQuery carQuery=packResultDataForCarQuery(car);
                carQueries.add(carQuery);
            }
        }
        if(carQueries.size()>12){
            carQueries= carQueries.subList(0,12);
        }
            return carQueries;
    }


    /**
     * Car转换成CarQuery,并随机取五条数据,
     * @param cars
     * @return
     */
    private List<CarQuery> randomCarToCarQuery(List<Car> cars){
        RandomDataUtil randomDataUtil=new RandomDataUtil();
        List<CarQuery> carQueries=new ArrayList<>();
        List<CarQuery> carQueryList=new ArrayList<>();
        for (Car car:cars){
            if(car.getState().equals(0)){
            CarQuery carQuery=packResultDataForCarQuery(car);
            carQueries.add(carQuery);}
        }
        if(carQueries.size()>12){
            carQueries=  randomDataUtil.generateRandomDataNoRepeat(carQueries,12);

        }
        return carQueries;
    }

  /**
   * @Author able-liu
   * @Description 车辆喜欢，提升热度值
   * @Param
   * @return
   **/
    @PostMapping("/likeThisCar")
    public void likeThisCar(@RequestBody JSONObject params ){
        String carId=params.getString("carId");
        Car car=new Car();
        car.setId(Long.parseLong(carId));
        carService.head_value(car);
    }


}
