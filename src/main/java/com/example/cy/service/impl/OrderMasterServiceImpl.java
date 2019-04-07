package com.example.cy.service.impl;

import com.example.cy.bean.Car;
import com.example.cy.bean.OrderMaster;
import com.example.cy.bean.User;
import com.example.cy.bean.query.OrderMasterQuery;
import com.example.cy.dao.OrderMasterDao;
import com.example.cy.service.OrderMasterService;
import com.example.cy.utils.DateUtils;
import com.example.cy.utils.GenerateOrderNoUtil;
import com.example.cy.utils.page.CommonResponsePage;
import org.springframework.data.domain.Pageable;

import javax.xml.crypto.Data;
import java.util.Date;

public class OrderMasterServiceImpl implements OrderMasterService {

    private OrderMasterDao orderMasterDao;

    @Override
    public OrderMaster creatOrder(OrderMaster orderMaster) {
        try{
            orderMaster.setOrderId(GenerateOrderNoUtil.gens(orderMaster.getUserId()));
            orderMasterDao.save(orderMaster);
            return orderMaster;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public CommonResponsePage<OrderMasterQuery> findOrderMasterAndPage(Pageable pageable, OrderMaster orderMaster) {
        return null;
    }


}
