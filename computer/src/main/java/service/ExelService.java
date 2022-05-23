package service;

import desktop.CPU;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ExelService {
  public static void createExel(List<CPU> cpuList, String filepath, String fileName,
      String sheetName) {

    String localFile = filepath + fileName + ".xlsx";
    File file = new File(localFile);

    try(XSSFWorkbook xssfWb = new XSSFWorkbook();
        FileOutputStream fos =  new FileOutputStream(file)
    ) {
      int rowNo = 0;
      XSSFSheet xssfSheet = xssfWb.createSheet(sheetName);

      XSSFRow xssfRow;
      XSSFCell xssfCell;

      List<String> header = List.of("no","제조사","코어","쓰레드","클럭");
      xssfRow = xssfSheet.createRow(rowNo++);
      int headNum = 0;
      for(String h:header){
        xssfCell = xssfRow.createCell((short) headNum);
        xssfCell.setCellValue(h);
        headNum++;
      }

      int idx = 1;
      for (CPU cpu : cpuList) {
        xssfRow = xssfSheet.createRow(rowNo++);

        xssfCell = xssfRow.createCell((short) 0);
        xssfCell.setCellValue(idx);

        xssfCell = xssfRow.createCell((short) 1);
        xssfCell.setCellValue(cpu.get제조사());

        xssfCell = xssfRow.createCell((short) 2);
        xssfCell.setCellValue(cpu.get코어());

        xssfCell = xssfRow.createCell((short) 3);
        xssfCell.setCellValue(cpu.get쓰레드());

        xssfCell = xssfRow.createCell((short) 4);
        xssfCell.setCellValue(cpu.get클럭());

        idx++;
      }


      xssfWb.write(fos);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
