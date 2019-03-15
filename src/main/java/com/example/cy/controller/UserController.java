package com.example.cy.controller;


import com.example.cy.bean.FileInfo;
import com.example.cy.bean.User;
import com.example.cy.bean.query.UserQuery;
import com.example.cy.dao.FileInfoDao;
import com.example.cy.dao.UserDao;

import com.example.cy.security.SecurityUtils;
import com.example.cy.service.FileInfoService;
import com.example.cy.service.UserService;
import com.example.cy.utils.Calibration;

import com.example.cy.utils.ResponseInfo;
import com.example.cy.utils.page.CommonResponsePage;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.web.PageableDefault;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;
    @Autowired
    private FileInfoService fileInfoService;
    @Autowired
    private FileInfoDao fileInfoDao;
    @Autowired
    private UserDao userDao;




   /**
    * @Author able-liu
    * @Description 添加用户
    * @Param
    * @return
    **/
    @PostMapping("/add")
    public ResponseInfo<?> AddUser( @RequestBody  User user){
       User oldUser=userDao.findUser(user.getUsername());
       if(Calibration.isNotEmpty(oldUser)){
           return ResponseInfo.error("用户存在，请登录");
       }
       User newUser=userService.saveUser(user);
        return ResponseInfo.success(newUser);
    }



    /**
     * 获取全部用户
     * @return
     */
    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public ResponseInfo<?> findAll(){
        List <User> list=userDao.findAll();
        return ResponseInfo.success(list);
    }


    /**
     * @Author able-liu
     * @Description 获取当前用户并分页
     * @Param
     * @return
     **/
    @RequestMapping(value = "/findallAndpage", method = RequestMethod.GET)
    public ResponseInfo<?> findAllAndPage(@PageableDefault(page = 1, size = 5)
                                                  Pageable pageable){
        int pageNumber = pageable.getPageNumber();
        pageNumber = pageNumber <= 0 ? 1 : pageNumber;
        Page<User> datas=userService.findUserNoCriteria(pageNumber-1, pageable.getPageSize());
        return ResponseInfo.success(datas);
    }
    /**
     * @Author able-liu
     * @Description /获取当前用户并分页可提供指定查询分页
     * @Param
     * @return
     **/
    @RequestMapping(value = "/AllfindallAndpage", method = RequestMethod.GET)
    public ResponseInfo<?> AllfindAllAndPage(@PageableDefault(page = 1, size = 5)
                                                     Pageable pageable,
                                             UserQuery userQuery){
        int pageNumber = pageable.getPageNumber();
        pageNumber = pageNumber <= 0 ? 1 : pageNumber;
        CommonResponsePage<UserQuery> datas=userService.findUserCriteria(pageNumber-1, pageable.getPageSize(),userQuery);
        return ResponseInfo.success(datas);
    }


    /**
     * @Author able-liu
     * @Description 当前用户详细信息
     * @Param
     * @return
     **/
    @RequestMapping(value = "/info")
    public User info() {
        return SecurityUtils.getUser();
    }

}
