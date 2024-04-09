package com.fanxy.subject.infra.basic.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fanxy.subject.infra.basic.entity.SubjectLabel;
import com.fanxy.subject.infra.basic.mapper.SubjectLabelMapper;
import com.fanxy.subject.infra.basic.service.SubjectLabelService;
import org.springframework.stereotype.Service;

/**
* @author Fanxy
* @description 针对表【subject_label(题目标签表)】的数据库操作Service实现
* @createDate 2024-03-31 16:38:34
*/
@Service
public class SubjectLabelServiceImpl extends ServiceImpl<SubjectLabelMapper, SubjectLabel>
    implements SubjectLabelService {

}




