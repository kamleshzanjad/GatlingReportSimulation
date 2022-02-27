package blazedemo4.pages

import blazedemo4.pages.CommonVariable.headers_0
import io.gatling.core.Predef.{exec, _}
import io.gatling.http.Predef.http


object Confirmation{
  def methodConfirmation ={
    exec(http("T3 Confirmation Page")
      .post("/confirmation.php")
      .headers(headers_0)
      .formParam("_token", "")
      .formParam("inputName", "Testing")
      .formParam("address", "Address1 ")
      .formParam("city", "NY")
      .formParam("state", "Ney york")
      .formParam("zipCode", "12345")
      .formParam("cardType", "visa")
      .formParam("creditCardNumber", "1234567890")
      .formParam("creditCardMonth", "12")
      .formParam("creditCardYear", "2017")
      .formParam("nameOnCard", "Automation Testing")
      //.check(bodyBytes.is(RawFileBody("blazedemo4/blazedemo4/0002_response.html")))
    )
  }
}
