package 찬양팀;

import java.util.List;

public class 찬양곡 {
  public 찬양곡() {
  }

  static void 찬양중(List<String> 찬양곡들) {
    찬양곡들.forEach((s) -> {
      System.out.println("찬양 : " + s);
    });
  }
}
