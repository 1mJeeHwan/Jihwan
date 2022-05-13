public class Main {
  public static void main(String[] args) {
    String typeDay = "주일";
    if (typeDay == 주일예배.days) {
      주일예배 주일예배 = new 주일예배();
      주일예배.시작();
    }
    if (typeDay == 수요예배.days) {
      수요예배 수요예배 = new 수요예배();
      수요예배.시작();
    }
    if (typeDay == 새벽예배.days) {
      새벽예배 새벽예배 = new 새벽예배();
      새벽예배.시작();
    }
  }
}
