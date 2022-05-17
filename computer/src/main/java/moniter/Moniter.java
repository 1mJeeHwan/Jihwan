package moniter;

import desktop.파워;

import java.util.List;

public class Moniter extends 파워 implements UserOutput {
  public 파워 파워 = new 파워();
  public void viewMoniter(List<String> datas,boolean 전기){
    if(파워.전력공급(전기)){
      System.out.println("----------모니터화면------------");
      System.out.println();
      datas.forEach(s -> System.out.print(s + " "));
      System.out.println();
      System.out.println("-------------끝---------------");
    }else{
      System.out.println("전력이상");
    }
  }
  public boolean bootingComputer(boolean 전기){
    System.out.println("컴퓨터가 부팅중입니다.");
    if(파워.전력공급(전기)){
      System.out.println("환영합니다.");
      return true;
    }else{
      System.out.println("전력이상");
      return false;
    }
  }

}
