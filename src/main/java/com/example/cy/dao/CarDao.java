package com.example.cy.dao;

import com.example.cy.bean.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDao extends JpaRepository<Car,Long> {

    Car findCarByCarId(String CarId);
}
