package com.fanxy.subject.application.dto;

import lombok.Data;

/**
 * Description:
 *      题目答案DTO
 * @Author FanXY
 * @Create 2024/4/2 20:53
 * @Version 1.0
 */
@Data
public class SubjectAnswerDTO {

    /**
     * 选项类型标识
     */
    private Integer optionType;

    /**
     * 选项内容
     */
    private String optionContent;

    /**
     * 是否正确
     */
    private Integer isCorrect;
}
