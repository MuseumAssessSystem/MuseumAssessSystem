package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.service.DeleteFileService;
import com.service.impl.DeleteFileServiceImpl;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * Created by 10922 on 2018/1/9.
 */
public class DeleteFileAction extends ActionSupport {
    private String filePath;            // 表示文件的绝对路径，如：E:\a.doc（a.doc是要删除的文件）；
                                        // 或 E:/Files/dlassess/博物馆1-2008（博物馆1-2008是要删除的文件夹）

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) throws UnsupportedEncodingException {
        if(ServletActionContext.getRequest().getMethod().equals("GET")){
            byte[] bytes = filePath.getBytes("ISO8859-1");
            filePath=new String(bytes,"utf-8");
        }
        this.filePath = filePath;
    }

    public String deleteFile(){
        System.out.println("file path is " + filePath);

        String type = filePath.split("/")[2];

        DeleteFileService deleteFileService = new DeleteFileServiceImpl();
        boolean success = deleteFileService.deleteDir(new File(filePath));
        if(success){
            System.out.println("delete file success");
            if(type.equals("dlassess"))
                return "deleteDir_success";
            else if(type.equals("dxassess"))
                return "deleteSheet_success";
            else{
                System.out.println("deleteFile_failure ------- type error");
                return "deleteFile_failure";
            }
        }else {
            System.out.println("delete file failure");
            return "deleteFile_failure";
        }
    }
}
