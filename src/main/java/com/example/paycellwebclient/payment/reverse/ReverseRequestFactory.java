package com.example.paycellwebclient.payment.reverse;

import com.example.paycellwebclient.payment.model.RequestHeader;
import com.example.paycellwebclient.payment.util.PaycelWebConstants;
import com.example.paycellwebclient.payment.util.UniqueIdGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReverseRequestFactory {

    private ReverseRequest reverseRequest;

    private SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");

    public ReverseRequestFactory() {
        reverseRequest = new ReverseRequest();
        reverseRequest.setRequestHeader(new RequestHeader());
        reverseRequest.setReferenceNumber(PaycelWebConstants.PRE_REFERENCE_NUMBER+UniqueIdGenerator.generateUUID());
        reverseRequest.setMerchantCode(PaycelWebConstants.MERCHANT_CODE);
        reverseRequest.getRequestHeader().setApplicationName(PaycelWebConstants.APPLICATION_NAME);
        reverseRequest.getRequestHeader().setApplicationPwd(PaycelWebConstants.APPLICATION_PASSWORD);
    }

    /**
     * Sets the original payment reference number of the payment to be reversed
     * @param originalPaymentReferenceNumber
     * @return this
     */
    public ReverseRequestFactory setOriginalPaymentReferenceNumber(String originalPaymentReferenceNumber){
        reverseRequest.setOriginalReferenceNumber(originalPaymentReferenceNumber);
        return this;
    }

    /**
     * Sets the IP address information of the customer
     * @param clientIPAddress
     * @return
     */
    public ReverseRequestFactory setClientIPAddress(String clientIPAddress){
        reverseRequest.getRequestHeader().setClientIPAddress(clientIPAddress);
        return this;
    }

    /**
     * Sets phone number of the customer
     * @param msisdn phone number of the customer, 10 Digits: 5XXXXXXXXX
     */
    public ReverseRequestFactory setMsisdn(String msisdn) {
        reverseRequest.setMsisdn(msisdn);
        return this;
    }

    /**
     * Builds ReverseRequest
     * @return builded ReverseRequest
     * @throws Exception thrown if OriginalReferenceNumber is not set
     */
    public ReverseRequest build() throws Exception {
        if(reverseRequest.getOriginalReferenceNumber() == null){
            throw new Exception("OriginalReferenceNumber must be set first");
        }
        preBuild();
        return reverseRequest;
    }

    private void preBuild(){
        if(reverseRequest.getRequestHeader().getTransactionId() == null){
            reverseRequest.getRequestHeader().setTransactionDateTime(sdf.format(new Date()));
            reverseRequest.getRequestHeader().setTransactionId(UniqueIdGenerator.generateTransactionId());
        }
    }

}
