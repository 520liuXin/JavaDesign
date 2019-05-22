package com.example.cy.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.cy.bean.FileInfo;
import com.example.cy.bean.User;
import com.example.cy.bean.input.UserInput;
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

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Autowired
    private AuthenticationManager myAuthenticationManager;

    private String CHECK_CODE = "CHECK_CODE";




   /**
    * @Author able-liu
    * @Description 添加用户
    * @Param
    * @return
    **/
    @PostMapping("/add")
    public ResponseInfo<?> AddUser(HttpServletRequest request, @RequestBody JSONObject params){
        String kaptcha=params.getString("kaptcha");

        String s = request.getSession().getAttribute(CHECK_CODE).toString();
        if (com.example.cy.utils.StringUtils.isEmpty(kaptcha) || !s.equals(kaptcha)) {
            return ResponseInfo.error("验证码不正确");
        }
        User user= getUser(params);
       User oldUser=userDao.findByUsername(user.getUsername());
       if(Calibration.isNotEmpty(oldUser)){
           return ResponseInfo.error("用户存在，请登录");
       }
        try {
            User newUser = userService.saveUser(user);
        }catch (Exception e){
           return ResponseInfo.error("注册失败");
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        try{
            //使用SpringSecurity拦截登陆请求 进行认证和授权
            Authentication authenticate = myAuthenticationManager.authenticate(usernamePasswordAuthenticationToken);

            SecurityContextHolder.getContext().setAuthentication(authenticate);
            //使用redis session共享
            HttpSession session = request.getSession();
            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext()); // 这个非常重要，否则验证后将无法登陆
        }catch (Exception e){
            e.printStackTrace();

        }
        return ResponseInfo.success("注册成功");
    }


    @PostMapping("/update")
    public ResponseInfo<?> updataUser(@RequestBody JSONObject params){

        User user =userService.findUser(SecurityUtils.getUser().getUsername());
       User newuser= updataGetUser(params,user);
        try {
            User newUser = userService.updataUser(newuser);
        }catch (Exception e){
            return ResponseInfo.error("修改失败");
        }
        return ResponseInfo.success("修改成功");
    }




    @PostMapping("/updatePwd")
    public ResponseInfo<?> updataUserPwd(@RequestBody JSONObject params){
        User user=userService.findUser(SecurityUtils.getUser().getUsername());
        String oldPwd=params.getString("oldPwd");
        if(!oldPwd.equals(user.getPassword())){
            return ResponseInfo.error("原密码错误");
        }
       String newPwd =params.getString("newPwd");
        user.setPassword(newPwd);
        try {
            User newUser = userService.updataUser(user);
        }catch (Exception e){
            return ResponseInfo.error("修改失败");
        }
        return ResponseInfo.success("修改成功");
    }



    @PostMapping("/update/admin")
    public ResponseInfo<?> updataUserByAdmin( String jsonStr){
        List < User > userList = new ArrayList < User > ();
        if (StringUtils.isNotBlank(jsonStr)) {
            userList = JSON.parseArray(jsonStr, User.class);
        }
        User user=userList.get(0);
        User oldUser=userDao.findByUsername(user.getUsername());
        if(Calibration.isEmpty(oldUser)){
            return ResponseInfo.error("用户不存在，无法修改");
        }
        try {
            User newUser = userService.updataUserByAdmin(user);
        }catch (Exception e){
            return ResponseInfo.error("修改失败");
        }
        return ResponseInfo.success("修改成功");
    }



    @PostMapping("/delete")
    public ResponseInfo<?> deleteUser( @RequestBody JSONObject params){
//
//        List < User > userList = new ArrayList < User > ();
//        if (StringUtils.isNotBlank(jsonStr)) {
//            userList = JSON.parseArray(jsonStr, User.class);
//        }
//        User user=userList.get(0);
//        User oldUser=userDao.findUser(user.getUsername());
//        if(Calibration.isEmpty(oldUser)){
//            return ResponseInfo.error("用户不存在，无法删除");
//        }
//        try {
//                   userService.deleteUser(user);
//        }catch (Exception e){
//            return ResponseInfo.error("删除失败");
//        }
       return ResponseInfo.success("删除成功");
    }



    /**
     * 获取全部用户
     * @return
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseInfo<?> findAll(){
        List <User> list=userDao.findAll();
        return ResponseInfo.success(list);
    }


//    /**
//     * @Author able-liu
//     * @Description 获取当前用户并分页
//     * @Param
//     * @return
//     **/
//    @RequestMapping(value = "/findUserNoCriteria", method = RequestMethod.GET)
//    public ResponseInfo<?> findUserNoCriteria(@PageableDefault(page = 1, size = 5) Pageable pageable){
//        int pageNumber = pageable.getPageNumber();
//        pageNumber = pageNumber <= 0 ? 1 : pageNumber;
//        Page<User> datas=userService.findUserNoCriteria(pageNumber-1, pageable.getPageSize());
//        return ResponseInfo.success(datas);
//    }
    /**
     * @Author able-liu
     * @Description /获取当前用户并分页可提供指定查询分页
     * @Param
     * @return
     **/
    @RequestMapping(value = "/findUser", method = RequestMethod.GET)
    public ResponseInfo<?> AllfindAllAndPage(@PageableDefault(page = 1, size = 5) Pageable pageable,
                                             UserInput userInput,
                                             @RequestParam(value = "sort", required = false) String sort){
        int pageNumber = pageable.getPageNumber();
        pageNumber = pageNumber <= 0 ? 1 : pageNumber;
        CommonResponsePage<UserQuery> datas=userService.findUserCriteria(pageNumber-1, pageable.getPageSize(),userInput,sort);
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



    private User getUser(JSONObject params){

        String username=params.getString("Name");
        String password=params.getString("Pwd");
        String usertag=params.getString("Usertag");
        String idCard=params.getString("idNumber");
        String name=params.getString("trueName");
        usertag=usertag.replace("[","");
        String label=usertag.replace("]","");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setLabel(label);
        user.setName(name);
        user.setIdCard(idCard);

        return user;

    }


    private User updataGetUser(JSONObject params,User user){
        String usertag=params.getString("Usertag");
        String idCard=params.getString("idNumber");
        String name=params.getString("trueName");
        String eamil=params.getString("email");
        String phone=params.getString("userPhone");
        String userSex=params.getString("userSex");
        usertag=usertag.replace("[","");
        String label=usertag.replace("]","");
        user.setLabel(label);
        user.setName(name);
        user.setEmail(eamil);
        user.setIdCard(idCard);
        user.setEmail(eamil);
        user.setPhone(phone);
        user.setSex(userSex);

        return user;

    }
}
