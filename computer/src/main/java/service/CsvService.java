package service;

import desktop.CPU;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CsvService {
  public static void createCSV(List<CPU> datas, String filepath) {
    int resultCount = 0;
    try(BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filepath + File.separator+ "test.csv"),
        StandardCharsets.UTF_8))) {
      fw.write("\uFEFF");
      List<String> header = List.of("제조사","코어","쓰레드","클럭");
      int idx = 1;
      fw.write("no.");
      fw.write(",");

      for(String h:header){
        fw.write(h);
        fw.write(",");
      }
      fw.newLine();

      for (CPU cpu:datas) {
        fw.write(Integer.toString(idx));
        fw.write(",");
        fw.write(cpu.get제조사());
        fw.write(",");
        fw.write(Integer.toString(cpu.get코어()));
        fw.write(",");
        fw.write(Integer.toString(cpu.get쓰레드()));
        fw.write(",");
        fw.write(cpu.get클럭());
        fw.newLine();
        idx++;
      }
      fw.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
