package com.lih.blogsystem.service.impl;

import com.lih.blogcommon.exception.UnauthorizedException;
import com.lih.blogsystem.entity.LoginUser;
import com.lih.blogsystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UnauthorizedException {
        User user = userService.selectUserByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("用户" + username + "不存在");
        }
        return createLoginUser(user);
    }
    public UserDetails createLoginUser(User user){
        Set<String> permissions = new HashSet<>();
        permissions.add("");
        return new LoginUser(user,permissions);
    }

}
