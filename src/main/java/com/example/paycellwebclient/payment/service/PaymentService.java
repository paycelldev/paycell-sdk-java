package com.example.paycellwebclient.payment.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.paycellwebclient.payment.init.InitRequest;
import com.example.paycellwebclient.payment.init.InitRequestFactory;
import com.example.paycellwebclient.payment.init.InitResponse;
import com.example.paycellwebclient.payment.init.InitRestClient;
import com.example.paycellwebclient.payment.model.ResponseHeader;
import com.example.paycellwebclient.payment.querystatu.QueryStatuRequest;
import com.example.paycellwebclient.payment.querystatu.QueryStatuRequestFactory;
import com.example.paycellwebclient.payment.querystatu.QueryStatuResponse;
import com.example.paycellwebclient.payment.querystatu.QueryStatuRestClient;
import com.example.paycellwebclient.payment.refund.RefundRequest;
import com.example.paycellwebclient.payment.refund.RefundRequestFactory;
import com.example.paycellwebclient.payment.refund.RefundResponse;
import com.example.paycellwebclient.payment.refund.RefundRestClient;
import com.example.paycellwebclient.payment.reverse.ReverseRequest;
import com.example.paycellwebclient.payment.reverse.ReverseRequestFactory;
import com.example.paycellwebclient.payment.reverse.ReverseResponse;
import com.example.paycellwebclient.payment.reverse.ReverseRestClient;
import com.example.paycellwebclient.payment.ui.model.viewdto.InstalmentPlanViewDto;
import com.example.paycellwebclient.payment.ui.model.viewdto.MetaDataViewDto;
import com.example.paycellwebclient.payment.ui.model.viewdto.PaymentViewDto;
import com.example.paycellwebclient.payment.ui.model.viewdto.QueryStatuViewDto;
import com.example.paycellwebclient.payment.util.PaycelWebConstants;
import com.example.paycellwebclient.payment.validationtracking.ValidationTrackingRestClient;

@Component
public class PaymentService {

	Logger logger = Logger.getLogger(PaymentService.class);

	@Autowired
	private InitRestClient initRestClient;

	@Autowired
	private QueryStatuRestClient queryStatuRestClient;

	@Autowired
	private ReverseRestClient reverseRestClient;

	@Autowired
	private RefundRestClient refundRestClient;

	/**
	 * Initialize payment
	 *
	 * @param metaDataViewDto
	 *            language, host account information is used
	 * @param paymentViewDto
	 *            payment data is used
	 * @return payment screen url
	 * @throws Exception
	 *             thrown if payment could not be initialized
	 */
	public String initPayment(MetaDataViewDto metaDataViewDto, PaymentViewDto paymentViewDto) throws Exception {
		InitResponse initResponse = sendInitPaymentRequest(metaDataViewDto, paymentViewDto);
		if (isInitResponseSuccessfull(initResponse)) {
			return ValidationTrackingRestClient.getPaymentScreenUrl(initResponse.getTrackingId());
		} else if (initResponseContainsStatusInfo(initResponse)) {
			String errorMessage = String.format("Init payment was not successful: [%s] %s",
					initResponse.getStatusCode(), initResponse.getMessage());
			logger.error(errorMessage);
			throw new Exception(errorMessage);
		} else {
			String errorMessage = "Init payment was not successful, status info is empty";
			logger.error(errorMessage);
			throw new Exception(errorMessage);
		}
	}

	private boolean initResponseContainsStatusInfo(InitResponse initResponse) {
		return initResponse.getStatusCode() != null;
	}

	private boolean isInitResponseSuccessfull(InitResponse initResponse) {
		return initResponse.getStatusCode() != null
				&& Integer.valueOf(initResponse.getStatusCode()).equals(PaycelWebConstants.SUCCESS_CODE);
	}

	private InitResponse sendInitPaymentRequest(MetaDataViewDto metaDataViewDto, PaymentViewDto paymentViewDto)
			throws Exception {
		InitRequestFactory initRequestFactory = new InitRequestFactory();

		initRequestFactory.setPostResultUrl(PaycelWebConstants.POST_RESULT_URL)
				.setReturnUrl(PaycelWebConstants.RETURN_URL).setTimeoutDuration("300")
				.setLanguage(metaDataViewDto.getLanguage()).setHostAccount(metaDataViewDto.getHostAccount())
				.createPayment(paymentViewDto.getAmount(), paymentViewDto.getCurrency(),
						paymentViewDto.getPaymentSecurity());

		for (InstalmentPlanViewDto instalmentPlanViewDto : paymentViewDto.getInstalmentPlans()) {
			initRequestFactory.addInstalmentPlan(instalmentPlanViewDto.getAmount(), instalmentPlanViewDto.getCount(),
					instalmentPlanViewDto.getPaymentMethodType(), instalmentPlanViewDto.getCardBrand());
		}
		InitRequest initRequest = initRequestFactory.build();

		paymentViewDto.setPaymentReferenceNumber(initRequest.getPayment().getPaymentReferenceNumber());
		initRequest.setReturnUrl(PaycelWebConstants.RETURN_URL + "?paymentReferenceNumber="
				+ paymentViewDto.getPaymentReferenceNumber());

		InitResponse initResponse = initRestClient.init(initRequest);

		return initResponse;
	}

	public String reversePayment(MetaDataViewDto metaData, PaymentViewDto payment) throws Exception {
		ReverseRequestFactory reverseRequestFactory = new ReverseRequestFactory();
		ReverseRequest reverseRequest = reverseRequestFactory
				.setOriginalPaymentReferenceNumber(payment.getPaymentReferenceNumber()).setMsisdn(metaData.getMsisdn())
				.setClientIPAddress(metaData.getClientIPAddress()).build();

		ReverseResponse reverseResponse = reverseRestClient .reverse(reverseRequest);

		if (isResponseHeaderSuccess(reverseResponse.getResponseHeader())) {
			return reverseResponse.getApprovalCode();

		} else if (responseHeaderContainsResultInfo(reverseResponse.getResponseHeader())) {
			String errorMessage = String.format("Reverse payment was not successful: [%s], %s",
					reverseResponse.getResponseHeader().getResponseCode(),
					reverseResponse.getResponseHeader().getResponseDescription());
			logger.error(errorMessage);
			throw new Exception(errorMessage);

		} else {
			String errorMessage = String.format("Reverse payment was not successful, response status info is empty.");
			logger.error(errorMessage);
			throw new Exception(errorMessage);

		}
	}

	public String refundPayment(MetaDataViewDto metaData, PaymentViewDto payment, String refundAmount)
			throws Exception {
		RefundRequestFactory refundRequestFactory = new RefundRequestFactory();
		RefundRequest refundRequest = refundRequestFactory
				.setOriginalReferenceNumber(payment.getPaymentReferenceNumber()).setAmount(refundAmount)
				.setClientIPAddress(metaData.getClientIPAddress()).setMsisdn(metaData.getMsisdn()).build();

		RefundResponse refundResponse = refundRestClient .refund(refundRequest);

		ResponseHeader responseHeader = refundResponse.getResponseHeader();
		if (isResponseHeaderSuccess(responseHeader)) {
			return refundResponse.getApprovalCode();

		} else if (responseHeaderContainsResultInfo(responseHeader)) {
			String errorMessage = String.format("Refund payment was not successful: [%s], %s",
					refundResponse.getResponseHeader().getResponseCode(),
					refundResponse.getResponseHeader().getResponseDescription());
			logger.error(errorMessage);
			throw new Exception(errorMessage);

		} else {
			String errorMessage = String.format("Refund payment was not successful, response status info is empty.");
			logger.error(errorMessage);
			throw new Exception(errorMessage);
		}
	}

	private boolean responseHeaderContainsResultInfo(ResponseHeader responseHeader) {
		return responseHeader.getResponseCode() != null;
	}

	private boolean isResponseHeaderSuccess(ResponseHeader responseHeader) {
		return responseHeader.getResponseCode() != null && Integer.valueOf(responseHeader.getResponseCode()) == 0;
	}

	public QueryStatuViewDto queryPayment(MetaDataViewDto metaData, PaymentViewDto paymentViewDto) throws Exception {
		QueryStatuRequest queryStatuRequest = new QueryStatuRequestFactory()
				.setOriginalPaymentReferenceNumber(paymentViewDto.getPaymentReferenceNumber())
				.setClientIPAddress(metaData.getClientIPAddress()).build();

		QueryStatuResponse queryStatuResponse = queryStatuRestClient .queryStatu(queryStatuRequest);

		if (isResponseHeaderSuccess(queryStatuResponse.getResponseHeader())) {
			return createQueryStatuViewDto(queryStatuResponse);

		} else if (responseHeaderContainsResultInfo(queryStatuResponse.getResponseHeader())) {
			String errorMessage = String.format("Query Status of Payment was not successful: [%s], %s",
					queryStatuResponse.getResponseHeader().getResponseCode(),
					queryStatuResponse.getResponseHeader().getResponseDescription());
			logger.error(errorMessage);
			throw new Exception(errorMessage);

		} else {
			String errorMessage = String
					.format("Query Status of Payment was not successful, response status info is empty.");
			logger.error(errorMessage);
			throw new Exception(errorMessage);

		}
	}

	private QueryStatuViewDto createQueryStatuViewDto(QueryStatuResponse queryStatuResponse) {
		QueryStatuViewDto queryStatuViewDto = new QueryStatuViewDto();

		queryStatuViewDto.setExtraParameters(queryStatuResponse.getExtraParameters());
		queryStatuViewDto.setAmount(queryStatuResponse.getAmount());
		queryStatuViewDto.setCurrency(queryStatuResponse.getCurrency());
		queryStatuViewDto.setInstallmentCount(queryStatuResponse.getInstallmentCount());
		queryStatuViewDto.setAcquirerbankCode(queryStatuResponse.getAcquirerbankCode());
		queryStatuViewDto.setIssuerBankCode(queryStatuResponse.getIssuerBankCode());
		queryStatuViewDto.setApprovalCode(queryStatuResponse.getApprovalCode());
		queryStatuViewDto.setMsisdn(queryStatuResponse.getMsisdn());
		queryStatuViewDto.setOrderId(queryStatuResponse.getOrderId());
		queryStatuViewDto.setPaymentReferenceNumber(queryStatuResponse.getPaymentReferenceNumber());
		queryStatuViewDto.setPaymentDate(queryStatuResponse.getPaymentDate());
		queryStatuViewDto.setPaymentSecurity(queryStatuResponse.getPaymentSecurity());
		queryStatuViewDto.setReconcilationDate(queryStatuResponse.getReconcilationDate());
		queryStatuViewDto.setStatus(queryStatuResponse.getStatus());
		queryStatuViewDto.setStatusExplanation(queryStatuResponse.getStatusExplanation());
		queryStatuViewDto.setPaymentMethodId(queryStatuResponse.getPaymentMethod().getPaymentMethodId());
		queryStatuViewDto.setPaymentMethodNumber(queryStatuResponse.getPaymentMethod().getPaymentMethodNumber());
		queryStatuViewDto.setPaymentMethodType(queryStatuResponse.getPaymentMethod().getPaymentMethodType());

		return queryStatuViewDto;
	}
}
