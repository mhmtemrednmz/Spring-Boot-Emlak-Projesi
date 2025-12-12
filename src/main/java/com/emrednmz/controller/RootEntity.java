package com.emrednmz.controller;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class RootEntity <T>{
    private int status;
    private T payload;
    private String errorMessage;

    public static <T> RootEntity <T> ok(T payload){
        RootEntity <T> root = new RootEntity <T>();
        root.setPayload(payload);
        root.setStatus(200);
        root.setErrorMessage(null);
        return root;
    }

    public static <T> RootEntity <T> error(String errorMessage){
        RootEntity <T> root = new RootEntity <T>();
        root.setErrorMessage(errorMessage);
        root.setStatus(400);
        root.setPayload(null);
        return root;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
