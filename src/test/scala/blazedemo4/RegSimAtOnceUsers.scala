package blazedemo4

import io.gatling.core.Predef._
import io.gatling.http.Predef._


class RegSimAtOnceUsers extends Simulation {
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

	//  FromPort,ToPort,Airline,Price,FlightNo
	object Reserve{
		def methodReserve ={
			exec(http("T1 Reserve Page")
				.post("/reserve.php")
				.headers(headers_0)
				.formParam("fromPort", "${FromPort}")
				.formParam("toPort", "${ToPort}"))
				//.pause(5)
		}
	}
	
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
				.formParam("toPort", "${ToPort}"))
				//.pause(2,5)
		}
	}

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

val scnRefactor= scenario("Fligh Booking" )
	.during(60){
		   feed((csvFedderBlazeDemoFilightDetails))
		   .exec(Reserve.methodReserve)
			.exec(Purchase.methodPurchase)
			.exec(Confirmation.methodConfirmation)
	}

	val scnRefactor2= scenario("Fligh Booking" )
		.during(60){
			feed((csvFedderBlazeDemoFilightDetails))
				.exec(Reserve.methodReserve)
				.exec(Purchase.methodPurchase)
				.exec(Confirmation.methodConfirmation)
		}

	setUp(
		scnRefactor.inject
		(
		     atOnceUsers(10)
		)
	)
		.protocols(httpProtocol)



}