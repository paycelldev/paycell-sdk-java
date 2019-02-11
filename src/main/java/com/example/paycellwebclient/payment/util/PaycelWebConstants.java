package com.example.paycellwebclient.payment.util;

public class PaycelWebConstants {

    public static final String MERCHANT_CODE = "1186";
    public static final String SECURE_CODE = "r92txmtCw8M0";
    public static final String TERMINAL_CODE = "12345";

    public static final String APPLICATION_NAME = "PORTALTEST";
    public static final String APPLICATION_PASSWORD = "ZDyXmMLWE2z7OzJU";

    public static final String INIT_URL = "https://sdk-services-test.turkcell.com.tr/api/Session/Init";
    public static final String VALIDATION_TRACKING_URL = "https://sdk-services-test.turkcell.com.tr/Validation/Tracking";
    public static final String REVERSE_URL = "https://tpay-test.turkcell.com.tr/tpay/provision/services/cancelrestful/cancelService/reversePayment";
    public static final String REFUND_URL = "https://tpay-test.turkcell.com.tr/tpay/provision/services/cancelrestful/cancelService/refundPayment";
    public static final String QUERY_STATU_URL = "https://tpay-test.turkcell.com.tr/tpay/provision/services/cancelrestful/cancelService/queryPaymentStatus";


    public static final String POST_RESULT_URL = "http://10.250.171.15:8080/handlePostResult";
    public static final String RETURN_URL = "http://10.250.171.15:8080/checkStatus.jsf";
    public static final String PRE_REFERENCE_NUMBER = "001";

    public static final Integer SUCCESS_CODE = 0;
}
