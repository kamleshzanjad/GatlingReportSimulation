package com.automationpractice

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class LoginCheckoutRefactor extends Simulation {

	val httpProtocol = http
		.baseUrl("http://automationpractice.com")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.acceptHeader("text/css,*/*;q=0.1")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Accept-Encoding" -> "gzip, deflate",
		"Accept-Language" -> "en-GB,en;q=0.9,en-US;q=0.8,mr;q=0.7,hi;q=0.6",
		"Cache-Control" -> "no-cache",
		"Pragma" -> "no-cache",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_3 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-GB,en;q=0.9,en-US;q=0.8,mr;q=0.7,hi;q=0.6",
		"origin" -> "http://automationpractice.com",
		"pragma" -> "no-cache",
		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="98", "Google Chrome";v="98""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "macOS",
		"sec-fetch-dest" -> "script",
		"sec-fetch-mode" -> "cors",
		"sec-fetch-site" -> "cross-site")

	val headers_4 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-GB,en;q=0.9,en-US;q=0.8,mr;q=0.7,hi;q=0.6",
		"origin" -> "http://automationpractice.com",
		"pragma" -> "no-cache",
		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="98", "Google Chrome";v="98""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "macOS",
		"sec-fetch-dest" -> "empty",
		"sec-fetch-mode" -> "cors",
		"sec-fetch-site" -> "cross-site")

	val headers_5 = Map(
		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-GB,en;q=0.9,en-US;q=0.8,mr;q=0.7,hi;q=0.6",
		"pragma" -> "no-cache",
		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="98", "Google Chrome";v="98""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "macOS",
		"sec-fetch-dest" -> "iframe",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "cross-site",
		"upgrade-insecure-requests" -> "1")

	val headers_7 = Map(
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-GB,en;q=0.9,en-US;q=0.8,mr;q=0.7,hi;q=0.6",
		"pragma" -> "no-cache",
		"sec-fetch-dest" -> "style",
		"sec-fetch-mode" -> "no-cors",
		"sec-fetch-site" -> "cross-site")

	val headers_8 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate",
		"Accept-Language" -> "en-GB,en;q=0.9,en-US;q=0.8,mr;q=0.7,hi;q=0.6",
		"Cache-Control" -> "no-cache",
		"Origin" -> "http://automationpractice.com",
		"Pragma" -> "no-cache")

	val headers_9 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Accept-Encoding" -> "gzip, deflate",
		"Accept-Language" -> "en-GB,en;q=0.9,en-US;q=0.8,mr;q=0.7,hi;q=0.6",
		"Cache-Control" -> "no-cache",
		"Origin" -> "http://automationpractice.com",
		"Pragma" -> "no-cache",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_15 = Map(
		"Accept" -> "application/json, text/javascript, */*; q=0.01",
		"Accept-Encoding" -> "gzip, deflate",
		"Accept-Language" -> "en-GB,en;q=0.9,en-US;q=0.8,mr;q=0.7,hi;q=0.6",
		"Cache-Control" -> "no-cache",
		"Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
		"Origin" -> "http://automationpractice.com",
		"Pragma" -> "no-cache",
		"X-Requested-With" -> "XMLHttpRequest")

    val uri1 = "https://connect.facebook.net/en_US/all.js"
    val uri2 = "https://www.facebook.com"
    val uri4 = "fonts.googleapis.com"

	val scn = scenario("LoginCheckout")
		.exec(http("LoginCheckout_0:GET_http://automationpractice.com/")
			.get("/")
			.headers(headers_0)
			.resources(http("LoginCheckout_1:GET_http://automationpractice.com/index.php")
			.get("/index.php")
			.headers(headers_0)))
		.pause(3)
		.exec(http("LoginCheckout_2:GET_http://automationpractice.com/index.php?controller=my-account")
			.get("/index.php?controller=my-account")
			.headers(headers_0)
			.resources(http("LoginCheckout_3:GET_https://connect.facebook.net/en_US/all.js?hash=526070825f9f6b24001098b477c57d15")
			.get(uri1 + "?hash=526070825f9f6b24001098b477c57d15")
			.headers(headers_3),
            http("LoginCheckout_4:GET_https://www.facebook.com/x/oauth/status?client_id=334341610034299&input_token&origin=1&redirect_uri=http_3A_2F_2Fautomationpractice.com_2Findex.php&sdk=joey&wants_cookie_data=false")
			.get(uri2 + "/x/oauth/status?client_id=334341610034299&input_token&origin=1&redirect_uri=http%3A%2F%2Fautomationpractice.com%2Findex.php&sdk=joey&wants_cookie_data=false")
			.headers(headers_4),
            http("LoginCheckout_5:GET_https://www.facebook.com/plugins/like_box.php?app_id=334341610034299&channel=https_3A_2F_2Fstaticxx.facebook.com_2Fx_2Fconnect_2Fxd_arbiter_2F_3Fversion_3D46_23cb_3Df24df4315c83bac_26domain_3Dautomationpractice.com_26is_canvas_3Dfalse_26origin_3Dhttp_253A_252F_252Fautomationpractice.com_252Ff1661e75417dba8_26relation_3Dparent.parent&color_scheme=light&container_width=330&header=false&href=https_3A_2F_2Fwww.facebook.com_2Fprestashop&locale=en_US&sdk=joey&show_border=false&show_faces=true&stream=false")
			.get(uri2 + "/plugins/like_box.php?app_id=334341610034299&channel=https%3A%2F%2Fstaticxx.facebook.com%2Fx%2Fconnect%2Fxd_arbiter%2F%3Fversion%3D46%23cb%3Df24df4315c83bac%26domain%3Dautomationpractice.com%26is_canvas%3Dfalse%26origin%3Dhttp%253A%252F%252Fautomationpractice.com%252Ff1661e75417dba8%26relation%3Dparent.parent&color_scheme=light&container_width=330&header=false&href=https%3A%2F%2Fwww.facebook.com%2Fprestashop&locale=en_US&sdk=joey&show_border=false&show_faces=true&stream=false")
			.headers(headers_5),
            http("LoginCheckout_6:GET_http://fonts.googleapis.com/css?family=Open_Sans:300_600&subset=latin_latin-ext")
			.get("http://" + uri4 + "/css?family=Open+Sans:300,600&subset=latin,latin-ext"),
            http("LoginCheckout_7:GET_https://fonts.googleapis.com/css?family=Open_Sans:300_600&subset=latin_latin-ext")
			.get("https://" + uri4 + "/css?family=Open+Sans:300,600&subset=latin,latin-ext")
			.headers(headers_7)))
		.pause(3)
		.exec(http("LoginCheckout_8:GET_http://automationpractice.com/themes/default-bootstrap/font/fontawesome-webfont.woff?v=3.2.1")
			.get("/themes/default-bootstrap/font/fontawesome-webfont.woff?v=3.2.1")
			.headers(headers_8))
		.pause(5)
		.exec(http("LoginCheckout_9:POST_http://automationpractice.com/index.php?controller=authentication")
			.post("/index.php?controller=authentication")
			.headers(headers_9)
			.formParam("email", "zanjadkamlesh@gmail.com")
			.formParam("passwd", "Training@1")
			.formParam("back", "my-account")
			.formParam("SubmitLogin", "")
			.resources(http("LoginCheckout_10:GET_https://fonts.googleapis.com/css?family=Open_Sans:300_600&subset=latin_latin-ext")
			.get("https://" + uri4 + "/css?family=Open+Sans:300,600&subset=latin,latin-ext")
			.headers(headers_7)))
		.pause(2)
		.exec(http("LoginCheckout_11:GET_http://automationpractice.com/themes/default-bootstrap/font/fontawesome-webfont.woff?v=3.2.1")
			.get("/themes/default-bootstrap/font/fontawesome-webfont.woff?v=3.2.1")
			.headers(headers_8))
		.pause(14)
		.exec(http("LoginCheckout_12:GET_http://fonts.googleapis.com/css?family=Open_Sans:300_600&subset=latin_latin-ext")
			.get("http://" + uri4 + "/css?family=Open+Sans:300,600&subset=latin,latin-ext")
			.resources(http("LoginCheckout_13:GET_http://automationpractice.com/index.php?id_category=9&controller=category")
			.get("/index.php?id_category=9&controller=category")
			.headers(headers_0)))
		.pause(2)
		.exec(http("LoginCheckout_14:GET_http://automationpractice.com/themes/default-bootstrap/font/fontawesome-webfont.woff?v=3.2.1")
			.get("/themes/default-bootstrap/font/fontawesome-webfont.woff?v=3.2.1")
			.headers(headers_8))
		.pause(3)
		.exec(http("LoginCheckout_15:POST_http://automationpractice.com/index.php?rand=1645693540085")
			.post("/index.php?rand=1645693540085")
			.headers(headers_15)
			.formParam("controller", "cart")
			.formParam("add", "1")
			.formParam("ajax", "true")
			.formParam("qty", "1")
			.formParam("id_product", "3")
			.formParam("token", "4bac0d9fd6dfba524d0ee23f0895f44a"))
		.pause(23)
		.exec(http("LoginCheckout_16:GET_http://fonts.googleapis.com/css?family=Open_Sans:300_600&subset=latin_latin-ext")
			.get("http://" + uri4 + "/css?family=Open+Sans:300,600&subset=latin,latin-ext")
			.resources(http("LoginCheckout_17:GET_https://fonts.googleapis.com/css?family=Open_Sans:300_600&subset=latin_latin-ext")
			.get("https://" + uri4 + "/css?family=Open+Sans:300,600&subset=latin,latin-ext")
			.headers(headers_7)))
		.pause(3)
		.exec(http("LoginCheckout_18:GET_http://automationpractice.com/themes/default-bootstrap/font/fontawesome-webfont.woff?v=3.2.1")
			.get("/themes/default-bootstrap/font/fontawesome-webfont.woff?v=3.2.1")
			.headers(headers_8))
		.pause(8)
		.exec(http("LoginCheckout_19:POST_http://automationpractice.com/index.php?rand=1645693578953")
			.post("/index.php?rand=1645693578953")
			.headers(headers_15)
			.formParam("controller", "cart")
			.formParam("add", "1")
			.formParam("ajax", "true")
			.formParam("qty", "1")
			.formParam("id_product", "4")
			.formParam("token", "4bac0d9fd6dfba524d0ee23f0895f44a"))
		.pause(3)
		.exec(http("LoginCheckout_20:GET_http://fonts.googleapis.com/css?family=Open_Sans:300_600&subset=latin_latin-ext")
			.get("http://" + uri4 + "/css?family=Open+Sans:300,600&subset=latin,latin-ext")
			.resources(http("LoginCheckout_21:GET_http://automationpractice.com/index.php?controller=order")
			.get("/index.php?controller=order")
			.headers(headers_0)))
		.pause(2)
		.exec(http("LoginCheckout_22:GET_http://automationpractice.com/themes/default-bootstrap/font/fontawesome-webfont.woff?v=3.2.1")
			.get("/themes/default-bootstrap/font/fontawesome-webfont.woff?v=3.2.1")
			.headers(headers_8))
		.pause(10)
		.exec(http("LoginCheckout_23:GET_http://fonts.googleapis.com/css?family=Open_Sans:300_600&subset=latin_latin-ext")
			.get("http://" + uri4 + "/css?family=Open+Sans:300,600&subset=latin,latin-ext")
			.resources(http("LoginCheckout_24:GET_https://fonts.googleapis.com/css?family=Open_Sans:300_600&subset=latin_latin-ext")
			.get("https://" + uri4 + "/css?family=Open+Sans:300,600&subset=latin,latin-ext")
			.headers(headers_7)))
		.pause(2)
		.exec(http("LoginCheckout_25:GET_http://automationpractice.com/themes/default-bootstrap/font/fontawesome-webfont.woff?v=3.2.1")
			.get("/themes/default-bootstrap/font/fontawesome-webfont.woff?v=3.2.1")
			.headers(headers_8))
		.pause(19)
		.exec(http("LoginCheckout_26:GET_http://fonts.googleapis.com/css?family=Open_Sans:300_600&subset=latin_latin-ext")
			.get("http://" + uri4 + "/css?family=Open+Sans:300,600&subset=latin,latin-ext")
			.resources(http("LoginCheckout_27:GET_https://fonts.googleapis.com/css?family=Open_Sans:300_600&subset=latin_latin-ext")
			.get("https://" + uri4 + "/css?family=Open+Sans:300,600&subset=latin,latin-ext")
			.headers(headers_7)))
		.pause(2)
		.exec(http("LoginCheckout_28:GET_http://automationpractice.com/themes/default-bootstrap/font/fontawesome-webfont.woff?v=3.2.1")
			.get("/themes/default-bootstrap/font/fontawesome-webfont.woff?v=3.2.1")
			.headers(headers_8))
		.pause(8)
		.exec(http("LoginCheckout_29:GET_http://fonts.googleapis.com/css?family=Open_Sans:300_600&subset=latin_latin-ext")
			.get("http://" + uri4 + "/css?family=Open+Sans:300,600&subset=latin,latin-ext")
			.resources(http("LoginCheckout_30:GET_https://fonts.googleapis.com/css?family=Open_Sans:300_600&subset=latin_latin-ext")
			.get("https://" + uri4 + "/css?family=Open+Sans:300,600&subset=latin,latin-ext")
			.headers(headers_7)
			.check(bodyBytes.is(RawFileBody("computerdatabase/logincheckout/0030_response.css")))))
		.pause(2)
		.exec(http("LoginCheckout_31:GET_http://automationpractice.com/themes/default-bootstrap/font/fontawesome-webfont.woff?v=3.2.1")
			.get("/themes/default-bootstrap/font/fontawesome-webfont.woff?v=3.2.1")
			.headers(headers_8)
			.check(bodyBytes.is(RawFileBody("computerdatabase/logincheckout/0031_response.dat"))))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}