package com.example.paycellwebclient.payment.init;

import org.springframework.stereotype.Component;

import com.example.paycellwebclient.payment.util.JsonRestClient;
import com.example.paycellwebclient.payment.util.PaycelWebConstants;

@Component
public class InitRestClient extends JsonRestClient<InitRequest, InitResponse> {

	@Override
	public String getUrl() {
		return PaycelWebConstants.INIT_URL;
	}

	/**
	 * calls init method from Paycell Web SDK
	 *
	 * @param initRequest
	 * @return service response
	 * @throws Exception
	 *             thrown if problem occurs during marshaling
	 */
	public InitResponse init(InitRequest initRequest) throws Exception {
		return request(initRequest, InitResponse.class);
	}

}
