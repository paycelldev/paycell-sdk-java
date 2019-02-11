package com.example.paycellwebclient.payment.refund;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class RefundRequestFactoryTests {

    private RefundRequestFactory refundRequestFactory;

    @Before
    public void setup(){
        refundRequestFactory = new RefundRequestFactory();
    }

    @Test
    public void shouldBuildSuccessfully(){
        try {
            String originalReferenceNumber = "T-33cfa1bc-1cd1-466a-8595-6b49ad4a9007";
            String msisdn = "5465553333";
            String amount = "100";
            RefundRequest request = refundRequestFactory
                    .setOriginalReferenceNumber(originalReferenceNumber)
                    .setMsisdn(msisdn)
                    .setAmount(amount)
                    .setClientIPAddress(null)
                    .build();
            assertNotNull(request);
            assertEquals(originalReferenceNumber, request.getOriginalReferenceNumber());
            assertEquals(msisdn, request.getMsisdn());
            assertEquals(amount, request.getAmount());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }
}
