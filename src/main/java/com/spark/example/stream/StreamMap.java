package com.spark.example.stream;

import java.util.List;
import java.util.function.Function;

public class StreamMap {

  public static void main(String[] args) {
    List<Integer> list = List.of(1, 2, 3, 4);
    Function<Integer, Integer> fun = new Function<Integer, Integer>() {

      @Override
      public Integer apply(Integer t) {
        return t;
      }
    };
    list.stream().map
  }
}
