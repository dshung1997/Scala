package controllers

import javax.inject._

import models.{UserInfo, UserInfoTableDef, UserLogin}
import models.Forms.ValidationForm
import play.api.libs.json.{JsError, JsValue, Json}
import play.api.libs.ws.{WSClient, WSResponse}
import play.api.mvc._
import play.twirl.api.Html

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class Application @Inject() (ws: WSClient) extends Controller
{
	def index = Action.async
	{
		implicit request =>
			if(Secured.isLoggedIn(request))
			{
				Secured.getUserInfo(request).map{
					case user => Ok(views.html.index("Fintech", true, user))
				}
			}
			else Future(Ok(views.html.index("Fintech", false, null)))
	}
	
	def login = Action
	{
		implicit request =>
			println("login...")
			if(Secured.isLoggedIn(request))
				Redirect(routes.Application.index())
			else
			{
				val login: Html = views.html.login()
				Ok(views.html.main("Login", false, null)(login)).withNewSession
			}
	}
	
//	def postLogin = Action {
//		implicit request =>
//			println(request.body)
//			Ok("ok login..")
//	}
	
	def postLogin = Action.async(parse.json) {
		implicit request =>
			println(request.body)
			request.body.validate[UserLogin].map{
				case user =>
				{
					println("Login pending : " + user)
					val futureResponse: Future[WSResponse] = ws.url("http://172.17.0.2:8000/login").post(Json.toJson(user))
					futureResponse.map {
						case response =>
							if(response.status == 200)
							{
								printf("Login success ...")
								Ok("1...").withSession("email" -> user.email)
							}
							else
							{
								printf("Login fail ...")
								BadRequest("2...")
							}
					}
				}
			}.recoverTotal{
				e =>
					println("Fail login : " + e.errors)
					//BadRequest()
					Future(BadRequest(Json.obj("message" -> JsError.toFlatJson(e))))
			}
	}
	
	def logout = Action {
		implicit request =>
		Redirect(routes.Application.index()).withNewSession.flashing("success" -> "You've been logged out !")
	}
	
	def profile = Action.async
	{
		implicit request =>
			if(!Secured.isLoggedIn(request))
				Future(Redirect(routes.Application.login()))
				
			else
			{
				println("http://localhost:8000/profile/" + Secured.getUserFromRequest(request))
				val futureResponse: Future[WSResponse] = ws.url("http://172.17.0.3:8000/profile/get/" + Secured.getUserFromRequest(request)).get()
				futureResponse.map {
					case response =>
					{
						val userJson: JsValue = Json.parse(response.body)
						
						val user = userJson.validate[UserInfo].asOpt.head
						val profile1: Html = views.html.profile1(userJson)
						Ok(views.html.main("Profile", true, user)(profile1))
						
//						response.body match {
//							case JsValue =>
//							{
//								val user = resJson.validate[UserInfo].asOpt.head
//								val profile1: Html = views.html.profile1(response)
//								Ok(views.html.main("Profile", true, user)(profile1))
//							}
//							case _ => BadRequest("Sai profile")
//						}
					}
				}
			}
	}
	
	def register = Action
	{
		implicit request =>
			if(!Secured.isLoggedIn(request))
			{
				val register: Html = views.html.register()
				Ok(views.html.main("Register", false, null)(register)).withNewSession
			}
			else
				Redirect(routes.Application.index())
	}
	
	def postRegister = Action.async(parse.json) {
		implicit request =>
			println(request.body)
			request.body.validate[UserInfo].map {
				case user =>
					println(user)
					
					val futureResponse: Future[WSResponse] = ws.url("http://172.17.0.3:8000/register").post(request.body)
					futureResponse.map {
						case response =>
							if(response.status == 200) Ok("3...").withSession("email" -> user.email)
							else BadRequest(response.body)
					}
					//Ok(Json.obj("status" -> "200")).withSession("email" -> user.email)
			}.recoverTotal{
				e =>
					println("Fail : " + e.errors)
					Future(BadRequest(Json.obj("message" -> JsError.toFlatJson(e))))
			}
	}
	
	def getUserInfo = Action
	{
		implicit request =>
			Ok(Json.toJson(Secured.getUserInfo(request).toString))
	}
	
	
}
