package com.action;

import com.dao.impl.FileServiceImpl;
import com.entity.DlassessEntity;
import com.entity.DxassessexpertEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.service.FileService;
import file.ExcelReader;
import file.WordReader;

import java.io.*;

public class FileUploadAction extends ActionSupport{
    private static final long serialVersionUID = 1L;

    //设置文件的保存路径
    private String PATH;

    private File upload;
    private String uploadFileName;

    private String museumName;
    private String year;
    private String dxFirst;
    private String expertName;

    public File getUpload() {
        return upload;
    }
    public void setUpload(File upload) {
        this.upload = upload;
    }
    public String getUploadFileName() {
        return uploadFileName;
    }
    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String execute() throws Exception{

        String res = new String();
        String type = new String();
        if(uploadFileName.split("\\.")[1].equals("xlsx")){
            res = "uploadSheet_success";
            PATH = "E:\\Files\\dxassess\\";
            System.out.println("res = " + res);
            type = "excel";
        }else if(uploadFileName.split("\\.")[1].equals("docx")){
            res = "uploadWord_success";
            PATH = "E:\\Files\\dxassess\\";
            System.out.println("res = " + res);
            type = "doc";
        }else{
            System.out.println("后缀是  " + uploadFileName.split("\\.")[1]);
            return "uploadFile_failure";
        }

        //得到输入流，通过struts已经得到名为upload的控件的值
        InputStream is=new FileInputStream(upload);

        //得到输出流
        OutputStream os = new FileOutputStream(PATH+uploadFileName);

        //分配接受缓冲区
        byte buffer[] = new byte[1024];
        int count=0;
        while((count=is.read(buffer))>0){
            os.write(buffer,0,count);
        }
        os.close();
        is.close();
        // 上传完成
        //**************************************

        // 解析文件
        if(type.equals("excel")){
            // 用打分表文件和一级指标 构建Excel reader的对象
            ExcelReader excelReader = new ExcelReader(new File(PATH+uploadFileName),dxFirst);
            // 读取文件数据 生成一条dxassessexpert数据表的记录,获取含有分值属性的实体
            DxassessexpertEntity deEntity = excelReader.excelToDatabase();
            // 从页面上获取需要的参数
            // 将年份，专家名称，deEntity传入service层
            // 在service层完成对deEntity所有属性的赋值
            FileService fileService = new FileServiceImpl();
            fileService.addDxassessexpertEntity(deEntity,expertName,year);

        }else if(type.equals("doc")){
            // 用定量打分表的路径 构建一个Word Reader对象
            WordReader wordReader = new WordReader(PATH+uploadFileName);
            // 读取文件数据 生成一条dxassessexpert数据表的记录,获取含有分值属性的实体
            DlassessEntity dlEntity = wordReader.wordToDatabase();
            // 从页面上获取需要的 museumName 和 year 参数
            // 将年份，博物馆名称，dlEntity传入service层
            // 在service层完成对dlEntity所有属性的赋值
            FileService fileService = new FileServiceImpl();
            fileService.addDlassessEntity(dlEntity,museumName,year);

        }else{
            return "uploadFile_failure";
        }

        return res;
    }

    public String getMuseumName() {
        return museumName;
    }

    public void setMuseumName(String museumName) {
        this.museumName = museumName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDxFirst() {
        return dxFirst;
    }

    public void setDxFirst(String dxFirst) {
        this.dxFirst = dxFirst;
    }

    public String getExpertName() {
        return expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName;
    }
}