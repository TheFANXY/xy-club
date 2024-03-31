
package com.fanxy.subject.application.convert;

import com.fanxy.subject.application.dto.SubjectCategoryDTO;
import com.fanxy.subject.domin.entity.SubjectCategoryBO;
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
public interface SubjectCategoryDTOConverter {

    SubjectCategoryDTOConverter INSTANCE = Mappers.getMapper(SubjectCategoryDTOConverter.class);

    SubjectCategoryBO convertDtoToCategoryBO(SubjectCategoryDTO subjectCategoryDTO);

    List<SubjectCategoryDTO> convertBoToCategoryDTOList(List<SubjectCategoryBO> subjectCategoryBOList);

}
