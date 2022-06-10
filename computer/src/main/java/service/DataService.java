package service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;


public interface DataService{

  @NotNull
  static <T> HashMap<Integer,String> getHeader(@NotNull T data){
    var hashMap = new HashMap<Integer,String>();
    for (Field filed : data.getClass().getDeclaredFields()) {
      filed.setAccessible(true);
      if (filed.getDeclaredAnnotation(SpreadSheetColum.class) != null) {
        filed.getAnnotation(SpreadSheetColum.class).order();
        SpreadSheetColum note = filed.getAnnotation(SpreadSheetColum.class);
        hashMap.put(note.order(), note.filedName());
      }
    }
    return sortOrder(hashMap);
  }
  @NotNull
  static <T> HashMap<Integer,String> getValue(@NotNull T result) throws IllegalAccessException {
    Field fields[] = result.getClass().getDeclaredFields();
    var hashMap = new HashMap<Integer,String>();
    for (Field filed : fields) {
      filed.setAccessible(true);
      if (filed.getDeclaredAnnotation(SpreadSheetColum.class) != null) {
        SpreadSheetColum note = filed.getAnnotation(SpreadSheetColum.class);
        hashMap.put(note.order(), filed.get(result).toString());
      }
    }
    return sortOrder(hashMap);
  }

  @NotNull
  @Contract("_ -> param1")
  static HashMap<Integer,String> sortOrder(@NotNull HashMap hashMap){
    Object[] map = hashMap.keySet().toArray();
    Arrays.sort(map);
    return hashMap;
  }

}
