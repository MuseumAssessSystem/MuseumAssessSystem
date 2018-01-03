package com.action;

import com.entity.UserEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;
import com.service.UserServiceImpl;

import java.util.Map;

/**
 * Created by 10922 on 2017/12/30.
 */
public class UserAction extends ActionSupport{
    private boolean bool;
    private String uname ;
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
       // Map session = ActionContext.getContext().getSession();
        Map params = ActionContext.getContext().getParameters();
        uname = ((String[]) params.get("uname"))[0];
        password = ((String[]) params.get("password"))[0];

        System.out.println("uname " + uname);
        System.out.println("password " + password);

        UserEntity userEntity = new UserEntity();
        userEntity.setUname(uname);
        userEntity.setPassword(password);


        System.out.println(userEntity.getUname());
        System.out.println(userEntity.getPassword());

        if(userEntity==null)
            System.out.println("userEntity is null");
        UserService userService = new UserServiceImpl();
        String rname = userService.login(userEntity);
        //session.put("rname",rname);
        if(rname=="error")
        return "login_failure";
        else
            return "login_success";
    }

    public void validate(){         //验证用户名和密码的有效性
        // 用户名不能为空，长度**位

        // 密码不能为空，长度**位
    }
}
