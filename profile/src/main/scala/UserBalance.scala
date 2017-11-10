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
case class UserBalance(email: String, balance: Int, id: Int = 0)

class UserBalanceModelDB(tag: Tag) extends Table[UserBalance](tag, "user_balance")
{
	def id = column[Int]("id", O.PrimaryKey)
	def email = column[String]("email")
	
	def balance = column[Int]("balance")
	
	override def * =
		(email, balance, id) <> (UserBalance.tupled, UserBalance.unapply)
}

object UserBalanceTableDef extends PersistentModuleDB
{
	val userBalances = TableQuery[UserBalanceModelDB]
	
	//Insert amount new row to DB with amount certain balance > 0
	def insert(email: String, balance: Int = 0): Future[Boolean] =
	{
		db.run(userBalances += UserBalance(email, balance)).map(_ => true).recover {
			case e: Exception =>
			{
				printf("Balance : "+e.getMessage)
				false
			}
		}
	}
	
	//Insert amount new row to DB with amount certain balance > 0
	def insert(user: UserBalance): Future[Boolean] =
	{
		db.run(userBalances += user).map(_ => true).recover {case _: Exception => false}
	}
	
	//Add "amount" of balance to "email" userLogin's balance
	def update(email: String, amount: Int): Future[Boolean] =
	{
		def action(user: UserBalance): Future[Boolean] =
		{
			if(user != null)
			{
				if(user.balance + amount < 0) Future(false)
				else
				{
					val exe = db.run(userBalances.insertOrUpdate(UserBalance(email, user.balance + amount)))
					exe.map (_ => true).recover{ case _:Exception => false }
				}
			}
			else
			{
				val exe = db.run(userBalances.insertOrUpdate(UserBalance(email, 0)))
				exe.map (_ => true).recover{ case _: Exception => false }
			}
		}
		
		get(email).flatMap{
			
			res => action(res).map(x => x).recover{case _:Exception => false}
			
		}.recover{case _:Exception => false}
	}
	
	
	//Get the balance of a userLogin
	def get(e: String): Future[UserBalance] =
	{
		val exe = db.run(userBalances.filter(_.email === e).result.headOption)
		
		exe.map
		{
			case result => if(result.isEmpty) null else result.head
		}
	}
	
	//Get all information of users' balance
	def getAll: Future[Seq[UserBalance]] =
	{
		db.run(userBalances.result)
	}
}



