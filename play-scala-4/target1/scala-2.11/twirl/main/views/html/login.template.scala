
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object login_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class login extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="row">
    <div class="col-sm-4 col-sm-offset-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Please log in</h3>
            </div>
            <div class="panel-body">
                <div id="login-form">
                    <fieldset>
                        <div class="form-group">
                            <input id="email" name="email" value="" class="form-control" placeholder="Email" type="text"
                                   required>

                            <span id="email_error_message"></span>
                        </div>

                        <div class="form-group">
                            <input id="password" name="password" value="" class="form-control" placeholder="Password"
                                   type="password" required minlength="1">

                            <span id="password_error_message"></span>
                        </div>

                        <div>
                            <span id="login-message-error"></span>
                        </div>

                        <input id="login-button-submit" class="btn btn-lg btn-success btn-block" type="submit" value="Login">
                    </fieldset>
                </div>
            </div>
        </div>
    </div>
</div>

<script src=""""),_display_(/*36.15*/routes/*36.21*/.Assets.versioned("javascripts/Form2Json.js")),format.raw/*36.66*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*37.15*/routes/*37.21*/.Assets.versioned("javascripts/LoginHandler.js")),format.raw/*37.69*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*38.15*/routes/*38.21*/.Assets.versioned("javascripts/LoginValidation.js")),format.raw/*38.72*/("""" type="text/javascript"></script>

"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object login extends login_Scope0.login
              /*
                  -- GENERATED --
                  DATE: Fri Oct 20 08:13:02 UTC 2017
                  SOURCE: /home/Workspace/play-scala-4/app/views/login.scala.html
                  HASH: 3871cb3d9c558a540ae6231013056476b8708d4d
                  MATRIX: 609->0|2035->1399|2050->1405|2116->1450|2193->1500|2208->1506|2277->1554|2354->1604|2369->1610|2441->1661
                  LINES: 25->1|60->36|60->36|60->36|61->37|61->37|61->37|62->38|62->38|62->38
                  -- GENERATED --
              */
          