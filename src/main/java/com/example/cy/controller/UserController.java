package com.example.cy.controller;


import com.alibaba.fastjson.JSON;
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

import org.apache.commons.lang3.StringUtils;
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
    private UserDao userDao;




   /**
    * @Author able-liu
    * @Description 添加用户
    * @Param
    * @return
    **/
    @PostMapping("/add")
    public ResponseInfo<?> AddUser( String jsonStr){
        List < User > userList = new ArrayList < User > ();
        if (StringUtils.isNotBlank(jsonStr)) {
            userList = JSON.parseArray(jsonStr, User.class);
        }
      User user=userList.get(0);

       User oldUser=userDao.findUser(user.getUsername());
       if(Calibration.isNotEmpty(oldUser)){
           return ResponseInfo.error("用户存在，请登录");
       }
        try {
            User newUser = userService.saveUser(user);
        }catch (Exception e){
           return ResponseInfo.success("注册失败");
        }
        return ResponseInfo.success("注册成功");
    }


    @PostMapping("/updata")
    public ResponseInfo<?> updataUser( String jsonStr){
        List < User > userList = new ArrayList < User > ();
        if (StringUtils.isNotBlank(jsonStr)) {
            userList = JSON.parseArray(jsonStr, User.class);
        }
        User user=userList.get(0);
        User oldUser=userDao.findUser(user.getUsername());
        if(Calibration.isEmpty(oldUser)){
            return ResponseInfo.error("用户不存在，无法修改");
        }
        try {
            User newUser = userService.updataUser(user);
        }catch (Exception e){
            return ResponseInfo.success("修改失败");
        }
        return ResponseInfo.success("修改成功");
    }



    @PostMapping("/updata/admin")
    public ResponseInfo<?> updataUserByAdmin( String jsonStr){
        List < User > userList = new ArrayList < User > ();
        if (StringUtils.isNotBlank(jsonStr)) {
            userList = JSON.parseArray(jsonStr, User.class);
        }
        User user=userList.get(0);
        User oldUser=userDao.findUser(user.getUsername());
        if(Calibration.isEmpty(oldUser)){
            return ResponseInfo.error("用户不存在，无法修改");
        }
        try {
            User newUser = userService.saveUser(user);
        }catch (Exception e){
            return ResponseInfo.success("修改失败");
        }
        return ResponseInfo.success("修改成功");
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
    @RequestMapping(value = "/findUserNoCriteria", method = RequestMethod.GET)
    public ResponseInfo<?> findUserNoCriteria(@PageableDefault(page = 1, size = 5) Pageable pageable){
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
    @RequestMapping(value = "/findUser", method = RequestMethod.GET)
    public ResponseInfo<?> AllfindAllAndPage(@PageableDefault(page = 1, size = 5) Pageable pageable,
                                             UserQuery userQuery,
                                             @RequestParam(value = "sort", required = false) String sort){
        int pageNumber = pageable.getPageNumber();
        pageNumber = pageNumber <= 0 ? 1 : pageNumber;
        CommonResponsePage<UserQuery> datas=userService.findUserCriteria(pageNumber-1, pageable.getPageSize(),userQuery,sort);
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
