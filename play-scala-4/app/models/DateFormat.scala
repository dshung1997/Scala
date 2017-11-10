package models

import java.sql.Timestamp
import java.util.Date

/**
  * Created by dshung on 17/08/2017.
  */
object DateFormat
{
	import java.text.SimpleDateFormat
	import java.util.Calendar
	
	val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
	
	//println(format.format(Calendar.getInstance().getTime()))
	
	def getCurrentTimestamp: Timestamp = Timestamp.valueOf(format.format(Calendar.getInstance().getTime))
	
	def getCurrentTimestampString: String = format.format(Calendar.getInstance().getTime)
	
	def defaultTimestamp: Timestamp = Timestamp.valueOf("2017-02-15 10:26:05")
	
	def getTimestamp(str: String) = Timestamp.valueOf(str)
}
