package com.hjzgg.test.thirdjar.web.interceptor;

import com.hjzgg.test.thirdjar.common.annotation.Resubmit;
import com.hjzgg.test.thirdjar.common.constant.CodeConstant;
import com.hjzgg.test.thirdjar.common.util.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * 重复请求阻止拦截器
 */
//@Component("resubmitInterceptorHandler")
public class ResubmitInterceptorHandler extends HandlerInterceptorAdapter {

    private RedisUtils redisUtils;

    public ResubmitInterceptorHandler(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    /**
     * 拦截重复提交的请求
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            Resubmit resubmit = method.getMethodAnnotation(Resubmit.class);
            if (resubmit == null) {
                return true;
            } else {
                Long seconds = resubmit.seconds();
                // 获取重复提交的键值
                String key = getKey(request, method);
                String value = redisUtils.get(key, String.class);
                if (StringUtils.isBlank(value)) {
                    // 如果存在就存储到redis中
                    redisUtils.set(key, seconds.toString(), seconds);
                    return true;
                } else {
                    request.setAttribute("code", CodeConstant.Normal.FAILURE);
                    request.setAttribute("message", "请不要在" + seconds + "秒内重复请求");
                    request.getRequestDispatcher("/error/throw").forward(request, response);
//                    throw new ValueError(CodeConstant.Normal.FAILURE, "请不要在" + seconds + "秒内重复请求");
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 获取redis存储的键
     *
     * @param request
     * @param method
     * @return
     */
    private String getKey(HttpServletRequest request, HandlerMethod method) {
        StringBuffer sb = new StringBuffer();
        String sessionId = request.getSession().getId();
        sb.append(sessionId);
        String requestURI = request.getRequestURI();
        // 拼接请求路径
        sb.append(requestURI);
        Method targetMethod = method.getMethod();
        // 拼接目标方法名称
        sb.append(targetMethod.getName());
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (parameterMap != null) {
            Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
            if (entries != null) {
                for (Map.Entry<String, String[]> entry : entries) {
                    sb.append(entry.getKey()).append(Arrays.toString(entry.getValue()));
                }
            }
        }
        return sb.toString();
    }
}
