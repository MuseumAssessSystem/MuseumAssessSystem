package com.service.impl;

import com.dao.RpDAO;
import com.dao.impl.RpDAOImpl;
import com.entity.PriviledgeEntity;
import com.entity.RoleEntity;
import com.entity.RpEntity;
import com.service.PriviledgeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10922 on 2018/1/8.
 */
public class PriviledgeServiceImpl implements PriviledgeService {
    @Override
    public List<PriviledgeEntity> getRolePriveledge(RoleEntity roleEntity) {
        /**
         *@描述 获取角色的权限
         *@参数 [roleEntity]
         *@返回值 java.util.List<com.entity.PriviledgeEntity>
         *@创建人 zzh
         *@创建时间 2018/1/8
         *@修改人和其它时间
        **/
        RpDAO rpDAO = new RpDAOImpl();
        RpEntity rpEntity = new RpEntity();
        List<RpEntity> rps;
        List<PriviledgeEntity> priviledges = new ArrayList<>();
        rpEntity.setRid(roleEntity.getRid());
        rps = rpDAO.getRp(rpEntity);
        for(int i=0;i<rps.size();i++){
            priviledges.add(new PriviledgeEntity(rps.get(i).getPid()));
        }
        return priviledges;
    }

    @Override
    public void updateRolePriviledge(RoleEntity roleEntity) {
        /**
         *@描述 修改角色的权限
         *@参数 [roleEntity]
         *@返回值 void
         *@创建人 zzh
         *@创建时间 2018/1/8
         *@修改人和其它时间
        **/

    }
}
