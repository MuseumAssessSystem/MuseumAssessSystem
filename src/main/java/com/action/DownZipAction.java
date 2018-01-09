package com.action;

import com.opensymphony.xwork2.ActionSupport;
import file.ZipUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.zip.ZipOutputStream;

/**
 * Created by 10922 on 2018/1/8.
 */
public class DownZipAction extends ActionSupport{

    private String filePath;
    private String filename;

    /**
     * 打包压缩下载文件
     */
    public String downLoadZip() throws IOException {
        // 获取 filename和filePath 参数
        // filename = "博物馆1申报书";
        // filePath = "E:\\Files\\dlassess\\博物馆1申报书";

        HttpServletResponse response = ServletActionContext.getResponse();
        String zipName = filename + ".zip";
        //获得源文件夹下的所有文件
        System.out.println("filename="+filename);
        System.out.println("filePath="+filePath);
        System.out.println("zipName="+zipName);
        File sourceFile = new File(filePath);
        File[] fileList = sourceFile.listFiles();

        System.out.println("get fils list finished");

        // 专治Chrome浏览器zip文件名乱码，23333
        zipName = URLEncoder.encode(zipName, "UTF-8");
        // 遍历文件夹下的文件，进行compress操作
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition","attachment; filename="+zipName);

        System.out.println("response set finished");

        // zipName = new String(zipName.getBytes("UTF-8"), "ISO8859-1");
        // zipName = URLEncoder.encode(zipName, "UTF-8");
        /**
        if (response.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
            System.out.println("in if");
            zipName = URLEncoder.encode(zipName, "UTF-8");
        } else {
            System.out.println("in else");
            zipName = new String(zipName.getBytes("UTF-8"), "ISO8859-1");
        }
         **/
        System.out.println("zip name is " + zipName);
        ZipOutputStream out = new ZipOutputStream(response.getOutputStream());
        try {
            for(int i=0;i<fileList.length;i++){
                ZipUtils.doCompress(fileList[i].getAbsolutePath(), out);
                response.flushBuffer();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            out.close();
        }
        return "downLoadZip_success";
    }

    public void setFilePath(String filePath) throws UnsupportedEncodingException {
        filePath=new String(filePath.getBytes("ISO-8859-1"),"utf-8");
        this.filePath = filePath;
    }

    public void setFilename(String filename) throws UnsupportedEncodingException {
        filename=new String(filename.getBytes("ISO-8859-1"),"utf-8");
        this.filename = filename;
    }
}
