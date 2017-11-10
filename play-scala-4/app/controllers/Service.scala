package controllers

import javax.inject._

import play.api.mvc.{Action, Controller, Flash}
import models.Forms.ValidationForm
import models.UserTransaction
import play.api.libs.json.{JsError, Json}
import play.api.mvc._
import play.api._
import play.api.libs.json._
import play.api.libs.ws.{WSClient, WSResponse}
import play.twirl.api.Html

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Created by dshung on 26/07/2017.
  */

@Singleton
class Service @Inject() (ws: WSClient) extends Controller
{
	
	def transfer = Action.async
	{
		implicit request =>
			if(!Secured.isLoggedIn(request))
			{
				Future(Redirect(routes.Application.login()))
			}
			else
			{
				
				Secured.getUserInfo(request).map{
					case user =>
						{
							val u : JsValue = Json.toJson(user)
							
							val transfer: Html = views.html.transfer(user)
							Ok(views.html.main("Transfer", true, user)(transfer))
						}
				}
			}
	}
	
	def postTransfer = Action.async(parse.json)
	{
		implicit request =>
			println(request.body)
			request.body.validate[UserTransaction].map{
				case tran =>
				{
					println(tran)
					println(Json.toJson(tran))
					val futureResponse: Future[WSResponse] = ws.url("http://172.17.0.3:8000/transfer").post(Json.toJson(tran))
					futureResponse.map {
						case response =>
							if(response.status == 200) Ok("5...")
							else BadRequest(response.body)
					}
					//Ok(Json.obj("status" -> "200"))
				}
			}.recoverTotal{
				e =>
					println("Fail" + e.errors)
					Future(BadRequest(Json.obj("message" -> JsError.toFlatJson(e))))
			}
	}
	
	def getTransactions = Action.async
	{
		implicit request =>
			
			if(!Secured.isLoggedIn(request))
			{
				Future(Redirect(routes.Application.login()))
			}
			else
			{
				val email = Secured.getUserFromRequest(request)
				//def futureResponse: Future[WSResponse] = ws.url("http://localhost:8000/transaction/" + email).get()
				
				val exe = for {
					sendingTrans <- ws.url("http://172.17.0.3:8000/transaction1/sending/" + email).get()
					receivingTrans <- ws.url("http://172.17.0.3:8000/transaction1/receiving/" + email).get()
				} yield (sendingTrans, receivingTrans)
				
				exe.flatMap {
					case (sendingTrans, receivingTrans) =>
						{
							var sendTrans = Seq[UserTransaction]()
							if(sendingTrans.status == 200)
							{
								val sendingTransJson: JsValue = Json.parse(sendingTrans.body)
								sendTrans = sendingTransJson.validateOpt[Seq[UserTransaction]].get.head
							}
							
							var receiveTrans = Seq[UserTransaction]()
							if(receivingTrans.status == 200)
							{
								val receivingTransJson: JsValue = Json.parse(receivingTrans.body)
								receiveTrans = receivingTransJson.validateOpt[Seq[UserTransaction]].get.head
							}
							
							val transactionsHtml: Html = views.html.transactions(sendTrans, receiveTrans)
							
							Secured.getUserInfo(request).map {
								case result => Ok(views.html.main("Transactions", true, result)(transactionsHtml))
							}.recover{ case e: Exception => BadRequest(e.getMessage) }
						}
				}.recover{ case e: Exception => BadRequest(e.getMessage) }
			}
			
			//Ok(Json.obj("status" -> "200"))
	}
	
}
