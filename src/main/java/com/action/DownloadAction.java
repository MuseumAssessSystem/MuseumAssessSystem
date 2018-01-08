package com.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * Created by 10922 on 2018/1/5.
 */
public class DownloadAction extends ActionSupport{
    private String downPath;
    private String filename;

    public String getFilename() throws Exception {
        return URLEncoder.encode(filename, "utf-8");
    }

    public void setFilename(String filename) throws Exception {
        if(ServletActionContext.getRequest().getMethod().equals("GET")){
            byte[] bytes = filename.getBytes("ISO8859-1");
            filename=new String(bytes,"utf-8");
        }
        this.filename = filename;
    }

    public String getDownPath() {
        return downPath;
    }

    public void setDownPath(String downPath) {
        this.downPath = downPath;
    }

    /*
    *下载用的Action返回一个InputString实例，该方法对应Action配置
    *里面的result的inputName参数，值为inputString
    *
    */

    public InputStream getInputStream() throws FileNotFoundException {
        System.out.println("getInStream downPath = " + downPath);
        return new FileInputStream(new File(downPath));
    }

    @Override
    public String execute() throws Exception {
        //filename = ((String[]) ActionContext.getContext().getSession().get("filename"))[0];
        // downPath = "E:/Files" + filename;
        downPath = filename;
        filename = filename.split("/")[3];
        System.out.println("filename = " + filename);
        return "download_success";
    }
}
