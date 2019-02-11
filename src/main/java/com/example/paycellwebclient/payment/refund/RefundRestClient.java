package com.example.paycellwebclient.payment.refund;

import org.springframework.stereotype.Component;

import com.example.paycellwebclient.payment.util.JsonRestClient;
import com.example.paycellwebclient.payment.util.PaycelWebConstants;

@Component
public class RefundRestClient extends JsonRestClient<RefundRequest, RefundResponse> {

	@Override
	public String getUrl() {
		return PaycelWebConstants.REFUND_URL;
	}

	/**
	 * Refund method is called from Paycell Web SDK
	 *
	 * @param refundRequest
	 * @return response that the SDK returned
	 * @throws Exception
	 *             thrown if an error occurs during service call
	 */
	public RefundResponse refund(RefundRequest refundRequest) throws Exception {
		return request(refundRequest, RefundResponse.class);
	}
}
