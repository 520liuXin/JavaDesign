package com.example.cy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping(value="/file")
    public String file()  {
        return "file";
    }

    @RequestMapping(value="/index")
    public String index()  {
        return "index";
    }

    @RequestMapping(value="/user/admin")
    public String successAdmin()  {
        return "admin";
    }

    @RequestMapping(value="/user/user")
    public String successUser()  {
        return "user";
    }

//homepage
    @RequestMapping(value="/homePageFirstPage.html")
    public String homePageFirstPage()  {
        return "homePageFirstPage";
    }

    @RequestMapping(value="/home")
    public String home()  {
        return "homePageFirstPage";
    }

    @RequestMapping(value="/homePageCarInformation.html")
    public String homePageCarInformation()  {
        return "homePageCarInformation";
    }

    @RequestMapping(value="/homePageMerchant.html")
    public String homePageMerchant()  {
        return "homePageMerchant";
    }

    @RequestMapping(value="/orderSuccess.html")
    public String orderSuccess()  {
        return "orderSuccess";
    }

    @RequestMapping(value="/orderFailed.html")
    public String orderFailed()  {
        return "orderFailed";
    }

    @RequestMapping(value="/personalCenter.html")
    public String personalCenter()  {
        return "personalCenter";
    }
    @RequestMapping(value="/homePageSellcar.html")
    public String homePageSellCar()  {
        return "homePageSellcar";
    }
//    iframe-personalCenter
    @RequestMapping(value="/changePwd.html")
    public String changePwd()  {
        return "/changePwd";
    }

    @RequestMapping(value="/personalData.html")
    public String personalData()  {
        return "/personalData";
    }

    @RequestMapping(value="/personalOrder.html")
    public String personalOrder()  {
        return "/personalOrder";
    }

//    iframe-mgrCenter
    @RequestMapping(value="mgrcenter")
    public String mgrcenter()  {
        return "mgrcenter";
    }

    @RequestMapping(value="/MgrOrder.html")
    public String MgrOrder()  {
        return "/MgrOrder";
    }

    @RequestMapping(value="/MgrCar.html")
    public String MgrCar()  {
        return "/MgrCar";
    }

    @RequestMapping(value="/MgrUser.html")
    public String MgrUser()  {
        return "/MgrUser";
    }

    @RequestMapping(value="/MgrData.html")
    public String MgrData()  {
        return "/MgrData";
    }
    @RequestMapping(value="/upLoadCar.html")
    public String uploadCar()  {
        return "/upLoadCar.html";
    }

    @RequestMapping(value="carDetail.html")
    public String carDetail()  {
        return "carDetail";
    }

    @RequestMapping(value="login")
    public String loginOrRegistPage()  {
        return "loginOrRegist";
    }

    @RequestMapping(value="loginOrRegist")
    public String loginOrRegist()  {
        return "loginOrRegist";
    }

    @RequestMapping("/404")
    public String to404()  {
        return "404";
    }
    @RequestMapping("/403")
    public String to403()  {
        return "403";
    }
    @RequestMapping("/500")
    public String to500()  {
        return "500";
    }

}
