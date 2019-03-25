package com.example.cy.dao;

import com.example.cy.bean.Car;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDao extends JpaRepository<Car,Long> {

    Car findCarByCarId(String CarId);

    Page<Car> findAll(Specification<Car> var1, Pageable var2);
}
