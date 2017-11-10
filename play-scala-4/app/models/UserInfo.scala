package models

import java.sql.Timestamp

import play.api.Play
import slick.driver.JdbcProfile
import slick.driver.MySQLDriver.api._

import scala.concurrent.ExecutionContext.Implicits.global
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.json._

import scala.concurrent._
import scala.concurrent.duration.Duration

/**
  * Created by dshung on 13/07/2017.
  */

case class UserInfo(email: String, fullname: String, displayname: String, phonenumber: String, date: Timestamp = DateFormat.defaultTimestamp, code: Int = 0, id: Int = 0)

object UserInfo {
	
	implicit val writeUser = new Writes[UserInfo] {
		def writes(user: UserInfo) = Json.obj(
			"email" -> user.email.toString,
			"fullname" -> user.fullname.toString,
			"displayname" -> user.displayname.toString,
			"phonenumber" -> user.phonenumber.toString,
			"date" -> DateFormat.getCurrentTimestampString,
			"code" -> user.code.toString
		)
	}
	
	implicit val read: Reads[UserInfo] = new Reads[UserInfo] {
		def reads(json: JsValue): JsResult[UserInfo] = {
			for {
				email <- (json \ "email").validate[String]
				fullname <- (json \ "fullname").validate[String]
				displayname <- (json \ "displayname").validate[String]
				phonenumber <- (json \ "phonenumber").validate[String]
				code <- (json \ "code").validateOpt[String]
				date <- (json \ "date").validateOpt[String]
				
			} yield {
				if(date.isEmpty)
				{
					println("json 1 ...")
					UserInfo(email, fullname, displayname, phonenumber, DateFormat.getCurrentTimestamp)
				}
				else
				{
					println("json 2 ...")
					UserInfo(email, fullname, displayname, phonenumber, DateFormat.getTimestamp(date.head), code.head.toInt)
				}
			}
		}
	}
	
}

class UserInfoTableDef(tag: Tag) extends Table[UserInfo](tag, "user_info") {

	def id = column[Int]("id", O.AutoInc, O.PrimaryKey)
	def email = column[String]("email")
	def fullname = column[String]("fullname")
	def displayname = column[String]("displayname")
	def phonenumber = column[String]("phonenumber")
	def code = column[Int]("code")
	def date = column[Timestamp]("registrationdate")

	override def * =
		(email, fullname, displayname, phonenumber, date, code, id) <> ((UserInfo.apply _).tupled, UserInfo.unapply)
}

object UserInfoTableDef extends PersistentDatabaseModule
{

	val users = TableQuery[UserInfoTableDef]
	
	//Get the balance of a user
	def get(email: String): Future[UserInfo] =
	{
		val exe = db.run(users.filter(_.email === email).result.headOption)
		
		exe.map
		{
			case result => if(result.isEmpty) null else result.head
		}
	}
}


