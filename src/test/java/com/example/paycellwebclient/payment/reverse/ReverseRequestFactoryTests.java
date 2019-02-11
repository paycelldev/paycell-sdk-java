package com.example.paycellwebclient.payment.reverse;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class ReverseRequestFactoryTests {

    ReverseRequestFactory reverseRequestFactory;

    @Before
    public void init() {
        reverseRequestFactory = new ReverseRequestFactory();
    }

    @Test
    public void shouldBuild() {
        try {
            reverseRequestFactory
                    .setOriginalPaymentReferenceNumber("33cfa1bc-1cd1-466a-8595-6b49ad4a9007")
                    .setClientIPAddress("127.0.0.1");
            ReverseRequest reverseRequest = reverseRequestFactory.build();
            assertNotNull(reverseRequest);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

}
