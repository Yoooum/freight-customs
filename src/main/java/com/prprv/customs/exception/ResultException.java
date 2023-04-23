package com.prprv.customs.exception;

import com.prprv.customs.common.result.ResultEnum;

/**
 * @author Yoooum
 */
public class ResultException extends RuntimeException {
    private final ResultEnum code;

    public ResultException(ResultEnum code, String message) {
        super(message);
        this.code = code;
    }

    public ResultException(ResultEnum code) {
        super(code.getMsg());
        this.code = code;
    }

    public ResultEnum getCode() {
        return code;
    }
}
