
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/Workspace/play-scala-4/conf/routes
// @DATE:Fri Oct 20 08:13:02 UTC 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Application_2: controllers.Application,
  // @LINE:18
  Service_0: controllers.Service,
  // @LINE:23
  Test_3: controllers.Test,
  // @LINE:30
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_2: controllers.Application,
    // @LINE:18
    Service_0: controllers.Service,
    // @LINE:23
    Test_3: controllers.Test,
    // @LINE:30
    Assets_1: controllers.Assets
  ) = this(errorHandler, Application_2, Service_0, Test_3, Assets_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_2, Service_0, Test_3, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.Application.login()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.Application.postLogin()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """register""", """controllers.Application.register()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """register""", """controllers.Application.postRegister()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """profile""", """controllers.Application.profile()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.Application.logout()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """transfer""", """controllers.Service.transfer()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """transfer""", """controllers.Service.postTransfer()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getuser""", """controllers.Application.getUserInfo()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """test""", """controllers.Test.test()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """javascriptRoutes""", """controllers.Test.javascriptRoutes()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """transaction/""", """controllers.Service.getTransactions()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    Application_2.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_Application_login1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_Application_login1_invoker = createInvoker(
    Application_2.login(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "login",
      Nil,
      "GET",
      """""",
      this.prefix + """login"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_Application_postLogin2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_Application_postLogin2_invoker = createInvoker(
    Application_2.postLogin(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "postLogin",
      Nil,
      "POST",
      """""",
      this.prefix + """login"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Application_register3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("register")))
  )
  private[this] lazy val controllers_Application_register3_invoker = createInvoker(
    Application_2.register(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "register",
      Nil,
      "GET",
      """""",
      this.prefix + """register"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Application_postRegister4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("register")))
  )
  private[this] lazy val controllers_Application_postRegister4_invoker = createInvoker(
    Application_2.postRegister(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "postRegister",
      Nil,
      "POST",
      """""",
      this.prefix + """register"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Application_profile5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("profile")))
  )
  private[this] lazy val controllers_Application_profile5_invoker = createInvoker(
    Application_2.profile(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "profile",
      Nil,
      "GET",
      """""",
      this.prefix + """profile"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Application_logout6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_Application_logout6_invoker = createInvoker(
    Application_2.logout(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "logout",
      Nil,
      "GET",
      """""",
      this.prefix + """logout"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Service_transfer7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("transfer")))
  )
  private[this] lazy val controllers_Service_transfer7_invoker = createInvoker(
    Service_0.transfer(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Service",
      "transfer",
      Nil,
      "GET",
      """""",
      this.prefix + """transfer"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_Service_postTransfer8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("transfer")))
  )
  private[this] lazy val controllers_Service_postTransfer8_invoker = createInvoker(
    Service_0.postTransfer(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Service",
      "postTransfer",
      Nil,
      "POST",
      """""",
      this.prefix + """transfer"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_Application_getUserInfo9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getuser")))
  )
  private[this] lazy val controllers_Application_getUserInfo9_invoker = createInvoker(
    Application_2.getUserInfo(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getUserInfo",
      Nil,
      "GET",
      """""",
      this.prefix + """getuser"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_Test_test10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("test")))
  )
  private[this] lazy val controllers_Test_test10_invoker = createInvoker(
    Test_3.test(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Test",
      "test",
      Nil,
      "GET",
      """""",
      this.prefix + """test"""
    )
  )

  // @LINE:25
  private[this] lazy val controllers_Test_javascriptRoutes11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("javascriptRoutes")))
  )
  private[this] lazy val controllers_Test_javascriptRoutes11_invoker = createInvoker(
    Test_3.javascriptRoutes(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Test",
      "javascriptRoutes",
      Nil,
      "GET",
      """""",
      this.prefix + """javascriptRoutes"""
    )
  )

  // @LINE:27
  private[this] lazy val controllers_Service_getTransactions12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("transaction/")))
  )
  private[this] lazy val controllers_Service_getTransactions12_invoker = createInvoker(
    Service_0.getTransactions(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Service",
      "getTransactions",
      Nil,
      "GET",
      """""",
      this.prefix + """transaction/"""
    )
  )

  // @LINE:30
  private[this] lazy val controllers_Assets_versioned13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned13_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_2.index())
      }
  
    // @LINE:7
    case controllers_Application_login1_route(params) =>
      call { 
        controllers_Application_login1_invoker.call(Application_2.login())
      }
  
    // @LINE:8
    case controllers_Application_postLogin2_route(params) =>
      call { 
        controllers_Application_postLogin2_invoker.call(Application_2.postLogin())
      }
  
    // @LINE:10
    case controllers_Application_register3_route(params) =>
      call { 
        controllers_Application_register3_invoker.call(Application_2.register())
      }
  
    // @LINE:11
    case controllers_Application_postRegister4_route(params) =>
      call { 
        controllers_Application_postRegister4_invoker.call(Application_2.postRegister())
      }
  
    // @LINE:13
    case controllers_Application_profile5_route(params) =>
      call { 
        controllers_Application_profile5_invoker.call(Application_2.profile())
      }
  
    // @LINE:14
    case controllers_Application_logout6_route(params) =>
      call { 
        controllers_Application_logout6_invoker.call(Application_2.logout())
      }
  
    // @LINE:18
    case controllers_Service_transfer7_route(params) =>
      call { 
        controllers_Service_transfer7_invoker.call(Service_0.transfer())
      }
  
    // @LINE:19
    case controllers_Service_postTransfer8_route(params) =>
      call { 
        controllers_Service_postTransfer8_invoker.call(Service_0.postTransfer())
      }
  
    // @LINE:21
    case controllers_Application_getUserInfo9_route(params) =>
      call { 
        controllers_Application_getUserInfo9_invoker.call(Application_2.getUserInfo())
      }
  
    // @LINE:23
    case controllers_Test_test10_route(params) =>
      call { 
        controllers_Test_test10_invoker.call(Test_3.test())
      }
  
    // @LINE:25
    case controllers_Test_javascriptRoutes11_route(params) =>
      call { 
        controllers_Test_javascriptRoutes11_invoker.call(Test_3.javascriptRoutes())
      }
  
    // @LINE:27
    case controllers_Service_getTransactions12_route(params) =>
      call { 
        controllers_Service_getTransactions12_invoker.call(Service_0.getTransactions())
      }
  
    // @LINE:30
    case controllers_Assets_versioned13_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned13_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
