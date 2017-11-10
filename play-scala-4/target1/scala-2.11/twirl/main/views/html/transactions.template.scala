
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object transactions_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class transactions extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Seq[models.UserTransaction],Seq[models.UserTransaction],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(sendingTrans: Seq[models.UserTransaction], receivingTrans: Seq[models.UserTransaction]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.90*/("""

"""),format.raw/*3.1*/("""<div class="container">

    <div class="col-md-4"></div>
    <div class="col-md-4">
        """),_display_(/*7.10*/if(sendingTrans.length != 0)/*7.38*/{_display_(Seq[Any](format.raw/*7.39*/("""
            """),format.raw/*8.13*/("""<table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Sender</th>
                <th>Recipient</th>
                <th>Amount</th>
                <th>Date</th>

            </tr>
            </thead>

            <tbody>

            """),_display_(/*22.14*/for((tran, id) <- sendingTrans.zipWithIndex) yield /*22.58*/{_display_(Seq[Any](format.raw/*22.59*/("""
            """),format.raw/*23.13*/("""<tr>
                <td>"""),_display_(/*24.22*/(id+1)),format.raw/*24.28*/("""</td>
                <td>"""),_display_(/*25.22*/tran/*25.26*/.sender),format.raw/*25.33*/("""</td>
                <td>"""),_display_(/*26.22*/tran/*26.26*/.recipient),format.raw/*26.36*/("""</td>
                <td>"""),_display_(/*27.22*/tran/*27.26*/.amount),format.raw/*27.33*/("""</td>
                <td>"""),_display_(/*28.22*/tran/*28.26*/.date),format.raw/*28.31*/("""</td>

            </tr>
            """)))}),format.raw/*31.14*/("""

            """),format.raw/*33.13*/("""</tbody>
        </table>
        """)))}),format.raw/*35.10*/("""

        """),_display_(/*37.10*/if(receivingTrans.length != 0)/*37.40*/{_display_(Seq[Any](format.raw/*37.41*/("""
            """),format.raw/*38.13*/("""<table class="table table-stripped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Sender</th>
                <th>Recipient</th>
                <th>Amount</th>
                <th>Date</th>

            </tr>
            </thead>

            <tbody>

            """),_display_(/*52.14*/for((tran, id) <- receivingTrans.zipWithIndex) yield /*52.60*/{_display_(Seq[Any](format.raw/*52.61*/("""
            """),format.raw/*53.13*/("""<tr>
                <td>"""),_display_(/*54.22*/(id+1)),format.raw/*54.28*/("""</td>
                <td>"""),_display_(/*55.22*/tran/*55.26*/.sender),format.raw/*55.33*/("""</td>
                <td>"""),_display_(/*56.22*/tran/*56.26*/.recipient),format.raw/*56.36*/("""</td>
                <td>"""),_display_(/*57.22*/tran/*57.26*/.amount),format.raw/*57.33*/("""</td>
                <td>"""),_display_(/*58.22*/tran/*58.26*/.date),format.raw/*58.31*/("""</td>

            </tr>
            """)))}),format.raw/*61.14*/("""

            """),format.raw/*63.13*/("""</tbody>
        </table>
        """)))}),format.raw/*65.10*/("""
    """),format.raw/*66.5*/("""</div>
   <div class="col-md-4"></div>
</div>


"""))
      }
    }
  }

  def render(sendingTrans:Seq[models.UserTransaction],receivingTrans:Seq[models.UserTransaction]): play.twirl.api.HtmlFormat.Appendable = apply(sendingTrans,receivingTrans)

  def f:((Seq[models.UserTransaction],Seq[models.UserTransaction]) => play.twirl.api.HtmlFormat.Appendable) = (sendingTrans,receivingTrans) => apply(sendingTrans,receivingTrans)

  def ref: this.type = this

}


}

/**/
object transactions extends transactions_Scope0.transactions
              /*
                  -- GENERATED --
                  DATE: Fri Oct 20 08:13:02 UTC 2017
                  SOURCE: /home/Workspace/play-scala-4/app/views/transactions.scala.html
                  HASH: 4555ecea0cc90714e0d4ba0de405b26befcef07f
                  MATRIX: 590->1|773->89|803->93|927->191|963->219|1001->220|1042->234|1388->553|1448->597|1487->598|1529->612|1583->639|1610->645|1665->673|1678->677|1706->684|1761->712|1774->716|1805->726|1860->754|1873->758|1901->765|1956->793|1969->797|1995->802|2067->843|2111->859|2179->896|2219->909|2258->939|2297->940|2339->954|2686->1274|2748->1320|2787->1321|2829->1335|2883->1362|2910->1368|2965->1396|2978->1400|3006->1407|3061->1435|3074->1439|3105->1449|3160->1477|3173->1481|3201->1488|3256->1516|3269->1520|3295->1525|3367->1566|3411->1582|3479->1619|3512->1625
                  LINES: 20->1|25->1|27->3|31->7|31->7|31->7|32->8|46->22|46->22|46->22|47->23|48->24|48->24|49->25|49->25|49->25|50->26|50->26|50->26|51->27|51->27|51->27|52->28|52->28|52->28|55->31|57->33|59->35|61->37|61->37|61->37|62->38|76->52|76->52|76->52|77->53|78->54|78->54|79->55|79->55|79->55|80->56|80->56|80->56|81->57|81->57|81->57|82->58|82->58|82->58|85->61|87->63|89->65|90->66
                  -- GENERATED --
              */
          