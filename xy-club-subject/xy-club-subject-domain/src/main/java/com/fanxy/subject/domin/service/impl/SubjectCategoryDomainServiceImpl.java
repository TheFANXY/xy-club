package com.fanxy.subject.domin.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fanxy.subject.domin.convert.SubjectCategoryConverter;
import com.fanxy.subject.domin.entity.SubjectCategoryBO;
import com.fanxy.subject.domin.service.SubjectCategoryDomainService;
import com.fanxy.subject.infra.basic.entity.SubjectCategory;
import com.fanxy.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: SubjectCategoryDomainServiceImpl
 * Package: com.fanxy.subject.domin.service.impl
 * Description:
 *
 * @Author FanXY
 * @Create 2024/3/23 18:20
 * @Version 1.0
 */
@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    SubjectCategoryService subjectCategoryService;

    /**
     * 增加分类
     *
     * @param subjectCategoryBO 分类BO
     * @return 是否成功
     */
    @Override
    public Boolean add(SubjectCategoryBO subjectCategoryBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainServiceImpl.add.bo:{}", JSON.toJSONString(subjectCategoryBO));
        }
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.
                convertBoToCategory(subjectCategoryBO);
        return subjectCategoryService.save(subjectCategory);
    }

    /**
     * 更新分类
     * @param subjectCategoryBO 分类BO
     * @return 是否成功
     */
    @Override
    public Boolean update(SubjectCategoryBO subjectCategoryBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainServiceImpl.update.bo:{}", JSON.toJSONString(subjectCategoryBO));
        }
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.
                convertBoToCategory(subjectCategoryBO);
        return subjectCategoryService.updateById(subjectCategory);
    }

    /**
     * 删除分类
     * @param subjectCategoryBO 分类BO
     * @return 是否成功
     */
    @Override
    public Boolean delete(SubjectCategoryBO subjectCategoryBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainServiceImpl.delete.bo:{}", JSON.toJSONString(subjectCategoryBO));
        }
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.
                convertBoToCategory(subjectCategoryBO);
        return subjectCategoryService.removeById(subjectCategory);
    }

    /**
     * 查询分类
     *
     * @param subjectCategoryBO 分类BO
     * @return 分类列表集合
     */
    @Override
    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.
                convertBoToCategory(subjectCategoryBO);
        QueryWrapper<SubjectCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_type", subjectCategory.getCategoryType());
        queryWrapper.eq("parent_Id", subjectCategory.getParentId());
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.list(queryWrapper);
        List<SubjectCategoryBO> boList = SubjectCategoryConverter.INSTANCE.
                convertCategoryListToBOList(subjectCategoryList);
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainServiceImpl.queryCategory.bo:{}", JSON.toJSONString(subjectCategoryBO));
        }
        return boList;
    }
}