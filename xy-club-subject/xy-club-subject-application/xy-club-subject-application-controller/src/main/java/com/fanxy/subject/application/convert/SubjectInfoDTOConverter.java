
package com.fanxy.subject.application.convert;

import com.fanxy.subject.application.dto.SubjectInfoDTO;
import com.fanxy.subject.domin.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

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
public interface SubjectInfoDTOConverter {

    SubjectInfoDTOConverter INSTANCE = Mappers.getMapper(SubjectInfoDTOConverter.class);

    SubjectInfoBO convertDtoToInfoBO(SubjectInfoDTO subjectInfoDTO);

    SubjectInfoDTO convertBoToDto(SubjectInfoBO subjectInfoBO);
}
