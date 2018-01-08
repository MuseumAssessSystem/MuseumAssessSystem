package com.action;

import com.entity.DxassessexpertEntity;
import com.entity.ExpertEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.*;
import com.service.impl.DxassessexpertServiceImpl;
import com.service.impl.Dxcriteria1ServiceImpl;
import com.service.impl.ExpertServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/1/6.
 */
public class DxassessexpertAction extends ActionSupport {
    private String edid;
    private String eid;
    private String mid;
    private String dxc1id;
    private String year;
    private String dxscore11;
    private String dxscore12;
    private String dxscore13;
    private String dxscore21;
    private String dxscore22;
    private String dxscore31;
    private String dxscore32;
    private String dxscore33;
    private String dxscore34;
    private String dxscore41;
    private String dxscore42;
    private String dxscore43;
    private String dxscore51;
    private String dxscore52;
    private String dxscore53;
    private String dxscore54;
    private String flag;
    private DxassessexpertEntity dxassessexpertEntity;

    public String addAnnualExpert()
    {
        /**
         * @author:zzy
         * @Description:从备选中指定年度评审专家
         * @date 2018/1/7
         */
        Map params = ActionContext.getContext().getParameters();
        DxassessexpertService dxassessexpertService =new DxassessexpertServiceImpl();
        ExpertService expertService = new ExpertServiceImpl();
        Dxcriteria1Service dxcriteria1Service= new Dxcriteria1ServiceImpl();
        DxassessexpertEntity dxassessexpert =new DxassessexpertEntity();
        String ename = ((String[])params.get("ename"))[0];
        dxassessexpert.setEid(expertService.getExpertByEname(ename).getEid());
        String dxc1name = ((String[])params.get("dxc1name"))[0];
        dxassessexpert.setDxc1id(dxcriteria1Service.getDxcriteria1ByDxc1name(dxc1name).getDxc1Id());
        year =((String[])params.get("year"))[0];
        dxassessexpert.setYear(Integer.valueOf(year));
        dxassessexpert.setFlag(0);
        dxassessexpertService.addDxassessexpert(dxassessexpert);

        return "addAnnualExpert_success";
    }

    public String deleteAnnualExpert()
    {
        /**
         * @author:zzy 
         * @Description:删除已指定的评审专家
         * @date 2018/1/7 
         */
        Map params = ActionContext.getContext().getParameters();
        DxassessexpertService dxassessexpertService =new DxassessexpertServiceImpl();
        ExpertService expertService = new ExpertServiceImpl();

        String ename = ((String[])params.get("ename"))[0];
        dxassessexpertEntity.setEid(expertService.getExpertByEname(ename).getEid());
        dxassessexpertService.deleteDxassessexpert(dxassessexpertEntity);

        return "deleteAnnualExpert_success";
    }

    public String SearchAnnualExpertByYear(){
        /**
         * @author:zzy
         * @Description:根据年份获取年度评审专家及备选专家
         * @date 2018/1/7
         */
        Map params = ActionContext.getContext().getParameters();
        DxassessexpertService dxassessexpertService = new DxassessexpertServiceImpl();
        Dxcriteria1Service dxcriteria1Service = new Dxcriteria1ServiceImpl();
        ExpertService expertService = new ExpertServiceImpl();
        year = ((String[])params.get("year"))[0];
        List<DxassessexpertEntity> dxassessexpertEntities = dxassessexpertService.getDxassessexpertByYear(Integer.valueOf(year));
        List<HashMap<String,String>> expertIncludeList = new ArrayList<>();
        for (DxassessexpertEntity dxassessexpert:dxassessexpertEntities)
        {
            HashMap<String,String> expertIncludeMap = new HashMap<>();
            expertIncludeMap.put("ename",expertService.getExpertByEid(dxassessexpert.getEid()).getEname());
            expertIncludeMap.put("dxc1name",dxcriteria1Service.getDxcriteria1ByDxc1id(dxassessexpert.getDxc1id()).getDxc1Name());
            expertIncludeList.add(expertIncludeMap);
        }
        ActionContext.getContext().put("expertIncludeList",expertIncludeList);

        List<ExpertEntity> expertEntities = dxassessexpertService.getOptionDxassessexpertByYear(Integer.valueOf(year));
        List<HashMap<String,String>> expertOptionList = new ArrayList<>();
        for(ExpertEntity expert:expertEntities)
        {
            HashMap<String,String> expertOptionMap = new HashMap<>();
            expertOptionMap.put("ename",expertService.getExpertByEid(expert.getEid()).getEname());
            expertOptionMap.put("dxc1name",dxcriteria1Service.getDxcriteria1ByDxc1id(expert.getDxc1id()).getDxc1Name());
            expertOptionList.add(expertOptionMap);
        }
        ActionContext.getContext().put("expertOptionList",expertOptionList);


        return "getAnnualExpert_success";
    }





}
