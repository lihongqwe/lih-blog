package com.lih.blogframework.security.handle;

import com.alibaba.fastjson.JSON;
import com.lih.blogcommon.utils.ServletUtils;
import com.lih.blogcommon.utils.StringUtils;
import com.lih.blogsystem.dto.ErrorDTO;
import com.lih.blogsystem.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    @Autowired
    private TokenUtils tokenUtils;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String userUUID = tokenUtils.getUUID(httpServletRequest);
        if(StringUtils.isNotNull(userUUID)) {
            tokenUtils.deleteLoginUser(userUUID);
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setMessage("登出成功!");
            errorDTO.setHttpCode(200);
            ServletUtils.renderString(httpServletResponse, JSON.toJSONString(errorDTO), 200);
        }

    }
}
