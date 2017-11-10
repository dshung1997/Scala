package models

import play.api.Play
import slick.driver.JdbcProfile
import slick.driver.MySQLDriver.api._

import scala.concurrent.ExecutionContext.Implicits.global
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.json._

import scala.concurrent._
import scala.concurrent.duration.Duration
import play.api.libs.functional.syntax._

/**
  * Created by dshung on 29/07/2017.
  */
case class UserBalance(email: String, balance: Int, id: Int = 0)

object UserBalance {
	
	implicit val read: Reads[UserBalance] = new Reads[UserBalance] {
		def reads(json: JsValue): JsResult[UserBalance] = {
			for {
				email <- (json \ "email").validate[String]
				balance <- (json \ "balance").validate[String]
				id <- (json \ "id").validate[String]
			} yield UserBalance(email, balance.toInt, id.toInt)
		}
	}
	
	implicit val write = new Writes[UserBalance] {
		def writes(user: UserBalance) = Json.obj(
			"email" -> user.email.toString,
			"balance" -> user.balance.toString,
			"id" -> user.id.toString
		)
	}
}

//class UserBalanceModelDB(tag: Tag) extends Table[UserBalance](tag, "user_balance")
//{
//
//	def email = column[String]("email", O.PrimaryKey)
//
//	def id = column[Int]("id")
//
//	override def * =
//		(email, id) <> (UserBalance.tupled, UserBalance.unapply)
//}

//object UserBudgetTableDef extends PersistentDatabaseModule
//{
//	val userBalances = TableQuery[UserBalanceModelDB]
//
//	def add(u: String): Boolean =
//	{
//		val ub = UserBalance(u, 0)
//		val m = dbConfig.db.run(userBalances += ub).map(res => "UserLogin successfully added").recover
//		{
//			case ex: Exception => ex.getCause.getMessage
//		}
//
//		val n = Await.result(m, Duration(10, "seconds"))
//		if (n == "UserLogin successfully added") true
//		else false
//	}
//
//	def transfer(s: String, r: String, m: Int): Boolean =
//	{
//		var ps = get(s)
//		var pr = get(r)
//
//		if(ps == null)
//		{
//			Await.result(dbConfig.db.run(userBalances.insertOrUpdate(UserBalance(s, 0))), Duration(10, "seconds"))
//			ps = get(s)
//		}
//
//		if(pr == null)
//		{
//			Await.result(dbConfig.db.run(userBalances.insertOrUpdate(UserBalance(r, 0))), Duration(10, "seconds"))
//			pr = get(r)
//		}
//
//		if(ps.id - m < 0) false
//		else
//		{
//			Await.result(dbConfig.db.run(userBalances.insertOrUpdate(UserBalance(s, ps.id - m))), Duration(10, "seconds"))
//			Await.result(dbConfig.db.run(userBalances.insertOrUpdate(UserBalance(r, pr.id + m))), Duration(10, "seconds"))
//
//			true
//		}
//	}
//
//	def update(e: String, a: Int): Boolean =
//	{
//		val m = get(e)
//
//		if(m != null)
//			{
//				val y = UserBalance(e, m.id + a)
//				val z = Await.result(dbConfig.db.run(userBalances.insertOrUpdate(y)), Duration(10, "seconds"))
//
//				true
//			}
//		else
//			{
//				val y = UserBalance(e, 0)
//				val z = Await.result(dbConfig.db.run(userBalances.insertOrUpdate(y)), Duration(10, "seconds"))
//
//				true
//			}
//	}
//
////	def delete(e: String): Boolean =
////	{
////		val m = dbConfig.db.run(userBalances.filter(_.email === e).delete)
////
////	}
//
//	def get(e: String): UserBalance =
//	{
//		val m = dbConfig.db.run(userBalances.filter(_.email === e).result.headOption)
//
//		val x = Await.result(m, Duration(10, "seconds"))
//
//		if(x.isEmpty) null
//		else x.head
//
//	}
//
//	def getUserBudgets: Future[Seq[UserBalance]] =
//	{
//		dbConfig.db.run(userBalances.result)
//	}
//}



