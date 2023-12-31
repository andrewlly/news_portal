package com.github.news_portal.mapper;

import com.github.news_portal.domain.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Set;


/**
* @author liuyu
* @description 针对表【sys_role】的数据库操作Mapper
* @createDate 2023-12-31 05:25:14
* @Entity com.github.news_portal.domain.entity.SysRole
*/
public interface RoleMapper extends BaseMapper<Role> {
    Set<Role> selectRoleByUserID(long id);
    Set<String> selectRoleLabelByUserID(long id);
}




