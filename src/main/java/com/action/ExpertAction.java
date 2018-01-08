package com.action;

import com.entity.ExpertEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.Dxcriteria1Service;
import com.service.impl.Dxcriteria1ServiceImpl;
import com.service.ExpertService;
import com.service.impl.ExpertServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/1/4.
 */
public class ExpertAction extends ActionSupport {
    private String eid;
    private String ename;
    private int dxc1id;
    private String dxc1name;
    private String description;
    private ExpertEntity expert;

//    public static void main(String[] args){
//        ExpertAction a = new ExpertAction();
//        String result = a.getExpertByEname();
//
//    }

    public String getAllExpert(){
        ExpertService expertService = new ExpertServiceImpl();
        Dxcriteria1Service dxcriteria1Service = new Dxcriteria1ServiceImpl();
        List<ExpertEntity> expertEntities = expertService.getAllExpert();
        List<HashMap<String, String>> expertList = new ArrayList<>();
        for (ExpertEntity expert : expertEntities) {
            HashMap<String, String> expertMap = new HashMap<>();
            expertMap.put("eid", new Integer(expert.getEid()).toString());
            expertMap.put("dxc1id", new Integer(expert.getDxc1id()).toString());
            expertMap.put("ename", expert.getEname());
            expertMap.put("description", expert.getDescription());
            expertMap.put("dxc1name", dxcriteria1Service.getDxcriteria1ByDxc1id(expert.getDxc1id()).getDxc1Name());
            expertList.add(expertMap);
        }
        ActionContext.getContext().put("expertList", expertList);
        return "getAllExpert_success";
    }

    public String getExpertByEname()
    {
        String ename = "王一";
        ExpertService expertService = new ExpertServiceImpl();
        Dxcriteria1Service dxcriteria1Service = new Dxcriteria1ServiceImpl();
        ExpertEntity expertEntitie = expertService.getExpertByEname(ename);


        List<HashMap<String, String>> searchexpert = new ArrayList<>();

            HashMap<String, String> expertMap = new HashMap<>();
            expertMap.put("eid", new Integer(expertEntitie.getEid()).toString());
            expertMap.put("dxc1id", new Integer(expertEntitie.getDxc1id()).toString());
            expertMap.put("ename", expertEntitie.getEname());
            expertMap.put("description", expertEntitie.getDescription());
            expertMap.put("dxc1name", dxcriteria1Service.getDxcriteria1ByDxc1id(expertEntitie.getDxc1id()).getDxc1Name());
        searchexpert.add(expertMap);

        ActionContext.getContext().put("searchexpert", searchexpert);
        System.out.println(searchexpert.get(0).toString());

        return "getAllExpert_success";


    }

    public String addExpert(){
        Map params = ActionContext.getContext().getParameters();
        ExpertService expertService = new ExpertServiceImpl();
        Dxcriteria1Service dxcriteria1Service = new Dxcriteria1ServiceImpl();
        ExpertEntity expert = new ExpertEntity();
//        eid = ((String[])params.get("eid"))[0];
//        expert.setEid(Integer.valueOf(eid));
        expert.setEname(((String[]) params.get("ename"))[0]);
        expert.setDescription(((String[])params.get("description"))[0]);
        dxc1name = (((String[])params.get("dxc1name"))[0]);
        expert.setDxc1id(dxcriteria1Service.getDxcriteria1ByDxc1name(dxc1name).getDxc1Id());
        expertService.addExpert(expert);
        return "addExpert_success";
    }

    public String deleteUser(){
        Map params = ActionContext.getContext().getParameters();
        ExpertService expertService = new ExpertServiceImpl();
        eid = ((String[])params.get("eid"))[0];
        expertService.deleteExpert(new Integer(eid));
        return "deleteExpert_success";
    }

    public String updateUser(){
        Map params = ActionContext.getContext().getParameters();
        ExpertService expertService = new ExpertServiceImpl();
        expert = (ExpertEntity)params.get("expert");
        expertService.updateExpert(expert);
        return "updateExpert_success";
    }

}