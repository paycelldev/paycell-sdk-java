package com.example.paycellwebclient.payment.querystatu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class QueryStatuRequestFactoryTests {

    private QueryStatuRequestFactory queryStatuRequestFactory;

    @Before
    public void setup() {
        queryStatuRequestFactory = new QueryStatuRequestFactory();
    }

    @Test
    public void shouldBuildSuccessfully() {
        try {
            String originalPaymentReferenceNumber = "T-f434d2aa-98f4-46b9-b35c-1da212504b5e";
            String clientIPAddress = "10.250.171.15";
            QueryStatuRequest request = queryStatuRequestFactory.setOriginalPaymentReferenceNumber(originalPaymentReferenceNumber)
                    .setClientIPAddress(clientIPAddress)
                    .build();
            assertNotNull(request);
            assertEquals(originalPaymentReferenceNumber, request.getOriginalPaymentReferenceNumber());
            assertEquals(clientIPAddress, request.getRequestHeader().getClientIPAddress());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
