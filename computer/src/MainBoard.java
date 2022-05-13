import desktop.CPU;
import desktop.GPU;
import desktop.RAM;
import desktop.SSD;
import desktop.파워;
import interfaces.마우스;
import interfaces.마이크;
import interfaces.키보드;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import moniter.Moniter;

public class MainBoard {
  CPU cpu = new CPU();
  GPU gpu = new GPU();
  RAM ram = new RAM();
  SSD ssd = new SSD();
  파워 파워 = new 파워();
  마우스 마우스 = new 마우스();
  키보드 키보드 = new 키보드();
  마이크 마이크 = new 마이크();
  public void OnPower(boolean 전기) {
    Moniter moniter = new Moniter();
    if(!moniter.bootingComputer(전기)){
      return;
    };
    List<String> datas = new ArrayList<>();
    datas = InPutData(datas,전기);
    moniter.viewMoniter(datas, 파워.전력공급(전기));
  }

  public List<String> InPutData(List<String> datas, boolean 전기){
    Scanner scan = new Scanner(System.in);
    System.out.println("마우스 데이터 입력");
    String data = scan.nextLine();
    datas = SendData(마우스.데이터입력(datas,data),전기);
    System.out.println("키보드 데이터 입력");
    data = scan.nextLine();
    datas = SendData(키보드.데이터입력(datas,data),전기);
    System.out.println("마이크 데이터 입력");

    data = scan.nextLine();
    datas = SendData(마이크.데이터입력(datas,data),전기);
    return datas;
  }
  public List<String> SendData(List<String> data,boolean 전기){
    if(data.size()>0){
      data = cpu.계산처리(
          gpu.계산처리(
              ram.계산처리(
                  ssd.계산처리(
                      data, 파워.전력공급(전기)
                  ), 파워.전력공급(전기)
              ), 파워.전력공급(전기)
          ), 파워.전력공급(전기));
      return data;
    }
    return data;
  }
}

