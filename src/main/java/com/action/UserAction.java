package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

/**
 * Created by 10922 on 2017/12/30.
 */
public class UserAction extends ActionSupport{
    private UserService userService;
    private boolean bool;
    private String userName ;
    private String password;

    public String excute(){         //处理登录请求的方法

        return "";
    }

    public void validate(){         //验证用户名和密码的有效性
        // 用户名不能为空，长度**位

        // 密码不能为空，长度**位

    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }
}
