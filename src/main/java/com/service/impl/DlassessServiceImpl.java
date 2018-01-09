package com.service.impl;

import com.dao.DlassessDAO;
import com.dao.impl.DlassessDAOImpl;
import com.entity.DlassessEntity;
import com.service.DlassessService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by X on 2018/1/5.
 */
public class DlassessServiceImpl implements DlassessService {
    private  DlassessDAO dlassessDAO =new DlassessDAOImpl();

    @Override
    public List<DlassessEntity> getDlassessByMid(int mid){
        /**
        *@Description:通过mid获取定量分数表
        *@Author:xyj
        *@Date:22:33 2018/1/6
        **/
        DlassessEntity dlassessEntity=new DlassessEntity();
        dlassessEntity.setMid(mid);
        return this.dlassessDAO.getDlassess(dlassessEntity);
    }
    @Override
    public List<DlassessEntity> getDlassess()
    {
        /**
        *@Description:获取定量分数表
        *@Author:xyj
        *@Date:22:34 2018/1/6
        **/
        DlassessEntity dlassessEntity=new DlassessEntity();
         return this.dlassessDAO.getDlassess(dlassessEntity);
    }
    @Override
    public List<DlassessEntity> getDlassessByYear(int year){
        DlassessEntity dlassessEntity =new DlassessEntity();
        dlassessEntity.setYear(year);
        return this.dlassessDAO.getDlassess(dlassessEntity);
    }
    @Override
    public boolean addDlassess(DlassessEntity dlassessEntity){
        this.dlassessDAO.addDlassess(dlassessEntity);
        return true;
    }
    @Override
    public boolean deleteDlassess(DlassessEntity dlassessEntity){
        this.dlassessDAO.deleteDlassess(dlassessEntity);
        return true;
    }
    @Override
    public boolean updateDlassess(DlassessEntity dlassessEntity){
        this.dlassessDAO.updateDlassess(dlassessEntity);
        return true;
    }

    @Override
    public void computeDlassess(int year) {
        DlassessService dlassessService = new DlassessServiceImpl();
        List<DlassessEntity> dlassessEntities = dlassessService.getDlassessByYear(year);
        List list11 = new ArrayList();
        List list12 = new ArrayList();
        List list21 = new ArrayList();
        List list22 = new ArrayList();
        List list23 = new ArrayList();
        List list31 = new ArrayList();
        List list32 = new ArrayList();
        List list41 = new ArrayList();
        List list42 = new ArrayList();
        double count11 = 0;
        double count12 = 0;
        double count21 = 0;
        double count22 = 0;
        double count23 = 0;
        double count31 = 0;
        double count32 = 0;
        double count41 = 0;
        double count42 = 0;
        for (DlassessEntity dlassessEntity : dlassessEntities) {
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
        for (int i = 0; i < dlassessEntities.size(); i++) {
            count11 = count11 + (double) list11.get(i);
            count12 = count12 + (double) list12.get(i);
            count21 = count21 + (double) list21.get(i);
            count22 = count22 + (double) list22.get(i);
            count23 = count23 + (double) list23.get(i);
            count31 = count31 + (double) list31.get(i);
            count32 = count32 + (double) list32.get(i);
            count41 = count41 + (double) list41.get(i);
            count42 = count42 + (double) list42.get(i);
        }
        for (DlassessEntity dlassessEntity : dlassessEntities) {
            dlassessEntity.setDlaid(dlassessEntity.getDlaid());
            dlassessEntity.setMid(dlassessEntity.getMid());
            dlassessEntity.setYear(dlassessEntity.getYear());
            int n = dlassessEntities.size();
            double temp = (double) Collections.max(list11) - count11 / n;
            double y11 = (temp!=0) ? 0.1 * (0.6 + 0.4 * (dlassessEntity.getDlscore11() - count11 / n) / temp):0;
            temp = (double) Collections.max(list12) - count12 / n;
            double y12 = (temp!=0) ? 0.05 * (0.6 + 0.4 * (dlassessEntity.getDlscore12() - count12 / n) / temp):0;
            dlassessEntity.setDlscore1(new BigDecimal(y11 + y12).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

            temp = (double) Collections.max(list21) - count21 / n;
            double y21 = (temp!=0) ? 0.08 * (0.6 + 0.4 * (dlassessEntity.getDlscore21() - count21 / n) / temp):0;
            temp = (double) Collections.max(list22) - count22 / n;
            double y22 = (temp!=0) ? 0.12 * (0.6 + 0.4 * (dlassessEntity.getDlscore22() - count22 / n) / (temp)):0;
            temp = (double) Collections.max(list23) - count23 / n;
            double y23 = (temp!=0) ? 0.05 * (0.6 + 0.4 * (dlassessEntity.getDlscore23() - count23 / n) / (temp)):0;
            dlassessEntity.setDlscore2(new BigDecimal(y21 + y22 + y23).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

            temp = (double) Collections.max(list31) - count31 / n;
            double y31 = (temp!=0)? 0.25 * (0.6 + 0.4 * (dlassessEntity.getDlscore31() - count31 / n) / (temp)):0;
            temp = (double) Collections.max(list32) - count32 / n;
            double y32 = (temp!=0) ? 0.2 * (0.6 + 0.4 * (dlassessEntity.getDlscore32() - count32 / n) / (temp)):0;
            dlassessEntity.setDlscore3(new BigDecimal(y31 + y32).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

            temp = (double) Collections.max(list41) - count41 / n;
            double y41 = (temp!=0) ? 0.05 * (0.6 + 0.4 * (dlassessEntity.getDlscore41() - count41 / n) / (temp)):0;
            temp = (double) Collections.max(list42) - count42 / n;
            double y42 = (temp!=0) ? 0.1 * (0.6 + 0.4 * (dlassessEntity.getDlscore42() - count42 / n) / (temp)):0;
            dlassessEntity.setDlscore4(new BigDecimal(y41 + y42).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

            dlassessEntity.setDlscore11(dlassessEntity.getDlscore11());
            dlassessEntity.setDlscore12(dlassessEntity.getDlscore12());
            dlassessEntity.setDlscore21(dlassessEntity.getDlscore21());
            dlassessEntity.setDlscore22(dlassessEntity.getDlscore22());
            dlassessEntity.setDlscore23(dlassessEntity.getDlscore23());
            dlassessEntity.setDlscore31(dlassessEntity.getDlscore31());
            dlassessEntity.setDlscore32(dlassessEntity.getDlscore32());
            dlassessEntity.setDlscore41(dlassessEntity.getDlscore41());
            dlassessEntity.setDlscore42(dlassessEntity.getDlscore42());

            dlassessEntity.setDltotal(new BigDecimal(y11 + y12 + y21 + y22 + y23 + y31 + y32 + y41 + y42).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            dlassessService.updateDlassess(dlassessEntity);
            System.out.println(dlassessEntity.getDlscore1());
            System.out.println(dlassessEntity.getDlscore2());
            System.out.println(dlassessEntity.getDlscore3());
            System.out.println(dlassessEntity.getDlscore4());
            System.out.println(dlassessEntity.getDltotal());
        }
    }

}
