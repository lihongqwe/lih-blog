package com.lih.blogcommon.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ApiException extends RuntimeException{

    protected Integer httpCode;
    protected String errMsg;

    public ApiException( Integer httpCode, String errMsg){

        this.httpCode = httpCode;
        this.errMsg = errMsg;

    }

    public ApiException(){

    }



    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .append("httpCode", getHttpCode())
            .append("errMsg", getErrMsg())
            .toString();
    }
}
