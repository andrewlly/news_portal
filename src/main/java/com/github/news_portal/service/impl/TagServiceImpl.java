package com.github.news_portal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.news_portal.domain.entity.Tag;
import com.github.news_portal.service.TagService;
import com.github.news_portal.mapper.TagMapper;
import org.springframework.stereotype.Service;

/**
* @author liuyu
* @description 针对表【tag】的数据库操作Service实现
* @createDate 2023-12-04 23:33:35
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService {

}




