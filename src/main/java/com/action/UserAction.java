package com.action;

import com.entity.UserEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by 10922 on 2017/12/30.
 */
public class UserAction extends ActionSupport{
    @Resource
    private UserService userService;
    private UserEntity userEntity;
    private boolean bool;
    private String userName ;
    private String password;


    public String login(){         //处理登录请求的方法
        /**
         *@描述 根据用户名、密码，实现用户登录
         *@参数 []
         *@返回值 java.lang.String
         *@创建人 zzh
         *@创建时间 2018/1/2
         *@修改人和其它时间
        **/
        Map session = ActionContext.getContext().getSession();
        // session.put("rname",rname);
        this.userService.login(new UserEntity());
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
