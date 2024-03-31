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
public enum CategoryTypeEnum {
    PRIMARY(1, "岗位大类"),
    SECOND(2, "二级分类");

    // 状态码
    private final int code;
    //
    private final String desc;

    CategoryTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static CategoryTypeEnum getByCode(int codeVal) {
        for (CategoryTypeEnum resultCodeEnum : CategoryTypeEnum.values()) {
            if (resultCodeEnum.code == codeVal) {
                return resultCodeEnum;
            }
        }
        return null;
    }
}
