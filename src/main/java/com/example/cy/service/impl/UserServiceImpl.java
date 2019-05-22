package com.example.cy.service.impl;

import com.example.cy.bean.User;
import com.example.cy.bean.input.UserInput;
import com.example.cy.bean.query.UserQuery;
import com.example.cy.dao.UserDao;

import com.example.cy.service.UserService;
import com.example.cy.utils.BeansUtil;
import com.example.cy.utils.DateUtils;
import com.example.cy.utils.page.CommonResponsePage;
import com.example.cy.utils.page.VenusPageVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.Transient;
import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public User findUser(String username) {
        return userDao.findUser(username);
    }

    @Override
    public User updataUser(User user) {
        try {
            User newUser=encapsulationUser(user);
            newUser.setUpdatedDate(new Date());
            userDao.save(newUser);
            return newUser;
        }catch (Exception e) {
           return null;
        }
    }

    @Override
    @Transient
    public User saveUser(User user) {
        try{
            User newUser=encapsulationUser(user);
            newUser.setAdmin(2L);
            newUser.setCreatedDate(new Date());
            userDao.save(newUser);
            return newUser;
        }catch (Exception e) {
            return null;
        }

    }

    @Override
    public void deleteUser(User user) throws Exception{
        try {
            userDao.delete(user);
        }
        catch (Exception e) {
           throw new Exception();
        }
    }

    @Override
    public User updataUserByAdmin(User user) {
        try {
            User newUser=encapsulationUser(user);
            newUser.setAdmin(user.getAdmin());
            userDao.save(newUser);
            return newUser;
        }
        catch (Exception e) {
            return null;
        }
    }



    @Override
    public Page<User> findUserNoCriteria(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        return userDao.findAll(pageable);
    }

    @Override
    public CommonResponsePage<UserQuery> findUserCriteria(Integer page, Integer size, final UserInput userInput, String sort) {
        if(StringUtils.isEmpty(sort)){
            sort="id";
        }
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, sort);
        Specification<User> specification = packSpecification(userInput);
        Page<User> pages = userDao.findAll(specification, pageable);
        List<User> users = pages.getContent();
        CommonResponsePage<UserQuery> responsePage = new CommonResponsePage<>();
        responsePage.setPagemeta(new VenusPageVO().init(pages));
        if (CollectionUtils.isEmpty(users)) {
            responsePage.setItems(new ArrayList<>());
            return responsePage;
        }
        List<UserQuery> userQueries=new ArrayList<>(users.size());
       UserQuery query;
        for(User user : users){
            query=packResultData(user);
            userQueries.add(query);
        }
        responsePage.setItems(userQueries);
        return responsePage;
    }


    private UserQuery packResultData(User user){
        UserQuery userQuery=new UserQuery();
        userQuery.setId(user.getId());
        userQuery.setPhone(user.getPhone());
        userQuery.setUsername(user.getUsername());
        userQuery.setImgurl(user.getImgurl());
        userQuery.setSex(user.getSex());
        userQuery.setIdCard(user.getIdCard());
        userQuery.setAdmin(user.getAdmin());
        userQuery.setEmail(user.getEmail());
        return userQuery;
    }
    private User encapsulationUser(User user){
        User newuser=new User();
        newuser.setId(user.getId());
        newuser.setPhone(user.getPhone());
        newuser.setUsername(user.getUsername());
        newuser.setPassword(user.getPassword());
        newuser.setImgurl(user.getImgurl());
        newuser.setSex(user.getSex());
        newuser.setIdCard(user.getIdCard());
        newuser.setUpdatedDate(new Date());
        newuser.setLabel(user.getLabel());
        newuser.setEmail(user.getEmail());
        return newuser;
    }




    private Specification<User> packSpecification(UserInput userInput) {
        Specification<User> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(StringUtils.isNotBlank(userInput.getUsername())){
                predicates.add(criteriaBuilder.equal(root.get("username").as(String.class), userInput.getUsername()));
            }
            if(StringUtils.isNotBlank(userInput.getPhone())){
                predicates.add(criteriaBuilder.equal(root.get("phone").as(String.class), userInput.getPhone()));
            }

            if(Objects.nonNull(userInput.getAdmin())){
                predicates.add(criteriaBuilder.equal(root.get("admin").as(Long.class), userInput.getAdmin()));
            }
            if(StringUtils.isNotBlank(userInput.getSex())){
                predicates.add(criteriaBuilder.equal(root.get("set").as(String.class), userInput.getSex()));
            }
            if(StringUtils.isNotBlank(userInput.getIdCard())){
                predicates.add(criteriaBuilder.equal(root.get("idCard").as(String.class), userInput.getIdCard()));
            }
            if (Objects.nonNull(userInput.getStarCreateDate()) && Objects.nonNull(userInput.getEndCreateDate())) {
                predicates.add(criteriaBuilder.between(root.get("createdDate"), userInput.getStarCreateDate(),
                        userInput.getEndCreateDate()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        return specification;
    }
}



