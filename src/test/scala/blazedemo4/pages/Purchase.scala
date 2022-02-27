package blazedemo4.pages

import blazedemo4.pages.CommonVariable.headers_0
import io.gatling.core.Predef.{exec, _}
import io.gatling.http.Predef.http

/// FromPort,ToPort,Airline,Price,FlightNo

object Purchase{
  def methodPurchase ={
    exec(
      http("T2 Purchase Page")
      .post("/purchase.php")
      .headers(headers_0)
      .formParam("flight", "${FlightNo}")
      .formParam("price", "${Price}")
      .formParam("airline", "${Airline}")
      .formParam("fromPort", "${FromPort}")
      .formParam("toPort", "${ToPort}")

    )
      .pause(2,5)
  }
}

