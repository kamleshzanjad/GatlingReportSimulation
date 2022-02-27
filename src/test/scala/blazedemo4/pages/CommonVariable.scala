package blazedemo4.pages

import io.gatling.core.Predef.{BlackList, WhiteList, _}
import io.gatling.http.Predef.http


object CommonVariable {
  val domain ="blazedemo.com"

  var csvFedderBlazeDemoFilightDetails  = csv("data/BlazeDemoFilightDetails.csv").circular

  val httpProtocol = http
    .baseUrl("https://" + domain)
    .inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-GB,en;q=0.9,en-US;q=0.8,mr;q=0.7,hi;q=0.6")
    .contentTypeHeader("application/x-www-form-urlencoded")
    .originHeader("https://blazedemo.com")
    .upgradeInsecureRequestsHeader("1")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36")

  val headers_0 = Map(
    "pragma" -> "no-cache",
    "sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="98", "Google Chrome";v="98""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-ch-ua-platform" -> "macOS",
    "sec-fetch-dest" -> "document",
    "sec-fetch-mode" -> "navigate",
    "sec-fetch-site" -> "same-origin",
    "sec-fetch-user" -> "?1")
}
