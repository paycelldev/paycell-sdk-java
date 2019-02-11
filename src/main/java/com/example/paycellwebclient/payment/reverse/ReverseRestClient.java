package com.example.paycellwebclient.payment.reverse;

import org.springframework.stereotype.Component;

import com.example.paycellwebclient.payment.util.JsonRestClient;
import com.example.paycellwebclient.payment.util.PaycelWebConstants;

@Component
public class ReverseRestClient extends JsonRestClient<ReverseRequest, ReverseResponse> {

	@Override
	public String getUrl() {
		return PaycelWebConstants.REVERSE_URL;
	}

	/**
	 * Reverses given payment
	 *
	 * @param reverseRequest
	 *            created using {@link ReverseRequestFactory}
	 * @return response returned by service
	 * @throws Exception
	 *             thrown if the paycell web service is not responding to reverse
	 *             method
	 */
	public ReverseResponse reverse(ReverseRequest reverseRequest) throws Exception {
		return request(reverseRequest, ReverseResponse.class);
	}

}
