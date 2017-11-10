
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object register_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class register extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="row">
    <div class="col-sm-4 col-sm-offset-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Register</h3>
            </div>
            <div class="panel-body">
                <div id="register-form">
                    <fieldset>
                        <div class="form-group" >
                            <input id="email" name="email" value="" class="form-control" placeholder="Email" type="email" required>
                        </div>

                        <div class="form-group" >
                            <input id="password" name="password" value="" class="form-control" placeholder="Password" type="password" required minlength="1"> 
                        </div>

                        <div class="form-group" >
                            <input id="passwordConfirm" name="passwordConfirm" value="" class="form-control" placeholder="Confirm Password" type="password" required minlength="1">
                        </div>

                        <div class="form-group" >
                            <input id="fullname" name="fullname" value="" class="form-control" placeholder="Full name" type="text" required >
                        </div>

                        <div class="form-group" >
                            <input id="displayname" name="displayname" value="" class="form-control" placeholder="Display name" type="text" required>
                        </div>

                        <div class="form-group" >
                            <input id="phonenumber" name="phonenumber" value="" class="form-control" placeholder="Phone number" type="text" required>
                        </div>

                        <div>
                            <span id="register-message-error"></span>
                        </div>

                        <input id="register-button-submit" class="btn btn-lg btn-success btn-block" type="submit" value="Register">
                    </fieldset>
                </div>
            </div>
        </div>
    </div>
</div>

<script src=""""),_display_(/*46.15*/routes/*46.21*/.Assets.versioned("javascripts/Form2Json.js")),format.raw/*46.66*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*47.15*/routes/*47.21*/.Assets.versioned("javascripts/RegisterHandler.js")),format.raw/*47.72*/("""" type="text/javascript"></script>
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
object register extends register_Scope0.register
              /*
                  -- GENERATED --
                  DATE: Fri Oct 20 08:13:02 UTC 2017
                  SOURCE: /home/Workspace/play-scala-4/app/views/register.scala.html
                  HASH: 6f8860b2c33c9a4899a884e7b4394fae498fd1af
                  MATRIX: 615->0|2803->2161|2818->2167|2884->2212|2961->2262|2976->2268|3048->2319
                  LINES: 25->1|70->46|70->46|70->46|71->47|71->47|71->47
                  -- GENERATED --
              */
          