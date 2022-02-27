//package session2
//
//
//import java.util.Random
//
//import io.gatling.core.Predef._
//import io.gatling.core.structure.ChainBuilder
//import io.gatling.http.Predef._
//import io.gatling.jdbc.Predef._
//
//
//class DemoStore extends Simulation {
////	val domain = "demostore.gatling.io"
//
//	val baseUrl="http://demostore.gatling.io";
//   var categoryFeeder = csv("./data/categoryDetails.csv").random
//	var jsonFeederProducts =jsonFile("./data/productDetails.json").random
//	var csvFeederLoginDetails =csv("./data/logindetails.csv").circular
//
//
//	val httpProtocol = http
//		.baseUrl(baseUrl)
//		//.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
//
//
//	val rnd = new Random()
//
//	def randomString(length: Int) ={
/////		rnd.alphanumeric.filter(_.isLetter).take(length).mkString
//	}
//
//
//	val initSession =exec(flushCookieJar)
//		.exec(session =>         session.set("randomNumber", rnd.nextInt()))
//		.exec( session => session.set("customerLoggedIn", false))
//		.exec( session => session.set("cartTotal", 0.00))
//		.exec(addCookie(Cookie("sessionId", randomString(10)).withDomain(domain)))
////		.exec(session => addCookie(Cookie("sessionId", randomString(10)).withDomain(domain )))
////		.exec{
////			session  => println(session);
////				session
////		}
//
//
//
//	object  CmsPages {
//		///var a="10";
/////     <title>Gatling Demo-Store</title>
//		//<meta id="_csrf" name="_csrf" content="aebe8724-9f9e-47f8-bc2b-16c77363f520" />
//		def  homepage ={
//			exec(
//				http("T1 Load Home Page")
//					.get("/")
//					.check(status.is(200))
//					.check( regex("<title>Gatling Demo-store</title>").exists)
//					.check(css("#_csrf", "content").saveAs("csrfValue"))
////					.check(headerRegex("content-type","(.*)").saveAs(("resHeaderRegexContentTyoe")))
////					.check(header("Content-Type").saveAs("responseContentyType"))
//			)
//		}
//
//		def aboutUs:ChainBuilder ={
//			exec(
//				http("T2 Load About Us page")
//					.get("/about-us")
//					.check(substring("About Us"))
//					.check(substring("fictional / dummy eCommerce"))
//
//			)
//		}
//
//		def contact:ChainBuilder ={
//			exec(
//				http("T2 Load Contact Us page")
//					.get("/contact")
//					.check(substring("Contact Us"))
//					.check(substring("the Contact Us page "))
//
//			)
//		}
//
//		def api:ChainBuilder ={
//			exec(
//				http("T2 Load Rest API page")
//					.get("/rest-api")
//					.check(substring("Rest Api"))
//			)
//		}
//
//
////		def commonNavigation ( reqName,  path,  verificationText) ={
////			exec(
////				http(reqName)
////					.get("/" + path)
////					.check(substring(verificationText))
////			)
////
////		}
//
//
//
//	}
//
//	object Catalog{
//
//		   object Category {
//
//				 def view={
//
//           feed(categoryFeeder)
//					 .exec(
//						 http("T3 Load Catalog Page- ${categoryName}")
//						 .get("/category/${categorySlug}")
//							 .check(status.is(200))
//							 .check(css("#CategoryName").is("${categoryName}"))
//						 ///   css locator h2#CategoryName
//					 )
//
//				 }
//			 }
//
//	}
//
//
//	object Product{
//		def view={
//			feed(jsonFeederProducts)
//
//				.exec(
//				http("T4 Load Product Page - ${name}")
//					.get("/product/${slug}")
//					.check(status.is(200))
//					.check(css("#ProductDescription").is("${description}"))
//				)
//		}
//
//	def add:ChainBuilder ={
//	  exec(
//	    http("T5 Add Product to Cart")
//		     .get("/cart/add/${id}")
//				.check(substring("in your cart"))
//		)
//	}
//
//	}
//
//	object Checkout {
//
//		def viewCart ={
//			doIf(session => !session("customerLoggedIn").as[Boolean]) {
//				exec(Customer.login)
//			}
//			.exec(
//				http("T6 Load Cart Page")
//					.get("/cart/view")
//					.check(status.in(200, 302, 304))
//			)
//		}
//	}
//
//	//  _csrf=84f662b1-397b-4a47-a7a9-fa11519c8914&username=user1&password=pass
//	object Customer{
//
//		def login ={
//			feed((csvFeederLoginDetails))
//				.exec{session => println("Pringing Before customer flag is set tot true"); println(session); session}
//
//					.exec(
//						http("T7 Load Login Page")
//							.post("/login")
//							.formParam("_csrf", "${csrfValue}")
//							.formParam("username", "${username}")
//							.formParam("password", "${password}")
//							.check(status.in(200, 302, 304))
//					)
//				  .exec(session => session.set("customerLoggedIn",  true))
//				.exec{session => println("Pringing after customer flag is set tot true"); println(session); session}
//
//		}
//
//
//	}
//
//
//
//
//	val scn = scenario("DemoStore")
//		.exec(initSession)
//		.exec(CmsPages.homepage)
//		.exec(CmsPages.contact,CmsPages.aboutUs, CmsPages.homepage)
//		.pause(2)
//		.exec(CmsPages.aboutUs)
//		.pause(2)
//		.exec(CmsPages.contact)
//		.pause(2)
//		.exec(CmsPages.api)
//		.pause(2)
////		.exec(Catalog.Category.view)
////		.pause(1)
////		.exec(Catalog.Category.view)
////		.pause(1)
////		.exec(Catalog.Category.view)
////		.pause(1)
//	   .repeat(15) {
//			 exec(Catalog.Category.view)
//		 }
//		.exec(Product.view)
//		.exec(Product.add)
//		.exec(Checkout.viewCart)
//		.exec(Customer.login)
//
//
//
//
////		.pause(3)
////		.exec(http("DemoStore_4:GET_http://demostore.gatling.io/product/casual-black-blue")
////			.get("/product/casual-black-blue")
////		)
////		.pause(2)
////		.exec(http("DemoStore_5:GET_http://demostore.gatling.io/cart/add/17")
////			.get("/cart/add/17")
////		)
////		.pause(4)
////		.exec(http("DemoStore_6:GET_http://demostore.gatling.io/category/for-her")
////			.get("/category/for-her")
////		)
////		.pause(1)
////		.exec(http("DemoStore_7:GET_http://demostore.gatling.io/product/perfect-pink")
////			.get("/product/perfect-pink")
////		)
////		.pause(2)
////		.exec(http("DemoStore_8:GET_http://demostore.gatling.io/cart/add/26")
////			.get("/cart/add/26")
////		)
////		.pause(2)
////		.exec(http("DemoStore_9:GET_http://demostore.gatling.io/cart/view")
////			.get("/cart/view")
////		)
////		.pause(1)
////		.exec(http("DemoStore_10:POST_http://demostore.gatling.io/login")
////			.post("/login")
////			.formParam("_csrf", "dd9d14d8-300b-4b14-babd-df4223db30e6")
////			.formParam("username", "user1")
////			.formParam("password", "pass")
////		)
//
//	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
//}