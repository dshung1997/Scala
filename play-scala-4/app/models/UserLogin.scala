package models

import play.api.libs.json._

/**
  * Created by dshung on 23/07/2017.
  */
case class UserLogin(email: String, password: String)

object UserLogin
{
	implicit val readUser: Reads[UserLogin] = new Reads[UserLogin]
	{
		def reads(json: JsValue): JsResult[UserLogin] =
		{
			for
			{
				email <- (json \ "email").validate[String]
				password <- (json \ "password").validate[String]
				
			} yield UserLogin(email, password)
		}
	}
	
	implicit val writeUser = new Writes[UserLogin]
	{
		def writes(user: UserLogin) = Json.obj(
			"email" -> user.email,
			"password" -> user.password
		)
	}
}