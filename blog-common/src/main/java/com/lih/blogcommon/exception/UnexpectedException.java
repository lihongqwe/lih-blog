package com.lih.blogcommon.exception;

public class UnexpectedException extends ApiException{
    public UnexpectedException() {
        super( 500, "未知系统错误");
    }
    public UnexpectedException from(Exception e){
        return (UnexpectedException) e;
    }
}
