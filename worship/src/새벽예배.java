import Common.예배종류;
import java.util.ArrayList;
import java.util.List;
import 기능.예배;
import 반주팀.연주자;
import 방송팀.방송팀;
import 예배팀.말씀원고;
import 예배팀.설교자;
import 장비.mike.*;
import 찬양팀.싱어;

public class 새벽예배 implements 예배 {
  public static String days;
  private static List<String> 찬양곡;
  private static 연주자 연주자;
  private static 방송팀 방송팀;
  private static 설교자 설교자;
  private static 싱어 싱어;
  private static 말씀원고 말씀원고;

  public 새벽예배() {
  }

  public void 시작() {
    this.준비찬양();
    this.말씀설교();
    this.설교후기도();
  }

  public void 준비찬양() {
    찬양곡.add("찬양1");
    찬양곡.add("찬양2");
    찬양곡.add("찬양3");
    싱어.get마이크(new 좋은마이크());
    싱어.찬양(찬양곡);
    방송팀.자막송출();
    방송팀.음향송출();
    방송팀.예배진행();
    방송팀.촬영();
    방송팀.촬영();
  }

  public void 말씀설교() {
    설교자.말씀설교(말씀원고);
    설교자.get마이크(new 설교용마이크());
    방송팀.영상송출();
    방송팀.촬영();
    방송팀.촬영();
    방송팀.음향송출();
    방송팀.자막송출();
  }

  public void 설교후기도() {
    설교자.기도();
    방송팀.촬영();
    방송팀.음향송출();
  }

  static {
    days = 예배종류.새벽.toString();
    찬양곡 = new ArrayList();
    연주자 = new 연주자();
    방송팀 = new 방송팀();
    설교자 = new 설교자();
    싱어 = new 싱어();
    말씀원고 = new 말씀원고();
  }
}
