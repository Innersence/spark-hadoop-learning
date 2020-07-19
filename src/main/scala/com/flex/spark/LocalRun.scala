package com.flex.spark

import java.util

object LocalRun {
  def main(args: Array[String]): Unit = {
    Service.parseString
  }
}

object Service{
  def parseString:Unit = {
    val bytes:Array[Byte] = "me".getBytes
    val bytes2:Array[Byte] =  "me".getBytes
    println(bytes2)
    println(bytes)
    println(bytes.length)
    if(util.Arrays.equals(bytes,bytes2)){
      println("bytes is equal")
    }else{
      println("not equal")
    }

    for(i <- 0 until 10){
      println(i)
    }

  }
}