package com.lih.blogweb.common;




import java.util.Collection;
import java.util.HashMap;


public class CommonResponse extends HashMap<String, Object> {


    private static final long serialVersionUID = 1L;

    /** 状态码 */
    public static final String CODE_TAG = "code";

    /** 返回内容 */
    public static final String MSG_TAG = "msg";

    /** 数据对象 */
    public static final String DATA_TAG = "data";


    public CommonResponse(){

    }
    public CommonResponse(int code, String msg){
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    public CommonResponse(int code, String msg, Object data)
    {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if(data!=null){
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static CommonResponse success()
    {
        return CommonResponse.success("操作成功");
    }
    public static CommonResponse success(Object data)
    {
        return CommonResponse.success("操作成功", data);
    }
    public static CommonResponse success(String msg)
    {
        return CommonResponse.success(msg, null);
    }
    public static CommonResponse success(String msg, Object data)
    {
        return new CommonResponse(200, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static CommonResponse error()
    {
        return CommonResponse.error("操作失败");
    }

    public static CommonResponse error(String msg)
    {
        return CommonResponse.error(msg, null);
    }
    public static CommonResponse error(String msg, Object data)
    {
        return new CommonResponse(500, msg, data);
    }
    public static CommonResponse error(int code, String msg)
    {
        return new CommonResponse(code, msg, null);
    }

    @Override
    public CommonResponse put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }






}
