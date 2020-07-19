package com.flex.spark.classwrapper

class UrlString(url:String) extends Serializable {
  override
  val hashCode:Int = url.hashCode()

  override def equals(obj: Any): Boolean = {
    val str = obj.toString
    val len = url.length
    if(str.length != len){
      false
    }else{
      val targetBytes = str.getBytes()
      val srcBytes = url.getBytes()
      for (i <-  0 until  len  ){
        if( targetBytes(i).equals(srcBytes(i))){

        }else{

        }
      }
    false

    }

  }

  def length = url.length

  override
  def toString = url

}
