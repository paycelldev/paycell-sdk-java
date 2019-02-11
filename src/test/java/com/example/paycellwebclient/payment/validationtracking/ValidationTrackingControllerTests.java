package com.example.paycellwebclient.payment.validationtracking;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ValidationTrackingControllerTests {

    @Autowired
    MockMvc mockMvc;

    @SpyBean
    private ValidationTrackingController validationTrackingController;

    @Test
    public void shouldHandlePostResult() {
        try {
            JSONObject request = new JSONObject();
            request.put("trackingId", "ec1b7d09f3324d0ab605464f468930a3");
            request.put("paymentMethodType", "CREDIT_CARD");
            request.put("paymentReferenceNumber", "T-43a2bbc9-ae8b-4228-839e-1ac22d3c13d2");
            request.put("isPaid", true);
            request.put("isReverse", false);
            request.put("transactionDate", "8.11.2018 14:51:48");
            request.put("amount", "100");
            request.put("isTimeoutOperation", false);
            request.put("isCancelled", false);
            request.put("transactionId", null);
            request.put("transactionDateTime", null);
            request.put("clientIPAddress", null);
            request.put("applicationName", null);
            request.put("applicationPwd", null);
            request.put("merchantCode", null);

            mockMvc.perform(post("http://localhost:8080/handlePostResult")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(request.toString())
                    .accept(MediaType.TEXT_PLAIN))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }


    @Test
    public void shouldHandleReverse() {
        try {
            JSONObject request = new JSONObject();
            request.put("trackingId", "ec1b7d09f3324d0ab605464f468930a3");
            request.put("paymentMethodType", "CREDIT_CARD");
            request.put("paymentReferenceNumber", "T-43a2bbc9-ae8b-4228-839e-1ac22d3c13d2");
            request.put("isPaid", true);
            request.put("isReverse", true);
            request.put("transactionDate", "8.11.2018 14:51:48");
            request.put("amount", "100");
            request.put("isTimeoutOperation", true);
            request.put("isCancelled", false);
            request.put("transactionId", null);
            request.put("transactionDateTime", null);
            request.put("clientIPAddress", null);
            request.put("applicationName", null);
            request.put("applicationPwd", null);
            request.put("merchantCode", null);

            mockMvc.perform(post("http://localhost:8080/handlePostResult")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(request.toString())
                    .accept(MediaType.TEXT_PLAIN))
                    .andExpect(status().isOk());
            verify(validationTrackingController).reversePayment(any());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }


    @Test
    public void shouldHandleCancel() {
        try {
            JSONObject request = new JSONObject();
            request.put("trackingId", "ec1b7d09f3324d0ab605464f468930a3");
            request.put("paymentMethodType", "CREDIT_CARD");
            request.put("paymentReferenceNumber", "T-43a2bbc9-ae8b-4228-839e-1ac22d3c13d2");
            request.put("isPaid", false);
            request.put("isReverse", false);
            request.put("transactionDate", "8.11.2018 14:51:48");
            request.put("amount", "100");
            request.put("isTimeoutOperation", false);
            request.put("isCancelled", true);
            request.put("transactionId", null);
            request.put("transactionDateTime", null);
            request.put("clientIPAddress", null);
            request.put("applicationName", null);
            request.put("applicationPwd", null);
            request.put("merchantCode", null);

            mockMvc.perform(post("http://localhost:8080/handlePostResult")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(request.toString())
                    .accept(MediaType.TEXT_PLAIN))
                    .andExpect(status().isOk());
            verify(validationTrackingController).handleCancel(any());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }


    @Test
    public void shouldHandlePaid() {
        try {
            JSONObject request = new JSONObject();
            request.put("trackingId", "ec1b7d09f3324d0ab605464f468930a3");
            request.put("paymentMethodType", "CREDIT_CARD");
            request.put("paymentReferenceNumber", "T-43a2bbc9-ae8b-4228-839e-1ac22d3c13d2");
            request.put("isPaid", true);
            request.put("isReverse", false);
            request.put("transactionDate", "8.11.2018 14:51:48");
            request.put("amount", "100");
            request.put("isTimeoutOperation", false);
            request.put("isCancelled", false);
            request.put("transactionId", null);
            request.put("transactionDateTime", null);
            request.put("clientIPAddress", null);
            request.put("applicationName", null);
            request.put("applicationPwd", null);
            request.put("merchantCode", null);

            mockMvc.perform(post("http://localhost:8080/handlePostResult")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(request.toString())
                    .accept(MediaType.TEXT_PLAIN))
                    .andExpect(status().isOk());
            verify(validationTrackingController).handlePaid(any());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
