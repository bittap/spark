package com.spark.example;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class MapPartitionsWithIndex {

  public static void main(String[] args) {
    SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("JD Word Counter");
    JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
    String dataFile = "C:\\spark\\spark-3.5.0-bin-hadoop3\\README.md";
    JavaRDD<String> rawInputRdd = sparkContext.textFile(dataFile).repartition(3);


    JavaRDD<String> inputRdd =
        rawInputRdd.mapPartitionsWithIndex((ind, iterator) -> iterator, false);
  }
}
