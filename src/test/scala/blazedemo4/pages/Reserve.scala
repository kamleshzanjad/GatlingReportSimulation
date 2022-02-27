package blazedemo4.pages

import blazedemo4.pages.CommonVariable.headers_0
import io.gatling.core.Predef.{exec, _}
import io.gatling.http.Predef.http

///// FromPort,ToPort,Airline,Price,FlightNo

object Reserve{
  def methodReserve ={
    exec(http("T1 Reserve Page")
      .post("/reserve.php")
      .headers(headers_0)
      .formParam("fromPort", "${FromPort}")
      .formParam("toPort", "${ToPort}")
    )
      .pause(5)
  }
}
