package com.action;

import com.entity.UserEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RoleService;
import com.service.UserService;
import com.service.UserServiceImpl;
import com.service.impl.RoleServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 10922 on 2017/12/30.
 */
public class UserAction extends ActionSupport{
    private String uname ;
    private String password;
    private String rid;
    private String rname;
    private String uid;
    private UserEntity user;


    public String login(){         //处理登录请求的方法
        /**
         *@描述 根据用户名、密码，实现用户登录
         *@参数 []
         *@返回值 java.lang.String
         *@创建人 zzh
         *@创建时间 2018/1/2
         *@修改人和其它时间
        **/
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
        rname = userService.login(userEntity);

        ActionContext.getContext().put("rname",rname);
        if(rname=="error")
            return "login_failure";
        else
            return "login_success";
    }

    public String getAllUser(){
        //Map params = ActionContext.getContext().getParameters();
        UserService userService = new UserServiceImpl();
        RoleService roleService = new RoleServiceImpl();
        List<UserEntity> userEntities = userService.getAllUser();
        List<HashMap<String,String>> userList = new ArrayList<>();
        for (UserEntity user:userEntities) {
            HashMap<String,String> userMap = new HashMap<>();
            userMap.put("uid",new Integer(user.getUid()).toString());
            userMap.put("rid",new Integer(user.getRid()).toString());
            userMap.put("uname",user.getUname());
            userMap.put("phone",user.getPhone());
            userMap.put("email",user.getEmail());
            userMap.put("rname",roleService.getRoleById(user.getRid()).getRname());
            userList.add(userMap);
        }
        ActionContext.getContext().put("userList",userList);
        return "getAllUser_success";
    }

    public String addUser(){
        Map params = ActionContext.getContext().getParameters();
        UserService userService = new UserServiceImpl();
        user = (UserEntity)params.get("user");
        userService.addUser(user);
        return "addUser_success";
    }

    public String deleteUser(){
        Map params = ActionContext.getContext().getParameters();
        UserService userService = new UserServiceImpl();
        uid = ((String[])params.get("uid"))[0];
        userService.deleteUser(new Integer(uid));
        return "deleteUser_success";
    }

    public String updateUser(){
        Map params = ActionContext.getContext().getParameters();
        UserService userService = new UserServiceImpl();
        user = (UserEntity)params.get("user");
        userService.updateUser(user);
        return "updateUser_success";
    }
}
