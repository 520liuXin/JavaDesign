package com.example.cy.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.cy.bean.User;
import com.example.cy.security.SecurityUtils;
import com.example.cy.service.impl.UserServiceImpl;
import com.example.cy.utils.ResponseInfo;
import com.example.cy.utils.StringUtils;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationManager myAuthenticationManager;

    @Autowired
    DefaultKaptcha defaultKaptcha;

   private String CHECK_CODE = "CHECK_CODE";
    @ResponseBody
    @PostMapping("/userLogin")
    public ResponseInfo<?> userLogin(HttpServletRequest request, @RequestBody JSONObject params) {



        String username=params.getString("name");
        String password=params.getString("pwd");
        String kaptcha=params.getString("kaptcha");

        String s = request.getSession().getAttribute(CHECK_CODE).toString();
        if (StringUtils.isEmpty(kaptcha) || !s.equals(kaptcha)) {
            return ResponseInfo.error("验证码不正确");
        }
        System.out.println("username:"+username+"------password:"+password);
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

            return ResponseInfo.error("账户或密码错误");
        }
        User user=SecurityUtils.getUser();
        return ResponseInfo.success(user);

    }


    @RequestMapping(value = "/user/logout")
    public String logout() {
        SecurityUtils.logout();
        return "redirect:login";
    }


    @RequestMapping("/captcha.jpg")
    @ResponseBody
    public ResponseInfo applyCheckCode(HttpServletRequest request, HttpServletResponse response) throws IOException {


        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = defaultKaptcha.createText();
        //生成图片验证码
        BufferedImage image = defaultKaptcha.createImage(text);
        //保存到session
        request.getSession().setAttribute(CHECK_CODE, text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        return ResponseInfo.success("");
    }
}


