import java.sql.Timestamp

import UserBalanceTableDef.{get, update}
import UserLoginTableDef.{db, userLogins}
import akka.http.scaladsl.server.{Directives, Route}
import akka.http.scaladsl.model.StatusCodes
import spray.json._
import spray.json.DefaultJsonProtocol._
import spray.httpx.marshalling._

import scala.concurrent.ExecutionContext.Implicits.global
import spray.httpx.SprayJsonSupport._

import scala.concurrent.Future

/**
  * Created by dshung on 14/08/2017.
  */
object UserService {
  def getProfile(email: String): Future[JsValue] = {
    import JsonSupport._
    val exe = for {
      info <- UserInfoTableDef.get(email)
      balance <- UserBalanceTableDef.get(email)
    } yield (info, balance)

    exe.map {
      case (info, balance) => {
        val infoJson = info.toJson
        val balanceJson = balance.toJson

        val i = infoJson.convertTo[Map[String, String]]
        val b = balanceJson.convertTo[Map[String, String]]

        val combined = i ++ b
        combined.toJson
      }
    } //.recover{case e: Exception => Future(new JsValue{"error" -> e.getMessage})}
  }

  //Transfer "amount" balance from "sender" to "recipient"
  def transfer(sender: String, sender_code: Int, recipient: String, recipient_code: Int, amount: Int, date: Timestamp): Future[JsonResponse] = {

    //Return true if there exists both users and the sender has enough balance to transfer
    def checkBalance(sender: UserBalance, recipient: UserBalance, m: Int): Boolean = {
      if (sender.balance - m < 0)
        false
      else
        true
    }

    //Execute transaction
    def execute(sender: String, sender_code: Int, recipient: String, recipient_code: Int, amount: Int, date: Timestamp): Future[Boolean] = {
      val updateStatus = for {

        senderUpdateOk <- update(sender, -amount)
        recipientUpdateOk <- update(recipient, amount)

      } yield (senderUpdateOk, recipientUpdateOk)

      updateStatus.flatMap {

        result =>
          if (result._1 && result._2) //if both updates are OK
          {
            //println("1...")
            UserTransactionTableDef.add(sender, sender_code, recipient, recipient_code, amount, date, 1).map(_ => true).recover { case _: Exception => false }
          }
          else {
            Future(false)
          }

      }.recover { case _: Exception => false }
    }

    UserTransactionTableDef.checkTransaction(sender, sender_code, recipient, recipient_code).flatMap {
      case result =>
        if (result._1 == 1) {
          val getTwoUsers = for {
            senderResult <- get(sender)
            recipientResult <- get(recipient)
          } yield (senderResult, recipientResult)

          getTwoUsers.flatMap {
            res =>
              if (checkBalance(res._1, res._2, amount)) {
                //update(sender, -amount).flatMap(_ => update(recipient, amount)).flatMap(_ => UserTransactionTableDef.insert(sender, recipient, amount)).map(_ => true).recover{case _:Exception => false}
                execute(sender, sender_code, recipient, recipient_code, amount, date).map {
                  case true => JsonResponse(1, "Successfully !")
                  case false => JsonResponse(0, "Unexpected error !")
                }
              }
              else Future(JsonResponse(0, "Not enough money"))
          }.recover { case e: Exception => JsonResponse(0, e.getLocalizedMessage) }

        }
        else {
          UserTransactionTableDef.add(sender, sender_code, recipient, recipient_code, amount, date, 0).map(_ => JsonResponse(result._1, result._2)).recover { case e: Exception => JsonResponse(result._1, result._2 + e.getLocalizedMessage) }
          //					Future(JsonResponse(result._1, result._2))
        }
    }
  }

  def checkPassword(userLogin: UserLogin): Future[JsonResponse] = {
    UserInfoTableDef.get(userLogin.email).flatMap {
      case user =>

        val salt = Encryption.createSalt(user.registrationdate.toString)

        val encryptedPassword = Encryption.encryptPassword(userLogin.password, salt)

        UserLoginTableDef.get(userLogin.email).map {
          case userLoginDB =>
            if (userLoginDB.password == encryptedPassword) // && userLoginDB.salt == salt)
              JsonResponse(1, "Accepted")
//              if(userLoginDB.password == userLogin.password)
//                JsonResponse(1, "Accepted")
            else
              JsonResponse(0, "Rejected")
        }.recover { case e: Exception => JsonResponse(-1, e.getMessage) }
    }.recover { case e: Exception => JsonResponse(-2, e.getMessage) }
  }
}
