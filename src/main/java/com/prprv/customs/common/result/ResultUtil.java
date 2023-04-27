package com.prprv.customs.common.result;

/**
 * 返回结果工具类
 * @author phj233
 * @since 2023/4/23 9:43
 */
public class ResultUtil {
    public static <T> Result<T> success(T data) {
        ResultEnum r = ResultEnum.SUCCESS;
        return new Result<>(r.getCode(), r.getMsg(), data);
    }
    public static <T> Result<T> success() {
        ResultEnum r = ResultEnum.SUCCESS;
        return new Result<>(r.getCode(), r.getMsg(), null);
    }

    public static <T> Result<T> error(ResultEnum code) {
        return new Result<>(code.getCode(), code.getMsg(), null);
    }

    public static <T> Result<T> error(ResultEnum code, String msg) {
        return new Result<>(code.getCode(), msg, null);
    }
}

