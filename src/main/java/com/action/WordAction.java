package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 10922 on 2018/1/8.
 */
public class WordAction extends ActionSupport {
    private String dir;             // dir从网页上获取。申报书的子目录，dir=博物馆的name；打分表的dir=null
    private List<File> files;
    private List<String> filesFileName;
    private List<String> filesPath;
    private List<Map<String,String>> words = new ArrayList<>();
    private String year;
    private String museumName;

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

    public List<Map<String, String>> getWords() {
        return words;
    }

    public void setWords(List<Map<String, String>> words) {
        this.words = words;
    }

    public List<String> getFilesFileName() {
        return filesFileName;
    }

    public void setFilesFileName(List<String> filesFileName) {
        this.filesFileName = filesFileName;
    }

    public List<String> getFilesPath() {
        return filesPath;
    }

    public void setFilesPath(List<String> filesPath) {
        this.filesPath = filesPath;
    }

    public String wordList(){
        String dirPath = "E:/Files";
        File f = new File(dirPath);

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

        // 定义文件上传时间的显示格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        for(int i=0;i<filelist.length;i++){
            System.out.println("第"+i+"个是"+filelist[i]);
            String mname;   // 博物馆名称，word命名格式：mname-year.xlsx
            mname = filelist[i].split("-")[0];
            String year = filelist[i].split("-")[1];
            System.out.println("museum name is  " + mname);
            Map<String,String> word = new HashMap<>();
            word.put("dirName",filelist[i]);
            word.put("dirPath",dirPath+"/"+filelist[i]);
            word.put("mname",mname);
            word.put("year",year);

            cal.setTimeInMillis(new File(word.get("dirPath")).lastModified());
            word.put("upTime",sdf.format(cal.getTime()));
            words.add(word);
        }
        ActionContext.getContext().getSession().put("words",words);
        return "wordList_success";
    }

    public String dirSearch(){
        System.out.println("museumName = " + museumName);
        System.out.println("year = " + year);

        // 获得dirPath目录下的所有文件夹
        String dirPath = "E:/Files/dlassess";
        File dirFile = new File(dirPath);
        String[] filelist = dirFile.list();

        // 定义文件上传时间的显示格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        for(int i=0;i<filelist.length;i++){
            // 若搜索时，年份不为空
            if(year!=null&&!year.equals("")){
                // 如果不是该年份的打分表，则跳过
                if(!filelist[i].split("-")[1].equals(year))
                    continue;
            }

            System.out.println("museum__________________________________name = " + museumName);
            // 若搜索时，专家不为空
            if(museumName!=null && !museumName.equals("")){
                System.out.println("__________________________________________________museum name = " + museumName);
                // 如果不是该专家的打分表，则跳过
                if(!filelist[i].split("-")[0].equals(museumName))
                    continue;
            }

            System.out.println("第"+i+"个是"+filelist[i]);
            String mname;   // 博物馆名称，word命名格式：mname-year.xlsx
            mname = filelist[i].split("-")[0];
            String year = filelist[i].split("-")[1];
            System.out.println("museum name is  " + mname);
            Map<String,String> word = new HashMap<>();
            word.put("dirName",filelist[i]);
            word.put("dirPath",dirPath+"/"+filelist[i]);
            word.put("mname",mname);
            word.put("year",year);

            cal.setTimeInMillis(new File(word.get("dirPath")).lastModified());
            word.put("upTime",sdf.format(cal.getTime()));
            words.add(word);
        }
        ActionContext.getContext().getSession().put("words",words);
        return "dirSearch_success";
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMuseumName() {
        return museumName;
    }

    public void setMuseumName(String museumName) {
        this.museumName = museumName;
    }
}
