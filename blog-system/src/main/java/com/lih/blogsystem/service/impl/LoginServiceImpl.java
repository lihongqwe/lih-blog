package com.lih.blogsystem.service.impl;

import com.lih.blogcommon.exception.CaptchaExpireException;
import com.lih.blogcommon.exception.GeneralException;
import com.lih.blogcommon.utils.RedisUtils;
import com.lih.blogcommon.utils.StringUtils;
import com.lih.blogsystem.entity.LoginBody;
import com.lih.blogsystem.entity.LoginUser;
import com.lih.blogsystem.service.LoginService;
import com.lih.blogsystem.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public String login(LoginBody loginBody) {
        validateCaptcha(loginBody.getCode());
        Authentication authentication = null;
        try{
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginBody.getUsername(),loginBody.getPassword()));
        }catch (Exception e){
            throw new GeneralException("用户名或密码错误！");
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return tokenUtils.createToken(loginUser);
    }

    public void validateCaptcha(String code){
        Object captcha = redisUtils.getCacheObject("captcha");
        if(StringUtils.isEmpty(captcha.toString())){
            throw new CaptchaExpireException("验证码已过期");
        }
        if(!code.equalsIgnoreCase((String) captcha)){
            throw new CaptchaExpireException("验证码错误");
        }
    }
}
