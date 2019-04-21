package com.example.cy.service;

import com.alibaba.fastjson.JSONObject;
import com.example.cy.bean.OrderMaster;
import com.example.cy.utils.ResponseInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public interface AlipayService {

     void pay(HttpServletRequest request, HttpServletResponse response, OrderMaster orderMaster) throws Exception;

    ResponseInfo<?> notifyUrl(HttpServletRequest request) throws Exception;
}
