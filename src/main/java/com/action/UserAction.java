package com.action;

import com.entity.RoleEntity;
import com.entity.UserEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RoleService;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.service.impl.RoleServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 10922 on 2017/12/30.
 */
public class UserAction extends ActionSupport{
    private String username ;
    private String password;
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
        username = ((String[]) params.get("uname"))[0];
        password = ((String[]) params.get("password"))[0];

        System.out.println("uname " + username);
        System.out.println("password " + password);

        UserEntity userEntity = new UserEntity();
        userEntity.setUname(username);
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

    public String getAllUserRole(){
        //Map params = ActionContext.getContext().getParameters();
        // 获得所有用户
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
        ActionContext.getContext().getSession().put("userList",userList);

        // 获得所有角色
        List<RoleEntity> roles = roleService.getAllRole();
        System.out.print("role description is " + roles.get(0).getDescription());
        ActionContext.getContext().getSession().put("roleList",roles);

        // 获得所有角色的所有权限

        return "getAllUserRole_success";
    }

    public String getUserByUname(){
        // uname = ((String[]) ActionContext.getContext().getSession().get("username"))[0];
        Map params = ActionContext.getContext().getParameters();
        username = ((String[]) params.get("username"))[0];
        UserService userService = new UserServiceImpl();

        System.out.println("username = " + username);

        List<UserEntity> users = userService.getUserByUname(username);
        ActionContext.getContext().getSession().put("userList",users);
        return "getUserByUname_success";
    }

    public String addUser(){
        Map params = ActionContext.getContext().getParameters();
        UserService userService = new UserServiceImpl();
        RoleService roleService = new RoleServiceImpl();
        user = (UserEntity)params.get("user");

        List<RoleEntity> roles = roleService.getAllRole();
        ActionContext.getContext().getSession().put("roles",roles);

        userService.addUser(user);
        return "addUser_success";
    }

    public String deleteUser(){
        UserService userService = new UserServiceImpl();
        userService.deleteUser(new Integer(uid));
        return "deleteUser_success";
    }

    public String updateUser(){
        Map session = ActionContext.getContext().getSession();
        UserService userService = new UserServiceImpl();
        user = (UserEntity)session.get("user");
        userService.updateUser(user);
        return "updateUser_success";
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
