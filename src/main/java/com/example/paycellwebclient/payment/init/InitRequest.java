package com.example.paycellwebclient.payment.init;

import com.example.paycellwebclient.payment.model.Payment;

/**
 * Request model for Paycell Web SDK init method
 */
public class InitRequest {

    /**
     * Header information of the request
     */
    private InitRequestHeader requestHeader;

    /**
     * Turkcell Hızlı Giriş parameters
     */
    private McParameters mcParameters;

    /**
     * Hash information of the data, encoded in base64
     * Calculated as combination of methods:
     * - securityData = Sha256(SecureCode + TerminalCode)
     * - hashData = Sha256(paymentReferenceNumber + terminalCode + amount + currency
     * + paymentSecurity + hostAccount + securityData)
     */
    private String hashData;

    /**
     * Represents account of the customer that pays the merchant.
     * If email address of the customer address is used for authentication in merchant system,
     * email address information may be sent in this attribute
     */
    private String hostAccount;

    /**
     * Language information tr/en
     */
    private String language;

    /**
     * Payment information
     */
    private Payment payment;

    /**
     * Represents the url that the customer will be redirected after the payment operation
     */
    private String returnUrl;

    /**
     * Represents the url that the result information and status will be sent after payment operation.
     * The data will be sent in json format.
     */
    private String postResultUrl;

    /**
     * Represents the time limit of payment that is given by the merchant to the customer.
     */
    private String timeoutDuration;

    public InitRequestHeader getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(InitRequestHeader requestHeader) {
        this.requestHeader = requestHeader;
    }

    public String getHashData() {
        return hashData;
    }

    public void setHashData(String hashData) {
        this.hashData = hashData;
    }

    public String getHostAccount() {
        return hostAccount;
    }

    public void setHostAccount(String hostAccount) {
        this.hostAccount = hostAccount;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getPostResultUrl() {
        return postResultUrl;
    }

    public void setPostResultUrl(String postResultUrl) {
        this.postResultUrl = postResultUrl;
    }

    public String getTimeoutDuration() {
        return timeoutDuration;
    }

    public void setTimeoutDuration(String timeoutDuration) {
        this.timeoutDuration = timeoutDuration;
    }

	public McParameters getMcParameters() {
		return mcParameters;
	}

	public void setMcParameters(McParameters mcParameters) {
		this.mcParameters = mcParameters;
	}
}
