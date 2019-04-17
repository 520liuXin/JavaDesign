package com.example.cy.service;

import com.example.cy.bean.Car;
import com.example.cy.bean.OrderMaster;
import com.example.cy.bean.User;
import com.example.cy.bean.input.OrderMasterInput;
import com.example.cy.bean.query.OrderMasterQuery;
import com.example.cy.utils.page.CommonResponsePage;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public interface OrderMasterService {
    OrderMaster creatOrder(OrderMaster orderMaster);

    CommonResponsePage<OrderMasterQuery> findOrderMasterAndPage(Pageable pageable, OrderMasterInput orderMaster);

    List<OrderMasterQuery> findOrderByUserId(Long userId);

}
