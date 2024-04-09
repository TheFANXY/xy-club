package com.fanxy.subject.infra.basic.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fanxy.subject.infra.basic.entity.SubjectMapping;
import com.fanxy.subject.infra.basic.mapper.SubjectMappingMapper;
import com.fanxy.subject.infra.basic.service.SubjectMappingService;
import org.springframework.stereotype.Service;

/**
* @author Fanxy
* @description 针对表【subject_mapping(题目分类关系表)】的数据库操作Service实现
* @createDate 2024-03-31 21:29:49
*/
@Service
public class SubjectMappingServiceImpl extends ServiceImpl<SubjectMappingMapper, SubjectMapping>
    implements SubjectMappingService {

}




