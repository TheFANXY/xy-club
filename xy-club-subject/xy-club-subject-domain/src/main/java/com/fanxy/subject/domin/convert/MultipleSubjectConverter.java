package com.fanxy.subject.domin.convert;

import com.fanxy.subject.domin.entity.SubjectAnswerBO;
import com.fanxy.subject.infra.basic.entity.SubjectMultiple;
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
public interface MultipleSubjectConverter {

    MultipleSubjectConverter INSTANCE = Mappers.getMapper(MultipleSubjectConverter.class);

    SubjectMultiple convertBoToEntity(SubjectAnswerBO subjectAnswerBO);

    List<SubjectAnswerBO> convertEntityListToAnswerList(List<SubjectMultiple> subjectMultipleList);
}
