package com.fanxy.subject.domin.handler.subject;

import com.fanxy.subject.common.enums.SubjectInfoTypeEnum;
import com.fanxy.subject.domin.convert.BriefSubjectConverter;
import com.fanxy.subject.domin.entity.SubjectInfoBO;
import com.fanxy.subject.domin.entity.SubjectOptionBO;
import com.fanxy.subject.infra.basic.entity.SubjectBrief;
import com.fanxy.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * ClassName: BriefTypeHandler
 * Description:
 *
 * @Author FanXY
 * @Create 2024/3/23 18:42
 * @Version 1.0
 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler{
    @Resource
    SubjectBriefService subjectBriefService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 简答题的插入
        SubjectBrief subjectBrief = BriefSubjectConverter.INSTANCE.convertBoToEntity(subjectInfoBO);
        subjectBrief.setSubjectId(subjectInfoBO.getId());
        subjectBriefService.save(subjectBrief);
    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectBrief subjectBrief = subjectBriefService.getById(subjectId);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setSubjectAnswer(subjectBrief.getSubjectAnswer());
        return subjectOptionBO;
    }
}