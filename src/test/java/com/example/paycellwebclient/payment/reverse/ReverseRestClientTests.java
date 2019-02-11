package com.example.paycellwebclient.payment.reverse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.paycellwebclient.payment.init.InitRequest;
import com.example.paycellwebclient.payment.init.InitRequestFactory;
import com.example.paycellwebclient.payment.init.InitResponse;
import com.example.paycellwebclient.payment.init.InitRestClient;
import com.example.paycellwebclient.payment.util.PaycelWebConstants;
import com.example.paycellwebclient.payment.validationtracking.ValidationTrackingRestClient;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReverseRestClientTests {

	private ReverseRequestFactory reverseRequestFactory;

	private InitRequestFactory initRequestFactory;

	@Autowired
	private InitRestClient initRestClient;

	@Autowired
	private ReverseRestClient reverseRestClient;

	@Before
	public void setup() {
		reverseRequestFactory = new ReverseRequestFactory();
		initRequestFactory = new InitRequestFactory();
	}

	@Test
	@Ignore
	public void shouldReverseReturnSuccess() {
		try {
			reverseRequestFactory.setOriginalPaymentReferenceNumber("T-f434d2aa-98f4-46b9-b35c-1da212504b5e")
					.setClientIPAddress("10.250.171.15").setMsisdn("905465553333");
			ReverseRequest reverseRequest = reverseRequestFactory.build();
			ReverseResponse reverseResponse = reverseRestClient.reverse(reverseRequest);
			assertEquals(reverseResponse.getResponseHeader().getResponseDescription(), "Success");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	@Ignore
	public void testUseCase() {
		try {
			initRequestFactory.setHostAccount("xxxxxxxx@xxxx.com").setLanguage("tr")
					.createPayment("600", "99", "NON_THREED_SECURE")
					.addInstalmentPlan("600", "1", "CREDIT_CARD", "BONUS")
					.setPostResultUrl(PaycelWebConstants.POST_RESULT_URL).setReturnUrl("www.google.com")
					.setTimeoutDuration("300");
			InitRequest initRequest = initRequestFactory.build();
			InitResponse initResponse = initRestClient.init(initRequest);
			String paymentScreenUrl = ValidationTrackingRestClient.getPaymentScreenUrl(initResponse.getTrackingId());

			reverseRequestFactory
					.setOriginalPaymentReferenceNumber(initRequest.getPayment().getPaymentReferenceNumber())
					.setClientIPAddress("10.250.171.15").setMsisdn("905465553333");
			ReverseRequest reverseRequest = reverseRequestFactory.build();
			ReverseResponse reverseResponse = reverseRestClient.reverse(reverseRequest);
			assertEquals(reverseResponse.getResponseHeader().getResponseDescription(), "Success");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
