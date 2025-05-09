package com.lufeijun.cloud.common.reponse;

import lombok.Data;

@Data
public class ApiTResponse<T> {
    private int status = 0; // 状态码
    private String message = "success"; // 消息
    private T values; // 数据列表

    // 无参构造函数
    public ApiTResponse() {

    }

    // 全参构造函数
    public ApiTResponse(int status, String message, T values) {
        this.status = status;
        this.message = message;
        this.values = values;
    }

    // 正常返回时，只需要填写返回数据即可
    public ApiTResponse(T values) {
        this.values = values;
    }
}
