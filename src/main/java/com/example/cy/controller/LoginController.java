package com.example.cy.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.cy.bean.User;
import com.example.cy.security.SecurityUtils;
import com.example.cy.service.impl.UserServiceImpl;
import com.example.cy.utils.StringUtils;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationManager myAuthenticationManager;



    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public String userLogin(HttpServletRequest request,@RequestBody JSONObject params) {


        String username=params.getString("name");
        String password=params.getString("pwd");
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);


        try{
            //使用SpringSecurity拦截登陆请求 进行认证和授权
            Authentication authenticate = myAuthenticationManager.authenticate(usernamePasswordAuthenticationToken);

            SecurityContextHolder.getContext().setAuthentication(authenticate);
            //使用redis session共享
            HttpSession session = request.getSession();
            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext()); // 这个非常重要，否则验证后将无法登陆
        }catch (Exception e){
            e.printStackTrace();

            return "redirect:login-error?error=2";//用户名或密码错误
        }
        User user=SecurityUtils.getUser();
        if ("1".equals(user.getAdmin())){
            return "redirect:admin";          //管理员用户直接跳转到admin。html
        }


        return "redirect:user";              // 用户直接跳转到user。html
    }


    @RequestMapping(value = "/user/logout")
    public String logout() {
        SecurityUtils.logout();
        return "redirect:login";
    }
//
//    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
//    public void login (@RequestBody JSONObject params){
//
//        System.out.println("param--name:"+params.getString("name")+"param--pwd:"+params.getString("pwd"));
//        JSONObject jsonObj = JSONObject.parseObject(jsonStr);
//        UserServiceImpl usl = new UserServiceImpl();
//        User sendUser = new User();
//        User getUser = new User();
//
//        sendUser.setUsername(jsonObj.getString("name"));
//        sendUser.setPassword(jsonObj.getString("pwd"));
//
//        getUser = usl.findUser(sendUser.getUsername());
//
//        if(getUser.getPassword().equals(sendUser.getPassword())){
//            return "success";
//        }
//
//    }

}
