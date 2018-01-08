package file;

import com.entity.DlassessEntity;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by 10922 on 2018/1/6.
 */
public class WordReader {
    private String filePath;
    private static int column = 7;
    private int start;
    private int end;
    private static Map<String,Integer> rowNum;
    static {
        rowNum = new HashMap<>();
        rowNum.put("dlscore11",1);
        rowNum.put("dlscore12",1);
        rowNum.put("dlscore21",3);
        rowNum.put("dlscore22",6);
        rowNum.put("dlscore23",4);
        rowNum.put("dlscore31",5);
        rowNum.put("dlscore32",6);
        rowNum.put("dlscore41",2);
        rowNum.put("dlscore42",2);
    }

    public WordReader(String filePath){
        this.filePath = filePath;
    }

    public DlassessEntity wordToDatabase(){
        DlassessEntity dlEntity = new DlassessEntity();

        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            // 如果是office2007 docx格式
            if(filePath.toLowerCase().endsWith("docx")){
                System.out.println("文件是docx格式");
                XWPFDocument xwpf = new XWPFDocument(inputStream); // 得到我的文档的信息
                Iterator<XWPFTable> it = xwpf.getTablesIterator(); // 得到word中的表格
                while (it.hasNext()){
                    XWPFTable table = it.next();
                    start = 1;
                    end = start + rowNum.get("dlscore11") - 1;
                    dlEntity.setDlscore11(docxRead(table,start,end));
                    start = end + 1;
                    end = start + rowNum.get("dlscore12") - 1;
                    dlEntity.setDlscore12(docxRead(table,start,end));
                    start = end + 1;
                    end = start + rowNum.get("dlscore21") - 1;
                    dlEntity.setDlscore21(docxRead(table,start,end));
                    start = end + 1;
                    end = start + rowNum.get("dlscore22") - 1;
                    dlEntity.setDlscore22(docxRead(table,start,end));
                    start = end + 1;
                    end = start + rowNum.get("dlscore23") - 1;
                    dlEntity.setDlscore23(docxRead(table,start,end));
                    start = end + 1;
                    end = start + rowNum.get("dlscore31") - 1;
                    dlEntity.setDlscore31(docxRead(table,start,end));
                    start = end + 1;
                    end = start + rowNum.get("dlscore32") - 1;
                    dlEntity.setDlscore32(docxRead(table,start,end));
                    start = end + 1;
                    end = start + rowNum.get("dlscore41") - 1;
                    dlEntity.setDlscore41(docxRead(table,start,end));
                    start = end + 1;
                    end = start + rowNum.get("dlscore42") - 1;
                    dlEntity.setDlscore42(docxRead(table,start,end));
                }

            }else{
                System.out.println("文件是doc格式");
                // 如果是office2003 doc格式
                POIFSFileSystem pfs = new POIFSFileSystem(inputStream);
                HWPFDocument hwpf = new HWPFDocument(pfs);
                Range range = hwpf.getRange();
                TableIterator it = new TableIterator(range);
                // 迭代文档中的表格
                while (it.hasNext()){
                    Table tb = it.next();
                    start = 1;
                    end = start + rowNum.get("dlscore11") - 1;
                    dlEntity.setDlscore11(docRead(tb,start,end));
                    start = end + 1;
                    end = start + rowNum.get("dlscore12") - 1;
                    dlEntity.setDlscore12(docRead(tb,start,end));
                    start = end + 1;
                    end = start + rowNum.get("dlscore21") - 1;
                    dlEntity.setDlscore21(docRead(tb,start,end));
                    start = end + 1;
                    end = start + rowNum.get("dlscore22") - 1;
                    dlEntity.setDlscore22(docRead(tb,start,end));
                    start = end + 1;
                    end = start + rowNum.get("dlscore23") - 1;
                    dlEntity.setDlscore23(docRead(tb,start,end));
                    start = end + 1;
                    end = start + rowNum.get("dlscore31") - 1;
                    dlEntity.setDlscore31(docRead(tb,start,end));
                    start = end + 1;
                    end = start + rowNum.get("dlscore32") - 1;
                    dlEntity.setDlscore32(docRead(tb,start,end));
                    start = end + 1;
                    end = start + rowNum.get("dlscore41") - 1;
                    dlEntity.setDlscore41(docRead(tb,start,end));
                    start = end + 1;
                    end = start + rowNum.get("dlscore42") - 1;
                    dlEntity.setDlscore42(docRead(tb,start,end));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dlEntity;
    }

    // 解析docx文件的特定单元格的数据，计算后并返回分值
    // 返回的是某个二级指标的分值
    private double docxRead(XWPFTable table,int start,int end){
        double sum=0;
        List<XWPFTableRow> rows = table.getRows();
        // 读取每一行数据
        for (int i = start; i <= end; i++) {
            XWPFTableRow row = rows.get(i);
            // 读取每一列数据
            List<XWPFTableCell> cells = row.getTableCells();
            // 读取第column列数据
            double x = new Double(cells.get(column).getText());
            double y = new Double(cells.get(column-1).getText());
            sum += x*y;
            System.out.println("第" + i + "行数据是 " + y + " 和 " +x);
        }
        return sum;
    }

    // 解析doc文件
    private double docRead(Table tb,int start,int end) {
        double sum = 0;
        // 迭代行，默认从0开始
        for(int i = start;i <= end;i++){
            double x = getCellByColumn(tb,i,column);
            double y = getCellByColumn(tb,i,column-1);
            sum = sum + x * y;
            System.out.println("第" + i + "行数据是  " + x + "和" + y);
        }
        return sum;
    }

    private double getCellByColumn(Table tb,int r,int c){
        TableRow tr = tb.getRow(r);
        // 取得第column列的单元格，默认从0开始
        TableCell td = tr.getCell(c);
        // 取得单元格的内容
        System.out.println("取得单元格内容 numParagraphs" + td.numParagraphs());
        double x=0;
        for(int k=0;k<td.numParagraphs();k++) {
            Paragraph para = td.getParagraph(k);
            String s = para.text();
            // 去除后面的特殊符号
            if (s != null && !"".equals(s)) {
                s = s.substring(0, s.length() - 1);
            }
            x = new Double(s);
        }
        return x;
    }

}
