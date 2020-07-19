package com.flex.spark.common

import java.io.File

import scala.io.Source

object FileUtils {

  def mkdir(path:String):Boolean={
    val file = new File(path)
   file.mkdirs
  }

  def deleteEmptyDir(dir: String):Boolean= {
    val success = new File(dir).delete()
    if (success) {
      println("Successfully deleted empty directory: " + dir)
    } else {
      println("Failed to delete empty directory: " + dir)
    }
    success
  }

  /**
    * 递归删除目录下的所有文件及子目录下所有文件
    *
    * @param dir 将要删除的文件目录
    * @return boolean Returns "true" if all deletions were successful.
    *         If a deletion fails, the method stops attempting to
    *         delete and returns "false".
    */
  def deleteDir(dir: String): Boolean = {
    val fileDir = new File(dir)
    if (fileDir.isDirectory) {
      val children = fileDir.list()
      for (subDir <- children) {
        val success = deleteDir(dir + "/" + subDir)
        if (!success) {
          false
        }
      }
    }
    fileDir.delete()
  }

  def readLines(fileName:String):Iterator[String]={
    val file = Source.fromFile(fileName)
    file.getLines()
  }


}



