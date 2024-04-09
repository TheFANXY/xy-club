package com.fanxy.subject.domin.handler.subject;


import com.fanxy.subject.common.enums.SubjectInfoTypeEnum;
import com.fanxy.subject.domin.entity.SubjectInfoBO;
import com.fanxy.subject.domin.entity.SubjectOptionBO;

public interface SubjectTypeHandler {
    /**
     * 枚举身份的识别
     */
    SubjectInfoTypeEnum getHandlerType();

    /**
     * 实际的题目的插入
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 查询题目详情
     */
    SubjectOptionBO query(int subjectId);
}
