package com.spark.example;

import java.util.Arrays;
import java.util.List;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

public class HelloWorld {

  public static void main(String[] args) {
    SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("JD Word Counter");
    JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
    JavaRDD<String> sc = sparkContext.textFile("C:\\spark\\spark-3.5.0-bin-hadoop3\\README.md")
        .flatMap(e -> Arrays.asList(e.split(" ")));
    List<Tuple2<String, Integer>> rdd =
        sc.mapToPair(e -> new Tuple2<>(e, 1)).reduceByKey((e1, e2) -> e1 + e2).collect();
    rdd.stream().forEach(val -> System.out.print(val + " "));
  }

}
