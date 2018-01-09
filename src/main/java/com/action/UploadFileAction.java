package com.action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.File;

/**
 * Created by 10922 on 2018/1/4.
 *  无效类
 */
public class UploadFileAction extends ActionSupport{
    /**
     *@描述 实现单个文件上传
     *@创建人 zzh
     *@创建时间 2018/1/5
     *@修改人和其它时间
     **/
    private File file; // **
    private String fileFileName; // **FileName
    private String fileContentType; // **ContentType
    private String fileFilePath;

//    public String uploadFile(){
//        String  realpath;                   // 文件上传后，在服务器中的默认存储位置
////        if(fileFileName.split("\\.")[1].equals("xlsx")){
////            realpath = "E:\\Files\\dxassess";
////        }else if(fileFileName.split("\\.")[1].equals("docx")){
////            realpath = "E:\\Files\\dxassess";
////        }else{
////            System.out.println("后缀是  " + fileFileName.split("\\.")[1]);
////            return "uploadFile_failure";
////        }
//        String dxFirst;                     // 一级指标名称
//
//        System.out.println(realpath);
//
//        // 从jsp页面获取定性一级指标名称
//        // Map params = ActionContext.getContext().getParameters();
//        // dxFirst = ((String[]) params.get("dxFirst"))[0];
//
//        // 声明文件目录files，如果文件名不存在就建一个
//        File file = new File(realpath);
//        if(!file.exists()){
//            file.mkdirs();
//        }
//
//        // 实现文件上传，也就是做了一个方法调用
//        File newFile = new File(file,fileFileName);
//
//        System.out.println("filename = " + fileFileName);
//        System.out.println("file is " + file.getAbsolutePath());
//
//        try {
//            FileUtils.copyFile(file,newFile);
//        } catch (IOException e2) {
//            e2.printStackTrace();
//            return "uploadFile_failure";
//        }
//
//        /**
//        // 判断文件类型，根据文件类型调用不同的数据解析方法
//        if(fileContentType.equals("")){
//            // 若是excel文件
//            // 调用Excel文件解析方法，对文件进行解析，生成一条数据库记录
//            ExcelReader excelReader = new ExcelReader(newFile,dxFirst);
//            excelReader.excelToDatabase();
//        }else if(fileContentType.equals("")){
//            // 若是Word文件
//            // 调用Word文件解析方法，对文件进行解析，生成一条数据库记录
//            // WordReader wordReader = new WordReader(newFile);
//        }
//        **/
//        return "uploadFile_success";
//    }


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public String getFileFilePath() {
        return fileFilePath;
    }

    public void setFileFilePath(String fileFilePath) {
        this.fileFilePath = fileFilePath;
    }
}
