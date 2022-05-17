package desktop;
import java.util.List;

public class RAM extends 파워 implements 메인보드 {
  public 파워 파워 = new 파워();

  String 메모리;
  public void set메모리(String 메모리) {
    this.메모리 = 메모리;
  }
  public String get메모리() {
    return 메모리;
  }
  public List<String> 계산처리(List<String> data, boolean 전기){
    if(!파워.전력공급(전기)){
      System.out.println("전력 공급이 원할하지 않습니다.");
      return null;
    }
    return 데이터전송(data, 파워.전력공급(true));
  }


  @Override
  public List<String> 데이터전송(List<String> data, boolean 전력공급) {
    return data;
  }
}
