package com.pusong.framework.log.model;

import java.util.Date;

public class LogModel {
    private String id;
    private String group;
    private String module;
    private String function;
    private String description;
    private String operator;
    private Date startTime;
    private Date overTime;
    private String status;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LogModel{" +
                "id='" + id + '\'' +
                ", group='" + group + '\'' +
                ", module='" + module + '\'' +
                ", function='" + function + '\'' +
                ", description='" + description + '\'' +
                ", operator='" + operator + '\'' +
                ", startTime=" + startTime +
                ", overTime=" + overTime +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
