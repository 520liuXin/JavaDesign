package com.example.cy.bean;



import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity(name="user")
public class User extends BasePo implements UserDetails {



    @Column(length = 255)
    private  String username;

    @Column(length = 255)
    private  String password;

    @Column(length = 255)
    private String phone;

    @Column(length = 255)
    private String email;

    @Column(length = 255)
    private String imgurl;

    @Column(length = 255)
    private String admin;

    @Transient
    private List<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }




    public String toString(){
        return "name:"+username+",password:"+password+"userPhone: "+phone+",userEmail:"+email+",userImgUrl:"+imgurl;
    }
}
