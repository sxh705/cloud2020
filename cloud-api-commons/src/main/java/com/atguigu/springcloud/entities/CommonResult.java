package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult {
    public static final int CODE_SUCCESS = 200;
    public static final int CODE_FAIL = 400;

    private Integer code;
    private String message;
    private Object data;

}
