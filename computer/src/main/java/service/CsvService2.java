package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CsvService2 implements DataService{

  public static <T> void createCSV2(List<T> data, String filepath, String fileName){

    try(BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filepath + File.separator+ fileName +".csv"),
        StandardCharsets.UTF_8))) {
      fw.write("\uFEFF");
      int check = 0;

      var header = DataService.getHeader(data.get(0));
      for(var headers : header.keySet()){
        if(check !=0){
          fw.write(",");
        }
        fw.write(header.get(headers).toString());
        check++;
      }
      fw.newLine();

      for (var result : data) {
        var sortMap = DataService.getValue(result);
        check = 0;
        for(var index : sortMap.keySet()){
          if(check !=0){
            fw.write(",");
          }
          fw.write(sortMap.get(index).toString());
          check++;
        }
        fw.newLine();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}

