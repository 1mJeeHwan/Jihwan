import desktop.TESTCPU;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import service.CsvService;
import service.ExcelService;

public class StartComputer {



  public static void main(String[] args) throws Exception {

//    MainBoard mainBoard = new MainBoard();
//    boolean 전기 = true;
////    mainBoard.PowerButton(전기);
//
    //테스트
    var filePath = "./";
    Random random = new Random();
    List<TESTCPU> cpuList = new ArrayList<>();
    for(int i = 0; i<2000; i++){
      cpuList.add(TESTCPU.builder()
          .제조사(String.valueOf(제조사.values()[random.nextInt(제조사.values().length)]))
          .코어(numCheck(random.nextInt(11)+1))
          .쓰레드(numCheck(random.nextInt(11)+1)*2)
          .클럭(random.nextDouble()*4+2)
          .build());
    }
    List<String> header = List.of("no","제조사","코어","쓰레드","클럭");
    var fileName = "test123";
    CsvService.createCSV(cpuList, filePath,fileName);
    ExcelService.createExcel(cpuList,filePath,header,fileName,"테스트중");

  }

  public static int numCheck(int num){
    if(num<2){
      return num;
    }
    if(num%2==1){
      num=num+1;
    }
    return num;
  }

}
