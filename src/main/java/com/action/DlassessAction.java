package com.action;

import com.entity.DlassessEntity;
import com.entity.MuseumEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.DlassessService;
import com.service.MuseumService;
import com.service.impl.DlassessServiceImpl;
import com.service.impl.MuseumServiceImpl;
import com.sort.dlsort.*;

import java.util.*;

/**
 * Created by X on 2018/1/5.
 */
public class DlassessAction extends ActionSupport {
    private DlassessEntity dlassessEntity;

    public String getDlassessByMid(){
        Map params = ActionContext.getContext().getParameters();
        String mid=((String[])params.get("mid"))[0];

        DlassessService dlassessService=new DlassessServiceImpl();
        List<DlassessEntity> dlassessEntities = dlassessService.getDlassessByMid(new Integer(mid));
        List<HashMap<String,String>> dlassessList = new ArrayList<>();
        for(DlassessEntity dlassessEntity:dlassessEntities){
            HashMap<String,String> dlassessMap = new HashMap<>();
            dlassessMap.put("mid",new Integer(dlassessEntity.getMid()).toString());
            dlassessMap.put("year",new Integer(dlassessEntity.getYear()).toString());
            dlassessList.add(dlassessMap);
        }
        ActionContext.getContext().put("dlassessList",dlassessList);
        return "getDlassessByMid_success";
    }

    public String getDlassess(){
        /**
        *@Description:获取全部排名
        *@Author:xyj
        *@Date:17:20 2018/1/7
        **/
        Map params =ActionContext.getContext().getParameters();
        String year =((String[])params.get("year"))[0];

        DlassessService dlassessService=new DlassessServiceImpl();
        MuseumService museumService=new MuseumServiceImpl();
        List<DlassessEntity> dlassessEntities =dlassessService.getDlassessByYear(new Integer(year));
        List<HashMap<String,String>> dlassessList=new ArrayList<>();

        Comparator comp1=new SortByDlscore1();
        Collections.sort(dlassessEntities,comp1);
        HashMap<Integer, String> dlscore1=new HashMap<>();
        for(int i=0;i<dlassessEntities.size();i++)
        {
            dlscore1.put(dlassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp2=new SortByDlscore2();
        Collections.sort(dlassessEntities,comp2);
        HashMap<Integer,String> dlscore2=new HashMap<>();
        for(int i=0;i<dlassessEntities.size();i++)
        {
             dlscore2.put(dlassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp3=new SortByDlscore3();
        Collections.sort(dlassessEntities,comp3);
        HashMap<Integer,String> dlscore3=new HashMap<>();
        for(int i=0;i<dlassessEntities.size();i++)
        {
            dlscore3.put(dlassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp4=new SortByDlscore4();
        Collections.sort(dlassessEntities,comp4);
        HashMap<Integer,String> dlscore4=new HashMap<>();
        for(int i=0;i<dlassessEntities.size();i++)
        {
            dlscore4.put(dlassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp11=new SortByDlscore11();
        Collections.sort(dlassessEntities,comp11);
        HashMap<Integer,String> dlscore11=new HashMap<>();
        for(int i=0;i<dlassessEntities.size();i++)
        {
            dlscore11.put(dlassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp12=new SortByDlscore12();
        Collections.sort(dlassessEntities,comp12);
        HashMap<Integer,String> dlscore12=new HashMap<>();
        for(int i=0;i<dlassessEntities.size();i++)
        {
            dlscore12.put(dlassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp21=new SortByDlscore21();
        Collections.sort(dlassessEntities,comp21);
        HashMap<Integer,String> dlscore21=new HashMap<>();
        for(int i=0;i<dlassessEntities.size();i++)
        {
            dlscore21.put(dlassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp22=new SortByDlscore22();
        Collections.sort(dlassessEntities,comp22);
        HashMap<Integer,String> dlscore22=new HashMap<>();
        for(int i=0;i<dlassessEntities.size();i++)
        {
            dlscore22.put(dlassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp23=new SortByDlscore23();
        Collections.sort(dlassessEntities,comp23);
        HashMap<Integer,String> dlscore23=new HashMap<>();
        for(int i=0;i<dlassessEntities.size();i++)
        {
            dlscore23.put(dlassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp31=new SortByDlscore31();
        Collections.sort(dlassessEntities,comp31);
        HashMap<Integer,String> dlscore31=new HashMap<>();
        for(int i=0;i<dlassessEntities.size();i++)
        {
            dlscore31.put(dlassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp32=new SortByDlscore32();
        Collections.sort(dlassessEntities,comp32);
        HashMap<Integer,String> dlscore32=new HashMap<>();
        for(int i=0;i<dlassessEntities.size();i++)
        {
            dlscore32.put(dlassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp41=new SortByDlscore41();
        Collections.sort(dlassessEntities,comp41);
        HashMap<Integer,String> dlscore41=new HashMap<>();
        for(int i=0;i<dlassessEntities.size();i++)
        {
            dlscore41.put(dlassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp42=new SortByDlscore42();
        Collections.sort(dlassessEntities,comp42);
        HashMap<Integer,String> dlscore42=new HashMap<>();
        for(int i=0;i<dlassessEntities.size();i++)
        {
            dlscore42.put(dlassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator compt=new SortByDltotal();
        Collections.sort(dlassessEntities,compt);
        HashMap<Integer,String> dltotal=new HashMap<>();
        for(int i=0;i<dlassessEntities.size();i++)
        {
            dltotal.put(dlassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        for(DlassessEntity dlassessEntity:dlassessEntities){
            HashMap<String,String> dlassessMap =new HashMap<>();
            dlassessMap.put("dlaid",new Integer(dlassessEntity.getDlaid()).toString());
            dlassessMap.put("mid",new Integer(dlassessEntity.getMid()).toString());
            dlassessMap.put("year",new Integer(dlassessEntity.getYear()).toString());
            dlassessMap.put("dlscore1",dlscore1.get(dlassessEntity.getMid()));
            dlassessMap.put("dlscore2",dlscore2.get(dlassessEntity.getMid()));
            dlassessMap.put("dlscore3",dlscore3.get(dlassessEntity.getMid()));
            dlassessMap.put("dlscore4",dlscore4.get(dlassessEntity.getMid()));
            dlassessMap.put("dlscore11",dlscore11.get(dlassessEntity.getMid()));
            dlassessMap.put("dlscore12",dlscore12.get(dlassessEntity.getMid()));
            dlassessMap.put("dlscore21",dlscore21.get(dlassessEntity.getMid()));
            dlassessMap.put("dlscore22",dlscore22.get(dlassessEntity.getMid()));
            dlassessMap.put("dlscore23",dlscore23.get(dlassessEntity.getMid()));
            dlassessMap.put("dlscore31",dlscore31.get(dlassessEntity.getMid()));
            dlassessMap.put("dlscore32",dlscore32.get(dlassessEntity.getMid()));
            dlassessMap.put("dlscore41",dlscore41.get(dlassessEntity.getMid()));
            dlassessMap.put("dlscore42",dlscore42.get(dlassessEntity.getMid()));
            dlassessMap.put("dltotal",dltotal.get(dlassessEntity.getMid()));
            List<MuseumEntity> museumEntities=museumService.getMuseumById(dlassessEntity.getMid());
            for(MuseumEntity museumEntity:museumEntities){
                dlassessMap.put("mid",new Integer(museumEntity.getMid()).toString());
                dlassessMap.put("mname",museumEntity.getMname());
                dlassessMap.put("mtype",museumEntity.getMtype());
                dlassessMap.put("mclass",museumEntity.getMclass());
                dlassessMap.put("description",museumEntity.getDescription());
            }
            dlassessList.add(dlassessMap);
        }
        ActionContext.getContext().put("dlassessList",dlassessList);
        return "getDlassess_success";
    }

    public String getDlassessBytype(){
        /**
        *@Description:按类型排名
        *@Author:xyj
        *@Date:17:25 2018/1/7
        **/
       // Map params =ActionContext.getContext().getParameters();
      //  String year =((String[])params.get("year"))[0];

        DlassessService dlassessService=new DlassessServiceImpl();
        MuseumService museumService=new MuseumServiceImpl();
      //  List<DlassessEntity> dlassessEntities =dlassessService.getDlassessByYear(new Integer(year));
        List<HashMap<String,String>> dlassessList=new ArrayList<>();
        List<MuseumEntity> museumEntities=museumService.getAllMuseum();
        for(MuseumEntity museumEntity:museumEntities){
            List<MuseumEntity> museumEntities1=museumService.getMuseumByMtype(museumEntity.getMtype());
            for(MuseumEntity museumEntity1:museumEntities1){
                System.out.println(museumEntity1.getMid());
                System.out.println(museumEntity1.getMtype());
            }
        }
        return "";
    }
}
