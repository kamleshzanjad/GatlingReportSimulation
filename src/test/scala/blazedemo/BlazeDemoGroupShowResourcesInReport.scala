package blazedemo

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BlazeDemoGroupShowResourcesInReport extends Simulation {

	var tokenExpr="""<input type="hidden" name="_token" value="(.*)">"""
	var redirectingUrlAfterLoginPost="""<title>Redirecting to (.*)"""

	//  <title>Redirecting to https://blazedemo.com/home</title>

	val httpProtocol = http
		.baseUrl("https://blazedemo.com")
		.inferHtmlResources()
		//.silentResources
		//.nameInferredHtmlResourcesAfterAbsoluteUrl
		//.disableFollowRedirect
		//.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
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


	object Login{
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

		def methodLogin={
			exec(flushHttpCache)
				.group("Login Group "){
					exec(
					http("T0 get Token from Login get call")
						.get("/login")
						.headers(headers_0)
						.check(regex(tokenExpr).saveAs("_token"))

				)
				.pause(2)
				.exec(http("T1 Login")
					.post("/login")
					.headers(headers_0)
					.formParam("_token", "${_token}")
					.formParam("email", "zanjadkamlesh@gmail.com")
					.formParam("password", "Testing@1")
					.check(status.in(302,304, 200))
				)
				.pause(2)
				}
		}

		def methodLogout ={
			group("Logout "){
						exec(http("T4 Navigate to Home")
						.get("/home")
						.headers(headers_2)
						.check(regex(tokenExpr).saveAs("_token2"))
					)
						.pause(2)
						.exec(http("T5 Logout")
							.post("/logout")
							.headers(headers_0)
							.formParam("_token", "${_token2}")
							//.formParam("_token", "FLyQO3cggY4Is8OLbDRntffY8QkJzAQIUukYcfb1")
						)
						.pause(2)
						.exec(flushHttpCache)
		}
		}
	}

	val scn = scenario("BlazeDemoLoginLogout")
		.exec(Login.methodLogin)

		.during(20){
			exec(http("T2 Navigate to base url")
				.get("/")
				.headers(headers_2))
			.pause(2)
			.exec(http("T3 Navigate to Vacation")
				.get("/vacation.html")
				.headers(headers_2))
			.pause(2)
		}
		.exec(Login.methodLogout)


	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}