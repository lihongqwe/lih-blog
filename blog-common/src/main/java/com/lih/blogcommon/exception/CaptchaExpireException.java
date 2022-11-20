package com.lih.blogcommon.exception;

public class CaptchaExpireException extends ApiException{
    public CaptchaExpireException(String detail) {
        super(400,detail);
    }
}
