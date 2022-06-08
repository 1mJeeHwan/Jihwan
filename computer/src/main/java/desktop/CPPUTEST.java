package desktop;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import service.SpreadSheetColum;

@Builder
@Getter
@Setter
@ToString
public class CPPUTEST {

  @SpreadSheetColum(order = 0,filedName = "CPU 제조사 이름")
  String 제조사;

  @SpreadSheetColum(order = 1,filedName = "코어 갯수")
  int 코어;

  @SpreadSheetColum(order = 2,filedName = "쓰레드 갯수")
  int 쓰레드;

  @SpreadSheetColum(order = 3,filedName = "CPU 최대 클럭")
  double 클럭;
}
