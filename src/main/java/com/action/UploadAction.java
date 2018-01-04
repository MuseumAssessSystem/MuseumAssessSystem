package com.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by 10922 on 2018/1/4.
 */
public class UploadAction extends ActionSupport{
    /*
     * 这里定义的变量,一定要跟网页的<input type="file" name="file">中的name属性的值一致.
     * 如果网页中定义的是<input type="file" name="img">,那么在这里就要定义File img;
     */
    private List<File> files;
    /*
     * 这里定义的fileFileName一定要是xxxFileName的形式,否则无法取到文件的文件名.
     * 其中xxx必须与上面定义的File类型的变量一致,如果上面定义的是File img,那么这里就
     * 定义为String imgFileName
     */
    private String wordFileName;
    /*
    * 这里定义的是文件的类型,如果不需要获取文件类型的话,可以不定义.
    *  命名规则跟xxxFileName类似,这里一定要定义成xxxContentType形式.
    */
    private String wordContentType;

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public String upload() throws Exception{
        ServletContext servletContext = ServletActionContext.getServletContext();
        String filePath = servletContext.getRealPath("/files/" + wordFileName);
        System.out.println(filePath);

        FileOutputStream out = new FileOutputStream(filePath);
        FileInputStream in = new FileInputStream(filePath);

        byte[] buffer = new byte[1024];
        int len = 0;
        while((len = in.read(buffer)) != -1){
            out.write(buffer,0,len);
        }
        out.close();
        in.close();

        return "upload_success";
    }

    public String getWordContentType() {
        return wordContentType;
    }

    public void setWordContentType(String wordContentType) {
        this.wordContentType = wordContentType;
    }

    public void setWordFileName(String wordFileName) {
        this.wordFileName = wordFileName;
    }

    public String getWordFileName(){
        return wordFileName;
    }
}
