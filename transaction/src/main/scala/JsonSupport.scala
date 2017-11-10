//import JsonSupport.{jsonFormat2, jsonFormat3}
//import JsonSupport.jsonFormat2
//import JsonSupport2.jsonFormat2
import java.sql.Timestamp

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.{DefaultJsonProtocol, DeserializationException, JsArray, JsNumber, JsObject, JsString, JsValue, RootJsonFormat}

object JsonSupport extends SprayJsonSupport with DefaultJsonProtocol
{
	//implicit val ubjs = jsonFormat2(UserBalance.apply)
	
	implicit object userBalanceJsonSupport extends RootJsonFormat[UserBalance]{
		
		def write(b: UserBalance) = JsObject(
			"email" -> JsString(b.email),
			"balance" -> JsString(b.balance.toString)
		)
		
		def read(value: JsValue) = {
			value.asJsObject.getFields("email", "balance") match {
				case Seq(JsString(email), JsString(balance)) =>
					new UserBalance(email, balance.toInt)
					
				case _ => throw new DeserializationException("User_Balance expected")
			}
		}
	}
	
	implicit object userTransactionJsonSupport extends RootJsonFormat[UserTransaction]{
		//		def write(b: UserTransaction) =
		//			JsArray(JsString(b.sender), JsString(b.recipient), JsNumber(b.amount))
		//
		//		def read(value: JsValue) = value match {
		//			case JsArray(Vector(JsString(sender), JsString(recipient), JsNumber(amount))) =>
		//				new UserTransaction(sender, recipient, amount.toInt)
		//			case _ => throw new DeserializationException("Color expected")
		//		}
		//
		def write(c: UserTransaction) = JsObject(
			"sender" -> JsString(c.sender),
			"sender_code" -> JsString(c.sender_code.toString),
			"recipient" -> JsString(c.recipient),
			"recipient_code" -> JsString(c.sender_code.toString),
			"amount" -> JsString(c.amount.toString),
			"date" -> JsString(c.date.toString),
			"status" -> JsString(c.status.toString)
		)
		def read(value: JsValue) = {
			value.asJsObject.getFields("sender", "sender_code", "recipient", "recipient_code", "amount", "date") match {
				case Seq(JsString(sender), JsString(sender_code), JsString(recipient), JsString(recipient_code), JsString(amount), JsString(date)) =>
					new UserTransaction(sender, sender_code.toInt, recipient, recipient_code.toInt, amount.toInt, DateFormat.getTimestamp(date))
				case _ => throw new DeserializationException("userLogin transaction expected")
			}
		}
	}
	
	implicit object userInfoJsonSupport extends RootJsonFormat[UserInfo]{
		
		def write(c: UserInfo) = JsObject(
			"email" -> JsString(c.email),
			"fullname" -> JsString(c.fullname),
			"displayname" -> JsString(c.displayname),
			"phonenumber" -> JsString(c.phonenumber),
			"date" -> JsString(c.registrationdate.toString),
			"code" -> JsString(c.code.toString)
		)
		
		def read(value: JsValue) = {
			value.asJsObject.getFields("email", "fullname", "displayname", "phonenumber", "date") match {
				case Seq(JsString(email), JsString(fullname), JsString(displayname), JsString(phonenumber), JsString(date)) =>
					new UserInfo(email, fullname, displayname, phonenumber, Timestamp.valueOf(date))
				
				case Seq(JsString(email), JsString(fullname), JsString(displayname), JsString(phonenumber)) =>
					new UserInfo(email, fullname, displayname, phonenumber, DateFormat.getCurrentTimestamp)
					
				case _ => throw new DeserializationException("UT expected")
			}
		}
	}
	
	implicit object userLoginJsonSupport extends RootJsonFormat[UserLogin]{
		
		def write(c: UserLogin) = JsObject(
			"email" -> JsString(c.email),
			"password" -> JsString(c.password)
		)
		
		def read(value: JsValue) = {
			value.asJsObject.getFields("email", "password") match {
				case Seq(JsString(email), JsString(password)) =>
					new UserLogin(email, password)
				case _ => throw new DeserializationException("UserLogin expected")
			}
		}
	}
	
	implicit object AnyJsonFormat extends RootJsonFormat[Any] {
		def write(x: Any) = x match {
			case _ => JsString(x.toString)
		}
		
		def read(value: JsValue) = value match {
			case JsString(s) => s
		}
	}
	
	implicit object jsonResponseJsonSupport extends RootJsonFormat[JsonResponse]{
		
		def write(c: JsonResponse) = JsObject(
			"status" -> JsString(c.status.toString),
			"message" -> JsString(c.message)
		)
		
		def read(value: JsValue) = {
			value.asJsObject.getFields("status", "message") match {
				case Seq(JsString(status), JsString(message)) =>
					new JsonResponse(status.toInt, message)
				case _ => throw new DeserializationException("JsonResponse expected")
			}
		}
	}
	
}

//object JsonSupport2 extends DefaultJsonProtocol with SprayJsonSupport
//{
//	implicit val ubjs = jsonFormat2(UserBalance.apply)
//	implicit val ubjs1 = jsonFormat4(UserTransaction.apply)
//}