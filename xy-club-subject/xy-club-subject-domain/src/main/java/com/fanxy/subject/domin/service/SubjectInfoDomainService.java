package com.fanxy.subject.domin.service;

import com.fanxy.subject.common.entity.PageResult;
import com.fanxy.subject.domin.entity.SubjectInfoBO;

/**
 * ClassName: SubjectLabelDomainService
 * Package: com.fanxy.subject.domin.service
 * Description:
 *
 * @Author FanXY
 * @Create 2024/3/31 17:09
 * @Version 1.0
 */
public interface SubjectInfoDomainService {
    /**
     * 新增课程
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 分页查询课程列表
     */
    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);

    /**
     * 查询课程详情
     */
    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);
}