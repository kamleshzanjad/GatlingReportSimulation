package blazedemo

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class JsonResponseSaveKEYValue extends Simulation {
	val httpProtocol = http
		.baseUrl("https://jsonplaceholder.typicode.com")

	val scn = scenario("BlazeDemoLoginLogout")
		.exec(
			http("T0 GetKEYVALUE")
				.get("/todos/")
				.check(
					jsonPath("$[2,3]").findAll.optional.saveAs("jsonKEYVALUE1")
				)
		)
		.exec(
			session =>{
				println("Printing json Key value pair")
				println(session("jsonKEYVALUE1"))
				session;
			}
		)
	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}