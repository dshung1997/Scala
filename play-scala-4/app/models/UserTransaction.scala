package models

import java.sql.Timestamp

import play.api.libs.json._

case class UserTransaction(sender: String, sender_code: Int, recipient: String, recipient_code: Int, amount: Int, date: Timestamp = DateFormat.defaultTimestamp, status: Int = -1)

object UserTransaction {
	
	implicit val read: Reads[UserTransaction] = new Reads[UserTransaction] {
		def reads(json: JsValue): JsResult[UserTransaction] = {
			for {
				sender <- (json \ "sender").validate[String]
				sender_code <- (json \ "sender_code").validate[String]
				recipient <- (json \ "recipient").validate[String]
				recipient_code <- (json \ "recipient_code").validate[String]
				amount <- (json \ "amount").validate[String]
				date <- (json \ "date").validateOpt[String]
				status <- (json \ "status").validateOpt[String]
			} yield
				{
					if(date.isEmpty) UserTransaction(sender, sender_code.toInt, recipient, recipient_code.toInt, amount.toInt, DateFormat.getCurrentTimestamp)
					else UserTransaction(sender, sender_code.toInt, recipient, recipient_code.toInt, amount.toInt, DateFormat.getTimestamp(date.head), status.head.toInt)
				}
		}
	}
	
	implicit val write = new Writes[UserTransaction] {
		def writes(tran: UserTransaction) = Json.obj(
			"sender" -> tran.sender,
			"sender_code" -> tran.sender_code.toString,
			"recipient" -> tran.recipient,
			"recipient_code" -> tran.recipient_code.toString,
			"amount" -> tran.amount.toString,
			"date" -> tran.date.toString,
			"status" -> tran.status.toString
		)
	}
}