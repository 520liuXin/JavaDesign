//package com.example.cy.controller;
//
//
//
//import com.example.cy.bean.User;
//import com.example.cy.dao.UserDao;
//import com.example.cy.security.SecurityUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.List;
//
///**
// * user表  admin具有所有权限   user具有查看权限不具有操作权限
// */
//@Controller
//@RequestMapping("/user")
//public class TestController {
//    @Autowired
//    private UserDao userDao;
//
//    @RequestMapping(value = "/list")
//    @PreAuthorize("hasAuthority('/user/list')")
//    @ResponseBody
//    public List login() {
//        List<User> list =  userDao.findAll();
//        return list;
//    }
//
//    @RequestMapping(value = "/update")
//    @PreAuthorize("hasAuthority('/user/update')")
//    @ResponseBody
//    public HashMap<String, Object> update() {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("state","success");
//        return map;
//    }
//
//
//    @RequestMapping(value = "/del")
//    @PreAuthorize("hasAuthority('/user/del')")
//    @ResponseBody
//    public HashMap<String, Object> del() {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("state","success");
//        return map;
//    }
//    @RequestMapping(value = "/add")
//    @PreAuthorize("hasAuthority('/user/add')")
//    @ResponseBody
//    public HashMap<String, Object> add() {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("state","success");
//        return map;
//    }
//
//}
