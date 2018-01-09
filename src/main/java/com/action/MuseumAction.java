package com.action;

import com.entity.DlassessEntity;
import com.entity.MuseumEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.DlassessService;
import com.service.MuseumService;
import com.service.impl.DlassessServiceImpl;
import com.service.impl.MuseumServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by X on 2018/1/4.
 */
public class MuseumAction extends ActionSupport{
    private MuseumEntity museumEntity;
    private String mid;

    public String getAllMuseum() {
        /**
        *@Description: 获得所有的博物馆
        *@Author:xyj
        *@Date:14:39 2018/1/6
        **/
        MuseumService museumService = new MuseumServiceImpl();
        DlassessService dlassessService=new DlassessServiceImpl();
        List<MuseumEntity> museumEntities =museumService.getAllMuseum();
        List<HashMap<String,String>> museumList=new ArrayList<>();
        for(MuseumEntity museumEntity:museumEntities){
            HashMap<String,String> museumMap=new HashMap<>();
            museumMap.put("mid",new Integer(museumEntity.getMid()).toString());
            museumMap.put("mname",museumEntity.getMname());
            museumMap.put("mtype",museumEntity.getMtype());
            museumMap.put("mclass",museumEntity.getMclass());
            List<DlassessEntity> dlassessEntities=dlassessService.getDlassessByMid(new Integer(museumEntity.getMid()));
            List yearlist=new ArrayList();
            for (DlassessEntity dlassessEntity:dlassessEntities){
                yearlist.add(dlassessEntity.getYear());
            }
            museumMap.put("year",yearlist.toString());
            museumMap.put("description",museumEntity.getDescription());
            museumList.add(museumMap);
        }
        ActionContext.getContext().put("museumList",museumList);
           return "getAllMuseum_success";
    }

    public String getMuseumByName(){
        /**
        *@Description:按博物馆名称搜索
        *@Author:xyj
        *@Date:0:35 2018/1/6
        **/
         Map params = ActionContext.getContext().getParameters();
         String mname = ((String[]) params.get("mname"))[0];
         MuseumService museumService =new MuseumServiceImpl();
         DlassessService dlassessService=new DlassessServiceImpl();
         List<MuseumEntity> museumEntities= museumService.getMuseumByName(mname);
         List<HashMap<String,String>> museumList=new ArrayList<>();
         for(MuseumEntity museumEntity:museumEntities){
             HashMap<String ,String> museumMap=new HashMap<>();
             museumMap.put("mid",new Integer(museumEntity.getMid()).toString());
             museumMap.put("mname",museumEntity.getMname());
             museumMap.put("mtype",museumEntity.getMtype());
             museumMap.put("mclass",museumEntity.getMclass());
             museumMap.put("description",museumEntity.getDescription());
             List<DlassessEntity> dlassessEntities=dlassessService.getDlassessByMid(new Integer(museumEntity.getMid()));
             List yearlist=new ArrayList();
             for (DlassessEntity dlassessEntity:dlassessEntities){
                 yearlist.add(dlassessEntity.getYear());
             }
             museumMap.put("year",yearlist.toString());
             museumList.add(museumMap);
         }
         ActionContext.getContext().put("museumList",museumList);
         return "getMuseumByName_success";

    }

    public String addMuseum(){
        /**
        *@Description:添加博物馆
        *@Author:xyj
        *@Date:14:46 2018/1/6
        **/
        Map params= ActionContext.getContext().getParameters();
        MuseumService museumService=new MuseumServiceImpl();
        museumEntity= (MuseumEntity) params.get("museum");
        museumService.addMuseum(museumEntity);
        return "addMuseum_success";
    }

    public  String deleteMuseum(){
        /**
        *@Description:删除博物馆
        *@Author:xyj
        *@Date:14:50 2018/1/6
        **/
        MuseumService museumService = new MuseumServiceImpl();
        System.out.println("mid = " + new Integer(mid));
        museumService.deleteMuseum(new Integer(mid));
        return "deleteMuseum_success";
    }

    public String updateMuseum(){
        /**
        *@Description:修改博物馆
        *@Author:xyj
        *@Date:14:56 2018/1/6
        **/
        Map params =ActionContext.getContext().getParameters();
        museumEntity= (MuseumEntity) params.get("museum");
        MuseumService museumService=new MuseumServiceImpl();
        museumService.updateMuseum(museumEntity);
        return "updateMuseum_success";
    }

    public String getMuseumByYear(){
        /**
        *@Description:按年份搜索博物馆
        *@Author:xyj
        *@Date:19:09 2018/1/6
        **/
        Map params= ActionContext.getContext().getParameters();
        String year= ((String[]) params.get("years"))[0];

        MuseumService museumService=new MuseumServiceImpl();
        DlassessService dlassessService=new DlassessServiceImpl();
        List<DlassessEntity> dlassessEntities=dlassessService.getDlassessByYear(new Integer(year));
        List<HashMap<String,String>> museumList=new ArrayList<>();
        for(DlassessEntity dlassessEntity:dlassessEntities){
            List<MuseumEntity> museumEntities=museumService.getMuseumById(dlassessEntity.getMid());
            for(MuseumEntity museumEntity:museumEntities){
                HashMap<String,String> museumMap=new HashMap<>();
                museumMap.put("mid",new Integer(museumEntity.getMid()).toString());
                museumMap.put("mname",museumEntity.getMname());
                museumMap.put("mtype",museumEntity.getMtype());
                museumMap.put("mclass",museumEntity.getMclass());
                museumMap.put("description",museumEntity.getDescription());
                museumList.add(museumMap);
            }
        }
        ActionContext.getContext().put("museumList",museumList);
        return "getMuseumByYear_success";

    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
}
