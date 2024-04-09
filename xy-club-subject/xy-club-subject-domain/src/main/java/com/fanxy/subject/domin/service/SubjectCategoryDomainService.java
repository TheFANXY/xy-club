package com.fanxy.subject.domin.service;

import com.fanxy.subject.domin.entity.SubjectCategoryBO;

import java.util.List;

/**
 * ClassName: SubjectCategoryDomainService
 * Package: com.fanxy.subject.domin.service
 * Description:
 *
 * @Author FanXY
 * @Create 2024/3/23 18:19
 * @Version 1.0
 */
public interface SubjectCategoryDomainService {

    /**
     * 查询题目分类
     */
    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);

    Boolean add(SubjectCategoryBO subjectCategoryBO);

    Boolean update(SubjectCategoryBO subjectCategoryBO);

    Boolean delete(SubjectCategoryBO subjectCategoryBO);
}
