package com.action;

import com.entity.ExpertEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ExpertService;
import com.service.impl.ExpertServiceImpl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 10922 on 2018/1/5.
 */
public class SheetAction extends ActionSupport{
    private String dir;             // dir从网页上获取。申报书的子目录，dir=博物馆的name；打分表的dir=null
    private List<File> files;
    private List<String> filesFileName;
    private List<String> filesPath;
    private List<Map<String,String>> sheets = new ArrayList<>();
    private String year;
    private String expertName;

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

    public String sheetList() throws UnsupportedEncodingException {

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
            String ename;   // 专家姓名，sheet命名格式：ename-打分表.xlsx
            ename = filelist[i].split("-")[0];
            System.out.println("expert name is  " + ename);
            Map<String,String> sheet = new HashMap<>();
            sheet.put("sheetName",filelist[i]);
            sheet.put("sheetPath",dirPath+"/"+filelist[i]);
            sheet.put("ename",ename);

            cal.setTimeInMillis(new File(sheet.get("sheetPath")).lastModified());
            sheet.put("upTime",sdf.format(cal.getTime()));
            sheets.add(sheet);
        }
        ActionContext.getContext().getSession().put("sheets",sheets);

        return "sheetList_success";
    }

    private List<String> getUnupExpert(String year){

        // 获取打分表文件夹下的所有打分表的文件名
        String dirPath = "E:/Files/dxassess";
        File dirFile = new File(dirPath);
        String[] sheetList = dirFile.list();

        // 创建已上传打分表的专家map，包含专家姓名和年份
        List<Map<String,String>> upExperts = new ArrayList<>();
        for(int i=0;i<sheetList.length;i++){
            String fname = sheetList[i];
            String name = fname.split("-")[0];
            String y = (fname.split("-")[1]).split("\\.")[0];
            Map<String,String> eMap = new HashMap<>();
            eMap.put("ename",name);
            eMap.put("year",y);
            upExperts.add(eMap);
        }

        // 获取所有expert的name
        ExpertService expertService = new ExpertServiceImpl();
        List<ExpertEntity> experts = expertService.getAllExpert();
        List<String> enameList = new ArrayList<>();
        for(int i=0;i<experts.size();i++){
            enameList.add(experts.get(i).getEname());
        }

        System.out.println("enameList(all) size is " + enameList.size());

        // 遍历所有打分表，若该专家该年已上传打分表，则从enameList中移除
        for(int i=0;i<sheetList.length;i++){
            String expertName = sheetList[i].split("-")[0];     // 从sheet文件名中解析出专家名字
            Map<String,String> e = new HashMap<>();
            e.put("year",year);
            e.put("ename",expertName);
            if (upExperts.contains(e)&enameList.contains(expertName)){
                enameList.remove(expertName);
            }
        }

        System.out.println("enameList(unUpload) size is " + enameList.size());

        // 创建该年还未上传打分表的专家的List<Map>
        List<String> unupExperts = new ArrayList<>();
        for(int i=0;i<enameList.size();i++){
            unupExperts.add(enameList.get(i));
        }

        return unupExperts;
    }

    public String getUnUpExpertByYear(){

        /**
        Map params = ActionContext.getContext().getParameters();
        year = ((String[])params.get("year"))[0];
         **/
        List<String> unUpExpertList = getUnupExpert(year);
        ActionContext.getContext().getSession().put("unUpExpertList",unUpExpertList);
        return "getUnUpExpertByYear_success";
    }

    public String sheetSearch(){

        System.out.println("expertName = " + expertName);
        System.out.println("year = " + year);

        String dirPath = "E:/Files/dxassess";
        File sheetdir = new File(dirPath);
        String[] sheetList = sheetdir.list();

        // 定义文件上传时间的显示格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        for(int i=0;i<sheetList.length;i++){
            //若搜索时，年份不为空
            if(year!=null&&!year.equals("")){
                // 如果不是该年份的打分表，则跳过
                if(!sheetList[i].split("-")[1].split("\\.")[0].equals(year))
                    continue;
            }
            System.out.println("expert__________________________________name = " + expertName);
            // 若搜索时，专家不为空
            if(expertName!=null && !expertName.equals("")){
                System.out.println("__________________________________________________expert name = " + expertName);
                // 如果不是该专家的打分表，则跳过
                if(!sheetList[i].split("-")[0].equals(expertName))
                    continue;
            }

            System.out.println("第"+i+"个是"+sheetList[i]);
            String ename;   // 专家姓名，sheet命名格式：ename-打分表.xlsx
            ename = sheetList[i].split("-")[0];
            System.out.println("expert name is  " + ename);
            Map<String,String> sheet = new HashMap<>();
            sheet.put("sheetName",sheetList[i]);
            sheet.put("sheetPath",dirPath+"/"+sheetList[i]);
            sheet.put("ename",ename);

            cal.setTimeInMillis(new File(sheet.get("sheetPath")).lastModified());
            sheet.put("upTime",sdf.format(cal.getTime()));
            System.out.println("finished");
            sheets.add(sheet);
        }
        System.out.println("out for");

        ActionContext.getContext().getSession().put("sheets",sheets);

        System.out.println("finish put");

        return "sheetSearch_success";
    }

    public List<String> getFilesPath() {
        return filesPath;
    }

    public void setFilesPath(List<String> filesPath) {
        this.filesPath = filesPath;
    }

    public List<Map<String, String>> getSheets() {
        return sheets;
    }

    public void setSheets(List<Map<String, String>> sheets) {
        this.sheets = sheets;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getExpertName() {
        return expertName;
    }

    public void setExpertName(String expertName) throws UnsupportedEncodingException {
        expertName=new String(expertName.getBytes("ISO-8859-1"),"utf-8");
        this.expertName = expertName;
    }
}
