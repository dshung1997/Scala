
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object transfer_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class transfer extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[UserInfo,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: UserInfo):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.18*/("""

"""),format.raw/*3.1*/("""<div class="row">
    <div class="col-sm-4 col-sm-offset-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Transaction</h3>
            </div>
            <div class="panel-body" id="transfer-money">
                <div id="transfer-form" >
                    <div class="form-group" >
                        <input id="sender" name="sender" value=""""),_display_(/*12.66*/user/*12.70*/.email),format.raw/*12.76*/("""" class="form-control" placeholder="Sender" type="text" disabled>
                    </div>

                    <div class="form-group" >
                        <input id="sender_code" name="sender_code" value=""""),_display_(/*16.76*/user/*16.80*/.code),format.raw/*16.85*/("""" class="form-control" placeholder="Your code" type="number" disabled>
                    </div>

                    <div class="form-group" >
                        <input id="recipient" name="recipient" value="" class="form-control" placeholder="Recipient" type="text">
                    </div>

                    <div class="form-group" >
                        <input id="recipient_code" name="recipient_code" value="" class="form-control" placeholder="Recipient code" type="number">
                    </div>

                    <div class="form-group" >
                        <input id="amount" name="amount" value="0" class="form-control" placeholder="Amount" type="number">
                    </div>

                    <input id="transfer-button-submit" class="btn btn-lg btn-success btn-block" type="submit" value="OK">
                </div>
            </div>
        </div>
    </div>
</div>

<script src=""""),_display_(/*38.15*/routes/*38.21*/.Assets.versioned("javascripts/Form2Json.js")),format.raw/*38.66*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*39.15*/routes/*39.21*/.Assets.versioned("javascripts/TransferHandler.js")),format.raw/*39.72*/("""" type="text/javascript"></script>


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
object transfer extends transfer_Scope0.transfer
              /*
                  -- GENERATED --
                  DATE: Fri Oct 20 08:13:02 UTC 2017
                  SOURCE: /home/Workspace/play-scala-4/app/views/transfer.scala.html
                  HASH: 8641f15365707cd9a21e9e0b5ed379e9ba8435a3
                  MATRIX: 535->1|646->17|676->21|1141->459|1154->463|1181->469|1427->688|1440->692|1466->697|2449->1653|2464->1659|2530->1704|2607->1754|2622->1760|2694->1811
                  LINES: 20->1|25->1|27->3|36->12|36->12|36->12|40->16|40->16|40->16|62->38|62->38|62->38|63->39|63->39|63->39
                  -- GENERATED --
              */
          