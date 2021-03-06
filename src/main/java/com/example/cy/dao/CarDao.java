package com.example.cy.dao;

import com.example.cy.bean.Car;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarDao extends JpaRepository<Car,Long> {

    List<Car> findByFuzzyQueryLike(String fuzzyQuery);

    Car findCarByCarId(String CarId);

    Page<Car> findAll(Specification<Car> var1, Pageable var2);

    Car findCarById(Long Id);

    @Query(value = "select c from  car c ")
    List<Car> findUserLikeBySort(Sort sort);

    List<Car> findByCarSource(String source);

//    @Modifying
//    @Query("update car  SET c.state= :state WHERE c.id = :id")
//    void updateCarState(@Param("id")Long id, @Param("state")Integer state);



}
