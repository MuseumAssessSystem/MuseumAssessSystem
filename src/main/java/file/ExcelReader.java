package file;

import com.dao.DxassessexpertDAO;
import com.dao.impl.DxassessexpertDAOImpl;
import com.entity.DxassessexpertEntity;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 10922 on 2018/1/6.
 */
public class ExcelReader {
    private File file;
    private String filePath;
    private String sheetName;
    private Workbook workBook;
    private Sheet sheet;
    private boolean flag;
    private int row;
    private int start;
    private int end;
    private static int column = 9;  // Excel文件的第9列（从0开始）是二级指标的分数
    private static Map<String,Integer> rowsNum;
    static {
        rowsNum = new HashMap<>();
        rowsNum.put("dxscore11",3);
        rowsNum.put("dxscore12",10);
        rowsNum.put("dxscore13",3);
        rowsNum.put("dxscore21",10);
        rowsNum.put("dxscore22",6);
        rowsNum.put("dxscore31",4);
        rowsNum.put("dxscore32",9);
        rowsNum.put("dxscore33",5);
        rowsNum.put("dxscore34",8);
        rowsNum.put("dxscore41",14);
        rowsNum.put("dxscore42",8);
        rowsNum.put("dxscore43",5);
        rowsNum.put("dxscore51",4);
        rowsNum.put("dxscore52",1);
        rowsNum.put("dxscore53",11);
        rowsNum.put("dxscore54",3);
    }

    public ExcelReader(File file,String sheetName){
        this.file = file;
        this.sheetName = sheetName;
        this.flag = false;
    }

    public boolean excelToDatabase(){
        DxassessexpertDAO deDao = new DxassessexpertDAOImpl();
        DxassessexpertEntity deEntity = new DxassessexpertEntity();

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            workBook = WorkbookFactory.create(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (sheetName){
            case "藏品管理":
                start = 1;
                end = start + rowsNum.get("dxscore11") - 1;
                deEntity.setDxscore11(getSecondScore("藏品管理"));
                start = end + 1;
                end = start + rowsNum.get("dxscore12");
                deEntity.setDxscore12(getSecondScore("藏品管理"));
                start = end + 1;
                end = start + rowsNum.get("dxscore13");
                deEntity.setDxscore13(getSecondScore("藏品管理"));
                break;
            case "科学研究":
                start = 1;
                end = start + rowsNum.get("dxscore21");
                deEntity.setDxscore21(getSecondScore("科学研究"));
                start = end;
                end = start + rowsNum.get("dxscore22");
                deEntity.setDxscore22(getSecondScore("科学研究"));
                break;
            case "陈列展览与社会教育":
                start = 1;
                end = start + rowsNum.get("dxscore31");
                deEntity.setDxscore31(getSecondScore("陈列展览与社会教育"));
                start = end;
                end = start + rowsNum.get("dxscore32");
                deEntity.setDxscore32(getSecondScore("陈列展览与社会教育"));
                start = end;
                end = start + rowsNum.get("dxscore33");
                deEntity.setDxscore33(getSecondScore("陈列展览与社会教育"));
                start = end;
                end = start + rowsNum.get("dxscore34");
                deEntity.setDxscore34(getSecondScore("陈列展览与社会教育"));
                break;
            case "公共关系与服务":
                start = 1;
                end = start + rowsNum.get("dxscore41");
                deEntity.setDxscore41(getSecondScore("公共关系与服务"));
                start = end + 1;
                end = start + rowsNum.get("dxscore42");
                deEntity.setDxscore42(getSecondScore("公共关系与服务"));
                start = end + 1;
                end = start + rowsNum.get("dxscore43");
                deEntity.setDxscore43(getSecondScore("公共关系与服务"));
                break;
            case "博物馆管理与发展建设":
                start = 1;
                end = start + rowsNum.get("dxscore51");
                deEntity.setDxscore51(getSecondScore("博物馆管理与发展建设"));
                start = end + 1;
                end = start + rowsNum.get("dxscore52");
                deEntity.setDxsocre52(getSecondScore("博物馆管理与发展建设"));
                start = end + 1;
                end = start + rowsNum.get("dxscore53");
                deEntity.setDxscore53(getSecondScore("博物馆管理与发展建设"));
                start = end + 1;
                end = start + rowsNum.get("dxscore54");
                deEntity.setDxscore54(getSecondScore("博物馆管理与发展建设"));
                break;
        }
        // 将deEntity add 进数据库
        deDao.addDxassessexpert(deEntity);
        System.out.println("add deEntity finished");
        return true;
    }

    private double getSecondScore(String sheetName){
        double sum = 0;
        sheet = workBook.getSheet(sheetName);
        for(int i=start;i<=end;i++){
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(column);
            double x = (double) cell.getNumericCellValue();
            System.out.println("cell value is " + x);
        }
        return sum;
    }

}
