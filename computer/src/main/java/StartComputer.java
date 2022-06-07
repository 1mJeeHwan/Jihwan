import desktop.CPPUTEST;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import service.CsvService2;
import service.ExcelService2;

public class StartComputer {



  public static void main(String[] args) throws Exception {

//    MainBoard mainBoard = new MainBoard();
//    boolean 전기 = true;
//    mainBoard.PowerButton(전기);
//
    //테스트
    var filePath = "./";
    Random random = new Random();
    List<CPPUTEST> cpuList = new ArrayList<>();
    for(int i = 0; i<2000; i++){
      cpuList.add(CPPUTEST.builder()
          .제조사(String.valueOf(제조사.values()[random.nextInt(제조사.values().length)]))
          .코어(numCheck(random.nextInt(11)+1))
          .쓰레드(numCheck(random.nextInt(11)+1)*2)
          .클럭(random.nextDouble()*4+2)
          .build());
    }
    var fileName = "test123";

//    CsvService.createCSV(cpuList, filePath, fileName);
//    ExcelService.createExcel(cpuList, filePath, fileName);

      CsvService2.createCSV2(cpuList, filePath, fileName);
      ExcelService2.createExcel2(cpuList, filePath, fileName);
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
