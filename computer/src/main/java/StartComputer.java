import desktop.CPU;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import service.CsvService;
import service.ExelService;

public class StartComputer {



  public static void main(String[] args){
    MainBoard mainBoard = new MainBoard();
    boolean 전기 = true;
//    mainBoard.PowerButton(전기);

    //테스트
    var filePath = "./";
    Random random = new Random();
    List<CPU> cpuList = new ArrayList<>();
    for(int i = 0; i<1000; i++){
      CPU cpu = new CPU();
      cpu.set클럭(Double.toString(random.nextDouble()*4+2));
      cpu.set코어(numCheck(random.nextInt(11)+1));
      cpu.set쓰레드(numCheck(cpu.get코어())*2);
      cpu.set제조사(String.valueOf(제조사.values()[random.nextInt(제조사.values().length)]));
      cpuList.add(cpu);
    }

    CsvService.createCSV(cpuList, filePath);

    ExelService.createExel(cpuList,filePath,"testest","테스트중");

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
