package com.hjzgg.test.thirdjar.web.interceptor;

import com.hjzgg.test.thirdjar.common.constant.CodeConstant;
import com.hjzgg.test.thirdjar.common.exception.BaseException;
import com.hjzgg.test.thirdjar.common.util.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Configuration
public class CustomExceptionHandler implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        return printErrorInfo(ex);
    }

    private ModelAndView printErrorInfo(Exception ex) {
        ModelAndView mav = new ModelAndView();
        if (ex instanceof BaseException) {
            LogUtils.exceptionLog(ex.getMessage());
            BaseException be = (BaseException) ex;
            mav.addObject("code", be.getCode());
            mav.addObject("message", be.getMessage());
            mav.addObject("data", null);
        } else {
            LogUtils.errorLog(ex);
            mav.addObject("code", CodeConstant.Normal.FAILURE);
            mav.addObject("message", CodeConstant.Normal.FAILURE_MSG);
            mav.addObject("data", null);
        }
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }
}
