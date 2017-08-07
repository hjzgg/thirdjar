package com.hjzgg.test.thirdjar.common.util;

import com.hjzgg.test.thirdjar.common.constant.CodeConstant;
import com.hjzgg.test.thirdjar.common.exception.ValueError;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;


public class ValidateUtils {

    private boolean ifCheckFlag = false;

    public ValidateUtils() {
    }

    public ValidateUtils(boolean ifCheckFlag) {
        this.ifCheckFlag = ifCheckFlag;
    }

    /**
     * 参数错误检查
     * @param request
     * @param obj
     * @param clazz
     * @param br
     * @param <T>
     */
    public <T> void check(HttpServletRequest request, Object obj, Class<T> clazz, BindingResult br) throws ValueError {
        // 日志还是要打印滴....
        this.log(obj);
        // 如果关闭检查, 就跳过检查
        if (!ifCheckFlag) {
            return ;
        }
        if (br != null) {
            if (br.hasFieldErrors()) {
                throw new ValueError(CodeConstant.ParamCheck.VALUE_ERROR_CODE, br.getFieldError().getDefaultMessage());
            }
        }
        paramValid(request, obj, clazz);
    }

    /**
     * 参数校验
     * @param obj
     * @param clazz
     * @param <T>
     */
    public <T> void paramValid(HttpServletRequest request, Object obj, Class<T> clazz) {

    }

    /**
     * 请求日志打印
     * @param params
     */
    private void log(Object params) {
        LogUtils.requestLog(params);
    }
}
