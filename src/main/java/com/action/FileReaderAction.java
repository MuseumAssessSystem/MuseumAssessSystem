package com.action;

import com.dao.impl.FileServiceImpl;
import com.entity.DlassessEntity;
import com.entity.DxassessexpertEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.FileService;
import file.ExcelReader;
import file.WordReader;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by 10922 on 2018/1/6.
 */
public class FileReaderAction extends ActionSupport{
    private ExcelReader excelReader;
    private WordReader wordReader;
    private String filePath;
    private String dxFirst;
    private DxassessexpertEntity deEntity;
    private DlassessEntity dlEntity;
    private String ename;
    private String mname;
    private String year;

    /**
     *@描述 根据文件路径，解析文件数据，并将对应的记录存入数据库
     *@参数
     *@返回值
     *@创建人 zzh
     *@创建时间 2018/1/7
     *@修改人和其它时间
    **/
    public String readExcel(){
        // 产生打分表文件路径
        filePath = "E:/files/dxassess/" + filePath;
        System.out.println("filePath = " + filePath);
        // 用打分表文件和一级指标 构建Excel reader的对象
        excelReader = new ExcelReader(new File(filePath),dxFirst);
        System.out.println("dxFirst = " + dxFirst);
        // 读取文件数据 生成一条dxassessexpert数据表的记录,获取含有分值属性的实体
        deEntity = excelReader.excelToDatabase();

        // 从页面上获取需要的参数
        Map params = ActionContext.getContext().getParameters();
        ename = ((String[])params.get("ename"))[0];
        year = ((String[])params.get("year"))[0];
        // 将年份，专家名称，deEntity传入service层
        // 在service层完成对deEntity所有属性的赋值
        FileService fileService = new FileServiceImpl();
        fileService.addDxassessexpertEntity(deEntity,ename,year);
        return "";
    }

    public String readWord(){
        // 产生申报书定量打分表的路径
        filePath = "E:/files/dlassess/" + filePath;
        System.out.println("filePath = " + filePath);
        // 用定量打分表的路径 构建一个Word Reader对象
        wordReader = new WordReader(filePath);
        // 读取文件数据 生成一条dxassessexpert数据表的记录,获取含有分值属性的实体
        dlEntity = wordReader.wordToDatabase();

        // 从页面上获取需要的参数
        Map params = ActionContext.getContext().getParameters();
        mname = ((String[])params.get("mname"))[0];
        year = ((String[])params.get("year"))[0];
        // 将年份，博物馆名称，dlEntity传入service层
        // 在service层完成对dlEntity所有属性的赋值
        FileService fileService = new FileServiceImpl();
        fileService.addDlassessEntity(dlEntity,mname,year);

        return "";
    }

    public String getFilePath() {
        return filePath;
    }

    public String getDxFirst(){
        return dxFirst;
    }

    public void setFilePath(String filePath) {
        try {
            // 解决下载时候的中文文件乱码问题
            filePath = new String(filePath.getBytes("ISO-8859-1"),"UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        this.filePath = filePath;
    }

    public void setDxFirst(String dxFirst) {
        try {
            // 解决下载时候的中文文件乱码问题
            dxFirst = new String(dxFirst.getBytes("ISO-8859-1"),"UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        this.dxFirst = dxFirst;
    }


}
