package com.action;

import com.entity.DxassessEntity;
import com.entity.DxassessexpertEntity;
import com.entity.MuseumEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.DxassessService;
import com.service.DxassessexpertService;
import com.service.MuseumService;
import com.service.impl.DxassessServiceImpl;
import com.service.impl.DxassessexpertServiceImpl;
import com.service.impl.MuseumServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/1/8.
 */
public class ComputeDxassessAction extends ActionSupport {
    private DxassessEntity dxassessEntity = new DxassessEntity();
    private DxassessexpertEntity dxassessexpertEntity = new DxassessexpertEntity();

    public String computeDxassess()
    {
        Map params = ActionContext.getContext().getParameters();
        String year = ((String[])params.get("year"))[0];

        DxassessexpertService dxassessexpertService = new DxassessexpertServiceImpl();
        DxassessService dxassessService = new DxassessServiceImpl();
        MuseumService museumService = new MuseumServiceImpl();

        DxassessEntity dxassessEntity = new DxassessEntity();

        List<MuseumEntity> museumList = museumService.getAllMuseum();
        for(int i =0;i<museumList.size();i++)
        {
            dxassessEntity.setMid(museumList.get(i).getMid());
            dxassessEntity.setYear(Integer.valueOf(year));

            DxassessexpertEntity dxassessexpertEntity1 = new DxassessexpertEntity();
            dxassessexpertEntity1.setMid(museumList.get(i).getMid());
            dxassessexpertEntity1.setYear(Integer.valueOf(year));
            dxassessexpertEntity1.setFlag(1);
            dxassessexpertEntity1.setDxc1id(1);
            List<DxassessexpertEntity> dxassessexpert1 = dxassessexpertService.getDxassessexpert(dxassessexpertEntity1);
            double sum11=0,sum12=0,sum13=0;
            for(int j=0;j<dxassessexpert1.size();j++)
            {
                sum11 += dxassessexpert1.get(j).getDxscore11();
                sum12 += dxassessexpert1.get(j).getDxscore12();
                sum13 += dxassessexpert1.get(j).getDxscore13();
            }
            double dxscore11 = sum11/dxassessexpert1.size()*0.05;
            double dxscore12 = sum12/dxassessexpert1.size()*0.08;
            double dxscore13 = sum13/dxassessexpert1.size()*0.07;
            double dxscore1 = dxscore11+dxscore12+dxscore13;
            dxassessEntity.setDxscore1(dxscore1);
            dxassessEntity.setDxscore11(dxscore11);
            dxassessEntity.setDxscore12(dxscore12);
            dxassessEntity.setDxscore13(dxscore13);

            DxassessexpertEntity dxassessexpertEntity2 = new DxassessexpertEntity();
            dxassessexpertEntity2.setMid(museumList.get(i).getMid());
            dxassessexpertEntity2.setYear(Integer.valueOf(year));
            dxassessexpertEntity2.setFlag(1);
            dxassessexpertEntity2.setDxc1id(2);
            List<DxassessexpertEntity> dxassessexpert2 = dxassessexpertService.getDxassessexpert(dxassessexpertEntity2);
            double sum21=0,sum22=0;
            for(int j=0;j<dxassessexpert2.size();j++)
            {
                sum21 += dxassessexpert2.get(j).getDxscore21();
                sum22 += dxassessexpert2.get(j).getDxscore22();

            }
            double dxscore21 = sum21/dxassessexpert2.size()*0.08;
            double dxscore22 = sum22/dxassessexpert2.size()*0.12;
            double dxscore2 = dxscore21+dxscore22;
            dxassessEntity.setDxscore2(dxscore2);
            dxassessEntity.setDxscore21(dxscore21);
            dxassessEntity.setDxscore22(dxscore22);

            DxassessexpertEntity dxassessexpertEntity3 = new DxassessexpertEntity();
            dxassessexpertEntity3.setMid(museumList.get(i).getMid());
            dxassessexpertEntity3.setYear(Integer.valueOf(year));
            dxassessexpertEntity3.setFlag(1);
            dxassessexpertEntity3.setDxc1id(3);
            List<DxassessexpertEntity> dxassessexpert3 = dxassessexpertService.getDxassessexpert(dxassessexpertEntity3);
            double sum31=0,sum32=0,sum33=0,sum34=0;
            for(int j=0;j<dxassessexpert3.size();j++)
            {
                sum31+=dxassessexpert3.get(j).getDxscore31();
                sum32+=dxassessexpert3.get(j).getDxscore32();
                sum33+=dxassessexpert3.get(j).getDxscore33();
                sum34+=dxassessexpert3.get(j).getDxscore34();
            }
            double dxscore31 = sum31/dxassessexpert3.size()*0.05;
            double dxscore32 = sum32/dxassessexpert3.size()*0.15;
            double dxscore33 = sum33/dxassessexpert3.size()*0.05;
            double dxscore34 = sum34/dxassessexpert3.size()*0.1;
            double dxscore3 = dxscore31+dxscore32+dxscore33+dxscore34;
            dxassessEntity.setDxscore3(dxscore3);
            dxassessEntity.setDxscore31(dxscore31);
            dxassessEntity.setDxscore32(dxscore32);
            dxassessEntity.setDxscore33(dxscore33);
            dxassessEntity.setDxscore34(dxscore34);

            DxassessexpertEntity dxassessexpertEntity4 = new DxassessexpertEntity();
            dxassessexpertEntity4.setMid(museumList.get(i).getMid());
            dxassessexpertEntity4.setYear(Integer.valueOf(year));
            dxassessexpertEntity4.setFlag(1);
            dxassessexpertEntity4.setDxc1id(4);
            List<DxassessexpertEntity> dxassessexpert4 = dxassessexpertService.getDxassessexpert(dxassessexpertEntity4);
            double sum41=0,sum42=0,sum43=0;
            for(int j=0;j<dxassessexpert4.size();j++)
            {
                sum41 += dxassessexpert4.get(j).getDxscore41();
                sum42 += dxassessexpert4.get(j).getDxscore42();
                sum43 += dxassessexpert4.get(j).getDxscore43();
            }
            double dxscore41 = sum41/dxassessexpert1.size()*0.07;
            double dxscore42 = sum42/dxassessexpert1.size()*0.05;
            double dxscore43 = sum43/dxassessexpert1.size()*0.03;
            double dxscore4 = dxscore41+dxscore42+dxscore43;
            dxassessEntity.setDxscore4(dxscore4);
            dxassessEntity.setDxscore41(dxscore41);
            dxassessEntity.setDxscore42(dxscore42);
            dxassessEntity.setDxscore43(dxscore43);

            DxassessexpertEntity dxassessexpertEntity5 = new DxassessexpertEntity();
            dxassessexpertEntity5.setMid(museumList.get(i).getMid());
            dxassessexpertEntity5.setYear(Integer.valueOf(year));
            dxassessexpertEntity5.setFlag(1);
            dxassessexpertEntity5.setDxc1id(5);
            List<DxassessexpertEntity> dxassessexpert5 = dxassessexpertService.getDxassessexpert(dxassessexpertEntity5);
            double sum51=0,sum52=0,sum53=0,sum54=0;
            for(int j=0;j<dxassessexpert5.size();j++)
            {
                sum51 += dxassessexpert5.get(j).getDxscore51();
                sum52 += dxassessexpert5.get(j).getDxscore52();
                sum53 += dxassessexpert5.get(j).getDxscore53();
                sum54 += dxassessexpert5.get(j).getDxscore54();
            }
            double dxscore51 = sum51/dxassessexpert5.size()*0.02;
            double dxscore52 = sum52/dxassessexpert5.size()*0.01;
            double dxscore53 = sum53/dxassessexpert5.size()*0.05;
            double dxscore54 = sum54/dxassessexpert5.size()*0.02;
            double dxscore5 = dxscore41+dxscore42+dxscore43+dxscore54;
            dxassessEntity.setDxscore5(dxscore5);
            dxassessEntity.setDxscore51(dxscore51);
            dxassessEntity.setDxscore52(dxscore52);
            dxassessEntity.setDxscore53(dxscore53);
            dxassessEntity.setDxscore54(dxscore54);

            double dxtotal = dxscore1*0.2+dxscore2*0.2+dxscore3*0.35+dxscore4*0.15+dxscore5*0.1;
            dxassessEntity.setDxtotal(dxtotal);

            dxassessService.addDxassess(dxassessEntity);

        }

        return "computeDxassess_success";
    }
}
