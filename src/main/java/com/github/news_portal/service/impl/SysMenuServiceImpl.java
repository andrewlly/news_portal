package com.github.news_portal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.news_portal.domain.entity.Menu;
import com.github.news_portal.service.SysMenuService;
import com.github.news_portal.mapper.MenuMapper;
import org.springframework.stereotype.Service;

/**
* @author liuyu
* @description 针对表【sys_menu】的数据库操作Service实现
* @createDate 2023-12-31 05:25:14
*/
@Service
public class SysMenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements SysMenuService{

}




