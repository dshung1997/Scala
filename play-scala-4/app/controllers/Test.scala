package controllers
import javax.inject.{Inject, Singleton}

import play.api.mvc.{Action, Controller, Flash}
import models.Forms.ValidationForm
import models.{UserTransaction, UserInfo}
import play.api.libs.json.{JsError, Json}
import play.api.mvc._
import play.api._
import play.api.libs.json._
import play.api.libs.ws._
import play.api.routing.JavaScriptReverseRouter

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Created by dshung on 26/07/2017.
  */

@Singleton
class Test @Inject() (ws: WSClient) extends Controller
{
	def test = Action.async {
		val o = Json.obj(
			"email" -> "hung123",
			"password" -> "pw123"
		)
		val futureResponse: Future[WSResponse] = ws.url("http://172.17.0.3:8000/test1").post(o)
		futureResponse.map {
			case response => Ok(response.body)
		}
	}

	def javascriptRoutes = Action
	{
		implicit request =>
		Ok(
			JavaScriptReverseRouter("jsRoutes")(
				routes.javascript.Service.transfer,
				routes.javascript.Service.postTransfer,
				routes.javascript.Application.index,
				routes.javascript.Application.login,
				routes.javascript.Application.postLogin,
				routes.javascript.Application.register,
				routes.javascript.Application.postRegister
			)
		).as("text/javascript")
	}
	
	def sendRegisterForm(user: UserInfo) = Action.async {
		val obj = Json.toJson(user)
		
		val futureResponse: Future[WSResponse] = ws.url("http://172.17.0.3:8000/register").post(obj)
		futureResponse.map {
			case response => Ok(response.body)
		}
	}
}