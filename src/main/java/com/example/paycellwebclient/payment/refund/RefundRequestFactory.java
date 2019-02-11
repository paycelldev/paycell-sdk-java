package com.example.paycellwebclient.payment.refund;

import com.example.paycellwebclient.payment.model.RequestHeader;
import com.example.paycellwebclient.payment.util.PaycelWebConstants;
import com.example.paycellwebclient.payment.util.UniqueIdGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RefundRequestFactory {

    private RefundRequest refundRequest;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");

    public RefundRequestFactory() {
        refundRequest = new RefundRequest();
        refundRequest.setMerchantCode(PaycelWebConstants.MERCHANT_CODE);
        refundRequest.setReferenceNumber(PaycelWebConstants.PRE_REFERENCE_NUMBER+UniqueIdGenerator.generateUUID());

        RequestHeader requestHeader = new RequestHeader();
        requestHeader.setApplicationName(PaycelWebConstants.APPLICATION_NAME);
        requestHeader.setApplicationPwd(PaycelWebConstants.APPLICATION_PASSWORD);
        refundRequest.setRequestHeader(requestHeader);
    }

    /**
     * Sets the ip address information of the customer
     * @param clientIPAddress
     * @return this
     */
    public RefundRequestFactory setClientIPAddress(String clientIPAddress){
        refundRequest.getRequestHeader().setClientIPAddress(clientIPAddress);
        return this;
    }

    /**
     * Sets the phone number information of the customer
     * @param msisdn 10 digits phone number: 5XXXXXXXXX
     * @return this
     */
    public RefundRequestFactory setMsisdn(String msisdn){
        refundRequest.setMsisdn(msisdn);
        return this;
    }

    /**
     * Sets original reference number of the payment
     * @param originalReferenceNumber
     * @return this
     */
    public RefundRequestFactory setOriginalReferenceNumber(String originalReferenceNumber){
        refundRequest.setOriginalReferenceNumber(originalReferenceNumber);
        return this;
    }

    /**
     * Sets the refund amount for the payment
     * @param amount last 2 digits represents cois
     *               1.00 is represented as "100"
     * @return
     */
    public RefundRequestFactory setAmount(String amount){
        refundRequest.setAmount(amount);
        return this;
    }

    private void preBuild(){
        if(refundRequest.getRequestHeader().getTransactionId() == null){
            refundRequest.getRequestHeader().setTransactionId(UniqueIdGenerator.generateTransactionId());
            refundRequest.getRequestHeader().setTransactionDateTime(sdf.format(new Date()));
        }
    }

    /**
     * Builds the request
     * @return RefundRequest builded
     * @throws Exception thrown if the Original Reference Number is not set
     */
    public RefundRequest build() throws Exception {
        if(refundRequest.getOriginalReferenceNumber() == null){
            throw new Exception("OriginalReferenceNumber should be created first.");
        }
        preBuild();
        return refundRequest;
    }
}
