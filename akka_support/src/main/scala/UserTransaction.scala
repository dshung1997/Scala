import java.sql.Timestamp

import UserInfoTableDef.{userInfos}
import slick.backend.DatabaseConfig
//import slick.driver.H2Driver.api._     -> this is the radical misconception
import scala.concurrent.duration.Duration

import slick.driver.JdbcProfile
import scala.concurrent._
import slick.driver.MySQLDriver.api._

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by dshung on 29/07/2017.
  */
//case class UserTransaction(sender: String, recipient: String, amount: Int)

case class UserTransaction(sender: String, sender_code: Int, recipient: String, recipient_code: Int, amount: Int, date: Timestamp = DateFormat.defaultTimestamp, status: Int = -1, id: Int = 0)

class UserTransactionModelDB(tag: Tag) extends Table[UserTransaction](tag, "user_transaction")
{
	def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
	def sender = column[String]("sender")
	def sender_code = column[Int]("sender_code")
	def recipient = column[String]("recipient")
	def recipient_code = column[Int]("recipient_code")
	def amount = column[Int]("amount")
	def date = column[Timestamp]("date")
	def status = column[Int]("status")
	
	override def * =
	
		(sender, sender_code, recipient, recipient_code, amount, date, status, id) <> (UserTransaction.tupled, UserTransaction.unapply)

}

object UserTransactionTableDef extends PersistentModuleDB
{
	
	val userTransactions = TableQuery[UserTransactionModelDB]
	
	def add(sender: String, sender_code: Int, recipient: String, recipient_code: Int, amount: Int, date: Timestamp, status: Int): Future[Boolean] =
	{
//		println("di vao day...")
		val temp = UserTransaction(sender, sender_code, recipient, recipient_code, amount, date, status)
		db.run(userTransactions += temp).map(_ => true).recover{case _:Exception => false}
	}
	
	def add(tran: UserTransaction): Future[Boolean] =
	{
		db.run(userTransactions += tran).map(_ => true).recover{case _:Exception => false}
	}
	
	def getAll : Future[Seq[UserTransaction]] =
	{
		db.run(userTransactions.result)
	}
	
	
	def getTransactions(sender: String): Future[Option[Seq[UserTransaction]]] =
	{
		val exe = db.run(userTransactions.filter(x => x.sender === sender).result)
		
		exe.map {
			case result => if(result.isEmpty) None else Some(result.seq)
		}
	}
	
	def getReceivingTransactions(rec: String): Future[Option[Seq[UserTransaction]]] =
	{
		val exe = db.run(userTransactions.filter(x => x.recipient === rec).result)
		
		exe.map {
			case result => if(result.isEmpty) None else Some(result.seq)
		}
	}
	
	def getSendingTransactions(sender: String): Future[Option[Seq[UserTransaction]]] =
	{
		val exe = db.run(userTransactions.filter(x => x.sender === sender).result)
		
		exe.map {
			case result => if(result.isEmpty) None else Some(result.seq)
		}
	}
	
	
	def checkTransaction(tran: UserTransaction): Future[Tuple2[Int, String]] =
	{
		val exe = for {
			checkSender <- db.run(userInfos.filter(x => x.email === tran.sender && x.code === tran.sender_code).result.headOption)
			checkRecipient <- db.run(userInfos.filter(x => x.email === tran.recipient && x.code === tran.recipient_code).result.headOption)
		} yield (checkSender, checkRecipient)
		
		exe.map {
			case (checkSender, checkRecipient) =>
				if(! (checkSender.isEmpty && checkRecipient.isEmpty) )
				{
					Tuple2[Int, String](1, "OK")
				}
				else
				{
					if(checkSender.isEmpty) Tuple2[Int, String](0, "Invalid sender_code")
					else Tuple2[Int, String](0, "Unsuccessful transaction")
				}
		}
	}
	
	def checkTransaction(sender: String, sender_code: Int, recipient: String, recipient_code: Int): Future[Tuple2[Int, String]] =
	{
		val exe = for {
			checkSender <- db.run(userInfos.filter(x => x.email === sender && x.code === sender_code).result.headOption)
			checkRecipient <- db.run(userInfos.filter(x => x.email === recipient && x.code === recipient_code).result.headOption)
		} yield (checkSender, checkRecipient)
		
//		exe.map {
//			case (checkSender, checkRecipient) =>
//				if(! (checkSender.isEmpty && checkRecipient.isEmpty) )
//				{
//					println("1   : " + checkSender.head.toString + " " + checkRecipient.head.toString)
//					Tuple2[Int, String](1, "OK")
//				}
//				else
//				{
//					if(checkSender.isEmpty)
//					{
//						println("2   : " + "Empty" + " " + checkRecipient.head.toString)
//						Tuple2[Int, String](2, "Invalid sender_code")
//					}
//					else
//					{
//						println("3   : " + checkSender.head.toString + " " + "Empty")
//						Tuple2[Int, String](3, "Unsuccessful transaction")
//					}
//				}
//		}.recover { case e:Exception => Tuple2[Int, String](4, e.getMessage)}
		
		exe.map {
			case (Some(checkSender), Some(checkRecipient)) =>
				println("1   : " + checkSender.toString + " " + checkRecipient.toString)
				Tuple2[Int, String](1, "OK")
				
			case (None, Some(checkRecipient)) =>
				println("2   : " + "Empty" + " " + checkRecipient.toString)
				Tuple2[Int, String](2, "Invalid sender_code")
				
			case (Some(checkSender), None) =>
				println("3   : " + checkSender.toString + " " + "Empty")
				Tuple2[Int, String](3, "Unsuccessful transaction")
					
			case (None, None) =>
				println("4   : " + "Empty" + " " + "Empty")
				Tuple2[Int, String](3, "Unsuccessful transaction")
				
		}.recover { case e:Exception => Tuple2[Int, String](5, e.getMessage)}
	}
	
}
