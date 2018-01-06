package com.service.impl;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

/**
 * Created by 10922 on 2018/1/6.
 */
public class ReadExcelServiceImpl{
    private String filePath;
    private Sheet sheet;
    private String sheetName;
    private Workbook workbook;
    private List<String> columnHeaderList;
    private List<List<String>> listData;


}
