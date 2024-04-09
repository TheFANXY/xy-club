package com.fanxy.subject.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: PageInfo
 * Package: com.fanxy.subject.common.entity
 * Description:
 *
 * @Author FanXY
 * @Create 2024/4/6 23:30
 * @Version 1.0
 */
@Data
public class PageInfo implements Serializable {

    /**
     * 默认页号 1
     */
    private static final Integer DEFAULT_PAGE_NO = 1;
    /**
     * 默认页面数 20
     */
    private static final Integer DEFAULT_PAGE_SIZE = 20;

    private Integer pageNo = DEFAULT_PAGE_NO;

    private Integer pageSize = DEFAULT_PAGE_SIZE;

    public Integer getPageNo() {
        if (pageNo == null || pageNo < DEFAULT_PAGE_NO) {
            return DEFAULT_PAGE_NO;
        }
        return pageNo;
    }
    public Integer getPageSize() {
        if (pageSize == null || pageSize < DEFAULT_PAGE_SIZE || pageSize > Integer.MAX_VALUE) {
            return DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }
}
