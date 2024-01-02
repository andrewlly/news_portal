package com.github.news_portal.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.news_portal.domain.entity.Menu;
import com.github.news_portal.domain.entity.Role;
import com.github.news_portal.domain.entity.User;
import com.github.news_portal.mapper.MenuMapper;
import com.github.news_portal.mapper.RoleMapper;
import com.github.news_portal.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private MenuMapper menuMapper;

    @Resource
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String email) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getEmail, email);
        User user = userMapper.selectOne(lambdaQueryWrapper);
        if(Objects.isNull(user)){
            throw new RuntimeException("invalid account");
        }
        Set<Role> roles = roleMapper.selectRoleByUserID(user.getUid());
        Set<String> roleLabels = new HashSet<>();
        Set<Long> roleIds = new HashSet<>();
        for(Role role: roles){
            roleLabels.add(role.getRoleLabel());
            roleIds.add(role.getId());
        }
        Set<Menu> menus = menuMapper.selectAllByRoleId(roleIds);
        List<String> perms= new ArrayList<>();
        for (Menu m: menus) {
            perms.add(m.getPerms());
        }

        return new LoginUser(user,perms,roleLabels);
    }


}
