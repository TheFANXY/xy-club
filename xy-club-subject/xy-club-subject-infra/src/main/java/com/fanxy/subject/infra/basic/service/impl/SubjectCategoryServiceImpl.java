package com.fanxy.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fanxy.subject.infra.basic.entity.SubjectCategory;
import com.fanxy.subject.infra.basic.mapper.SubjectCategoryMapper;
import com.fanxy.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.stereotype.Service;

/**
* @author Fanxy
* @description 针对表【subject_category(题目分类)】的数据库操作Service实现
* @createDate 2024-03-17 20:42:07
*/
@Service
public class SubjectCategoryServiceImpl extends ServiceImpl<SubjectCategoryMapper, SubjectCategory>
    implements SubjectCategoryService {

}
