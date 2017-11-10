
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object profile1_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class profile1 extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[play.api.libs.json.JsValue,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userJson: play.api.libs.json.JsValue):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.40*/("""

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
                    <td>"""),_display_(/*18.26*/((userJson \ "fullname").as[String])),format.raw/*18.62*/("""</td>
                </tr>

                <tr>
                    <td>Email</td>
                    <td>"""),_display_(/*23.26*/((userJson \ "email").as[String])),format.raw/*23.59*/("""</td>
                </tr>

                <tr>
                    <td>Display name</td>
                    <td>"""),_display_(/*28.26*/((userJson \ "displayname").as[String])),format.raw/*28.65*/("""</td>
                </tr>

                <tr>
                    <td>Phone number</td>
                    <td>"""),_display_(/*33.26*/((userJson \ "phonenumber").as[String])),format.raw/*33.65*/("""</td>
                </tr>

                <tr>
                    <td>Code</td>
                    <td>"""),_display_(/*38.26*/((userJson \ "code").as[String])),format.raw/*38.58*/("""</td>
                </tr>

                <tr>
                    <td>Balance</td>
                    <td>"""),_display_(/*43.26*/((userJson \ "balance").as[String])),format.raw/*43.61*/("""</td>
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

  def render(userJson:play.api.libs.json.JsValue): play.twirl.api.HtmlFormat.Appendable = apply(userJson)

  def f:((play.api.libs.json.JsValue) => play.twirl.api.HtmlFormat.Appendable) = (userJson) => apply(userJson)

  def ref: this.type = this

}


}

/**/
object profile1 extends profile1_Scope0.profile1
              /*
                  -- GENERATED --
                  DATE: Fri Oct 20 08:13:02 UTC 2017
                  SOURCE: /home/Workspace/play-scala-4/app/views/profile1.scala.html
                  HASH: 8e67fa4914f7f6c5ef30cb377ed9b4b726d9d3cf
                  MATRIX: 553->1|686->39|716->43|1135->435|1192->471|1334->586|1388->619|1537->741|1597->780|1746->902|1806->941|1947->1055|2000->1087|2144->1204|2200->1239
                  LINES: 20->1|25->1|27->3|42->18|42->18|47->23|47->23|52->28|52->28|57->33|57->33|62->38|62->38|67->43|67->43
                  -- GENERATED --
              */
          