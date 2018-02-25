package com.pusong.framework.log;

import com.pusong.framework.annotation.LogAnnotation;
import com.pusong.framework.authorization.service.AuthenticationService;
import com.pusong.framework.log.impl.LoggerImpl;
import com.pusong.framework.log.model.LogModel;
import org.springframework.security.core.Authentication;

import java.util.Date;
import java.util.UUID;

public interface Logger {
    LoggerImpl.Log init(LogAnnotation logAnnotation, Authentication auth);

//    void start();
//
//    void over();
//
//    void error();

    class Log {
        private LogModel logModel;
        private AuthenticationService authenticationService;

        public Log(LogAnnotation logAnnotation, AuthenticationService authenticationService) {
            this.logModel = new LogModel();
            logModel.setId(UUID.randomUUID().toString());
            this.authenticationService = authenticationService;
        }

        public void start() {
            System.out.println("logger start...");

            logModel.setStartTime(new Date());
            logModel.setStatus("0");

            System.out.println(logModel.toString());
        }

        public void over() {
            System.out.println("logger over.");

            logModel.setOverTime(new Date());
            logModel.setStatus("1");
            logModel.setMessage("SUCCESS");

            System.out.println(logModel.toString());
        }

        public void error() {
            System.out.println("logger error.");

            logModel.setOverTime(new Date());
            logModel.setStatus("2");
            logModel.setMessage("FAILED");

            System.out.println(logModel.toString());
        }

    }
}
