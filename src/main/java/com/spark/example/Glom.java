package com.spark.example;

import java.util.Arrays;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class Glom {

  public static void main(String[] args) {
    JavaSparkContext sc =
        new JavaSparkContext(new SparkConf().setMaster("local").setAppName("mapPar"));
    JavaRDD<Integer> nums = sc.parallelize(Arrays.asList(3, 2, 4, 1, 2, 1), 3);
    nums.glom().mapPartitions((e) -> () -> e).collect().stream().forEach(System.out::println);

  }
}
