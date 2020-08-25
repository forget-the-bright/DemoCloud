package com.mr.wh.domain;

import lombok.*;

/**
 * @Description:
 * @ClassName: CommonResult
 * @Author: User
 * @date: 2020.08.25 15:23
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String  message;
    private T       data;

    public CommonResult(Integer code, String message)
    {
        this(code,message,null);
    }
}
