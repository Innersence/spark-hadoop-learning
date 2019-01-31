package cn.mp.spark

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author ${user.name}
 */
object WordCount {
  def main(args : Array[String]): Unit = {
    var model = "local";
    var inputFile = "/home/minpan/study/data/spark/words.txt"
    var output = "/home/minpan/study/data/spark/output/result.txt"
    val sparkConf = new SparkConf().setMaster(model).setAppName("WordCount")
    val sparkContext = new SparkContext(sparkConf)
    val rowRdd = sparkContext.textFile(inputFile)
    val resultRdd = rowRdd.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_ + _)
    resultRdd.saveAsTextFile(output);
  }
}
