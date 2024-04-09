package com.fanxy.subject.application.convert;

import com.fanxy.subject.application.dto.SubjectLabelDTO;
import com.fanxy.subject.domin.entity.SubjectLabelBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Description:
 *    标签DTO转化器
 * @Author FanXY
 * @Create 2024/3/31 16:53
 * @Version 1.0
 */
@Mapper
public interface SubjectLabelDTOConverter {

    SubjectLabelDTOConverter INSTANCE = Mappers.getMapper(SubjectLabelDTOConverter.class);

    SubjectLabelBO convertDtoToLabelBO(SubjectLabelDTO subjectLabelDTO);

    List<SubjectLabelDTO> convertBoListToDTOList(List<SubjectLabelBO> subjectLabelBoList);
}
