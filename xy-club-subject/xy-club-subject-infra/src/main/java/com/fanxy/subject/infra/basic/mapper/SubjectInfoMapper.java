package com.fanxy.subject.infra.basic.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fanxy.subject.infra.basic.entity.SubjectInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

;

/**
 * @author FanXY
 * @description 针对表【subject_info(题目信息表)】的数据库操作Mapper
 * @createDate 2024-04-02 18:57:34
 * @Entity generator.domain.SubjectInfo
 */
public interface SubjectInfoMapper extends BaseMapper<SubjectInfo> {

    int countByCondition(@Param("subjectInfo") SubjectInfo subjectInfo,
                         @Param("categoryId") Long categoryId,
                         @Param("labelId") Long labelId);

    List<SubjectInfo> queryPage(@Param("subjectInfo") SubjectInfo subjectInfo,
                                @Param("categoryId") Long categoryId,
                                @Param("labelId") Long labelId,
                                @Param("start") int start,
                                @Param("pageSize") Integer pageSize);
}




