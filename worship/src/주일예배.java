import Common.예배종류;
import java.util.ArrayList;
import java.util.List;
import 기능.예배;
import 반주팀.연주자;
import 방송팀.방송팀;
import 예배팀.말씀원고;
import 예배팀.봉헌위원;
import 예배팀.사회자;
import 예배팀.설교자;
import 예배팀.예배위원;
import 장비.instrument.*;
import 장비.mike.*;
import 찬양팀.싱어;

public class 주일예배 implements 예배 {
  public static String days;
  private static List<String> 찬양곡;
  private static List<String> 봉헌곡;
  private static 연주자 연주자;
  private static 방송팀 방송팀;
  private static 설교자 설교자;
  private static 싱어 싱어;
  private static 봉헌위원 봉헌위원;
  private static 사회자 사회자;
  private static 예배위원 예배위원;
  private static 말씀원고 말씀원고;

  public 주일예배() {
  }

  public void 시작() {
    this.예배준비();
    this.준비찬양();
    this.신앙고백합독();
    this.예배시작();
    this.성경봉독();
    this.말씀설교();
    this.설교후기도();
    this.봉헌();
    this.봉헌기도();
    this.광고();
  }

  public void 예배준비() {
    예배위원.주차관리();
    예배위원.ERP체크();
    예배위원.예배안내();
    예배위원.인사();
  }

  public void 준비찬양() {
    찬양곡.add("찬양1");
    찬양곡.add("찬양2");
    찬양곡.add("찬양3");
    연주자.연주(new 기타());
    연주자.연주(new 피아노());
    연주자.연주(new 바이올린());
    연주자.연주(new 키보드());
    연주자.연주(new 트럼펫());
    연주자.연주(new 베이스());
    연주자.연주(new 기타());
    연주자.연주(new 첼로());
    싱어.get마이크(new 좋은마이크());
    싱어.찬양(찬양곡);
    방송팀.자막송출();
    방송팀.음향송출();
    방송팀.예배진행();
    방송팀.촬영();
    방송팀.촬영();
  }

  public void 신앙고백합독() {
    방송팀.영상송출();
    방송팀.음향송출();
  }

  public void 예배시작() {
    사회자.사회인도();
    사회자.get마이크(new 일반마이크());
    방송팀.음향송출();
    방송팀.촬영();
    방송팀.영상송출();
  }

  public void 성경봉독() {
    방송팀.영상송출();
    방송팀.음향송출();
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

  public void 봉헌() {
    봉헌곡.add("봉헌찬양");
    싱어.찬양(봉헌곡);
    봉헌위원.봉헌인도();
    방송팀.음향송출();
    방송팀.영상송출();
    방송팀.촬영();
  }

  public void 봉헌기도() {
    설교자.기도();
    방송팀.촬영();
    방송팀.음향송출();
  }

  public void 광고() {
    사회자.광고();
    사회자.get마이크(new 일반마이크());
    방송팀.영상송출();
    방송팀.음향송출();
  }

  static {
    days = 예배종류.주일.toString();
    찬양곡 = new ArrayList();
    봉헌곡 = new ArrayList();
    연주자 = new 연주자();
    방송팀 = new 방송팀();
    설교자 = new 설교자();
    싱어 = new 싱어();
    봉헌위원 = new 봉헌위원();
    사회자 = new 사회자();
    예배위원 = new 예배위원();
    말씀원고 = new 말씀원고();
  }
}
