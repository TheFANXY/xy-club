package com.fanxy.subject.application.controller;

import com.fanxy.subject.infra.basic.entity.SubjectCategory;
import com.fanxy.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName: SubjectController
 * Package: com.fanxy.subject.application.controller
 * Description:
 *
 *      刷题Controller
 *
 * @Author FanXY
 * @Create 2024/3/12 20:41
 * @Version 1.0
 */
@RestController
public class SubjectController {

    @Resource
    SubjectCategoryService subjectCategoryService;

    @GetMapping("/test")
    public String test() {
        SubjectCategory subjectCategory = subjectCategoryService.getById(1L);
        return subjectCategory.getCategoryName();
    }
}
