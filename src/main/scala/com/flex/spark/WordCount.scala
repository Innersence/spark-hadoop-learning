package com.flex.spark

import com.flex.spark.common.{FileUtils, Utils}
import org.apache.spark.{SparkConf, SparkContext}
import com.flex.spark.classwrapper.{UrlString,UrlStringJava}

import scala.collection.mutable

/**
 * @author ${user.name}
 */
object WordCount {
  def main(args : Array[String]): Unit = {
    System.setProperty("hadoop.home.dir","D:\\programs\\hadoop-common-2.2.0-bin")

    var inputFile = "/home/data/spark/urls2.txt"
    var output = "/home/data/spark/output/result"
    urlDistinctRdd(inputFile:String,output:String)
//    mapToUrlString(inputFile:String,output:String)


  }

  def urlDistinctRdd(inputFile:String,output:String): Unit ={
    val master = "local[4]"
    val sparkConf = new SparkConf().setMaster(master).setAppName("WordCount")
    val sparkContext = new SparkContext(sparkConf)
    val rowRdd = sparkContext.textFile(inputFile)
    val mpStart = Utils.getTimestamp
//    val mapRdd = rowRdd.map(url => (new UrlString(url), 1))
    val mapRdd = rowRdd.map(url => ( new  UrlStringJava(url), 1))
    val count = mapRdd.count()
    val mpEnd = Utils.getTimestamp
    println("count="+count)
    println("mp time "+(mpEnd - mpStart))

    val resultRdd = mapRdd.reduceByKey(_ + _)


    FileUtils.deleteDir(output)
    val saveBefore = Utils.getTimestamp
    val arrStr = resultRdd.take(100000)
    val saveAfter = Utils.getTimestamp
    println("\ncount="+resultRdd.count())
    println("save time cost :"+(saveAfter - saveBefore))
    println("\n array string :\n")
//    arrStr.toList.foreach(println)
  }

  def mapToUrlString(inputFile:String,output:String):Unit = {
    val lines = FileUtils.readLines(inputFile)
    val mapBefore = Utils.getTimestamp
    val urlCountMap :mutable.HashMap[String,Int] =  mutable.HashMap()
    val urlString = new UrlString("https://g.csdnimg.cn/fixed-sidebar/1.1.3/fixed-sidebar.js")
    val urlStrings = lines.map( url => {
      val u = new UrlString(url)
      if(u.equals(urlString)) 1 else 2
    }).reduce(_ + _)
    println(urlStrings)
    val mapAfter = Utils.getTimestamp
    println("map cost :"+(mapAfter - mapBefore))

  }
}
