package com.fanxy.subject.domin.convert;

import com.fanxy.subject.domin.entity.SubjectAnswerBO;
import com.fanxy.subject.domin.entity.SubjectInfoBO;
import com.fanxy.subject.infra.basic.entity.SubjectBrief;
import com.fanxy.subject.infra.basic.entity.SubjectJudge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

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
public interface BriefSubjectConverter {

    BriefSubjectConverter INSTANCE = Mappers.getMapper(BriefSubjectConverter.class);

    SubjectBrief convertBoToEntity(SubjectInfoBO subjectInfoBO);
}
