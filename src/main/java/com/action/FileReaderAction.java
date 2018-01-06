package com.action;

import com.opensymphony.xwork2.ActionSupport;
import file.ExcelReader;
import file.WordReader;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * Created by 10922 on 2018/1/6.
 */
public class FileReaderAction extends ActionSupport{
    private ExcelReader excelReader;
    private WordReader wordReader;
    private String filePath;
    private String dxFirst;

    public String readExcel(){
        // 产生打分表文件路径
        filePath = "E:/files/" + filePath;
        System.out.println("filePath = " + filePath);
        // 用打分表文件和一级指标 构建Excel reader的对象
        File newFile = new File(filePath);
        if(newFile==null){
            System.out.println("new file is null");
        }
        excelReader = new ExcelReader(newFile,dxFirst);
        if (excelReader==null){
            System.out.println("excelReader is null");
        }
        System.out.println("dxFirst = " + dxFirst);
        // 读取文件数据 生成一条dxassessexpert数据表的记录，写入数据库
        excelReader.excelToDatabase();
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
