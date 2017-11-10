
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,Boolean,models.UserInfo,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(page: String, isLoggedIn: Boolean, user: models.UserInfo)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.75*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>

<head>
    <title>"""),_display_(/*8.13*/page),format.raw/*8.17*/("""</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    
    <script src="http://code.jquery.com/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.2/html5shiv.js" type="text/javascript"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.2.0/respond.js" type="text/javascript"></script>

    <script type="text/javascript" src=""""),_display_(/*17.42*/routes/*17.48*/.Test.javascriptRoutes),format.raw/*17.70*/(""""></script>

    <!--  Load site-specific customizations after bootstrap. -->
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href=""""),_display_(/*21.51*/routes/*21.57*/.Assets.versioned("stylesheets/main.css")),format.raw/*21.98*/("""">
    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*22.55*/routes/*22.61*/.Assets.versioned("images/favicon.png")),format.raw/*22.100*/("""">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
          <script src="http://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.2/html5shiv.js"></script>
          <script src="http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.2.0/respond.js"></script>
        <![endif]-->
    <!-- Load Bootstrap JavaScript components. HTMLUnit (used in testing) requires JQuery 1.8.3 or below). -->
   
</head>

<body id="main-body">

    <!-- Responsive navbar -->
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <!--  Display three horizontal lines when navbar collapsed. -->
          <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
        </button>
                <a class="navbar-brand" href="/">Fintech</a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-left">
                    """),_display_(/*47.22*/if(isLoggedIn)/*47.36*/ {_display_(Seq[Any](format.raw/*47.38*/("""
                    """),format.raw/*48.21*/("""<li class=""""),_display_(/*48.33*/("active".when(page == "Profile"))),format.raw/*48.67*/(""""><a href=""""),_display_(/*48.79*/routes/*48.85*/.Application.profile()),format.raw/*48.107*/("""">Profile</a></li>
                    <li class=""""),_display_(/*49.33*/("active".when(page == "Transfer"))),format.raw/*49.68*/(""""><a href=""""),_display_(/*49.80*/routes/*49.86*/.Service.transfer()),format.raw/*49.105*/("""">Transaction</a></li>
                    """)))}),format.raw/*50.22*/("""
                """),format.raw/*51.17*/("""</ul>
                <ul class="nav navbar-nav navbar-right">
                    """),_display_(/*53.22*/if(isLoggedIn)/*53.36*/ {_display_(Seq[Any](format.raw/*53.38*/("""
                    """),format.raw/*54.21*/("""<li><a href=""""),_display_(/*54.35*/routes/*54.41*/.Application.profile()),format.raw/*54.63*/("""">"""),_display_(/*54.66*/user/*54.70*/.displayname),format.raw/*54.82*/("""</a></li>
                    <li><a href=""""),_display_(/*55.35*/routes/*55.41*/.Application.logout()),format.raw/*55.62*/("""">Logout</a></li>
                    """)))}/*56.23*/else/*56.28*/{_display_(Seq[Any](format.raw/*56.29*/("""
                    """),format.raw/*57.21*/("""<li><a href=""""),_display_(/*57.35*/routes/*57.41*/.Application.login()),format.raw/*57.61*/("""">Login</a></li>
                    <li><a href=""""),_display_(/*58.35*/routes/*58.41*/.Application.register()),format.raw/*58.64*/("""">Register</a></li>
                    """)))}),format.raw/*59.22*/("""


                """),format.raw/*62.17*/("""</ul>
            </div>
        </div>
    </div>

    """),_display_(/*67.6*/content),format.raw/*67.13*/("""

"""),format.raw/*69.1*/("""</body>

</html>"""))
      }
    }
  }

  def render(page:String,isLoggedIn:Boolean,user:models.UserInfo,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(page,isLoggedIn,user)(content)

  def f:((String,Boolean,models.UserInfo) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (page,isLoggedIn,user) => (content) => apply(page,isLoggedIn,user)(content)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Fri Oct 20 08:13:02 UTC 2017
                  SOURCE: /home/Workspace/play-scala-4/app/views/main.scala.html
                  HASH: 81dbc0b0ad57c147e48a965134e94650595c4dd2
                  MATRIX: 554->1|722->74|750->76|820->120|844->124|1450->703|1465->709|1508->731|1767->963|1782->969|1844->1010|1928->1067|1943->1073|2004->1112|3209->2290|3232->2304|3272->2306|3321->2327|3360->2339|3415->2373|3454->2385|3469->2391|3513->2413|3591->2464|3647->2499|3686->2511|3701->2517|3742->2536|3817->2580|3862->2597|3973->2681|3996->2695|4036->2697|4085->2718|4126->2732|4141->2738|4184->2760|4214->2763|4227->2767|4260->2779|4331->2823|4346->2829|4388->2850|4446->2890|4459->2895|4498->2896|4547->2917|4588->2931|4603->2937|4644->2957|4722->3008|4737->3014|4781->3037|4853->3078|4900->3097|4983->3154|5011->3161|5040->3163
                  LINES: 20->1|25->1|27->3|32->8|32->8|41->17|41->17|41->17|45->21|45->21|45->21|46->22|46->22|46->22|71->47|71->47|71->47|72->48|72->48|72->48|72->48|72->48|72->48|73->49|73->49|73->49|73->49|73->49|74->50|75->51|77->53|77->53|77->53|78->54|78->54|78->54|78->54|78->54|78->54|78->54|79->55|79->55|79->55|80->56|80->56|80->56|81->57|81->57|81->57|81->57|82->58|82->58|82->58|83->59|86->62|91->67|91->67|93->69
                  -- GENERATED --
              */
          