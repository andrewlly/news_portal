package com.github.news_portal;


import com.github.news_portal.domain.entity.Menu;
import com.github.news_portal.domain.entity.Role;
import com.github.news_portal.mapper.MenuMapper;
import com.github.news_portal.mapper.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;


@SpringBootTest
public class CrudTest {

    @Autowired (required = false)
    RoleMapper roleMapper;

    @Autowired
    MenuMapper menuMapper;

    @Test
    void testMapper(){
//        News news = newsMapper.selectById(1L);
//        System.out.println(news);
//        newsMapper.incrementShareCount(1L);
//        news = newsMapper.selectById(1L);
//        System.out.println(news);

        Set<Role> roles = roleMapper.selectRoleByUserID(1);
        Set<String> roleLabels = new HashSet<>();
        Set<Long> roleIds = new HashSet<>();
        for(Role role: roles){
            roleLabels.add(role.getRoleLabel());
            roleIds.add(role.getId());
        }
        Set<Menu> menus = menuMapper.selectAllByRoleId(roleIds);
        Set<String> perms= new HashSet<>();
        for (Menu m: menus) {
            perms.add(m.getPerms());
        }
        System.out.println(roles);
        System.out.println(menus);
    }



}
