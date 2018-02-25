package com.pusong.framework.log.impl;

import com.pusong.framework.annotation.LogAnnotation;
import com.pusong.framework.authorization.service.AuthenticationService;
import com.pusong.framework.log.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoggerImpl implements Logger {

    @Autowired
    private AuthenticationService authenticationService;
    private static final ThreadLocal<Map<Integer, Log>> logContext = new ThreadLocal<Map<Integer, Log>>(){
        @Override
        protected Map<Integer, Log> initialValue() {
            return new HashMap<>();
        }
    };
//    private static final ThreadLocal<LogModel> logId = new ThreadLocal<LogModel>() {
//        @Override
//        protected LogModel initialValue() {
//            LogModel model = new LogModel();
//
//            model.setId(UUID.randomUUID().toString());
//            model.setModule("");
//            model.setDescription("");
//            model.setOperator("");
//
//            return model;
//        }
//    };

    @Override
    public Log init(LogAnnotation logAnnotation, Authentication auth) {
        Log log = new Log(logAnnotation, authenticationService);
        logContext.get().put(log.hashCode(), log);
        return log;
//        LogModel model;
//        Map<String, LogModel> logMap = logContext.get();
//        if (logMap.containsKey(logAnnotation.code())) {
//            model = logMap.get(logAnnotation);
//        } else {
//            model=new LogModel();
//            model.setId(UUID.randomUUID().toString());
//            logMap.put(logAnnotation.code(), model);
//        }
//
//        model.setModule(logAnnotation.code());
//        model.setDescription(logAnnotation.description());
//        AuthUserModel authUserModel = authenticationService.get(auth);
//        model.setOperator(authUserModel.getId());
//
//        System.out.println(model.toString());
    }


}

