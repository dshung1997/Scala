import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.{Directives, Route}
import akka.stream.ActorMaterializer

import akka.actor.ActorSystem

import scala.io.StdIn
import spray.json._

object Boot extends Directives {
	
	val host = "172.17.0.2"
	val port = 8000
	
	def main(args: Array[String]): Unit = {
		
		implicit val system = ActorSystem("simple-rest-system")
		implicit val materializer = ActorMaterializer()
		implicit val executionContext = system.dispatcher
		
		//import JsonSupport._
		//Define the route
//		val route : Route = {
//			path("send") {
//				post {
//					entity(as[UserBalance]) {
//						order =>
//							val m = UserBalanceTableDef.update(order.email, order.balance)
//							onSuccess(m)
//							{
//								case true => complete(StatusCodes.OK, "OK : " + order.email + " " + order.balance)
//								case false => complete(StatusCodes.BadGateway)
//							}
//					}
//				}
//			} ~
//			path("transfer") {
//				post {
//					entity(as[UserTransaction]) {
//						trans =>
//							println(trans)
////							val amount = UserBalanceTableDef.transfer(trans.sender, trans.recipient, trans.amount)
//							val m = UserBalanceTableDef.transfer(trans.sender, trans.recipient, trans.amount)
//							//val m = UserTransactionTableDef.insert(trans.sender, trans.recipient, trans.amount)
//							onSuccess(m)
//							{
//								case true => complete(StatusCodes.OK, "OK !! : " + trans.sender + " -> " + trans.recipient + " -> " + trans.amount)
//								case false => complete(StatusCodes.BadGateway, "Not bad...")
//							}
////							complete(StatusCodes.OK, "OK...")
//					}
//				}
//			} ~
//			path("get") {
//				get {
//					val o = UserBalanceTableDef.getAll
//					onSuccess(o) {
//						userBalances => complete(StatusCodes.OK, userBalances.toJson)
//					}
//				}
//			} ~
//			path("history") {
//				get {
//					val o = UserTransactionTableDef.getAll
//					onSuccess(o) {
//						userTransactions => complete(StatusCodes.OK, userTransactions.toJson)
//					}
//				}
//			}
//
//		}
		
		//Startup, and listen for requests
		val bindingFuture = Http().bindAndHandle((new Routes).routes, host, port)
		println(s"Waiting for requests at http://$host:$port/...\nHit RETURN to terminate")
		StdIn.readLine()
		
		//Shutdown
		bindingFuture.flatMap(_.unbind())
		system.terminate()
	}
}
