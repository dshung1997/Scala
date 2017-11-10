
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object listAll_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class listAll extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,Boolean,models.UserInfo,Seq[models.UserInfo],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(page: String, isLoggedIn: Boolean, user: models.UserInfo, users: Seq[models.UserInfo]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.89*/("""

"""),_display_(/*3.2*/main(page, isLoggedIn, user)/*3.30*/ {_display_(Seq[Any](format.raw/*3.32*/("""

"""),format.raw/*5.1*/("""<h1>Users</h1>
<table>
    <thead>
    <tr><th>Username</th><th>Password</th>
    </thead>
    <tbody>
    """),_display_(/*11.6*/for(u <- users) yield /*11.21*/ {_display_(Seq[Any](format.raw/*11.23*/("""
    """),format.raw/*12.5*/("""<tr>
        <td>"""),_display_(/*13.14*/u/*13.15*/.email),format.raw/*13.21*/("""</td>

        <td>"""),_display_(/*15.14*/u/*15.15*/.fullname),format.raw/*15.24*/("""</td>
        <td>"""),_display_(/*16.14*/u/*16.15*/.displayname),format.raw/*16.27*/("""</td>
        <td>"""),_display_(/*17.14*/u/*17.15*/.phonenumber),format.raw/*17.27*/("""</td>
    </tr>
    """)))}),format.raw/*19.6*/("""
    """),format.raw/*20.5*/("""</tbody>
</table>

""")))}))
      }
    }
  }

  def render(page:String,isLoggedIn:Boolean,user:models.UserInfo,users:Seq[models.UserInfo]): play.twirl.api.HtmlFormat.Appendable = apply(page,isLoggedIn,user,users)

  def f:((String,Boolean,models.UserInfo,Seq[models.UserInfo]) => play.twirl.api.HtmlFormat.Appendable) = (page,isLoggedIn,user,users) => apply(page,isLoggedIn,user,users)

  def ref: this.type = this

}


}

/**/
object listAll extends listAll_Scope0.listAll
              /*
                  -- GENERATED --
                  DATE: Fri Oct 20 08:13:02 UTC 2017
                  SOURCE: /home/Workspace/play-scala-4/app/views/listAll.scala.html
                  HASH: 30018f508f8150fa42df1c66321abdd58a29306b
                  MATRIX: 576->1|758->88|788->93|824->121|863->123|893->127|1033->241|1064->256|1104->258|1137->264|1183->283|1193->284|1220->290|1269->312|1279->313|1309->322|1356->342|1366->343|1399->355|1446->375|1456->376|1489->388|1542->411|1575->417
                  LINES: 20->1|25->1|27->3|27->3|27->3|29->5|35->11|35->11|35->11|36->12|37->13|37->13|37->13|39->15|39->15|39->15|40->16|40->16|40->16|41->17|41->17|41->17|43->19|44->20
                  -- GENERATED --
              */
          