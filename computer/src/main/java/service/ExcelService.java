package service;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ExcelService implements DataService{


  public static <T> void createExcel(List<T> data, String filepath,
      String fileName) {

    String localFile = filepath + fileName + ".xlsx";
    File file = new File(localFile);

    try(XSSFWorkbook excel = new XSSFWorkbook();
        FileOutputStream fos =  new FileOutputStream(file)
    ) {
      XSSFSheet sheet = excel.createSheet("test");

      int rowNo = 0;
      int headNum = 0;
      XSSFRow row = sheet.createRow(rowNo++);

      for(var headers : data.get(0).getClass().getDeclaredFields()){
        row.createCell(headNum++).setCellValue(headers.getName());
      }

      int cellIndex;
      for (var result : data) {
        Field fieldlist[] = result.getClass().getDeclaredFields();
        cellIndex = 0;
        row = sheet.createRow(rowNo++);
        for(Field filed : fieldlist) {
          filed.setAccessible(true);
          row.createCell(cellIndex++).setCellValue(filed.get(result).toString());
        }
      }
      excel.write(fos);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
