
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object profile_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class profile extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[UserInfo,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: UserInfo):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.18*/("""

"""),format.raw/*3.1*/("""<div class="container">

    <div class="col-md-4"></div>
    <div class="col-md-4">
        <table class="table table-hover">
                <thead>
                    <tr>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>Full name</td>
                        <td>"""),_display_(/*18.30*/user/*18.34*/.fullname),format.raw/*18.43*/("""</td>
                    </tr>

                    <tr>
                        <td>Email</td>
                        <td>"""),_display_(/*23.30*/user/*23.34*/.email),format.raw/*23.40*/("""</td>
                    </tr>

                    <tr>
                        <td>Display name</td>
                        <td>"""),_display_(/*28.30*/user/*28.34*/.displayname),format.raw/*28.46*/("""</td>
                    </tr>

                    <tr>
                        <td>Phone number</td>
                        <td>"""),_display_(/*33.30*/user/*33.34*/.phonenumber),format.raw/*33.46*/("""</td>
                    </tr>

                    <tr>
                        <td>Code</td>
                        <td>"""),_display_(/*38.30*/user/*38.34*/.code),format.raw/*38.39*/("""</td>
                    </tr>
                </tbody>
            </table>
    </div>
   <div class="col-md-4"></div>
</div>


"""))
      }
    }
  }

  def render(user:UserInfo): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((UserInfo) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}


}

/**/
object profile extends profile_Scope0.profile
              /*
                  -- GENERATED --
                  DATE: Fri Oct 20 08:13:02 UTC 2017
                  SOURCE: /home/Workspace/play-scala-4/app/views/profile.scala.html
                  HASH: eaca1f0b79940b9294c8f884107b3a35f0379608
                  MATRIX: 533->1|644->17|674->21|1133->453|1146->457|1176->466|1334->597|1347->601|1374->607|1539->745|1552->749|1585->761|1750->899|1763->903|1796->915|1953->1045|1966->1049|1992->1054
                  LINES: 20->1|25->1|27->3|42->18|42->18|42->18|47->23|47->23|47->23|52->28|52->28|52->28|57->33|57->33|57->33|62->38|62->38|62->38
                  -- GENERATED --
              */
          