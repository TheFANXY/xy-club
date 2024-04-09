package com.fanxy.subject.domin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 题目DTO
 */
@Data
public class SubjectOptionBO implements Serializable {

    /**
     * 题目答案
     */
    private String subjectAnswer;
    /**
     * 题目选项
     */
    private List<SubjectAnswerBO> optionList;

    private static final long serialVersionUID = 6779519098276153482L;
}