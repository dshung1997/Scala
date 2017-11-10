
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Boolean,models.UserInfo,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(page: String, isLoggedIn: Boolean, user: models.UserInfo):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.60*/("""

"""),_display_(/*3.2*/main(page, isLoggedIn, user)/*3.30*/ {_display_(Seq[Any](format.raw/*3.32*/("""
   """),format.raw/*4.4*/("""<div class="container">
     <div class="row">
       <div class="col-sm-10 col-sm-offset-1">

       <h2>Welcome to Fintech !</h2>

       </div>
     </div>
   </div>
""")))}),format.raw/*13.2*/("""
"""))
      }
    }
  }

  def render(page:String,isLoggedIn:Boolean,user:models.UserInfo): play.twirl.api.HtmlFormat.Appendable = apply(page,isLoggedIn,user)

  def f:((String,Boolean,models.UserInfo) => play.twirl.api.HtmlFormat.Appendable) = (page,isLoggedIn,user) => apply(page,isLoggedIn,user)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Fri Oct 20 08:13:02 UTC 2017
                  SOURCE: /home/Workspace/play-scala-4/app/views/index.scala.html
                  HASH: a5ab9bab4da86914c65ba7013cb40addc9067c68
                  MATRIX: 551->1|704->59|732->62|768->90|807->92|837->96|1037->266
                  LINES: 20->1|25->1|27->3|27->3|27->3|28->4|37->13
                  -- GENERATED --
              */
          