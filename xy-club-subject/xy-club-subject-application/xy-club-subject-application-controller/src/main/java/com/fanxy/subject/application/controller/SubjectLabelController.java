package com.fanxy.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.fanxy.subject.application.convert.SubjectLabelDTOConverter;
import com.fanxy.subject.application.dto.SubjectLabelDTO;
import com.fanxy.subject.common.entity.Result;
import com.fanxy.subject.domin.entity.SubjectLabelBO;
import com.fanxy.subject.domin.service.SubjectLabelDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: SubjectLabelController
 * Package: com.fanxy.subject.application.controller
 * Description:
 *
 * @Author FanXY
 * @Create 2024/3/31 16:49
 * @Version 1.0
 */
@RestController
@RequestMapping("/subject/label")
@Slf4j
public class SubjectLabelController {

    @Resource
    private SubjectLabelDomainService subjectLabelDomainService;

    /**
     * 新增标签
     * @param subjectLabelDTO 标签DTO
     * @return 是否成功
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.add.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }
            // 参数校验
            Preconditions.checkNotNull(subjectLabelDTO.getCategoryId(), "分类id不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(subjectLabelDTO.getLabelName()), "标签名称不能为空");
            SubjectLabelBO subjectCategoryBO = SubjectLabelDTOConverter.INSTANCE.
                    convertDtoToLabelBO(subjectLabelDTO);
            Boolean result = subjectLabelDomainService.add(subjectCategoryBO);
            return  Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectLabelController.add.error:{}", e.getMessage(), e);
            return Result.fail("新增标签失败");
        }
    }

    /**
     * 更新标签
     * @param subjectLabelDTO 标签DTO
     * @return 是否成功
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.update.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }
            // 参数校验
            Preconditions.checkNotNull(subjectLabelDTO.getId(), "标签id不能为空");
            SubjectLabelBO subjectCategoryBO = SubjectLabelDTOConverter.INSTANCE.
                    convertDtoToLabelBO(subjectLabelDTO);
            Boolean result = subjectLabelDomainService.update(subjectCategoryBO);
            return  Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectLabelController.update.error:{}", e.getMessage(), e);
            return Result.fail("更新标签失败");
        }
    }

    /**
     * 删除标签
     * @param subjectLabelDTO 标签DTO
     * @return 是否成功
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.delete.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }
            // 参数校验
            Preconditions.checkNotNull(subjectLabelDTO.getId(), "标签id不能为空");
            SubjectLabelBO subjectCategoryBO = SubjectLabelDTOConverter.INSTANCE.
                    convertDtoToLabelBO(subjectLabelDTO);
            Boolean result = subjectLabelDomainService.delete(subjectCategoryBO);
            return  Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.delete.error:{}", e.getMessage(), e);
            return Result.fail("删除标签失败");
        }
    }

    /**
     * 查询分类下标签
     * @param subjectLabelDTO 标签DTO
     * @return 查询分类下标签列表集合
     */

    @PostMapping("/queryLabelByCategoryId")
    public Result<List<SubjectLabelDTO>> queryLabelByCategoryId(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.queryLabelByCategoryId.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }
            // 参数校验
            Preconditions.checkNotNull(subjectLabelDTO.getCategoryId(), "分类id不能为空");
            SubjectLabelBO subjectCategoryBO = SubjectLabelDTOConverter.INSTANCE.
                    convertDtoToLabelBO(subjectLabelDTO);
            List<SubjectLabelBO> subjectLabelBOList = subjectLabelDomainService.queryLabelByCategoryId(subjectCategoryBO);
            List<SubjectLabelDTO> result = SubjectLabelDTOConverter.INSTANCE.
                    convertBoListToDTOList(subjectLabelBOList);
            return  Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryLabelByCategoryId.error:{}", e.getMessage(), e);
            return Result.fail("查询分类下标签失败");
        }
    }
}
