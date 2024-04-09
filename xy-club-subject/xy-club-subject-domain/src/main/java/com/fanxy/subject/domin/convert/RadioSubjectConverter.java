package com.fanxy.subject.domin.convert;

import com.fanxy.subject.domin.entity.SubjectAnswerBO;
import com.fanxy.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * ClassName: SubjectCategoryConverter
 * Package: com.fanxy.subject.domin.convert
 * Description:
 *
 * @Author FanXY
 * @Create 2024/3/23 18:42
 * @Version 1.0
 */
@Mapper
public interface RadioSubjectConverter {

    RadioSubjectConverter INSTANCE = Mappers.getMapper(RadioSubjectConverter.class);

    SubjectRadio convertBoToEntity(SubjectAnswerBO subjectAnswerBO);

    List<SubjectAnswerBO> convertEntityListToAnswerList(List<SubjectRadio> subjectRadioList);
}
