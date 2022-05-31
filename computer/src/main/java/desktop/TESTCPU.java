package desktop;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class TESTCPU {
  String 제조사;
  int 코어;
  int 쓰레드;
  double 클럭;
}
