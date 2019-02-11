package com.example.paycellwebclient.payment.querystatu;

import com.example.paycellwebclient.payment.model.RequestHeader;
import com.example.paycellwebclient.payment.util.PaycelWebConstants;
import com.example.paycellwebclient.payment.util.UniqueIdGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QueryStatuRequestFactory {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
    private QueryStatuRequest queryStatuRequest;

    public QueryStatuRequestFactory() {
        queryStatuRequest = new QueryStatuRequest();
        queryStatuRequest.setRequestHeader(new RequestHeader());
        queryStatuRequest.setMerchantCode(PaycelWebConstants.MERCHANT_CODE);
        queryStatuRequest.getRequestHeader().setApplicationName(PaycelWebConstants.APPLICATION_NAME);
        queryStatuRequest.getRequestHeader().setApplicationPwd(PaycelWebConstants.APPLICATION_PASSWORD);
    }

    /**
     * Sets original payment reference number
     * @param originalPaymentReferenceNumber
     * @return
     */
    public QueryStatuRequestFactory setOriginalPaymentReferenceNumber(String originalPaymentReferenceNumber) {
        queryStatuRequest.setOriginalPaymentReferenceNumber(originalPaymentReferenceNumber);
        return this;
    }

    /**
     * Sets ip address information of the client
     * @param clientIPAddress
     * @return
     */
    public QueryStatuRequestFactory setClientIPAddress(String clientIPAddress) {
        queryStatuRequest.getRequestHeader().setClientIPAddress(clientIPAddress);
        return this;
    }

    private void preBuild() {
        if (queryStatuRequest.getRequestHeader().getTransactionId() == null) {
            queryStatuRequest.getRequestHeader().setTransactionId(UniqueIdGenerator.generateTransactionId());
            queryStatuRequest.getRequestHeader().setTransactionDateTime(sdf.format(new Date()));
        }
    }

    /**
     * @return builded QueryStatuRequest
     * @throws Exception thrown if OriginalPaymentReferenceNumber is not set
     */
    public QueryStatuRequest build() throws Exception {
        if (queryStatuRequest.getOriginalPaymentReferenceNumber() == null) {
            throw new Exception("OriginalPaymentReferenceNumber should be set first");
        }
        preBuild();
        return queryStatuRequest;
    }
}
