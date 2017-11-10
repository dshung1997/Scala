package controllers

import models.{UserInfo, UserInfoTableDef}
import play.api.mvc._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by dshung on 13/07/2017.
  */
object Secured extends Controller
{
	def onUnauthorized(request: RequestHeader) = Action
	{
		Redirect(routes.Application.login())
	}
	
	def getUserFromRequest(request: RequestHeader): String =
	{
		val users = request.session.get("email")
		if(users.isEmpty) null
		else users.head
	}
	
	def isLoggedIn(request: RequestHeader): Boolean =
	{
		getUserFromRequest(request) != null
	}
	
	def getUserInfo(request: RequestHeader): Future[UserInfo] =
	{
			val email = getUserFromRequest(request)
			UserInfoTableDef.get(email).map {case user: UserInfo => user}
	}
}
