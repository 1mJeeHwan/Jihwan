
import desktop.*;
import interfaces.마우스;
import interfaces.마이크;
import interfaces.키보드;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
import service.CsvService;
import service.ExelService;

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
        inPutData(moniter, datas, 전기);

    }

    public void inPutData(Moniter moniter, List<String> datas, boolean 전기) {

        moniter.viewMoniter(datas, 파워.전력공급(전기));
        var filePath = "./";
        Random random = new Random();
        List<CPU> cpuList = new ArrayList<>();
        for(int i = 0; i<1000; i++){
            CPU cpu = new CPU();
            cpu.set클럭(Double.toString(random.nextDouble()*6));
            cpu.set쓰레드(random.nextInt(11)+1);
            cpu.set코어(random.nextInt(5)+1);
            cpu.set제조사(String.valueOf(제조사.values()[random.nextInt(제조사.values().length)]));
            cpuList.add(cpu);
        }
        CsvService.createCSV(cpuList, filePath);
        ExelService.createExel(cpuList,filePath,"testest","테스트중");
    }


    public List<String> sendData(List<String> data, boolean 전기) {
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





}


