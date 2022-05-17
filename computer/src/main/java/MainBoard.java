
import desktop.*;
import interfaces.마우스;
import interfaces.마이크;
import interfaces.키보드;
import moniter.Moniter;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.xssf.usermodel.*;

public class MainBoard {
    CPU cpu = new CPU();
    GPU gpu = new GPU();
    RAM ram = new RAM();
    SSD ssd = new SSD();
    파워 파워 = new 파워();
    마우스 마우스 = new 마우스();
    키보드 키보드 = new 키보드();
    마이크 마이크 = new 마이크();
    Scanner scan = new Scanner(System.in);
    boolean 전기상태;

    public void PowerButton(boolean 전기) {
        this.전기상태 = !전기;
        Moniter moniter = new Moniter();
        if (!moniter.bootingComputer(전기)) {
            return;
        }
        List<String> datas = new ArrayList<>();
        InPutData(moniter, datas, 전기);

    }

    public void InPutData(Moniter moniter, List<String> datas, boolean 전기) {
        for (int i = 0; i < 1000; i++) {
            datas.add("아무데이터" + (i + 1));
            datas = SendData(datas, 전기);
        }

        moniter.viewMoniter(datas, 파워.전력공급(전기));
        var filePath = "c:/test/";
        CreateCSV(datas, filePath);
        CreateXML(datas,filePath,"testest","테스트중");
    }

    public List<String> SendData(List<String> data, boolean 전기) {
        if (data.size() > 0) {
            data = cpu.계산처리(
                    gpu.계산처리(
                            ram.계산처리(data
                                    , 파워.전력공급(전기)
                            ), 파워.전력공급(전기)
                    ), 파워.전력공급(전기));

//            data = ssd.계산처리(
//                    data, 파워.전력공급(전기)
//            );

            return data;
        }
        return data;
    }


    public int CreateCSV(List<String> datas, String filepath) {
        int resultCount = 0;
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(filepath + "/test.csv", true));
            for (int i = 0; datas.size() > i; i++) {
                fw.write(datas.get(i));
                fw.newLine();
                resultCount++;
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultCount;
    }

    public void CreateXML(List<String> datas, String filepath, String fileName, String sheetName) {
        XSSFWorkbook xssfWb = null;
        XSSFSheet xssfSheet = null;
        XSSFRow xssfRow = null;
        XSSFCell xssfCell = null;

        try {
            int rowNo = 0;

            xssfWb = new XSSFWorkbook();
            xssfSheet = xssfWb.createSheet(sheetName);

            XSSFFont font = xssfWb.createFont();
            font.setFontName(HSSFFont.FONT_ARIAL);
            font.setFontHeightInPoints((short) 20);
            font.setBold(true);

            xssfSheet.createRow(rowNo++); //빈행추가가

            for (String a : datas) {
                xssfRow = xssfSheet.createRow(rowNo++);
                xssfCell = xssfRow.createCell((short) 1);
                xssfCell.setCellValue(a+"1번시트");
                xssfCell = xssfRow.createCell((short) 2);
                xssfCell.setCellValue(a+"2번시트");
                xssfCell = xssfRow.createCell((short) 3);
                xssfCell.setCellValue(a+"3번시트");

            }
            String localFile = filepath + fileName + ".xlsx";
            File file = new File(localFile);
            FileOutputStream fos = null;
            fos = new FileOutputStream(file);
            xssfWb.write(fos);
            if (fos != null) fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}


