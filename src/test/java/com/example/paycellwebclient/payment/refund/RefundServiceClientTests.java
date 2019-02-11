package com.example.paycellwebclient.payment.refund;

import com.example.paycellwebclient.payment.init.InitRequest;
import com.example.paycellwebclient.payment.init.InitRequestFactory;
import com.example.paycellwebclient.payment.init.InitResponse;
import com.example.paycellwebclient.payment.init.InitRestClient;
import com.example.paycellwebclient.payment.util.PaycelWebConstants;
import com.example.paycellwebclient.payment.validationtracking.ValidationTrackingRestClient;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RefundServiceClientTests {

    private RefundRequestFactory refundRequestFactory;
    private InitRequestFactory initRequestFactory;

    @Autowired
	private InitRestClient initRestClient;

    @Autowired
	private RefundRestClient refundRestClient;

    @Before
    public void setup() {
        refundRequestFactory = new RefundRequestFactory();
        initRequestFactory = new InitRequestFactory();
    }

    @Test
    @Ignore
    public void shouldRefundSuccessfully() {
        try {
            RefundRequest refundRequest = refundRequestFactory
                    .setOriginalReferenceNumber("T-f434d2aa-98f4-46b9-b35c-1da212504b5e")
                    .setMsisdn("905465553333")
                    .setAmount("100")
                    .setClientIPAddress("10.250.171.15")
                    .build();
            RefundResponse refundResponse = refundRestClient.refund(refundRequest);
            assertNotNull(refundResponse);
            assertEquals("0", refundResponse.getResponseHeader().getResponseCode());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @Ignore
    public void testUseCase() {
        try {
            initRequestFactory
                    .setHostAccount("xxxxxxxx@xxxx.com")
                    .setLanguage("tr")
                    .createPayment("600", "99", "NON_THREED_SECURE")
                    .addInstalmentPlan(
                            "600",
                            "1",
                            "CREDIT_CARD",
                            "BONUS")
                    .setPostResultUrl(PaycelWebConstants.POST_RESULT_URL)
                    .setReturnUrl("www.google.com")
                    .setTimeoutDuration("300");
            InitRequest initRequest = initRequestFactory.build();
            InitResponse initResponse = initRestClient.init(initRequest);
            String paymentScreenUrl = ValidationTrackingRestClient.getPaymentScreenUrl(initResponse.getTrackingId());

            RefundRequest refundRequest = refundRequestFactory
                    .setOriginalReferenceNumber(initRequest.getPayment().getPaymentReferenceNumber())
                    .setMsisdn("905465553333")
                    .setClientIPAddress("10.250.171.15")
                    .setAmount(initRequest.getPayment().getAmount())
                    .build();
            RefundResponse refundResponse = refundRestClient .refund(refundRequest);
            assertNotNull(refundResponse);
            assertEquals("0", refundResponse.getResponseHeader().getResponseCode());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
