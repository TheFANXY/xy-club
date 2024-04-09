package com.fanxy.subject.domin.convert;

import com.fanxy.subject.domin.entity.SubjectLabelBO;
import com.fanxy.subject.infra.basic.entity.SubjectLabel;
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
public interface SubjectLabelConverter {

    SubjectLabelConverter INSTANCE = Mappers.getMapper(SubjectLabelConverter.class);

    SubjectLabel convertBoToLabel(SubjectLabelBO subjectLabelBO);

    List<SubjectLabelBO> convertLabelListToBOList(List<SubjectLabel> subjectLabelList);
}
