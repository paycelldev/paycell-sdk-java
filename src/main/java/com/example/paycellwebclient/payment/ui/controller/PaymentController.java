package com.example.paycellwebclient.payment.ui.controller;

import java.util.Map;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.example.paycellwebclient.payment.service.PaymentService;
import com.example.paycellwebclient.payment.ui.model.viewdto.InstalmentPlanViewDto;
import com.example.paycellwebclient.payment.ui.model.viewdto.MetaDataViewDto;
import com.example.paycellwebclient.payment.ui.model.viewdto.PaymentViewDto;
import com.example.paycellwebclient.payment.ui.model.viewdto.QueryStatuViewDto;
import com.example.paycellwebclient.payment.util.PaycelWebConstants;

@ManagedBean
@ViewScoped
public class PaymentController extends SpringBeanAutowiringSupport {

	private static final String KEY_PAYMENT_REFERENCE_NUMBER = "paymentReferenceNumber";

	private PaymentViewDto payment;

	private MetaDataViewDto metaData;

	private QueryStatuViewDto queryStatu;

	private String refundAmount;

	private String paymentUrl;

	private PaymentService paymentService;

	@Autowired
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
		metaData = new MetaDataViewDto();
		fillMetaData();

		if (requestParametersContainPaymentReferenceNumber()) {
			createPaymentFromRequestParameter();
		} else if (requestMapContainsPaymentReferenceNumber()) {
			createPaymentFromRequestMap();
		} else {
			payment = new PaymentViewDto();
			queryStatu = new QueryStatuViewDto();
		}
		fillDummyData();
	}

	private void createPaymentFromRequestMap() {
		Map<String, Object> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
		payment = new PaymentViewDto();
		payment.setPaymentReferenceNumber((String) requestMap.get(KEY_PAYMENT_REFERENCE_NUMBER));
		queryStatusOfPayment();
	}

	private boolean requestMapContainsPaymentReferenceNumber() {
		Map<String, Object> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
		return requestMap.containsKey(KEY_PAYMENT_REFERENCE_NUMBER);
	}

	private void createPaymentFromRequestParameter() {
		Map<String, String> requestParameterMap = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap();
		payment = new PaymentViewDto();
		payment.setPaymentReferenceNumber(requestParameterMap.get(KEY_PAYMENT_REFERENCE_NUMBER));
		queryStatusOfPayment();
	}

	private boolean requestParametersContainPaymentReferenceNumber() {
		Map<String, String> requestParameterMap = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap();
		return requestParameterMap.containsKey(KEY_PAYMENT_REFERENCE_NUMBER);
	}

	private void fillMetaData() {
		metaData.setClientIPAddress(getClientIpAddress());
		metaData.setApplicationName(PaycelWebConstants.APPLICATION_NAME);
		metaData.setMerchantCode(PaycelWebConstants.MERCHANT_CODE);
		metaData.setTerminalCode(PaycelWebConstants.TERMINAL_CODE);
		metaData.setLanguage("tr");
	}

	private String getClientIpAddress() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}
		return ipAddress;
	}

	private void fillDummyData() {
		metaData.setHostAccount("xxxxx@xxxx.com");
		metaData.setMsisdn("905465553333");
		payment.setAmount("100");
		payment.setCurrency("99");
		payment.setPaymentSecurity("NON_THREED_SECURE");
		InstalmentPlanViewDto instalmentPlan = new InstalmentPlanViewDto();
		instalmentPlan.setAmount("100");
		instalmentPlan.setCardBrand("BONUS");
		instalmentPlan.setCount("1");
		instalmentPlan.setPaymentMethodType("CREDIT_CARD");
		payment.getInstalmentPlans().add(instalmentPlan);
	}

	public void initPayment() {
		try {
			paymentUrl = paymentService.initPayment(metaData, payment);
		} catch (Exception e) {
			showErrorMessage(e.getMessage());
		}
	}

	public void reversePayment() {
		try {
			paymentService.reversePayment(metaData, payment);
		} catch (Exception e) {
			showErrorMessage(e.getMessage());
		}
	}

	public void refundPayment() {
		try {
			paymentService.refundPayment(metaData, payment, refundAmount);
		} catch (Exception e) {
			showErrorMessage(e.getMessage());
		}
	}

	public void queryStatusOfPayment() {
		try {
			queryStatu = paymentService.queryPayment(metaData, payment);
		} catch (Exception e) {
			showErrorMessage(e.getMessage());
		}
	}

	public String openQueryStatuPageUrl() {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(KEY_PAYMENT_REFERENCE_NUMBER,
				payment.getPaymentReferenceNumber());
		return "checkStatus.jsf";
	}

	public void addNewInstalmentPlan() {
		payment.getInstalmentPlans().add(new InstalmentPlanViewDto());
	}

	private void showErrorMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", message));
	}

	public PaymentViewDto getPayment() {
		return payment;
	}

	public void setPayment(PaymentViewDto payment) {
		this.payment = payment;
	}

	public MetaDataViewDto getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaDataViewDto metaData) {
		this.metaData = metaData;
	}

	public QueryStatuViewDto getQueryStatu() {
		return queryStatu;
	}

	public void setQueryStatu(QueryStatuViewDto queryStatu) {
		this.queryStatu = queryStatu;
	}

	public String getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getPaymentUrl() {
		return paymentUrl;
	}

	public void setPaymentUrl(String paymentUrl) {
		this.paymentUrl = paymentUrl;
	}

}
