package com.example.cy.service.impl;

import com.example.cy.bean.Car;
import com.example.cy.bean.OrderMaster;
import com.example.cy.bean.User;
import com.example.cy.bean.input.OrderMasterInput;
import com.example.cy.bean.query.OrderMasterQuery;
import com.example.cy.dao.OrderMasterDao;
import com.example.cy.service.OrderMasterService;
import com.example.cy.utils.DateUtils;
import com.example.cy.utils.GenerateOrderNoUtil;
import com.example.cy.utils.page.CommonResponsePage;
import com.example.cy.utils.page.VenusPageVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.Predicate;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


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
    public CommonResponsePage<OrderMasterQuery> findOrderMasterAndPage(Pageable pageable, OrderMasterInput orderMaster) {
        Specification<OrderMaster> specification = packSpecification(orderMaster);
        Page<OrderMaster> pages = orderMasterDao.findAll(specification, pageable);
        List<OrderMaster> orderMasters = pages.getContent();
        CommonResponsePage<OrderMasterQuery> responsePage = new CommonResponsePage<>();
        responsePage.setPagemeta(new VenusPageVO().init(pages));
        if (CollectionUtils.isEmpty(orderMasters)) {
            responsePage.setItems(new ArrayList<>());
            return responsePage;
        }
        List<OrderMasterQuery> list=new ArrayList<>(orderMasters.size());
        for(OrderMaster om : orderMasters){
            list.add(packResultData(om));
        }
        responsePage.setItems(list);
        return responsePage;
    }


    private Specification<OrderMaster> packSpecification(OrderMasterInput orderMaster) {
        Specification<OrderMaster> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(StringUtils.isNotBlank(orderMaster.getOrderId())){
                predicates.add(criteriaBuilder.equal(root.get("orderId").as(String.class), orderMaster.getOrderId()));
            }
            if(StringUtils.isNotBlank(orderMaster.getCarName())){
                predicates.add(criteriaBuilder.equal(root.get("carName").as(String.class),orderMaster.getCarName()));
            }
            if(StringUtils.isNotBlank(orderMaster.getUserName())){
                predicates.add(criteriaBuilder.equal(root.get("userName").as(String.class), orderMaster.getUserName()));
            }
            if(orderMaster.getOrderStatus()!=null){
                predicates.add(criteriaBuilder.equal(root.get("orderStatus").as(Integer.class), orderMaster.getOrderStatus()));
            }
            if(orderMaster.getUserId()!=null){
                predicates.add(criteriaBuilder.equal(root.get("userId").as(Long.class), orderMaster.getUserId()));
            }
            if(orderMaster.getCarId()!=null){
                predicates.add(criteriaBuilder.equal(root.get("carId").as(Long.class), orderMaster.getCarId()));
            }

            if (Objects.nonNull(orderMaster.getStartDate()) && Objects.nonNull(orderMaster.getEndDate())) {
                predicates.add(criteriaBuilder.between(root.get("createdDate"), orderMaster.getStartDate(),
                        orderMaster.getEndDate()));
            }
            if(orderMaster.getBuyerAmount()!=null){
                predicates.add(criteriaBuilder.equal(root.get("buyerAmount"), orderMaster.getBuyerAmount()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        return specification;
    }

    private OrderMasterQuery packResultData(OrderMaster orderMaster){
        OrderMasterQuery orderMasterQuery=new OrderMasterQuery();
        orderMasterQuery.setCarId(orderMaster.getCarId());
        orderMasterQuery.setBuyerAmount(orderMaster.getBuyerAmount());
        orderMasterQuery.setCarImgUrl(orderMaster.getCarImgUrl());
        orderMasterQuery.setCarRent(orderMaster.getCarRent());
        orderMasterQuery.setLeaseDay(orderMaster.getLeaseDay());
        orderMasterQuery.setOrderId(orderMaster.getOrderId());
        orderMasterQuery.setUserId(orderMaster.getUserId());
        orderMasterQuery.setStartDate(orderMaster.getStartDate());
        orderMasterQuery.setEndDate(orderMaster.getEndDate());
        orderMasterQuery.setCarName(orderMaster.getCarName());
        orderMasterQuery.setOrderStatus(orderMaster.getOrderStatus());
        return orderMasterQuery;
    }

}
