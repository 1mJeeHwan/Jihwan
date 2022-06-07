package service;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ExcelService2 implements DataService{


  public static <T> void createExcel2(List<T> data, String filepath,
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

      var header = DataService.getHeader(data);
      for(var index : header.keySet()){
        row.createCell(headNum++).setCellValue(header.get(index).toString());
      }

      int cellIndex;
      for (var result : data) {
        var sortMap = DataService.getValue(result);
        cellIndex = 0;
        row = sheet.createRow(rowNo++);
        for(var index : sortMap.keySet()) {
          row.createCell(cellIndex++).setCellValue(sortMap.get(index).toString());
        }
      }
      excel.write(fos);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
