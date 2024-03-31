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
public enum ResultCodeEnum {
    SUCCESS(200, "成功"),
    FAIL(500, "失败");

    // 状态码
    private final int code;
    //
    private final String desc;

    ResultCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ResultCodeEnum getByCode(int codeVal) {
        for (ResultCodeEnum resultCodeEnum : ResultCodeEnum.values()) {
            if (resultCodeEnum.code == codeVal) {
                return resultCodeEnum;
            }
        }
        return null;
    }
}
