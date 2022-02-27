package com.automationpractice

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class Recording extends Simulation {

	val httpProtocol = http
		.baseUrl("http://fonts.googleapis.com")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.acceptHeader("text/css,*/*;q=0.1")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36")

	val headers_1 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Accept-Encoding" -> "gzip, deflate",
		"Accept-Language" -> "en-GB,en;q=0.9,en-US;q=0.8,mr;q=0.7,hi;q=0.6",
		"Cache-Control" -> "no-cache",
		"Pragma" -> "no-cache",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_2 = Map(
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

	val headers_3 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate",
		"Accept-Language" -> "en-GB,en;q=0.9,en-US;q=0.8,mr;q=0.7,hi;q=0.6",
		"Cache-Control" -> "no-cache",
		"Origin" -> "http://automationpractice.com",
		"Pragma" -> "no-cache")

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

	val headers_6 = Map(
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-GB,en;q=0.9,en-US;q=0.8,mr;q=0.7,hi;q=0.6",
		"origin" -> "https://www.facebook.com",
		"pragma" -> "no-cache",
		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="98", "Google Chrome";v="98""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "macOS",
		"sec-fetch-dest" -> "style",
		"sec-fetch-mode" -> "cors",
		"sec-fetch-site" -> "cross-site")

	val headers_7 = Map(
		"Accept" -> "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate",
		"Accept-Language" -> "en-GB,en;q=0.9,en-US;q=0.8,mr;q=0.7,hi;q=0.6",
		"Cache-Control" -> "no-cache",
		"Pragma" -> "no-cache")

	val headers_10 = Map(
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-GB,en;q=0.9,en-US;q=0.8,mr;q=0.7,hi;q=0.6",
		"pragma" -> "no-cache",
		"sec-fetch-dest" -> "style",
		"sec-fetch-mode" -> "no-cors",
		"sec-fetch-site" -> "cross-site")

    val uri1 = "https://connect.facebook.net/en_US/all.js"
    val uri2 = "https://www.facebook.com"
    val uri3 = "https://static.xx.fbcdn.net/rsrc.php/v3/yA/l/0,cross/Vfktt9mnRwJ.css"
    val uri4 = "http://automationpractice.com"
	val uri5 = "http://automationpractice.com"

	val scn = scenario("Recording")
		.exec(http("Recording_0")
			.get("/css?family=Open+Sans:300,600&subset=latin,latin-ext")
			.resources(http("Recording_1")
			.get(uri4 + "/index.php")
			.headers(headers_1)))
		.pause(3)
		.exec(http("Recording_2")
			.get(uri1 + "?hash=66bdc3bf4254f78c9b6f07df8ae5b888")
			.headers(headers_2)
			.resources(http("Recording_3")
			.get(uri4 + "/themes/default-bootstrap/font/fontawesome-webfont.woff?v=3.2.1")
			.headers(headers_3),
            http("Recording_4")
			.get(uri2 + "/x/oauth/status?client_id=334341610034299&input_token&origin=1&redirect_uri=http%3A%2F%2Fautomationpractice.com%2Findex.php&sdk=joey&wants_cookie_data=false")
			.headers(headers_4),
            http("Recording_5")
			.get(uri2 + "/plugins/like_box.php?app_id=334341610034299&channel=https%3A%2F%2Fstaticxx.facebook.com%2Fx%2Fconnect%2Fxd_arbiter%2F%3Fversion%3D46%23cb%3Df2da80a381c91ac%26domain%3Dautomationpractice.com%26is_canvas%3Dfalse%26origin%3Dhttp%253A%252F%252Fautomationpractice.com%252Ff224be659a3460c%26relation%3Dparent.parent&color_scheme=light&container_width=330&header=false&href=https%3A%2F%2Fwww.facebook.com%2Fprestashop&locale=en_US&sdk=joey&show_border=false&show_faces=true&stream=false")
			.headers(headers_5),
            http("Recording_6")
			.get(uri3 + "?_nc_x=2Zb73g7CVpx")
			.headers(headers_6),
            http("Recording_7")
			.get(uri4 + "/img/favicon.ico?1461205423")
			.headers(headers_7),
            http("Recording_8")
			.get(uri4 + "/img/favicon.ico?1461205423")
			.headers(headers_7)))
		.pause(3)
		.exec(http("Recording_9")
			.get("/css?family=Open+Sans:300,600&subset=latin,latin-ext")
			.resources(http("Recording_10")
			.get("https://" + uri5 + "/css?family=Open+Sans:300,600&subset=latin,latin-ext")
			.headers(headers_10)))
		.pause(2)
		.exec(http("Recording_11")
			.get(uri4 + "/themes/default-bootstrap/font/fontawesome-webfont.woff?v=3.2.1")
			.headers(headers_3))
		.pause(17)
		.exec(http("Recording_12")
			.get("/css?family=Open+Sans:300,600&subset=latin,latin-ext")
			.resources(http("Recording_13")
			.get(uri4 + "/index.php?id_category=3&controller=category")
			.headers(headers_1)))
		.pause(2)
		.exec(http("Recording_14")
			.get(uri4 + "/themes/default-bootstrap/font/fontawesome-webfont.woff?v=3.2.1")
			.headers(headers_3))
		.pause(5)
		.exec(http("Recording_15")
			.get("/css?family=Open+Sans:300,600&subset=latin,latin-ext")
			.resources(http("Recording_16")
			.get("https://" + uri5 + "/css?family=Open+Sans:300,600&subset=latin,latin-ext")
			.headers(headers_10)))
		.pause(3)
		.exec(http("Recording_17")
			.get(uri4 + "/themes/default-bootstrap/font/fontawesome-webfont.woff?v=3.2.1")
			.headers(headers_3))
		.pause(2)
		.exec(http("Recording_18")
			.get("/css?family=Open+Sans:300,600&subset=latin,latin-ext")
			.resources(http("Recording_19")
			.get("https://" + uri5 + "/css?family=Open+Sans:300,600&subset=latin,latin-ext")
			.headers(headers_10)
			.check(bodyBytes.is(RawFileBody("com/automationpractice/recording/0019_response.css")))))
		.pause(2)
		.exec(http("Recording_20")
			.get(uri4 + "/themes/default-bootstrap/font/fontawesome-webfont.woff?v=3.2.1")
			.headers(headers_3)
			.check(bodyBytes.is(RawFileBody("com/automationpractice/recording/0020_response.dat"))))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}