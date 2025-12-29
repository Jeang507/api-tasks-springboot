package com.task.apitask.error;


public class ApiException extends RuntimeException{

    private String code; 
    private String detail;

    public ApiException(String code, String detail) {
        super(detail);
        this.code = code;

    }

    public String getCode() {
        return code;
    }

    public String getDetail() {
        return detail;
    }    
    
}
