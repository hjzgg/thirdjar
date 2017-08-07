package com.hjzgg.test.thirdjar.config;

import com.hjzgg.test.thirdjar.common.util.LogUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Configuration
@SuppressWarnings("all")
public class LogAopConfig {

    /**
     * 定义拦截规则, 拦截Service
     */
    @Pointcut("execution(* com.xxx.service..*(..))")
    public void stepTracePointCutForService(){}
    /**
     * 定义拦截规则, 拦截Dao
     */
    @Pointcut("execution(* com.bqmart.core.dao..*(..))")
    public void stepTracePointCutForDao(){}
    /**
     * 定义拦截规则, 拦截Controller
     */
    @Pointcut("execution(* com.xxx.controller..*(..))")
    public void stepTracePointCutForController(){}

    /**
     * 拦截定时任务
     */
    @Pointcut("execution(* com.xxx..*(..))")
    public void stepTracePointCutForJob(){}

    /**
     * 定义拦截方式, 执行拦截
     */
//    @Before("stepTracePointCutForService()")
    public void stepTraceForServiceInterceptor(JoinPoint joinPoint) {
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod(); // 获取被拦截的方法
            Object[] args = joinPoint.getArgs();
            Class<?> clazz = method.getDeclaringClass();
            LogUtils.stepLog(clazz, method.getName(), Arrays.toString(args));
        } catch (Exception e) {
            // 这部分不能出现异常导致业务终止
            LogUtils.errorLog(e);
        }
    }

    /**
     * 定义拦截方式, 执行拦截
     * controller log已经由RequestLog代替, 可以不用再打印了
     */
//    @Before("stepTracePointCutForController()")
    public void stepTraceForControllerInterceptor(JoinPoint joinPoint) {
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod(); // 获取被拦截的方法
            Object[] args = joinPoint.getArgs();
            Class<?> clazz = method.getDeclaringClass();
            LogUtils.stepLog(clazz, method.getName(), Arrays.toString(args));
        } catch (Exception e) {
            // 这部分不能出现异常导致业务终止
            LogUtils.errorLog(e);
        }
    }

    /**
     * 定义拦截方式, 执行拦截
     */
//    @Before("stepTracePointCutForDao()")
    public void stepTraceForDaoInterceptor(JoinPoint joinPoint) {
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod(); // 获取被拦截的方法
            Object[] args = joinPoint.getArgs();
            Class<?> clazz = method.getDeclaringClass();
            LogUtils.stepLog(clazz, method.getName(), Arrays.toString(args));
        } catch (Exception e) {
            // 这部分不能出现异常导致业务终止
            LogUtils.errorLog(e);
        }
    }

    /**
     * 定义拦截方式, 执行拦截
     */
//    @Before("stepTracePointCutForJob()")
    public void stepTraceForJonInterceptor(JoinPoint joinPoint) {
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod(); // 获取被拦截的方法
            Object[] args = joinPoint.getArgs();
            Class<?> clazz = method.getDeclaringClass();
            LogUtils.stepLog(clazz, method.getName(), Arrays.toString(args));
        } catch (Exception e) {
            // 这部分不能出现异常导致业务终止
            LogUtils.errorLog(e);
        }
    }
}
