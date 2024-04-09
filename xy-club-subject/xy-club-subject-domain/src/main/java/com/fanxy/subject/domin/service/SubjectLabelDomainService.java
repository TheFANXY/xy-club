package com.fanxy.subject.domin.service;

import com.fanxy.subject.domin.entity.SubjectLabelBO;

import java.util.List;

/**
 * ClassName: SubjectLabelDomainService
 * Package: com.fanxy.subject.domin.service
 * Description:
 *
 * @Author FanXY
 * @Create 2024/3/31 17:09
 * @Version 1.0
 */
public interface SubjectLabelDomainService {
    /**
     * 新增标签
     */
    Boolean add(SubjectLabelBO subjectLabelBO);
    /**
     * 更新标签
     */
    Boolean update(SubjectLabelBO subjectLabelBO);
    /**
     * 删除标签
     */
    Boolean delete(SubjectLabelBO subjectLabelBO);

    /**
     * 查询分类下标签
     */
    List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectCategoryBO);
}
