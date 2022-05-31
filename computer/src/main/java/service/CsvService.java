package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.List;



public class CsvService {
  public static <T> void createCSV(List<T> data, String filepath,String fileName)throws IllegalAccessException{

    int resultCount = 0;
    try(BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filepath + File.separator+ fileName +".csv"),
        StandardCharsets.UTF_8))) {
      fw.write("\uFEFF");

      for(var headers : data.get(0).getClass().getDeclaredFields()){
        fw.write(headers.getName());
        fw.write(",");
      }
      fw.newLine();
      for (var result : data) {
        Field fieldlist[] = result.getClass().getDeclaredFields();
        for(Field filed : fieldlist) {
          filed.setAccessible(true);
          fw.write(filed.get(result).toString());
          fw.write(",");
        }
        fw.newLine();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
