package desktop;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class CPU extends 파워 implements 메인보드{
  파워 파워 = new 파워();
  String 클럭;
  String 제조사;
  int 코어;
  int 쓰레드;


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
