package com.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by 10922 on 2018/1/4.
 */
public class UploadAction extends ActionSupport{
    /**
     *@描述 实现多文件上传
     *@参数
     *@返回值
     *@创建人 zzh
     *@创建时间 2018/1/5
     *@修改人和其它时间
    **/
    private List<File> dxWords; // **
    private List<String> dxWordsFileName; // **FileName
    private List<String> dxWordsContentType; // **ContentType
    private String savePath;

    public String uploadList() throws Exception {
        ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
        // 取得需要上传的文件数组
        List<File> files = getDxWords();
        if (files != null && files.size() > 0) {
            for (int i = 0; i < files.size(); i++) {
                if(getDxWords().get(i)==null)
                    System.out.println("dxWords is null");
                System.out.println(getSavePath() + "\\" + getDxWords().get(i).getName());
                FileOutputStream fos = new FileOutputStream(getSavePath() + "\\" + getDxWords().get(i).getName());
                FileInputStream fis = new FileInputStream(files.get(i));
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = fis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fis.close();
                fos.close();
            }
        }else{
            System.out.println("nullllllllllllllll");
        }
        return "uploadList_success";
    }

    public List<File> getDxWords(){
        return dxWords;
    }

    public void setDxWords(List<File> dxWords) {
        this.dxWords = dxWords;
    }

    public List<String> getDxWordsFileName(){
        return dxWordsFileName;
    }

    public void setDxWordsFileName(List<String> dxWordsFileName) {
        this.dxWordsFileName = dxWordsFileName;
    }

    public List<String> getDxWordsContentType() {
        return dxWordsContentType;
    }

    public void setDxWordsContentType(List<String> dxWordsContentType) {
        this.dxWordsContentType = dxWordsContentType;
    }

    public String getSavePath() throws Exception {
        String path = ServletActionContext.getServletContext().getRealPath(savePath);
        System.out.println(path);
        return path;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
}
