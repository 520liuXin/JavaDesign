package com.example.cy.dao;

import com.example.cy.bean.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MenuDao extends JpaRepository<Menu,Long> {

    //@Query注解加上nativeQuery=true 则查询语句使用原生sql，不加则使用HQL
    @Query(value = "SELECT  m.* FROM ( SELECT * FROM user ) u INNER JOIN ( SELECT * FROM user_role ) ur ON u.id = ur.user_id AND u.id =:userId INNER JOIN ( SELECT * FROM role ) r ON r.id = ur.role_id INNER JOIN ( SELECT * FROM role_menu ) rm ON rm.role_id = r.id INNER JOIN ( SELECT * FROM menu ) m ON rm.menu_id = m.id",nativeQuery = true)
    List<Menu> getMenusByUserId(@Param("userId") Long userId);//@Param("username") String username,
}
