package service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public interface DataService{

  static <T> HashMap getHeader(List<T> data){
    var hashMap = new HashMap<>();
    for (Field filed : data.get(0).getClass().getDeclaredFields()) {
      filed.setAccessible(true);
      if (filed.getDeclaredAnnotation(SpreadSheetColum.class) != null) {
        SpreadSheetColum note = filed.getAnnotation(SpreadSheetColum.class);
        hashMap.put(note.order(), note.filedName());
      }
    }
    return sortOrder(hashMap);
  }
  static <T> HashMap getValue(T result) throws IllegalAccessException {
    Field fields[] = result.getClass().getDeclaredFields();
    var hashMap = new HashMap<>();
    for (Field filed : fields) {
      filed.setAccessible(true);
      if (filed.getDeclaredAnnotation(SpreadSheetColum.class) != null) {
        SpreadSheetColum note = filed.getAnnotation(SpreadSheetColum.class);
        hashMap.put(note.order(), filed.get(result).toString());
      }
    }
    return sortOrder(hashMap);
  }

  static HashMap sortOrder(HashMap hashMap){
    Object[] map = hashMap.keySet().toArray();
    Arrays.sort(map);
    return hashMap;
  }

}
