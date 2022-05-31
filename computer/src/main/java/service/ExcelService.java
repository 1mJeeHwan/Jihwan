package service;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelService {
    public static <T> void createExcel(List<T> data, String filepath, List<String> header,
        String fileName,
        String sheetName) {

    String localFile = filepath + fileName + ".xlsx";
    File file = new File(localFile);

    try(XSSFWorkbook excel = new XSSFWorkbook();
        FileOutputStream fos =  new FileOutputStream(file)
    ) {
      XSSFSheet sheet = excel.createSheet(sheetName);

      int rowNo = 0;
      int headNum = 0;

      XSSFRow row = sheet.createRow(rowNo++);;

      for(String h : header){
        row.createCell(headNum).setCellValue(h);
        headNum++;
      }
      int idx = 1;
      int cellIndex = 0;
      for (var result : data) {
        Field fieldlist[] = result.getClass().getDeclaredFields();
        cellIndex = 0;
        row = sheet.createRow(rowNo++);
        row.createCell(cellIndex++).setCellValue(idx);
        for(Field filed : fieldlist) {
          filed.setAccessible(true);
          row.createCell(cellIndex++).setCellValue(filed.get(result).toString());
        }
        idx++;
      }
      excel.write(fos);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
