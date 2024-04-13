package com.fanxy.subject.domin.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fanxy.subject.common.enums.CategoryTypeEnum;
import com.fanxy.subject.domin.convert.SubjectLabelConverter;
import com.fanxy.subject.domin.entity.SubjectLabelBO;
import com.fanxy.subject.domin.service.SubjectLabelDomainService;
import com.fanxy.subject.infra.basic.entity.SubjectCategory;
import com.fanxy.subject.infra.basic.entity.SubjectLabel;
import com.fanxy.subject.infra.basic.entity.SubjectMapping;
import com.fanxy.subject.infra.basic.service.SubjectCategoryService;
import com.fanxy.subject.infra.basic.service.SubjectLabelService;
import com.fanxy.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: SubjectLabelDomainServiceImpl
 * Package: com.fanxy.subject.domin.service.impl
 * Description:
 *
 * @Author FanXY
 * @Create 2024/3/31 17:10
 * @Version 1.0
 */
@Service
@Slf4j
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Resource
    SubjectLabelService subjectLabelService;

    @Resource
    SubjectCategoryService subjectCategoryService;
    @Resource
    SubjectMappingService subjectMappingService;

    /**
     * 新增标签
     * @param subjectLabelBO 标签BO
     * @return 是否成功
     */
    @Override
    public Boolean add(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.add.bo:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.
                convertBoToLabel(subjectLabelBO);
        return subjectLabelService.save(subjectLabel);
    }
    /**
     * 更新标签
     * @param subjectLabelBO 标签BO
     * @return 是否成功
     */
    @Override
    public Boolean update(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.update.bo:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.
                convertBoToLabel(subjectLabelBO);
        return subjectLabelService.updateById(subjectLabel);
    }
    /**
     * 删除标签
     * @param subjectLabelBO 标签BO
     * @return 是否成功
     */
    @Override
    public Boolean delete(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.delete.bo:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.
                convertBoToLabel(subjectLabelBO);
        return subjectLabelService.removeById(subjectLabel);
    }
    /**
     * 查询分类下标签
     * @param subjectLabelBO 标签BO
     * @return 指定分类的标签列表集合
     */
    @Override
    public List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.queryLabelByCategoryId.bo:{}",
                    JSON.toJSONString(subjectLabelBO));
        }
        // 如果当前分类是1级分类，则查询所有标签
        Long categoryId = subjectLabelBO.getCategoryId();
        SubjectCategory subjectCategory = subjectCategoryService.getById(categoryId);
        if (CategoryTypeEnum.PRIMARY.getCode() == subjectCategory.getCategoryType()) {
            QueryWrapper<SubjectLabel> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("category_id", categoryId);
            List<SubjectLabel> labelList = subjectLabelService.list(queryWrapper);
            return SubjectLabelConverter.INSTANCE.convertLabelListToBOList(labelList);
        }
        // 如果不是1级分类 则根据关联表查询符合条件标签
        QueryWrapper<SubjectMapping> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_id", categoryId);
        queryWrapper.select("DISTINCT label_id");
        List<SubjectMapping> mappingList = subjectMappingService.list(queryWrapper);
        if (CollectionUtils.isEmpty(mappingList)) {
            return Collections.emptyList();
        }
        List<Long> labelIdList = mappingList.stream().
                map(SubjectMapping::getLabelId).
                collect(Collectors.toList());
        List<SubjectLabel> labelList = subjectLabelService.listByIds(labelIdList);
        return SubjectLabelConverter.INSTANCE.convertLabelListToBOList(labelList);
    }
}