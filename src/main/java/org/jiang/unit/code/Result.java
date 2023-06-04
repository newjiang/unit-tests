package org.jiang.unit.code;

import lombok.Data;

@Data
public class Result<T> {
    /**
     * 返回码
     */
    private int code;
    /**
     * 消息
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    /**
     * 成功
     *
     * @param data 数据
     * @param <T>  数据类型
     * @return 成功结果
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("success");
        result.setData(data);
        return result;
    }

    /**
     * 失败
     *
     * @param message 错误信息
     * @param <T>     数据类型
     * @return 失败结果
     */
    public static <T> Result<T> failure(String message) {
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMessage(message);
        return result;
    }
}
