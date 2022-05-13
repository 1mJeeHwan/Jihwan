package com.example.myungzak;


import com.example.myungzak.common.Floor;
import com.example.myungzak.dept.개발팀;
import com.example.myungzak.dept.경영지원팀;
import com.example.myungzak.dept.음악팀;
import com.example.myungzak.dept.제작팀;
import com.example.myungzak.dept.팀3D;
import com.example.myungzak.room.A스튜디오;
import com.example.myungzak.room.A스튜디오엔지니어룸;
import com.example.myungzak.room.VVIPROOM;
import com.example.myungzak.room.palm짐;
import com.example.myungzak.room.개발경영지원팀사무실;
import com.example.myungzak.room.녹음실;
import com.example.myungzak.room.녹음실2;
import com.example.myungzak.room.다이닝룸;
import com.example.myungzak.room.덤웨이터;
import com.example.myungzak.room.릴렉스존;
import com.example.myungzak.room.메이크업실;
import com.example.myungzak.room.명작문화재단;
import com.example.myungzak.room.명작예배당;
import com.example.myungzak.room.믹싱룸1;
import com.example.myungzak.room.믹싱룸2;
import com.example.myungzak.room.믹싱룸3;
import com.example.myungzak.room.믹싱룸4;
import com.example.myungzak.room.서버실;
import com.example.myungzak.room.앵커룸;
import com.example.myungzak.room.작가실1;
import com.example.myungzak.room.작가실2;
import com.example.myungzak.room.제작3D실;
import com.example.myungzak.room.제작사무실1;
import com.example.myungzak.room.제작사무실2;
import com.example.myungzak.room.제작사무실3;
import com.example.myungzak.room.제작사무실4;
import com.example.myungzak.room.제작사무실5;
import com.example.myungzak.room.주방;
import com.example.myungzak.room.창고;
import com.example.myungzak.room.크로마키홀;
import com.example.myungzak.room.편곡실1;
import com.example.myungzak.room.편곡실2;
import com.example.myungzak.room.편곡실3;
import com.example.myungzak.room.편곡실4;
import com.example.myungzak.room.편곡실5;
import com.example.myungzak.room.편집실1;
import com.example.myungzak.room.편집실2;
import com.example.myungzak.room.편집실3;
import com.example.myungzak.room.회의실;
import com.example.myungzak.room.휴게실_남;
import com.example.myungzak.room.휴게실_여;


public class Main {

  MyungZakTower mz = MyungZakTower.builder()
      .A스튜디오(new A스튜디오()).A스튜디오엔지니어룸(new A스튜디오엔지니어룸()).개발경영지원팀사무실(new 개발경영지원팀사무실())
      .편집실1(new 편집실1()).편집실2(new 편집실2()).편곡실1(new 편곡실1()).크로마키홀(new 크로마키홀()).믹싱룸1(new 믹싱룸1())
      .믹싱룸2(new 믹싱룸2()).녹음실(new 녹음실()).덤웨이터(new 덤웨이터()).휴게실_남(new 휴게실_남()).휴게실_여(new 휴게실_여())
      .회의실(new 회의실()).편집실3(new 편집실3()).편곡실4(new 편곡실4()).편곡실5(new 편곡실5()).편곡실3(new 편곡실3())
      .편곡실2(new 편곡실2()).창고(new 창고()).주방(new 주방()).제작사무실5(new 제작사무실5()).제작사무실4(new 제작사무실4())
      .제작사무실3(new 제작사무실3()).제작사무실2(new 제작사무실2()).제작사무실1(new 제작사무실1()).제작3D실(new 제작3D실())
      .작가실2(new 작가실2()).작가실1(new 작가실1()).앵커룸(new 앵커룸()).서버실(new 서버실()).믹싱룸4(new 믹싱룸4())
      .믹싱룸3(new 믹싱룸3()).명작예배당(new 명작예배당()).명작문화재단(new 명작문화재단()).메이크업실(new 메이크업실())
      .릴렉스존(new 릴렉스존()).다이닝룸(new 다이닝룸()).녹음실2(new 녹음실2()).palm짐(new palm짐())
      .VVIPROOM(new VVIPROOM()).build();
  개발팀 개발팀 = new 개발팀();
  경영지원팀 경영지원팀 = new 경영지원팀();
  음악팀 음악팀 = new 음악팀();
  제작팀 제작팀 = new 제작팀();
  팀3D 팀3D = new 팀3D();

  public void move(String floor) {

    if (floor.equals(Floor.F1)) {
      this.F1();
    } else if (floor.equals(Floor.F2)) {
      this.F2();
    } else if (floor.equals(Floor.F3)) {
      this.F3();
    }
  }

  void F1() {
    mz.get개발경영지원팀사무실().난방Off();
    mz.get개발경영지원팀사무실().에어컨On();
    mz.get개발경영지원팀사무실().개발팀.개발();
    mz.get개발경영지원팀사무실().개발팀.유지보수();
    mz.get개발경영지원팀사무실().경영지원팀.CS();
    mz.get개발경영지원팀사무실().경영지원팀.기술지원();
    mz.get개발경영지원팀사무실().경영지원팀.내부운영();
    mz.get개발경영지원팀사무실().경영지원팀.네트워크();
    mz.get개발경영지원팀사무실().경영지원팀.비품구매();
    mz.get개발경영지원팀사무실().경영지원팀.시설관리();
    mz.get개발경영지원팀사무실().경영지원팀.외부채널관리();
    mz.get개발경영지원팀사무실().경영지원팀.회계();
    mz.get개발경영지원팀사무실().형광등On();
    mz.get녹음실().음악팀.녹음();
    mz.get편집실3().음악팀.녹음();

  }

  void F2() {
    mz.get명작예배당().난방Off();
    mz.get명작예배당().형광등Off();
  }

  void F3() {
    mz.getPalm짐().에어컨On();
    mz.getPalm짐().형광등On();
    mz.getPalm짐().사람.물건옮기기();

  }

}
