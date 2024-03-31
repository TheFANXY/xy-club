package com.fanxy.subject.common.enums;

import lombok.Getter;

/**
 * ClassName: ResultCode
 * Package: com.fanxy.subject.common.enums
 * Description:
 *
 * @Author FanXY
 * @Create 2024/3/26 0:20
 * @Version 1.0
 */

@Getter
public enum isDeletedFlagEnum {
    SUCCESS(1, "已删除"),
    FAIL(0, "未删除");

    // 状态码
    private final int code;
    //
    private final String desc;

    isDeletedFlagEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static isDeletedFlagEnum getByCode(int codeVal) {
        for (isDeletedFlagEnum resultCodeEnum : isDeletedFlagEnum.values()) {
            if (resultCodeEnum.code == codeVal) {
                return resultCodeEnum;
            }
        }
        return null;
    }
}
