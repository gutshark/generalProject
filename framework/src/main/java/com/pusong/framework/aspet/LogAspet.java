package com.pusong.framework.aspet;

import com.pusong.framework.annotation.LogAnnotation;
import com.pusong.framework.log.model.LogModel;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Aspect
@Component
@Order(10100)
//@Scope(value = "prototype")
public class LogAspet {
    private static final ThreadLocal<String> groupContextHolder = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return UUID.randomUUID().toString();
        }
    };

    private static final ThreadLocal<Map<String, LogModel>> loggerContextHolder = new ThreadLocal<Map<String, LogModel>>() {
        @Override
        protected Map<String, LogModel> initialValue() {
            return new HashMap<>();
        }
    };

//    @Autowired
//    private Logger logger;
//    private Logger.Log log;

    @Pointcut("@annotation(com.pusong.framework.annotation.LogAnnotation)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("log start...");
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = point.getTarget().getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        LogAnnotation logAnnotation = point
                .getTarget()
                .getClass()
                .getMethod(methodSignature.getName(), methodSignature.getParameterTypes())
                .getAnnotation(LogAnnotation.class);

        System.out.println("method: " + point.getSignature().toLongString());
        Map<String, LogModel> logMap = loggerContextHolder.get();
        LogModel logModel = new LogModel();
        logModel.setId(UUID.randomUUID().toString());
        logModel.setGroup(groupContextHolder.get());
        logModel.setStatus("0");
        logModel.setModule(logAnnotation.code());
        logModel.setDescription(logAnnotation.description());
        System.out.println("log model: " + logModel);
        logMap.put(point.getSignature().toLongString(), logModel);

//        log = logger.init(logAnnotation, SecurityContextHolder.getContext().getAuthentication());
//        if (log != null) {
//            log.start();
//        }

        Object result = point.proceed();

        logModel.setStatus("1");
//        logMap.remove(point.getSignature().toLongString());
//        if (log != null) {
//            log.over();
//        }
        System.out.println("log model: " + logModel);
        System.out.println("log end.");

        return result;
    }

    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void afterthrowing(JoinPoint point, Throwable e) {

        System.out.println("exception - signature: " + point.getSignature().getName());
        System.out.println("method: " + point.getSignature().toLongString());

        Map<String, LogModel> logMap = loggerContextHolder.get();
        LogModel logModel = logMap.get(point.getSignature().toLongString());
        logModel.setStatus("2");
        logModel.setMessage(e.getMessage());
        System.out.println("log model: " + logModel);

        boolean haveItem = false;
        for (Map.Entry<String, LogModel> entry : logMap.entrySet()) {
            if ("0".equals(entry.getValue().getStatus())) {
                haveItem = true;
            }
        }

        if (!haveItem) {
            System.out.println("成功的项都回填为失败.");
            for (Map.Entry<String, LogModel> entry : logMap.entrySet()) {
                if ("1".equals(entry.getValue().getStatus())) {
                    entry.getValue().setStatus("2");
                    entry.getValue().setMessage(e.getMessage());
                    System.out.println("log model: " + entry.getValue());
                }
            }
        }
//        logMap.remove(point.getSignature().toLongString());
//        if (log != null) {
//            log.error();
//        }
        System.out.println("log exception: " + e.getMessage());
    }
}
