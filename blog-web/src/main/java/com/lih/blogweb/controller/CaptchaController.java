package com.lih.blogweb.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.kaptcha.Kaptcha;
import com.lih.blogcommon.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/captcha")
public class CaptchaController {

    @Autowired
    private Kaptcha kaptcha;

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("/render")
    public void render() {
        String render = kaptcha.render();
        redisUtils.setCacheObject("captcha",render,5, TimeUnit.MINUTES);
        System.out.println(render);
        kaptcha.render();
    }

}
