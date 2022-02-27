package blazedemo4

import pages.{CommonVariable, Confirmation, Purchase, Reserve}
import io.gatling.core.Predef.{rampConcurrentUsers, _}


class BlazeDemo6 extends Simulation {



val scnRefactor= scenario("""Fligh Booking""" )
		.feed(CommonVariable.csvFedderBlazeDemoFilightDetails)

		.exec(Reserve.methodReserve)
		.exec(Purchase.methodPurchase)
		.exec(Confirmation.methodConfirmation)



	/*

	rampConcurrentUsers(1) to(20) during(20 minutes),
  constantConcurrentUsers(20) during (30 minutes),
  constantConcurrentUsers(nbUsers).during(duration)
  rampConcurrentUsers(20) to(1) during(20 minutes)
	 */
		setUp(scnRefactor
			.inject(
				rampConcurrentUsers(1) to (20) during(20),
				constantConcurrentUsers(20) during (20),
				rampConcurrentUsers((20)) to (1) during (20)
			)
		)
			.protocols(CommonVariable.httpProtocol)
		.maxDuration(70)


}