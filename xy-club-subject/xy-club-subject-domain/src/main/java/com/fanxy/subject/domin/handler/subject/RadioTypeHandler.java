package com.fanxy.subject.domin.handler.subject;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fanxy.subject.common.enums.SubjectInfoTypeEnum;
import com.fanxy.subject.domin.convert.RadioSubjectConverter;
import com.fanxy.subject.domin.entity.SubjectAnswerBO;
import com.fanxy.subject.domin.entity.SubjectInfoBO;
import com.fanxy.subject.domin.entity.SubjectOptionBO;
import com.fanxy.subject.infra.basic.entity.SubjectRadio;
import com.fanxy.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Component
public class RadioTypeHandler implements SubjectTypeHandler{

    @Resource
    SubjectRadioService subjectRadioService;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 单选题目的插入
        List<SubjectRadio> subjectRadioList = new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectRadio subjectRadio = RadioSubjectConverter.INSTANCE.convertBoToEntity(option);
            subjectRadio.setSubjectId(subjectInfoBO.getId());
            subjectRadioList.add(subjectRadio);
        });
        subjectRadioService.saveBatch(subjectRadioList);
    }
    @Override
    public SubjectOptionBO query(int subjectId) {
        QueryWrapper<SubjectRadio> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("subject_id", subjectId);
        List<SubjectRadio> subjectRadioList = subjectRadioService.list(queryWrapper);
        List<SubjectAnswerBO> subjectAnswerBOList = RadioSubjectConverter.INSTANCE.
                convertEntityListToAnswerList(subjectRadioList);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }
}
