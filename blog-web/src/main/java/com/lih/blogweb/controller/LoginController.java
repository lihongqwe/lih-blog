package com.lih.blogweb.controller;

import com.lih.blogcommon.utils.StringUtils;
import com.lih.blogsystem.entity.LoginBody;
import com.lih.blogsystem.entity.LoginUser;
import com.lih.blogsystem.service.LoginService;
import com.lih.blogweb.common.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService LoginService;

    @PostMapping("login")
    public CommonResponse login(@RequestBody LoginBody loginBody){
        CommonResponse response = new CommonResponse();
        if(StringUtils.isNotEmpty(loginBody.getCode())){
            String token = LoginService.login(loginBody);
            response.put("token",token);
            return  CommonResponse.success(response);
        }
        return CommonResponse.error("请输入验证码");
    }

}
