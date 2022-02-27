package blazedemo

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BlazeDemoDisableRedirect extends Simulation {

	var tokenExpr="""<input type="hidden" name="_token" value="(.*)">"""
	var redirectingUrlAfterLoginPost="""<title>Redirecting to (.*)"""

	//  <title>Redirecting to https://blazedemo.com/home</title>

	val httpProtocol = http
		.baseUrl("https://blazedemo.com")
		.disableFollowRedirect
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-GB,en;q=0.9,en-US;q=0.8,mr;q=0.7,hi;q=0.6")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.109 Safari/537.36")

	val headers_0 = Map(
		"origin" -> "https://blazedemo.com",
		"pragma" -> "no-cache",
		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="98", "Google Chrome";v="98""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "macOS",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "same-origin",
		"sec-fetch-user" -> "?1",
		"upgrade-insecure-requests" -> "1")

	val headers_1 = Map(
		"accept" -> "text/css,*/*;q=0.1",
		"pragma" -> "no-cache",
		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="98", "Google Chrome";v="98""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "macOS",
		"sec-fetch-dest" -> "style",
		"sec-fetch-mode" -> "no-cors",
		"sec-fetch-site" -> "cross-site",
		"x-client-data" -> "CJO2yQEIprbJAQjEtskBCKmdygEInvnLAQjnhMwBCJuczAEIrJzMAQ==")

	val headers_2 = Map(
		"pragma" -> "no-cache",
		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="98", "Google Chrome";v="98""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "macOS",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "same-origin",
		"sec-fetch-user" -> "?1",
		"upgrade-insecure-requests" -> "1")

    val uri2 = "https://fonts.googleapis.com/css"

	val scn = scenario("BlazeDemoLoginLogout")
		.exec(flushHttpCache)
		.exec(
			http("T0 get Token from Login get call")
				.get("/login")
				.headers(headers_0)
				.check(regex(tokenExpr).saveAs("_token"))
		)
		.exec(http("T1 Login")
			.post("/login")
			.headers(headers_0)
			.formParam("_token", "${_token}")
			.formParam("email", "zanjadkamlesh@gmail.com")
			.formParam("password", "Testing@1")
			.check(status.in(200,302,304))
			.check(regex(redirectingUrlAfterLoginPost).saveAs("redirectUrlAfterLogin"))
			.check(header("location").saveAs("gLocation"))
//			.resources(http("BlazeDemoLoginLogout_1:GET_https://fonts.googleapis.com/css?family=Raleway:300_400_600")
//			.get(uri2 + "?family=Raleway:300,400,600")
//			.headers(headers_1))
		)
		.pause(2)
		.exec(session => {
			val fetchURLFromResponseBody = session("redirectUrlAfterLogin")
			val fetchURLFromResponseHeaders = session("gLocation")
			println("Printing session varialbes")
			println("fetchURLFromResponseBody '" + fetchURLFromResponseBody +"'")
			println("fetchURLFromResponseHeaders  '" + fetchURLFromResponseHeaders +"'")
			session
		})
		.exec(
			http(" T2 Redirect Url")
				.get("${gLocation}")
				.headers(headers_1)   /// header for redirect url will be different, need to fetch it using programs
				.check(regex("You are logged in!").exists)
				.check(regex("""<div class="panel-heading">Dashboard</div>""").exists)
		)
		.exec(http("BlazeDemoLoginLogout_2:GET_https://blazedemo.com/")
			.get("/")
			.headers(headers_2))
		.pause(2)
		.exec(http("BlazeDemoLoginLogout_3:GET_https://blazedemo.com/vacation.html")
			.get("/vacation.html")
			.headers(headers_2))
		.pause(2)
		.exec(http("BlazeDemoLoginLogout_4:GET_https://blazedemo.com/home")
			.get("/home")
			.headers(headers_2)
			.check(regex(tokenExpr).saveAs("_token2"))
		)
		.pause(2)

		.exec(flushHttpCache)

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}