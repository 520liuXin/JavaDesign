package com.example.cy.service;

import com.example.cy.bean.User;

import com.example.cy.bean.query.UserQuery;
import com.example.cy.utils.page.CommonResponsePage;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional//事物注解
public interface UserService {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 根据username查询用户
     * @param username
     * @return
     */


    User findUser(String username);

    User updataUser(User user);

    User saveUser(User user);

    void deleteUser(User user);

    User updataUserByAdmin(User user);

    Page<User> findUserNoCriteria(Integer page, Integer size);


    CommonResponsePage<UserQuery> findUserCriteria(Integer page, Integer size, UserQuery userQuery,String sort);

}
