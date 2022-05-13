package com.example.myungzak.room;

public interface Room {
  default void 형광등On(){}
  default void 형광등Off(){}
  default void 에어컨On(){}
  default void 에어컨Off(){}
  default void 난방On(){}
  default void 난방Off(){}
}
