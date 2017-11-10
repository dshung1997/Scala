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

		
		//Startup, and listen for requests
		val bindingFuture = Http().bindAndHandle((new Routes).routes, host, port)
		println(s"Waiting for requests at http://$host:$port/...\nHit RETURN to terminate")
		StdIn.readLine()
		
		//Shutdown
		bindingFuture.flatMap(_.unbind())
		system.terminate()
	}
}
