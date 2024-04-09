package com.fanxy.subject.domin.handler.subject;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fanxy.subject.common.enums.SubjectInfoTypeEnum;
import com.fanxy.subject.domin.convert.JudgeSubjectConverter;
import com.fanxy.subject.domin.entity.SubjectAnswerBO;
import com.fanxy.subject.domin.entity.SubjectInfoBO;
import com.fanxy.subject.domin.entity.SubjectOptionBO;
import com.fanxy.subject.infra.basic.entity.SubjectJudge;
import com.fanxy.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class JudgeTypeHandler implements SubjectTypeHandler{

    @Resource
    SubjectJudgeService subjectJudgeService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 判断题的插入
        SubjectJudge subjectJudge = new SubjectJudge();
        SubjectAnswerBO subjectAnswerBO = subjectInfoBO.getOptionList().get(0);
        subjectJudge.setSubjectId(subjectInfoBO.getId());
        subjectJudge.setIsCorrect(subjectAnswerBO.getIsCorrect());
        subjectJudgeService.save(subjectJudge);
    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        QueryWrapper<SubjectJudge> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("subject_id", subjectId);
        List<SubjectJudge> list = subjectJudgeService.list(queryWrapper);
        List<SubjectAnswerBO> subjectAnswerBOList = JudgeSubjectConverter.INSTANCE.
                convertEntityListToAnswerBoList(list);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }
}
