package com.example.cy.service;

import com.example.cy.bean.Car;
import com.example.cy.bean.OrderMaster;
import com.example.cy.bean.User;

import javax.xml.crypto.Data;
import java.util.Date;

public interface OrderMasterService {
    OrderMaster creatOrder(User user, Car car, Date starData, Date endData);
}
