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
case class UserLogin(email: String, password: String, salt: String = "hihi", hihi: String = "aloalo", id: Int = 0)

class UserLoginModelDB(tag: Tag) extends Table[UserLogin](tag, "user_login")
{
	def id = column[Int]("id", O.AutoInc, O.PrimaryKey)
	def email = column[String]("email")
	def password = column[String]("password")
	def salt = column[String]("salt")
	def hihi = column[String]("hihi")
	
	override def * =
		(email, password, salt, hihi, id) <> (UserLogin.tupled, UserLogin.unapply)
}

object UserLoginTableDef extends PersistentModuleDB
{
	val userLogins = TableQuery[UserLoginModelDB]
	
	//Get a userLogin from an email
	def check(email: String, password: String): Future[Boolean] =
	{
		val exe = db.run(userLogins.filter(x => x.email === email && x.password === password).result.headOption)
		
		exe.map
		{
			case result =>
			{
				println("Result : " + result.isEmpty)
				if(result.isEmpty) false else true
			}
		}
	}
	
	def insert(userLogin: UserLogin, userInfo: UserInfo): Future[Boolean] =
	{
		val salt = Encryption.createSalt(userInfo.registrationdate.toString)
		val encryptedPassword = Encryption.encryptPassword(userLogin.password, salt)
		
		val encryptedUser = UserLogin(userLogin.email, encryptedPassword, salt, userLogin.password)
		db.run(userLogins += encryptedUser).map(_ => true).recover {
			case e: Exception =>
			{
				printf("Login : "+e.getMessage)
				false
			}
		}
	}
	
	def get(email: String): Future[UserLogin] =
	{
		val exe = db.run(userLogins.filter(_.email === email).result.headOption)
		
		exe.map
		{
			case Some(result) => result
			case None => null
		}
	}
	
}