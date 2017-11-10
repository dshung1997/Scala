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
	
	//Transfer "amount" balance from "sender" to "recipient"
//	def transfer(sender: String, recipient: String, amount: Int): Future[Boolean] =
//	{
//		
//		//Return true if there exists both users and the sender has enough balance to transfer
//		def check(sender : UserBalance, recipient: UserBalance, m: Int): Boolean =
//		{
//			if(sender == null || recipient == null)
//				false
//			else if(sender.balance - m < 0)
//				false
//			else
//				true
//		}
//		
//		//Execute transaction
//		def execute(sender: String, recipient: String, amount: Int): Future[Boolean] =
//		{
//			val updateStatus = for {
//				
//				senderUpdateOk <- update(sender, -amount)
//				recipientUpdateOk <- update(recipient, amount)
//				
//			} yield (senderUpdateOk, recipientUpdateOk)
//			
//			updateStatus.flatMap {
//				
//				result => if(result._1 && result._2)  //if both updates are OK
//				{
//					//println("1...")
//					UserTransactionTableDef.add(sender, recipient, amount, DateFormat.getCurrentTimestamp).map(_ => true).recover{case _:Exception => false}
//				}
//				else
//				{
//					Future(false)
//				}
//				
//			}.recover{ case _:Exception => false }
//		}
//		
//		val getTwoUsers = for {
//			senderResult <- get(sender)
//			recipientResult <- get(recipient)
//		} yield (senderResult, recipientResult)
//		
//		getTwoUsers.flatMap{
//			result =>
//				if(check(result._1, result._2, amount))
//				{
//					//update(sender, -amount).flatMap(_ => update(recipient, amount)).flatMap(_ => UserTransactionTableDef.insert(sender, recipient, amount)).map(_ => true).recover{case _:Exception => false}
//					execute(sender, recipient, amount)
//				}
//				else Future(false)
//		}.recover{case _:Exception => false}
//		
//	}
	
	//Add "amount" of balance to "email" userLogin's balance
//	def update(email: String, amount: Int): Future[Boolean] =
//	{
//		def action(userLogin: UserBalance): Future[Boolean] =
//		{
//			if(userLogin != null)
//			{
//				if(userLogin.balance + amount < 0) Future(false)
//				else
//				{
//					val exe = db.run(userInfos.insertOrUpdate(UserBalance(email, userLogin.balance + amount)))
//					exe.map (_ => true).recover{ case _:Exception => false }
//				}
//			}
//			else
//			{
//				val exe = db.run(userInfos.insertOrUpdate(UserBalance(email, 0)))
//				exe.map (_ => true).recover{ case _: Exception => false }
//			}
//		}
//
//		get(email).flatMap{
//
//			res => action(res).map(x => x).recover{case _:Exception => false}
//
//		}.recover{case _:Exception => false}
//	}
	
	
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