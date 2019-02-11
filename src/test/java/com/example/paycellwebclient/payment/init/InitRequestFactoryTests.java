package com.example.paycellwebclient.payment.init;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class InitRequestFactoryTests {

    InitRequestFactory initRequestFactory;

    @Before
    public void init() {
        initRequestFactory = new InitRequestFactory();
    }

    @Test
    public void shouldBuild() {
        try {
            initRequestFactory
                    .setHostAccount("xxxxxxxx@xxxx.com")
                    .setLanguage("tr")
                    .createPayment("600", "99", "NON_THREED_SECURE")
                    .addInstalmentPlan(
                            "600",
                            "1",
                            "CreditCard",
                            "BONUS");
            InitRequest initRequest = initRequestFactory.build();
            assertNotNull(initRequest);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }
}
