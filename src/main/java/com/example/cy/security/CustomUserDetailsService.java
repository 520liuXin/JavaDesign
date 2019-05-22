package com.example.cy.security;

import com.example.cy.bean.Menu;
import com.example.cy.bean.User;
import com.example.cy.dao.MenuDao;
import com.example.cy.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 认证和授权
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MenuDao menuDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //--------------------认证账号
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("账号不存在");
        }


        //-------------------开始授权
        List<Menu> menus = menuDao.getMenusByUserId(user.getId());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Menu menu : menus) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(menu.getUrl());
            //此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
            grantedAuthorities.add(grantedAuthority);
        }
        user.setAuthorities(grantedAuthorities);
        return user;
    }


}
