package com.lih.blogcommon.exception;

public class GeneralException extends ApiException{
    public GeneralException(String detail) {
        super(400,detail);
    }
}
