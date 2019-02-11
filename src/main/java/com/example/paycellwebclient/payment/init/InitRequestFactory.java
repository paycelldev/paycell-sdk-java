package com.example.paycellwebclient.payment.init;

import com.example.paycellwebclient.payment.model.*;
import com.example.paycellwebclient.payment.util.HashFactory;
import com.example.paycellwebclient.payment.util.PaycelWebConstants;
import com.example.paycellwebclient.payment.util.UniqueIdGenerator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InitRequestFactory {

    private static final String IS_MC_SESSION_TRUE_VALUE = "Y";
	private static final String IS_MC_SESSION_FALSE_VALUE = "N";
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private InitRequest initRequest;

    public InitRequestFactory() {
        initializeRequest();
    }

    /**
     * Sets Turkcell Hızlı Giriş parameters
     * if the customer is logged in. Easy payment will be provided.
     * @param mcPhoneNumber phone number of the customer without country code, 5XXXXXXXXX
     * @param mcPhoneCountry country code of the customer phone number
     * @param mcAuthToken Turkcell Hızlı Giriş authorization token
     * @return this
     */
    public InitRequestFactory setMcParameters(String mcPhoneNumber, String mcPhoneCountry, String mcAuthToken) {
    	McParameters mcParameters = initRequest.getMcParameters();
    	mcParameters.setIsMcSession(IS_MC_SESSION_TRUE_VALUE);
    	mcParameters.setMcPhoneNumber(mcPhoneNumber);
    	mcParameters.setMcPhoneCountry(mcPhoneCountry);
    	mcParameters.setMcAuthToken(mcAuthToken);
    	return this;
    }

    /**
     * Sets host account information, used in fast login
     *
     * @param hostAccount credential of the customer in merchant system, email address may be used.
     * @return InitRequestFactory
     */
    public InitRequestFactory setHostAccount(String hostAccount) {
        initRequest.setHostAccount(hostAccount);
        return this;
    }

    /**
     * Sets language information
     *
     * @param language tr/en
     * @return InitRequestFactory
     */
    public InitRequestFactory setLanguage(String language) {
        initRequest.setLanguage(language);
        return this;
    }

    /**
     * Sets return url, customer is redirected to the url after payment operation
     *
     * @param returnUrl url information
     * @return InitRequestFactory
     */
    public InitRequestFactory setReturnUrl(String returnUrl) {
        initRequest.setReturnUrl(returnUrl);
        return this;
    }

    /**
     * Sets post result url, operation result is posted into this url in json format
     *
     * @param postResultUrl url information
     * @return InitRequestFactory
     */
    public InitRequestFactory setPostResultUrl(String postResultUrl) {
        initRequest.setPostResultUrl(postResultUrl);
        return this;
    }

    /**
     * Sets time limit for payment
     *
     * @param duration in seconds
     * @return InitRequestFactory
     */
    public InitRequestFactory setTimeoutDuration(String duration) {
        initRequest.setTimeoutDuration(duration);
        return this;
    }

    /**
     * Creates payment
     *
     * @param amount          total amount of the payment in advance
     * @param currency        99 for TL
     * @param paymentSecurity Security method for credit cards: THREED_SECURE, NON_THREED_SECURE
     * @return InitRequestFactory
     */
    public InitRequestFactory createPayment(String amount, String currency, String paymentSecurity) {
        Payment payment = new Payment();
        payment.setAmount(amount);
        payment.setCurrency(currency);
        payment.setPaymentSecurity(paymentSecurity);
        payment.setInstalmentPlan(new ArrayList<>());
        initRequest.setPayment(payment);
        return this;
    }

    /**
     * @param amount            instalment amount
     * @param count             instalment count, "1" if it is pay in advance
     * @param paymentMethodType payment method type: CREDIT_CARD, DCB
     * @param cardBrand         Card Brand Partnership: BONUS, WORLD, CARDFINANS, AXESS, ADVANTAGE, PARAF, MAXIMUM
     * @return InitRequestFactory
     * @throws Exception is thrown if no payment is created. @createPayment
     */
    public InitRequestFactory addInstalmentPlan(String amount, String count, String paymentMethodType, String cardBrand) throws Exception {
        validatePaymentAdded();
        InstalmentPlan instalmentPlan = new InstalmentPlan();
        int instalmentPlanCount = initRequest.getPayment().getInstalmentPlan().size();
        instalmentPlan.setLineId(String.valueOf(instalmentPlanCount + 1));
        instalmentPlan.setAmount(amount);
        instalmentPlan.setCount(count);
        instalmentPlan.setPaymentMethodType(paymentMethodType);
        instalmentPlan.setCardBrand(cardBrand);
        initRequest.getPayment().getInstalmentPlan().add(instalmentPlan);
        return this;
    }

    /**
     * Builds init request
     *
     * @return an init request
     * @throws Exception thrown if no payment is created or no instalment plan is added.
     */
    public InitRequest build() throws Exception {
        validateBuild();
        preBuild();
        return initRequest;
    }

    private void preBuild() {
        stampTransaction();
        initRequest.getPayment().setPaymentReferenceNumber( UniqueIdGenerator.generateUUID());
        initRequest.setHashData(
                HashFactory.createHash(
                        initRequest.getRequestHeader().getMerchant(),
                        initRequest.getPayment(),
                        initRequest.getHostAccount()));
    }

    private void stampTransaction() {
        TransactionInfo transactionInfo = new TransactionInfo();
        transactionInfo.setTransactionDateTime(sdf.format(new Date()));
        transactionInfo.setTransactionId(UniqueIdGenerator.generateTransactionId());
        initRequest.getRequestHeader().setTransactionInfo(transactionInfo);
    }

    private void initializeRequest() {
        initRequest = new InitRequest();
        initRequest.setRequestHeader(createRequestHeader());

        McParameters mcParameters = new McParameters();
        mcParameters.setIsMcSession(IS_MC_SESSION_FALSE_VALUE);
		initRequest.setMcParameters(mcParameters);
    }

    private void validateBuild() throws Exception {
        validatePaymentAdded();
        if (initRequest.getPayment().getInstalmentPlan().isEmpty()) {
            throw new Exception("An instalment plan should be added first");
        }
    }

    private void validatePaymentAdded() throws Exception {
        if (initRequest.getPayment() == null) {
            throw new Exception("A payment should be created first");
        }
    }

    private InitRequestHeader createRequestHeader() {
        InitRequestHeader requestHeader = new InitRequestHeader();
        requestHeader.setMerchant(createMerchant());
        requestHeader.setApplicationName(PaycelWebConstants.APPLICATION_NAME);
        requestHeader.setApplicationPassword(PaycelWebConstants.APPLICATION_PASSWORD);
        return requestHeader;
    }

    private Merchant createMerchant() {
        Merchant merchant = new Merchant();
        merchant.setMerchantCode(PaycelWebConstants.MERCHANT_CODE);
        merchant.setTerminalCode(PaycelWebConstants.TERMINAL_CODE);
        return merchant;
    }
}
