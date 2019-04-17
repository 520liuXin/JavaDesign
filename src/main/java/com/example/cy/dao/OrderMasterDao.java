package com.example.cy.dao;


import com.example.cy.bean.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderMasterDao extends JpaRepository<OrderMaster,Long> {

    Page<OrderMaster> findAll(Specification<OrderMaster> var1, Pageable var2);

    List<OrderMaster> findByUserId(Long userId);

}
