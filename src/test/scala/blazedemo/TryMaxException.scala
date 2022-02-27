package blazedemo

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class TryMaxException extends Simulation {
	val httpProtocol = http
		.baseUrl("https://jsonplaceholder.typicode.com")

	val scn = scenario("BlazeDemoLoginLogout")
		.tryMax(5){
			exec(
				http("T0 GetKEYVALUE")
					.get("/todos/")
					//.check(status.is(200+scala.util.Random.nextInt((20))))  // all file times only one vale 217
					.check(
						status.is(
							session=>200+scala.util.Random.nextInt((20)
						)
					)
					)
			)

		}.exitHereIfFailed

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}

