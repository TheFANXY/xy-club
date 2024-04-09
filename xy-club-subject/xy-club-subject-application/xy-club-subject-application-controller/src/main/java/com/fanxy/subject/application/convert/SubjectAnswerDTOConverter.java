
package com.fanxy.subject.application.convert;

import com.fanxy.subject.application.dto.SubjectAnswerDTO;
import com.fanxy.subject.application.dto.SubjectInfoDTO;
import com.fanxy.subject.domin.entity.SubjectAnswerBO;
import com.fanxy.subject.domin.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * ClassName: SubjectCategoryDTOConverter
 * Package: com.fanxy.subject.application.convert
 * Description:
 *
 * @Author FanXY
 * @Create 2024/3/23 20:09
 * @Version 1.0
 */
@Mapper
public interface SubjectAnswerDTOConverter {

    SubjectAnswerDTOConverter INSTANCE = Mappers.getMapper(SubjectAnswerDTOConverter.class);

    SubjectAnswerBO convertDtoToAnswerBO(SubjectAnswerDTO subjectAnswerDTO);

    List<SubjectAnswerBO> convertDtoListToBOList(List<SubjectAnswerDTO> dtoList);

}
