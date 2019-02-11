package com.example.paycellwebclient.payment.querystatu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class QueryStatuRestClientTests {

	private QueryStatuRequestFactory queryStatuRequestFactory;

	@Autowired
	private QueryStatuRestClient queryStatuRestClient;

	@Before
	public void setup() {
		queryStatuRequestFactory = new QueryStatuRequestFactory();
	}

	@Test
	public void shouldQueryStatuSuccessfully() {
		try {
			QueryStatuRequest queryStatuRequest = queryStatuRequestFactory
					.setOriginalPaymentReferenceNumber("T-b8a3a0b1-d513-436a-9bf0-a731d7b5898d")
					.setClientIPAddress("10.250.171.15").build();
			QueryStatuResponse queryStatuResponse = queryStatuRestClient.queryStatu(queryStatuRequest);
			assertNotNull(queryStatuResponse);
			assertEquals("0", queryStatuResponse.getResponseHeader().getResponseCode());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
