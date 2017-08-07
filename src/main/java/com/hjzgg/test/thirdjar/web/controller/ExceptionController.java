package com.hjzgg.test.thirdjar.web.controller;

import com.hjzgg.test.thirdjar.common.annotation.CustomCrossOrigin;
import com.hjzgg.test.thirdjar.common.exception.ValueError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/error")
@CustomCrossOrigin
public class ExceptionController {

    @RequestMapping(value = "/throw", method = {RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.POST, RequestMethod.GET})
    public Object errorThrow(HttpServletRequest request) throws ValueError {
        String code = (String) request.getAttribute("code");
        String message = (String) request.getAttribute("message");
        throw new ValueError(code, message);
    }
}
