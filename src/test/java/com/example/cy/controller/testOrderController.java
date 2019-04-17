package com.example.cy.controller;

import com.example.cy.CyApplication;
import com.example.cy.bean.OrderMaster;
import com.example.cy.bean.User;
import com.example.cy.service.OrderMasterService;
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
public class testOrderController extends TestCase{

    @Autowired
    public OrderMasterService orderMasterService;

    @Test
    public void testAddOrder(){

//        for(int i=0;i<20;i++) {
//            OrderMaster orderMaster = new OrderMaster();
//            orderMaster.setCarId(1111L+i);
//            orderMaster.setCarBrand("奔驰"+i);
//            orderMaster.setCarColor("红色"+i);
//            orderMaster.setCarImgUrl("F:/JavaCode/file/20190303/211926/FL_cKk1NetWyPGivMhEi.jpg");
//            orderMaster.setCarName("奔驰c100");
//            orderMaster.setCarRent(100L+1);
//            orderMaster.setUserId(22222L+1);
//            orderMaster.setUserIdCard("2323232656"+i);
//            orderMaster.setUserName("liuxin"+i);
//            orderMaster.setUserPhone("1767394865"+i);
//            orderMaster.setBuyerAmount(10000L+i);
//            orderMaster.setDetailedAddress("2362323");
//            orderMaster.setCarType("suv");
//            orderMaster.setLeaseDay(2+i);
//
//          OrderMaster orderMaster1= orderMasterService.creatOrder(orderMaster);
//          System.out.println(orderMaster1);

        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setCarId(1111L);
        orderMaster.setCarBrand("奔驰");
        orderMaster.setCarColor("红色");
        orderMaster.setCarImgUrl("F:/JavaCode/file/20190303/211926/FL_cKk1NetWyPGivMhEi.jpg");
        orderMaster.setCarName("奔驰c100");
        orderMaster.setCarRent(100L+1);
        orderMaster.setUserId(22222L+1);
        orderMaster.setUserIdCard("2323232656");
        orderMaster.setUserName("liuxin");
        orderMaster.setUserPhone("1767394865");
        orderMaster.setBuyerAmount(10000L);
        orderMaster.setDetailedAddress("2362323");
        orderMaster.setCarType("suv");
        orderMaster.setLeaseDay(2);

        OrderMaster orderMaster1= orderMasterService.creatOrder(orderMaster);
        }



    @Test
    public void test(){
        System.out.println("测试开始");
    }

}
