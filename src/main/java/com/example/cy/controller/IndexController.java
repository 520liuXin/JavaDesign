package com.example.cy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value="/login")
    public String login()  {
        return "login";
    }


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
    @RequestMapping(value="/personalCenter.html")
    public String personalCenter()  {
        return "personalCenter";
    }
//    iframe-personalCenter
    @RequestMapping(value="personalS/changePwd.html")
    public String changePwd()  {
        return "personalS/changePwd";
    }
    @RequestMapping(value="personalS/personalData.html")
    public String personalData()  {
        return "personalS/personalData";
    }
    @RequestMapping(value="personalS/personalOrder.html")
    public String personalOrder()  {
        return "personalS/personalOrder";
    }
//    iframe-mgrCenter
    @RequestMapping(value="mgrcenter")
    public String mgrcenter()  {
        return "mgrcenter";
    }
    @RequestMapping(value="MgrCenterS/MgrOrder.html")
    public String MgrOrder()  {
        return "MgrCenterS/MgrOrder";
    }
    @RequestMapping(value="MgrCenterS/MgrCar.html")
    public String MgrCar()  {
        return "MgrCenterS/MgrCar";
    }
    @RequestMapping(value="MgrCenterS/MgrUser.html")
    public String MgrUser()  {
        return "MgrCenterS/MgrUser";
    }
    @RequestMapping(value="MgrCenterS/MgrData.html")
    public String MgrData()  {
        return "MgrCenterS/MgrData";
    }

    @RequestMapping(value="carDetail.html")
    public String carDetail()  {
        return "carDetail";
    }

    @RequestMapping(value="loginOrRegist.html")
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
