package com.example.cy.dao;

import com.example.cy.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
@Repository
public interface UserDao extends JpaRepository<User,Long> {
    /**
     * 查询所有用户
     * @return
     */
     List<User> findAll();

    /**
     *
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String username,String password);
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findById(Integer id);
    User findByUsername(String username);

//    /**
//     * 根据username查询用户
//     * @param username
//     * @return
//     */
////    @Query(" select u.* from user u where u.username =:username")
////    User findUser(@Param("username") String username);


    Page<User> findAll(Specification<User> var1, Pageable var2);
}
