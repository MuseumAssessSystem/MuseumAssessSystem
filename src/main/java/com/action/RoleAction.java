package com.action;

import com.entity.PriviledgeEntity;
import com.entity.RoleEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PriviledgeService;
import com.service.impl.PriviledgeServiceImpl;

import java.util.List;

/**
 * Created by 10922 on 2018/1/8.
 */
public class RoleAction extends ActionSupport {
    private int rid;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRolePriviledge(){
        PriviledgeService priviledgeService = new PriviledgeServiceImpl();
        List<PriviledgeEntity> pris = priviledgeService.getRolePriveledge(new RoleEntity(rid));
        ActionContext.getContext().getSession().put("pris",pris);
        if(pris.size()!=0)
            return "getRolePriviledge_success";
        else
            return "getRolePriviledge_failure";
    }
}
