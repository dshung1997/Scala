

import akka.http.scaladsl.server.{Directives, Route}
import akka.http.scaladsl.model.StatusCodes
//import akka.http.scaladsl.model.StatusCodes.Success
//import spray.http.StatusCodes.Success
import spray.json._
import spray.json.DefaultJsonProtocol._
import spray.httpx.marshalling._
import akka.http.scaladsl.marshallers

import scala.concurrent.ExecutionContext.Implicits.global

class Routes extends Directives {

  import JsonSupport._


  val getBalance = pathPrefix("balance") {
    path("get" / Segment) {
      case seg: String =>
        get {
          val exe = UserBalanceTableDef.get(seg)
          onSuccess(exe) {
            case null => complete(StatusCodes.BadRequest, "Get balance fails with no ")
            case result: UserBalance => complete(StatusCodes.OK, result)
          }
        }
    }
  }


  val getTransactionHistory = pathPrefix("history") {
    path("get" / Segment) {
      case seg: String =>
        get {
          val exe = UserTransactionTableDef.getTransactions(seg)
          onSuccess(exe) {
            case None => complete(StatusCodes.BadRequest, "Get history fails with no ")
            case Some(seqHistory) => complete(StatusCodes.OK, seqHistory)
          }
        }
    }
  }

  val login = path("login") {
    post {
      entity(as[UserLogin]) {
        user =>
          println(user)
          val exe = UserService.checkPassword(user)
          onSuccess(exe) {
            case result =>
              if (result.status == 1) complete(StatusCodes.OK, "Login OK !")
              else complete(StatusCodes.BadRequest, result.toJson)
          }

          completeOrRecoverWith(exe) { ex =>
            failWith(ex) // not executed.
          }
//          onComplete(exe)
//          {
//            case Success(result) =>
//              {
//                if (result.status == 1) complete(StatusCodes.OK, "Login OK !")
//                else complete(StatusCodes.BadRequest, result.toJson)
//              }
//            case Failure(ex) => complete(StatusCodes.BadRequest, ex.getMessage)
//          }
      }
    }
  }

  val transfer = path("transfer") {
    post {
      entity(as[UserTransaction]) {
        trans =>
          println(trans)
          val exe = UserService.transfer(trans.sender, trans.sender_code, trans.recipient, trans.recipient_code, trans.amount, trans.date)
          //val m = UserTransactionTableDef.insert(trans.sender, trans.recipient, trans.amount)
          onSuccess(exe) {
            case result: JsonResponse =>
              if (result.status == 1)
                complete(StatusCodes.OK, "OK !! : " + trans.sender + " -> " + trans.recipient + " -> " + trans.amount)
              else complete(StatusCodes.BadGateway, result.toJson)
          }
      }
    }
  }

  //import JsonSupport.userTransactionJsonSupport
  val getAllBalance = path("getallb") {
    get {
      val o = UserBalanceTableDef.getAll
      onSuccess(o) {
        userBalances => complete(StatusCodes.OK, userBalances.toJson)
      }
    }
  }

  val getAllTransaction = path("getallt") {
    get {
      val o = UserTransactionTableDef.getAll
      onSuccess(o) {
        case userTransactions: Seq[UserTransaction] => complete(StatusCodes.OK, userTransactions.toJson)
      }
    }
  }

  val register = path("register") {
    post {
      (entity(as[UserInfo]) & entity(as[UserLogin])) {
        (userInfo: UserInfo, userLogin: UserLogin) =>
          println(userInfo + "." + userLogin)

          val exe = for {
            infoResult <- UserInfoTableDef.insert(userInfo)
            loginResult <- UserLoginTableDef.insert(userLogin, userInfo)
            balanceResult <- UserBalanceTableDef.insert(userInfo.email)
          } yield (infoResult && loginResult && balanceResult)

          onSuccess(exe) {
            case true => complete(StatusCodes.OK, userInfo.toJson)
            case _ => complete(StatusCodes.BadRequest, "Fail...")
          }
        //						.recover{
        //						case e: Exception => complete(StatusCodes.BadRequest, "..."+e.)
        //					}
      }
      //			entity(as[UserInfo]) {
      //				userInfo =>
      //					println(userInfo)
      //
      //					val exe = UserInfoTableDef.insert(userInfo)
      //
      //					onSuccess(exe)
      //					{
      //						case true => complete(StatusCodes.OK, userInfo.toJson)
      //						case _ => complete(StatusCodes.BadRequest, "Loi deoo gi ko biet")
      //					}
      //			}
    }
  }


  //	val profile = path("profile") {
  //		get {
  //			val exe = UserService.getProfile("1@hung.com")
  //			onSuccess(exe) {
  //				case result: JsValue => complete(StatusCodes.OK, result)
  //			}
  //		}
  //	}

  val profile = path("profile" / Segment) {
    case email: String =>
      get {
        val exe = UserService.getProfile(email)
        onSuccess(exe) {
          case result: JsValue => complete(StatusCodes.OK, result)
        }
        //
        //				onFailure(exe)
        //				{
        //					case e: Exception => complete(StatusCodes.InternalServerError, e.getMessage)
        //				}

        //				onComplete(exe)
        //				{
        //					case Success(result: JsValue) => complete(StatusCodes.OK, result)
        //						case Failure(e: Exception) => complete(StatusCodes.InternalServerError, e.getMessage)
        //				}
        //
        //				completeOrRecoverWith(exe)
        //				{
        //					case Success(result: JsValue) => complete(StatusCodes.OK, result)
        //					case Failure(e: Exception) => complete(StatusCodes.InternalServerError, e.getMessage)
        //				}

      }
  }

  val transaction = path("transaction" / Segment) {
    case email: String =>
      get {
        println("tran...")
        val exe = UserTransactionTableDef.getTransactions(email)
        onSuccess(exe) {
          case result: Some[Seq[UserTransaction]] => complete(StatusCodes.OK, result.head.toJson)
          case x => complete(StatusCodes.BadRequest, "None  --- Transaction")
        }
      }
  }

  val transaction1 = pathPrefix("transaction1") {
    path("sending" / Segment) {
      case email: String =>
        get {
          println("sending tran...")
          val exe = UserTransactionTableDef.getSendingTransactions(email)
          onSuccess(exe) {
            case result: Some[Seq[UserTransaction]] => complete(StatusCodes.OK, result.head.toJson)
            case x => complete(StatusCodes.BadRequest, "None  --- S Transaction")
          }
        }
    } ~
      path("receiving" / Segment) {
        case email: String =>
          get {
            println("receiving tran...")
            val exe = UserTransactionTableDef.getReceivingTransactions(email)
            onSuccess(exe) {
              case result: Some[Seq[UserTransaction]] => complete(StatusCodes.OK, result.head.toJson)
              case x => complete(StatusCodes.BadRequest, "None  --- R Transaction")
            }
          }
      }
  }

  val check = path("check") {
    get {
      complete(StatusCodes.OK, "Good connection !")
    }
  }


  val routes: Route = getBalance ~ getTransactionHistory ~ login ~ check
} 

