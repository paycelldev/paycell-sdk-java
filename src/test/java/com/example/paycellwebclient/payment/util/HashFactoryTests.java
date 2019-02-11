package com.example.paycellwebclient.payment.util;

import com.example.paycellwebclient.payment.model.InstalmentPlan;
import com.example.paycellwebclient.payment.model.Merchant;
import com.example.paycellwebclient.payment.model.Payment;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HashFactoryTests {

    @Test
    public void shouldHashCorrectly() {
        Merchant merchant = createMerchant();
        Payment payment = createPayment();

        String expectedHashCode = "aENd6OzrEzzXwaHLHwPKi5/3kom/mon3rWDzb/zXSD0=";
        String actualHashCode = HashFactory.createHash(
                merchant,
                payment,
                "xxxxxxxx@xxxx.com");

        Assert.assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    public void shouldEncodeSHA256(){
        String text = "Test";
        String expected = "Uy6qvZV0iA2/drm4zACDLCCm7BE9aCKZVQ16bg80XiU=";

        String actual = HashFactory.sha256(text);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortInstalmentPlansInAscendingOrderByLineId() {
        InstalmentPlan instalmentPlan1 = new InstalmentPlan();
        instalmentPlan1.setLineId("1");
        InstalmentPlan instalmentPlan2 = new InstalmentPlan();
        instalmentPlan2.setLineId("2");
        InstalmentPlan instalmentPlan3 = new InstalmentPlan();
        instalmentPlan3.setLineId("3");

        List<InstalmentPlan> instalmentPlans = new ArrayList<>();
        instalmentPlans.add(instalmentPlan2);
        instalmentPlans.add(instalmentPlan3);
        instalmentPlans.add(instalmentPlan1);

        instalmentPlans = HashFactory.sortByLineId(instalmentPlans);
        InstalmentPlan lastInstalmentPlan = null;
        for (InstalmentPlan instalmentPlan : instalmentPlans) {
            Assert.assertTrue(lastInstalmentPlan == null ||
                    Integer.valueOf(instalmentPlan.getLineId()) >= Integer.valueOf(lastInstalmentPlan.getLineId()));
            lastInstalmentPlan = instalmentPlan;
        }
    }

    private Payment createPayment() {
        Payment payment = new Payment();
        payment.setAmount("600");
        payment.setCurrency("99");
        payment.setPaymentReferenceNumber("e4e27be0-f88f-11e8-a63a-25ea92e7355f");
        payment.setPaymentSecurity("NON_THREED_SECURE");
        payment.setInstalmentPlan(createInstalmentPlan());
        return payment;
    }

    private ArrayList<InstalmentPlan> createInstalmentPlan() {
        ArrayList<InstalmentPlan> instalmentPlans = new ArrayList<>();
        InstalmentPlan instalmentPlan1 = new InstalmentPlan();
        instalmentPlan1.setLineId("1");
        instalmentPlan1.setAmount("600");
        instalmentPlan1.setCardBrand("BONUS");
        instalmentPlan1.setCount("1");
        instalmentPlan1.setPaymentMethodType("CreditCard");

        instalmentPlans.add(instalmentPlan1);

        return instalmentPlans;
    }

    private Merchant createMerchant() {
        Merchant merchant = new Merchant();
        merchant.setMerchantCode("1186");
        merchant.setTerminalCode("12345");
        return merchant;
    }
}
