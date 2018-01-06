package com.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by 10922 on 2018/1/5.
 */
public class DownloadAction extends ActionSupport{
    private String downPath;
    private String contentType;
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getDownPath() {
        return downPath;
    }

    public void setDownPath(String downPath) {
        try {
            // 解决下载时候的中文文件乱码问题
            downPath = new String(downPath.getBytes("ISO-8859-1"),"UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        this.downPath = downPath;
    }

    /*
    *下载用的Action返回一个InputString实例，该方法对应Action配置
    *里面的result的inputName参数，值为inputString
    *
    */

    public InputStream getInputStream(){
        return ServletActionContext.getServletContext().getResourceAsStream(downPath);
    }

    public String download(){
        // 下载保存时的文件名和被下载的文件名一样
        filename = downPath;
        // 下载的文件路径，请在webapps目录下创建files
        downPath = "files/" + downPath;
        // 保存文件的类型

        contentType = "application/x-msdownload";

       /*
        *对下载的文件名按照UTF-8进行编码，解决下载窗口中的中文乱码问题
        * 其中,MyUtil是自己定义的一个类
        */

        filename = MyUtil.toUTF8String(filename);
        return "download_success";
    }

}
