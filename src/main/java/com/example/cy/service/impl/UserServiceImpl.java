package com.example.cy.service.impl;

import com.example.cy.bean.User;
import com.example.cy.bean.query.UserQuery;
import com.example.cy.dao.UserDao;

import com.example.cy.service.UserService;
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

import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
    public User saveUser(User user) {
       User newUser=new User();
       newUser.setAdmin("2");
       newUser.setUsername(user.getUsername());
       newUser.setPassword(user.getPassword());
       newUser.setPhone(user.getPhone());
       newUser.setCreatedDate(new Date());
       newUser.setUpdatedDate(newUser.getCreatedDate());
       userDao.save(newUser);
        return newUser;
    }
    @Override
    public Page<User> findUserNoCriteria(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        return userDao.findAll(pageable);
    }

    @Override
    public CommonResponsePage<UserQuery> findUserCriteria(Integer page, Integer size, final UserQuery userQuery) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        Specification<User> specification = packSpecification(userQuery);
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
        userQuery.setEmail(user.getEmail());
        userQuery.setImgurl(user.getImgurl());
        return userQuery;
    }

    private Specification<User> packSpecification(UserQuery userQuery) {
        Specification<User> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(StringUtils.isNotBlank(userQuery.getUsername())){
                predicates.add(criteriaBuilder.equal(root.get("username").as(String.class), userQuery.getUsername()));
            }
            if(StringUtils.isNotBlank(userQuery.getPhone())){
                predicates.add(criteriaBuilder.equal(root.get("phone").as(String.class), userQuery.getPhone()));
            }
            if(StringUtils.isNotBlank(userQuery.getEmail())){
                predicates.add(criteriaBuilder.equal(root.get("email").as(String.class), userQuery.getEmail()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        return specification;
    }
}



