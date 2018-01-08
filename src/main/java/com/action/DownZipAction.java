package com.action;

import com.opensymphony.xwork2.ActionSupport;
import file.ZipUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
        filename = "博物馆1申报书";
        filePath = "E:\\Files\\dlassess\\博物馆1申报书";

        HttpServletResponse response = ServletActionContext.getResponse();
        String zipName = filename + ".zip";
        //获得源文件夹下的所有文件
        System.out.println("filename="+filename);
        System.out.println("filePath="+filePath);
        File sourceFile = new File(filePath);
        File[] fileList = sourceFile.listFiles();

        // 遍历文件夹下的文件，进行compress操作
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition","attachment; filename="+zipName);
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
