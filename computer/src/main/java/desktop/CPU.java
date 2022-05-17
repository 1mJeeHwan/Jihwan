package desktop;

import java.util.List;

public class CPU extends 파워 implements 메인보드{
  파워 파워 = new 파워();
  String 클럭;
  public void set클럭(String 클럭) {
    this.클럭 = 클럭;
  }
  public String get클럭() {
    return 클럭;
  }

  public List<String> 계산처리(List<String> data, boolean 전기){
    if(!파워.전력공급(전기)){
      System.out.println("전력 공급이 원할하지 않습니다.");
      return null;
    }
    return 데이터전송(data,파워.전력공급(true));
  }
  @Override
  public List<String> 데이터전송(List<String> data, boolean 전력공급) {
    return data;
  }
}
