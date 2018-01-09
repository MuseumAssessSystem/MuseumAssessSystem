package com.action;

import com.entity.RoleEntity;
import com.entity.UserEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RoleService;
import com.service.UserService;
import com.service.impl.RoleServiceImpl;
import com.service.impl.UserServiceImpl;

import java.io.UnsupportedEncodingException;
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
    // private UserEntity user;
    private RoleEntity role;

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

    public String getUserById(){
        // 根据 uid 获取user
        UserService userService = new UserServiceImpl();
        // List<UserEntity> users = userService.getUserById(new Integer(uid));
        // ActionContext.getContext().getSession().put("user",user);
        List<UserEntity> userList = userService.getUserById(new Integer(uid));
        ActionContext.getContext().getSession().put("userList",userList);

        // 根据 user 的 rid 获取role
        RoleService roleService = new RoleServiceImpl();
        role = roleService.getRoleById(userList.get(0).getRid());
        ActionContext.getContext().getSession().put("role",role);

        if(userList.size()!=0)
            return "getUserById_success";
        else
            return "getUserById_failure";
    }

    public String addUser(){
        Map params = ActionContext.getContext().getParameters();
        UserService userService = new UserServiceImpl();
        UserEntity user = new UserEntity();
        user.setUname(((String[])params.get("userName"))[0]);
        user.setPassword(((String[])params.get("password"))[0]);
        if(((String[])params.get("email"))[0]!=null)
            user.setEmail(((String[])params.get("email"))[0]);
        if(((String[])params.get("telephone"))[0]!=null)
            user.setPhone(((String[])params.get("telephone"))[0]);

        String rname = ((String[])params.get("roleName"))[0];
        RoleService roleService = new RoleServiceImpl();
        int rid = roleService.getRoleByName(rname).get(0).getRid();
        user.setRid(rid);

        userService.addUser(user);
        return "addUser_success";
    }

    public String deleteUser(){
        UserService userService = new UserServiceImpl();
        userService.deleteUser(new Integer(uid));
        return "deleteUser_success";
    }

    public String updateUser() throws UnsupportedEncodingException {
        Map params = ActionContext.getContext().getParameters();
        UserService userService = new UserServiceImpl();
        UserEntity user = new UserEntity();
        user.setUname(((String[])params.get("userName"))[0]);
        user.setPassword(((String[])params.get("password"))[0]);
        user.setEmail(((String[])params.get("email"))[0]);
        user.setPhone(((String[])params.get("telephone"))[0]);
        user.setUid(new Integer(((String[])params.get("uid"))[0]));

        String rname = ((String[])params.get("roleName"))[0];
        System.out.println("roleName = " + rname);

        RoleService roleService = new RoleServiceImpl();
        int rid = roleService.getRoleByName(rname).get(0).getRid();

        user.setRid(rid);

        System.out.println("user name = " + user.getUname());

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

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
