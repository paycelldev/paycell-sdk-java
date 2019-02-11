package com.example.paycellwebclient.payment.service;

import com.example.paycellwebclient.payment.ui.model.viewdto.InstalmentPlanViewDto;
import com.example.paycellwebclient.payment.ui.model.viewdto.MetaDataViewDto;
import com.example.paycellwebclient.payment.ui.model.viewdto.PaymentViewDto;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentServiceTests {

    @Autowired
    PaymentService paymentService;

    @Test
    public void shouldInitPayment(){
        MetaDataViewDto metaDataViewDto = new MetaDataViewDto();
        metaDataViewDto.setHostAccount("xxxxxx@xxxx.com");
        metaDataViewDto.setLanguage("tr");

        PaymentViewDto paymentViewDto = new PaymentViewDto();
        paymentViewDto.setAmount("600");
        paymentViewDto.setCurrency("99");
        paymentViewDto.setPaymentSecurity("NON_THREED_SECURE");

        InstalmentPlanViewDto instalmentPlanViewDto = new InstalmentPlanViewDto();
        instalmentPlanViewDto.setAmount("600");
        instalmentPlanViewDto.setCount("1");
        instalmentPlanViewDto.setPaymentMethodType("CREDIT_CARD");
        instalmentPlanViewDto.setCardBrand("BONUS");
        paymentViewDto.getInstalmentPlans().add(instalmentPlanViewDto);

        try {
            String paymentScreenUrl = paymentService.initPayment(metaDataViewDto, paymentViewDto);
            assertNotNull(paymentScreenUrl);
            assertNotNull(paymentViewDto.getPaymentReferenceNumber());
            URL url = new URL(paymentScreenUrl);
            assertNotNull(url);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @Ignore
    public void shouldReversePayment(){
        MetaDataViewDto metaDataViewDto = new MetaDataViewDto();
        metaDataViewDto.setMsisdn("905465553333");
        metaDataViewDto.setClientIPAddress("10.250.171.15");

        PaymentViewDto paymentViewDto = new PaymentViewDto();
        paymentViewDto.setPaymentReferenceNumber("T-f434d2aa-98f4-46b9-b35c-1da212504b5e");

        try {
            String approvalCode = paymentService.reversePayment(metaDataViewDto, paymentViewDto);
            assertNotNull(approvalCode);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    @Test
    @Ignore
    public void shouldRefundPayment(){
        MetaDataViewDto metaDataViewDto = new MetaDataViewDto();
        metaDataViewDto.setMsisdn("905465553333");
        metaDataViewDto.setClientIPAddress("10.250.171.15");

        PaymentViewDto paymentViewDto = new PaymentViewDto();
        paymentViewDto.setPaymentReferenceNumber("T-f434d2aa-98f4-46b9-b35c-1da212504b5e");

        try {
            String approvalCode = paymentService.refundPayment(metaDataViewDto, paymentViewDto, "1");
            assertNotNull(approvalCode);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

}
