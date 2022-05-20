
import desktop.*;
import interfaces.마우스;
import interfaces.마이크;
import interfaces.키보드;
import moniter.Moniter;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.*;

public class MainBoard {

    SSD ssd = new SSD();
    CPU cpu = new CPU();
    GPU gpu = new GPU();
    RAM ram = new RAM();
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

        moniter.viewMoniter(datas, 파워.전력공급(전기));
        var filePath = "./";

        List<CPU> cpuList = new ArrayList<>();
//        List<GPU> gpuList = new ArrayList<>();
//        List<RAM> ramList = new ArrayList<>();
        for(int i = 0; i<1000; i++){
            CPU cpu = new CPU();
            GPU gpu = new GPU();
            RAM ram = new RAM();
            cpu.set클럭(Double.toString(Math.random()*6));
//            gpu.set메모리(Integer.toString((int)Math.random()*16*10000));
//            gpu.set클럭(Double.toString(Math.random()*12+1));
//            ram.set메모리(Integer.toString((int)Math.random()*64*10000));
            cpuList.add(cpu);
//            gpuList.add(gpu);
//            ramList.add(ram);
        }
        CreateCSV(cpuList, filePath);
//        CreateXML(cpuList,gpuList,ramList,filePath,"testest","테스트중");
        CreateXML(cpuList,filePath,"testest","테스트중");
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


    public int CreateCSV(List<CPU> datas, String filepath) {
        int resultCount = 0;
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(filepath +File.separator+ "test.csv", true));
            for (CPU cpu:datas) {
                fw.write(cpu.get클럭());
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

//    public void CreateXML(List<CPU> cpuList, List<GPU> gpuList, List<RAM> ramList,String filepath, String fileName, String sheetName) {
    public void CreateXML(List<CPU> cpuList ,String filepath, String fileName, String sheetName) {
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

            CellStyle cellStyle = xssfWb.createCellStyle();

            xssfSheet.setColumnWidth(1, (xssfSheet.getColumnWidth(0))+(short)2048); // 3번째 컬럼 넓이 조절
            xssfSheet.setColumnWidth(2, (xssfSheet.getColumnWidth(1))+(short)2048); // 4번째 컬럼 넓이 조절
            xssfSheet.setColumnWidth(3, (xssfSheet.getColumnWidth(2))+(short)2048); // 5번째 컬럼 넓이 조절
            xssfSheet.setColumnWidth(4, (xssfSheet.getColumnWidth(3))+(short)2048); // 5번째 컬럼 넓이 조절
            xssfSheet.setColumnWidth(5, (xssfSheet.getColumnWidth(4))+(short)2048); // 5번째 컬럼 넓이 조절


            xssfRow = xssfSheet.createRow(rowNo++);
            xssfCell = xssfRow.createCell((short) 1);
            xssfCell.setCellStyle(cellStyle);
            xssfCell.setCellValue("cpu클럭");

//            xssfCell = xssfRow.createCell((short) 2);
//            xssfCell.setCellStyle(cellStyle);
//            xssfCell.setCellValue("gpu클럭");
//
//            xssfCell = xssfRow.createCell((short) 3);
//            xssfCell.setCellStyle(cellStyle);
//            xssfCell.setCellValue("gpu메모리");
//
//            xssfCell = xssfRow.createCell((short) 4);
//            xssfCell.setCellStyle(cellStyle);
//            xssfCell.setCellValue("ram클럭");
//
//            xssfCell = xssfRow.createCell((short) 5);
//            xssfCell.setCellStyle(cellStyle);
//            xssfCell.setCellValue("ram메모리");



            for (CPU cpu : cpuList) {
                xssfRow = xssfSheet.createRow(rowNo++);


                xssfCell = xssfRow.createCell((short) 1);
                xssfCell.setCellStyle(cellStyle);
                xssfCell.setCellValue(cpu.get클럭());


//                xssfCell = xssfRow.createCell((short) 2);
//                xssfCell.setCellStyle(cellStyle);
//                xssfCell.setCellValue("2번시트");
//
//
//                xssfCell = xssfRow.createCell((short) 3);
//                xssfCell.setCellStyle(cellStyle);
//                xssfCell.setCellValue("3번시트");
//
//                xssfCell = xssfRow.createCell((short) 4);
//                xssfCell.setCellStyle(cellStyle);
//                xssfCell.setCellValue("4번시트");
//
//
//                xssfCell = xssfRow.createCell((short) 5);
//                xssfCell.setCellStyle(cellStyle);
//                xssfCell.setCellValue("5번시트");

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


