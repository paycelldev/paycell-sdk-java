package com.example.paycellwebclient.payment.validationtracking;

import com.example.paycellwebclient.payment.util.PaycelWebConstants;


public class ValidationTrackingRestClient {

    public static String getPaymentScreenUrl(String trackingId) {
        return String.format("%s/%s", PaycelWebConstants.VALIDATION_TRACKING_URL, trackingId);

    }
}
