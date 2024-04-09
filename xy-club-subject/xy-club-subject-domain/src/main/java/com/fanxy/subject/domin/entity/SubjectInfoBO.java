package com.fanxy.subject.domin.entity;

import com.fanxy.subject.common.entity.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 题目DTO
 */
@Data
public class SubjectInfoBO extends PageInfo implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 题目名称
     */
    private String subjectName;

    /**
     * 题目难度
     */
    private Integer subjectDifficult;

    /**
     * 出题人名
     */
    private String settleName;

    /**
     * 题目类型 1单选 2多选 3判断 4简答
     */
    private Integer subjectType;

    /**
     * 题目分数
     */
    private Integer subjectScore;

    /**
     * 题目解析
     */
    private String subjectParse;

    /**
     * 题目答案
     */
    private String subjectAnswer;

    /**
     * 分类id集合
     */
    private List<Integer> categoryIds;

    /**
     * 标签id集合
     */
    private List<Integer> labelIds;

    /**
     * 标签name集合【查询题目详情的返回属性】
     */
    private List<String> labelNames;

    /**
     * 题目选项
     */
    private List<SubjectAnswerBO> optionList;

    /**
     * 分类id【用于条件查询】
     */
    private Long categoryId;

    /**
     * 标签id【用于条件查询】
     */
    private Long labelId;

    private static final long serialVersionUID = 1L;
}