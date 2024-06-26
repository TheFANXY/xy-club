package com.fanxy.subject.infra.basic.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.fanxy.subject.infra.basic.entity.SubjectInfo;

import java.util.List;

/**
* @author FanXY
* @description 针对表【subject_info(题目信息表)】的数据库操作Service
* @createDate 2024-04-02 18:57:34
*/
public interface SubjectInfoService extends IService<SubjectInfo> {

    int countByCondition(SubjectInfo subjectInfo, Long categoryId, Long labelId);

    List<SubjectInfo> queryPage(SubjectInfo subjectInfo, Long categoryId, Long labelId, int start, Integer pageSize);
}
