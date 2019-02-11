package com.example.paycellwebclient.payment.init;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.paycellwebclient.payment.util.PaycelWebConstants;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InitRestClientTests {

	private InitRequestFactory initRequestFactory;

	@Autowired
	private InitRestClient initRestClient;

	@Before
	public void setup() {
		initRequestFactory = new InitRequestFactory();
	}

	@Test
	public void shouldInitReturnSuccess() {
		try {
			initRequestFactory.setHostAccount("xxxxxxxx@xxxx.com").setLanguage("tr")
					.createPayment("600", "99", "NON_THREED_SECURE")
					.addInstalmentPlan("600", "1", "CREDIT_CARD", "BONUS")
					.setPostResultUrl(PaycelWebConstants.POST_RESULT_URL).setReturnUrl("www.google.com")
					.setTimeoutDuration("300");
			InitRequest initRequest = initRequestFactory.build();
			InitResponse initResponse = initRestClient.init(initRequest);
			assertEquals(initResponse.getMessage(), "Success");
			System.out.println("trackingId: " + initResponse.getTrackingId());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
