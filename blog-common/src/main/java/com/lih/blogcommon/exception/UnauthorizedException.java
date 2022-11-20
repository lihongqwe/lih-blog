package com.lih.blogcommon.exception;

public class UnauthorizedException extends ApiException {
    public UnauthorizedException(String detail) {
        super( 401,  detail);
    }
}
