package com.action;

import com.entity.DlassessEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.DlassessService;
import com.service.impl.DlassessServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by X on 2018/1/7.
 */
public class ComputeDlassessAction extends ActionSupport {
    public String computeDlassess(){
        /**
        *@Description:计算定量分数
        *@Author:xyj
        *@Date:21:18 2018/1/7
        **/
        DlassessService dlassessService=new DlassessServiceImpl();
        Map params= ActionContext.getContext().getParameters();
        String year = ((String[]) params.get("year"))[0];
        List<DlassessEntity> dlassessEntities=dlassessService.getDlassessByYear(new Integer(year));
        List list11=new ArrayList();
        List list12=new ArrayList();
        List list21=new ArrayList();
        List list22=new ArrayList();
        List list23=new ArrayList();
        List list31=new ArrayList();
        List list32=new ArrayList();
        List list41=new ArrayList();
        List list42=new ArrayList();
        double count11=0;
        double count12=0;
        double count21=0;
        double count22=0;
        double count23=0;
        double count31=0;
        double count32=0;
        double count41=0;
        double count42=0;
        for(DlassessEntity dlassessEntity:dlassessEntities){
            list11.add(dlassessEntity.getDlscore11());
            list12.add(dlassessEntity.getDlscore12());
            list21.add(dlassessEntity.getDlscore21());
            list22.add(dlassessEntity.getDlscore22());
            list23.add(dlassessEntity.getDlscore23());
            list31.add(dlassessEntity.getDlscore31());
            list32.add(dlassessEntity.getDlscore32());
            list41.add(dlassessEntity.getDlscore41());
            list42.add(dlassessEntity.getDlscore42());
        }
        for(int i=0;i<dlassessEntities.size();i++)
        {
            count11=count11+(double)list11.get(i);
            count12=count12+(double)list12.get(i);
            count21=count21+(double)list21.get(i);
            count22=count22+(double)list22.get(i);
            count23=count23+(double)list23.get(i);
            count31=count31+(double)list31.get(i);
            count32=count32+(double)list32.get(i);
            count41=count41+(double)list41.get(i);
            count42=count42+(double)list42.get(i);
        }
        for(DlassessEntity dlassessEntity:dlassessEntities){
            int n=dlassessEntities.size();
            double y11=0.1*(0.6+0.4*(dlassessEntity.getDlscore11()-count11/n)/((double)Collections.max(list11)-count11/n));
            double y12=0.05*(0.6+0.4*(dlassessEntity.getDlscore12()-count12/n)/((double)Collections.max(list12)-count12/n));
            dlassessEntity.setDlscore1(new BigDecimal(y11+y12).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());

            double y21=0.08*(0.6+0.4*(dlassessEntity.getDlscore21()-count21/n)/((double)Collections.max(list21)-count21/n));
            double y22=0.12*(0.6+0.4*(dlassessEntity.getDlscore22()-count22/n)/((double)Collections.max(list22)-count22/n));
            double y23=0.05*(0.6+0.4*(dlassessEntity.getDlscore23()-count23/n)/((double)Collections.max(list23)-count23/n));
            dlassessEntity.setDlscore2(new BigDecimal(y21+y22+y23).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());

            double y31=0.25*(0.6+0.4*(dlassessEntity.getDlscore31()-count31/n)/((double)Collections.max(list31)-count31/n));
            double y32=0.2*(0.6+0.4*(dlassessEntity.getDlscore32()-count32/n)/((double)Collections.max(list32)-count32/n));
            dlassessEntity.setDlscore3(new BigDecimal(y31+y32).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());

            double y41=0.05*(0.6+0.4*(dlassessEntity.getDlscore41()-count41/n)/((double)Collections.max(list41)-count41/n));
            double y42=0.1*(0.6+0.4*(dlassessEntity.getDlscore42()-count42/n)/((double)Collections.max(list42)-count42/n));
            dlassessEntity.setDlscore4(new BigDecimal(y41+y42).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());

            dlassessEntity.setDltotal(new BigDecimal(y11+y12+y21+y22+y23+y31+y32+y41+y42).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
            System.out.println(dlassessEntity.getDlscore1());
            System.out.println(dlassessEntity.getDlscore2());
            System.out.println(dlassessEntity.getDlscore3());
            System.out.println(dlassessEntity.getDlscore4());
            System.out.println(dlassessEntity.getDltotal());

        }
        return "";
    }
}
