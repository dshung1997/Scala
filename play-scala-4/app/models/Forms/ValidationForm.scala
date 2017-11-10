package models.Forms
//
//import models.{UserTransaction, UserLogin, UserRegister}
//import play.api.data.Forms.{mapping, text, number}
//import play.api.data.Form

/**
  * Created by dshung on 23/07/2017.
  */
object ValidationForm
{
	
//	lazy val UserLoginForm: Form[UserLogin] = Form(
//		mapping(
//			"email" -> text,
//			"password" -> text
//		) (UserLogin.apply)(UserLogin.unapply)
//	)
	
//	val UserRegisterForm: Form[UserRegister] = Form(
//		mapping(
//			"email" -> text,
//			"password" -> text,
//			"passwordConfirm" -> text,
//			"fullname" -> text,
//			"displayname" -> text,
//			"phonenumber" -> text
//		) (UserRegister.apply)(UserRegister.unapply) verifying("Failed form constraints!", user => validate(user))
//	)
//
//	def validate(user: UserRegister): Boolean =
//	{
//		println("validate : "+user.toString)
//		if(user.password != user.passwordConfirm) false
//		else true
//	}
//
//	val TransferMoneyForm: Form[UserTransaction] = Form(
//		mapping(
//			"sender" -> text,
//			"recipient" -> text,
//			"amount" -> number
//		)(UserTransaction.apply)(UserTransaction.unapply)
//	)
	
//	val UserLoginForm: Form[UserLogin] = Form(
//		mapping(
//			"email" -> text,
//			"password" -> text
//		) ((x1, x2) => UserInfo.apply(x1: String, x2: String))(x3 => UserInfo.unapply(x3: UserInfo))
//	)
	
	//	val UserLoginForm: Form[UserInfo] = Form(
	//		mapping(
	//			"username" -> text,
	//			"password" -> text
	//		) ((x1, x2) => UserInfo.apply(x1: String, x2: String))(x3 => UserInfo.unapply(x3: UserInfo))
	//	)
	
	//	lazy val UserForm = Form(
	//		tuple(
	//			"username" -> text,
	//			"password" -> text
	//		) verifying ("Invalid user or password", result => result match {
	//			case (user, password) if UserInfoDB.isValid(user, password) => true
	//			case _ => false
	//		})
	//	)
	
}
