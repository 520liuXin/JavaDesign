package com.example.cy.controller;

import com.example.cy.CyApplication;
import com.example.cy.bean.User;
import com.example.cy.service.UserService;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = {CyApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class testUserController  extends TestCase{

    @Autowired
    public UserService userService;

    @Test
    @Ignore
    public void testAddUser(){
        User user=new User();
        user.setSex("男");
        user.setPassword("1111");
        user.setUsername("liuxin");
        user.setIdCard("155664694");
        user.setAdmin("1");
        User newUser=userService.saveUser(user);
        Assert.assertEquals("2",newUser.getAdmin());
    }
    @Test
    @Ignore
    public void testUpdataUser(){
        User user=new User();
        user.setId(15L);
        user.setSex("女");
        user.setPassword("565656598");
        user.setUsername("updata");
        user.setIdCard("updata");
        user.setAdmin("1");
        User newUser=userService.updataUser(user);
        Assert.assertEquals("565656598",newUser.getPassword());
        Assert.assertNotEquals("1",newUser.getAdmin());
    }
    @Test
    @Ignore
    public void testUpdataUserByAdmin(){
        User user=new User();
        user.setId(15L);
        user.setSex("女");
        user.setPassword("updata11121");
        user.setUsername("updata");
        user.setIdCard("updata");
        user.setAdmin("1");
        User newUser=userService.updataUserByAdmin(user);
        Assert.assertEquals("updata11121",newUser.getPassword());
        Assert.assertEquals("1",newUser.getAdmin());
    }


    @Test
    public void test(){
        System.out.println("测试开始");
    }

}
