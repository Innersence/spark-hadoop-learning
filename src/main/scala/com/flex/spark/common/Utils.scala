package com.flex.spark.common

import java.util.Date
import java.text.SimpleDateFormat

object Utils {
   def getTimestamp:Double ={
     val date = new Date()
     val dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(date)
     println(dateStr)
     date.getTime/1000.0
   }
}
