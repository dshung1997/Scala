import java.sql.Timestamp

import slick.backend.DatabaseConfig

import scala.util.{Failure, Success}
//import slick.driver.H2Driver.api._     -> this is the radical misconception
import scala.concurrent.duration.Duration
import slick.driver.JdbcProfile

import scala.concurrent._

import slick.driver.MySQLDriver.api._
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by dshung on 29/07/2017.
  */
case class UserInfo(email: String, fullname: String, displayname: String, phonenumber: String, registrationdate: Timestamp = DateFormat.defaultTimestamp, code: Int = 0, id: Int = 0)

class UserInfoModelDB(tag: Tag) extends Table[UserInfo](tag, "user_info")
{
	def id = column[Int]("id", O.AutoInc, O.PrimaryKey)
	def email = column[String]("email")
	def fullName = column[String]("fullname")
	def displayName = column[String]("displayname")
	def phoneNumber = column[String]("phonenumber")
	def code = column[Int]("code")
	def registrationDate = column[Timestamp]("registrationdate")
	
	override def * =
		(email, fullName, displayName, phoneNumber, registrationDate, code , id) <> (UserInfo.tupled, UserInfo.unapply)
}

object UserInfoTableDef extends PersistentModuleDB
{
	val userInfos = TableQuery[UserInfoModelDB]
	
	//Insert new userLogin with some certain infomation
	def insert(email: String, fullname: String, displayname: String, phonenumber: String): Future[Boolean] =
	{
		db.run(userInfos += UserInfo(email, fullname, displayname, phonenumber)).map(_ => true).recover {case _: Exception => false}
	}
	
	//Insert new userLogin from an object
	def insert(user: UserInfo): Future[Boolean] =
	{
		db.run(userInfos += user).map(_ => true).recover {
			case e: Exception =>
			{
				printf("Info : "+e.getMessage)
				false
			}
		}
	}

	//Get a userLogin from an email
	def get(email: String): Future[UserInfo] =
	{
		val exe = db.run(userInfos.filter(_.email === email).result.headOption)
		
		exe.map
		{
			case Some(result) => result
			case None => null
		}
	}
	
	//Get all users
	def getAll: Future[Seq[UserInfo]] = db.run(userInfos.result)
}