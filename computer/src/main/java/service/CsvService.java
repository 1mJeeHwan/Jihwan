package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

@Service
public class CsvService implements DataService{

  public static <T> void createCSV(List<T> data, String filepath, String fileName){

    try(BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filepath + File.separator+ fileName +".csv"),
        StandardCharsets.UTF_8))) {
      fw.write("\uFEFF");
      int check = 0;
      for(var headers : data.get(0).getClass().getDeclaredFields()){
        if(check !=0){
          fw.write(",");
        }
        fw.write(headers.getName());
        check++;
      }
      fw.newLine();
      for (var result : data) {
        Field fieldList[] = result.getClass().getDeclaredFields();
        check = 0;
        for(Field filed : fieldList) {
          filed.setAccessible(true);
          if(check !=0){
            fw.write(",");
          }
          fw.write(filed.get(result).toString());
          check++;
        }
        fw.newLine();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
