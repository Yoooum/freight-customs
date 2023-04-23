package com.prprv.customs.exception;

import com.prprv.customs.common.result.Result;
import com.prprv.customs.common.result.ResultEnum;
import com.prprv.customs.common.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Yoooum
 */
@Slf4j
@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(ResultException.class)
    public Result<?> requestExceptionHandler(ResultException e) {
        log.error("requestException: " + e.getMessage(), e);
        return ResultUtil.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Result<?> runtimeExceptionHandler(RuntimeException e) {
        log.error("runtimeException", e);
        return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
    }
}
