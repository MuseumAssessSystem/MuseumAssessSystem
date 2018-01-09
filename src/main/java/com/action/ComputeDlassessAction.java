package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.DlassessService;
import com.service.impl.DlassessServiceImpl;

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

        Map params= ActionContext.getContext().getParameters();
        String year = ((String[]) params.get("year"))[0];
        DlassessService dlassess = new DlassessServiceImpl();
        dlassess.computeDlassess(new Integer(year));
        return "";
    }
}
