package interfaces;

import java.util.List;

public class 마우스 implements Input{

  @Override
  public List<String> 데이터입력(List<String> datas, String data) {
      if(!data.isEmpty()){
        datas.add(data);
      }
    return datas;
  }
}
