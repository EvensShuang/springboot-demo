package com.shuang.controller.base;


import com.shuang.util.RestResult;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

/**
 * <描述>
 *
 * @Author: zhengbin.jin
 * @Email: zhengbin.jin@rograndec.com
 * @CreateDate: 2018/4/23
 * @Version: 1.0
 */
@ControllerAdvice
public class BaseController {

    /**
     * <JSR-303>
     *
     * @Author: Zhengbin.jin 金正斌
     * @Email: Zhengbin.jin@rograndec.com
     * @2018/7/16 15:55
     */
    @ExceptionHandler(BindException.class)
    public RestResult<T> validMessage(BindException exception) {
        BindingResult result = exception.getBindingResult();
        String msg = "校验失败";
        List<FieldError> list = result.getFieldErrors();
        for (FieldError error : list) {
            msg = error.getDefaultMessage();
            break;
        }
        return RestResult.genErrorResult(msg);
    }

}
