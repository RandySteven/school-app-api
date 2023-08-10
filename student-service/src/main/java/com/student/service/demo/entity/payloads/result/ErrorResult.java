package com.student.service.demo.entity.payloads.result;

public class ErrorResult <T>{

    private T errorContext;

    public T getErrorContext(){
        return errorContext;
    }

    public void setErrorContext(T errorContext){
        this.errorContext = errorContext;
    }

    public ErrorResult(){

    }

    public ErrorResult(T errorContext){
        this.errorContext = errorContext;
    }

}
