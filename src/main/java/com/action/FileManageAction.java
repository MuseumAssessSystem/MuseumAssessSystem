package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10922 on 2018/1/5.
 */
public class FileManageAction extends ActionSupport{
    private String dir;             // dir从网页上获取。申报书的子目录，dir=博物馆的name；打分表的dir=null
    private List<File> files;
    private List<String> filesFileName;
    private List<String> filesPath;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public List<String> getFilesFileName() {
        return filesFileName;
    }

    public void setFilesFileName(List<String> filesFileName) {
        this.filesFileName = filesFileName;
    }

    public String fileManage() throws UnsupportedEncodingException {
        String dirPath = "E:/Files";
        File f = new File(dirPath);
        filesFileName = new ArrayList<>();
        files = new ArrayList<>();
        filesPath = new ArrayList<>();


        if (!(f.isDirectory())){
            f.mkdir();
        }
        if(dir!=null)
            dirPath = dirPath + dir;
        // irPath = new String(dirPath.getBytes("ISO-8859-1"),"UTF-8");
        System.out.println("dirPath = " + dirPath);
        File file = new File(dirPath);
        System.out.println("文件夹");

        String[] filelist = file.list();
        for(int i=0;i<filelist.length;i++){
            System.out.println("第"+i+"个是"+filelist[i]);
            filesFileName.add(filelist[i]);
            files.add(new File(dirPath + "//" + filelist[i]));
            filesPath.add(dirPath + "//" + filelist[i]);
        }
        ActionContext.getContext().put("filesName",filesFileName);
        ActionContext.getContext().put("filesPath",filesPath);
        return "fileManage_success";
    }

    public List<String> getFilesPath() {
        return filesPath;
    }

    public void setFilesPath(List<String> filesPath) {
        this.filesPath = filesPath;
    }




}
