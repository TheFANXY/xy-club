package com.fanxy.subject.domin.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fanxy.subject.common.entity.PageResult;
import com.fanxy.subject.domin.convert.SubjectInfoConverter;
import com.fanxy.subject.domin.entity.SubjectInfoBO;
import com.fanxy.subject.domin.entity.SubjectOptionBO;
import com.fanxy.subject.domin.handler.subject.SubjectTypeHandler;
import com.fanxy.subject.domin.handler.subject.SubjectTypeHandlerFactory;
import com.fanxy.subject.domin.service.SubjectInfoDomainService;
import com.fanxy.subject.infra.basic.entity.SubjectInfo;
import com.fanxy.subject.infra.basic.entity.SubjectLabel;
import com.fanxy.subject.infra.basic.entity.SubjectMapping;
import com.fanxy.subject.infra.basic.service.SubjectInfoService;
import com.fanxy.subject.infra.basic.service.SubjectLabelService;
import com.fanxy.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */

@Service
@Slf4j
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {

    @Resource
    SubjectInfoService subjectInfoService;

    @Resource
    SubjectTypeHandlerFactory subjectTypeHandlerFactory;

    @Resource
    SubjectMappingService subjectMappingService;

    @Resource
    SubjectLabelService subjectLabelService;

    /**
     * 增加课程
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SubjectInfoBO subjectInfoBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectDomainServiceImpl.add.dto:{}", JSON.toJSONString(subjectInfoBO));
        }
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.
                convertBoToInfo(subjectInfoBO);
        subjectInfoService.save(subjectInfo);
        // mybatis-plus 可以实现自动主键回显 因此传递给 subjectInfoBO 用于策略模式的副表更新
        subjectInfoBO.setId(subjectInfo.getId());
        // 工厂模型获取对应的 handler 并进行策略模式的处理
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        handler.add(subjectInfoBO);
        // 关联表更新
        List<Integer> categoryIds = subjectInfoBO.getCategoryIds();
        List<Integer> labelIds = subjectInfoBO.getLabelIds();
        List<SubjectMapping> subjectMappingList = new LinkedList<>();
        labelIds.forEach(labelId -> {
            categoryIds.forEach(categoryId -> {
                SubjectMapping subjectMapping = new SubjectMapping();
                subjectMapping.setSubjectId(subjectInfo.getId());
                subjectMapping.setLabelId(Long.valueOf(labelId));
                subjectMapping.setCategoryId(Long.valueOf(categoryId));
                subjectMappingList.add(subjectMapping);
            });
        });
        subjectMappingService.saveBatch(subjectMappingList);
    }

    @Override
    public PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO) {
        PageResult<SubjectInfoBO> pageResult = new PageResult<>();
        pageResult.setPageNo(subjectInfoBO.getPageNo());
        pageResult.setPageSize(subjectInfoBO.getPageSize());
        // 这里的 start 不需要加1 因为数据库的分页是 0 开始
        int start = (subjectInfoBO.getPageNo() - 1) * subjectInfoBO.getPageSize();
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.
                convertBoToInfo(subjectInfoBO);
        // 查询符合条件的课程数量
        int count = subjectInfoService.countByCondition(subjectInfo, subjectInfoBO.getCategoryId(),
                subjectInfoBO.getLabelId());
        if (count == 0) {
            return pageResult;
        }
        // 根据数量 起始页码 以及类别和标签条件 查询分页需要查询的集合列表
        List<SubjectInfo> subjectInfoList = subjectInfoService.queryPage(subjectInfo, subjectInfoBO.getCategoryId(),
                subjectInfoBO.getLabelId(), start, subjectInfoBO.getPageSize());
        List<SubjectInfoBO> subjectInfoBOList = SubjectInfoConverter.INSTANCE.
                convertEntityListToBoList(subjectInfoList);
        pageResult.setRecords(subjectInfoBOList);
        return pageResult;
    }

    @Override
    public SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO) {
        // 查询主表信息
        SubjectInfo subjectInfo = subjectInfoService.getById(subjectInfoBO.getId());
        // 策略模式查询该类副表
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        SubjectOptionBO optionBO = handler.query(subjectInfo.getId().intValue());
        // 主表副表信息合并为 BO 实体
        SubjectInfoBO bo = SubjectInfoConverter.INSTANCE.convertOptionAndInfoToBo(optionBO, subjectInfo);
        // 查询当前题目的标签名称集合 需要使用到关联表 先通过关联表查询该题目对应的所有labelId
        Long subjectId = subjectInfo.getId();
        QueryWrapper<SubjectMapping> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("subject_id", subjectId);
        queryWrapper.select("DISTINCT label_id");
        List<SubjectMapping> subjectMappingList = subjectMappingService.list(queryWrapper);
        List<Long> labelIdList = subjectMappingList.stream().
                map(SubjectMapping::getLabelId)
                .collect(Collectors.toList());
        // 通过获取的该题目所有labelId 批量查询所有的SubjectLabel 并通过流转化为名称 存入上面组装的 bo 实体
        List<SubjectLabel> subjectLabels = subjectLabelService.listByIds(labelIdList);
        List<String> labelNameList = subjectLabels.stream().map(SubjectLabel::getLabelName).collect(Collectors.toList());
        bo.setLabelNames(labelNameList);
        return bo;
    }
}
