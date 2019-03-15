package com.example.cy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value="/login")
    public String login()  {
        return "login";
    }

    @RequestMapping(value="/index")
    public String index()  {
        return "index";
    }

    @RequestMapping(value="/user/success")
    public String success()  {
        return "success";
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
