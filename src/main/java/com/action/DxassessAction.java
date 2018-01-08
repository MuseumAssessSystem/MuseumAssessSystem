package com.action;

import com.entity.DxassessEntity;
import com.entity.MuseumEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.DxassessService;
import com.service.MuseumService;
import com.service.impl.DxassessServiceImpl;
import com.service.impl.MuseumServiceImpl;
import com.sort.dxsort.*;

import java.util.*;

/**
 * Created by admin on 2018/1/7.
 */
public class DxassessAction extends ActionSupport {
    private DxassessEntity dxassessEntity;

    public String getdxassess(){
        Map params = ActionContext.getContext().getParameters();
        String year =((String[])params.get("year"))[0];

        DxassessService dxassessService =new DxassessServiceImpl();
        MuseumService museumService=new MuseumServiceImpl();
        List<DxassessEntity> dxassessEntities =dxassessService.getDxassessByYear(new Integer(year));
        List<HashMap<String,String>> dxassessList=new ArrayList<>();

        Comparator comp1=new SortByDxscore1();
        Collections.sort(dxassessEntities,comp1);
        HashMap<Integer, String> dxscore1=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxscore1.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp2=new SortByDxscore2();
        Collections.sort(dxassessEntities,comp2);
        HashMap<Integer,String> dxscore2=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxscore2.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp3=new SortByDxscore3();
        Collections.sort(dxassessEntities,comp3);
        HashMap<Integer,String> dxscore3=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxscore3.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp4=new SortByDxscore4();
        Collections.sort(dxassessEntities,comp4);
        HashMap<Integer,String> dxscore4=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxscore4.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp5=new SortByDxscore5();
        Collections.sort(dxassessEntities,comp5);
        HashMap<Integer,String> dxscore5=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxscore5.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp11=new SortByDxscore11();
        Collections.sort(dxassessEntities,comp11);
        HashMap<Integer,String> dxscore11=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxscore11.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp12=new SortByDxscore12();
        Collections.sort(dxassessEntities,comp12);
        HashMap<Integer,String> dxscore12=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxscore12.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp13=new SortByDxscore13();
        Collections.sort(dxassessEntities,comp13);
        HashMap<Integer,String> dxscore13=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxscore13.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp21=new SortByDxscore21();
        Collections.sort(dxassessEntities,comp21);
        HashMap<Integer,String> dxscore21=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxscore21.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp22=new SortByDxscore22();
        Collections.sort(dxassessEntities,comp22);
        HashMap<Integer,String> dxscore22=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxscore22.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp31=new SortByDxscore31();
        Collections.sort(dxassessEntities,comp31);
        HashMap<Integer,String> dxscore31=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxscore31.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp32=new SortByDxscore32();
        Collections.sort(dxassessEntities,comp32);
        HashMap<Integer,String> dxscore32=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxscore32.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp33=new SortByDxscore33();
        Collections.sort(dxassessEntities,comp33);
        HashMap<Integer,String> dxscore33=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxscore33.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp34=new SortByDxscore34();
        Collections.sort(dxassessEntities,comp34);
        HashMap<Integer,String> dxscore34=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxscore34.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp41=new SortByDxscore41();
        Collections.sort(dxassessEntities,comp41);
        HashMap<Integer,String> dxscore41=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxscore41.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp42=new SortByDxscore42();
        Collections.sort(dxassessEntities,comp42);
        HashMap<Integer,String> dxscore42=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxscore42.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp43=new SortByDxscore43();
        Collections.sort(dxassessEntities,comp43);
        HashMap<Integer,String> dxscore43=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxscore43.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp51=new SortByDxscore51();
        Collections.sort(dxassessEntities,comp51);
        HashMap<Integer,String> dxscore51=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxscore51.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp52=new SortByDxscore52();
        Collections.sort(dxassessEntities,comp52);
        HashMap<Integer,String> dxscore52=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxscore52.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp53=new SortByDxscore53();
        Collections.sort(dxassessEntities,comp53);
        HashMap<Integer,String> dxscore53=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxscore53.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comp54=new SortByDxscore54();
        Collections.sort(dxassessEntities,comp54);
        HashMap<Integer,String> dxscore54=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxscore54.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }

        Comparator comptotal=new SortByDxtotal();
        Collections.sort(dxassessEntities,comptotal);
        HashMap<Integer,String> dxtotal=new HashMap<>();
        for(int i=0;i<dxassessEntities.size();i++)
        {
            dxtotal.put(dxassessEntities.get(i).getMid(),new Integer(i+1).toString());
        }


        for(DxassessEntity dxassessEntity:dxassessEntities){
            HashMap<String,String> dxassessMap =new HashMap<>();
            dxassessMap.put("dxaid",new Integer(dxassessEntity.getDxaid()).toString());
            //dxassessMap.put("mid",new Integer(dxassessEntity.getMid()).toString());
            //dxassessMap.put("year",new Integer(dxassessEntity.getYear()).toString());
            dxassessMap.put("dxscore1",dxscore1.get(dxassessEntity.getMid()));
            dxassessMap.put("dxscore2",dxscore2.get(dxassessEntity.getMid()));
            dxassessMap.put("dxscore3",dxscore3.get(dxassessEntity.getMid()));
            dxassessMap.put("dxscore4",dxscore4.get(dxassessEntity.getMid()));
            dxassessMap.put("dxscore5",dxscore5.get(dxassessEntity.getMid()));
            dxassessMap.put("dxscore11",dxscore11.get(dxassessEntity.getMid()));
            dxassessMap.put("dxscore12",dxscore12.get(dxassessEntity.getMid()));
            dxassessMap.put("dxscore13",dxscore13.get(dxassessEntity.getMid()));
            dxassessMap.put("dxscore21",dxscore21.get(dxassessEntity.getMid()));
            dxassessMap.put("dxscore22",dxscore22.get(dxassessEntity.getMid()));
            dxassessMap.put("dxscore31",dxscore31.get(dxassessEntity.getMid()));
            dxassessMap.put("dxscore32",dxscore32.get(dxassessEntity.getMid()));
            dxassessMap.put("dxscore33",dxscore33.get(dxassessEntity.getMid()));
            dxassessMap.put("dxscore34",dxscore34.get(dxassessEntity.getMid()));
            dxassessMap.put("dxscore41",dxscore41.get(dxassessEntity.getMid()));
            dxassessMap.put("dxscore42",dxscore42.get(dxassessEntity.getMid()));
            dxassessMap.put("dxscore43",dxscore43.get(dxassessEntity.getMid()));
            dxassessMap.put("dxscore51",dxscore51.get(dxassessEntity.getMid()));
            dxassessMap.put("dxscore52",dxscore52.get(dxassessEntity.getMid()));
            dxassessMap.put("dxscore53",dxscore53.get(dxassessEntity.getMid()));
            dxassessMap.put("dxscore54",dxscore54.get(dxassessEntity.getMid()));
            dxassessMap.put("dxtotal",dxtotal.get(dxassessEntity.getMid()));
            List<MuseumEntity> museumEntities=museumService.getMuseumById(dxassessEntity.getMid());
            for(MuseumEntity museumEntity:museumEntities){
                dxassessMap.put("mid",new Integer(museumEntity.getMid()).toString());
                dxassessMap.put("mname",museumEntity.getMname());
                dxassessMap.put("mtype",museumEntity.getMtype());
                dxassessMap.put("mclass",museumEntity.getMclass());
                dxassessMap.put("description",museumEntity.getDescription());
            }
            dxassessList.add(dxassessMap);
        }
        ActionContext.getContext().put("dlassessList",dxassessList);
        return "getDxassess_success";
    }


}
