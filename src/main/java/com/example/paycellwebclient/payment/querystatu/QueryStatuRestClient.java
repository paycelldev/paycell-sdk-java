package com.example.paycellwebclient.payment.querystatu;

import org.springframework.stereotype.Component;

import com.example.paycellwebclient.payment.util.JsonRestClient;
import com.example.paycellwebclient.payment.util.PaycelWebConstants;

@Component
public class QueryStatuRestClient extends JsonRestClient<QueryStatuRequest, QueryStatuResponse>{

	@Override
	public String getUrl() {
		return PaycelWebConstants.QUERY_STATU_URL;
	}

    /**
     * Queries the statu of the given payment
     * @param queryStatuRequest created using {@link QueryStatuRequestFactory}
     * @return response returned by service
     * @throws Exception thrown if the paycell web service is not responding to query statu method
     */
    public QueryStatuResponse queryStatu(QueryStatuRequest queryStatuRequest) throws Exception {
    	return request(queryStatuRequest, QueryStatuResponse.class);
    }
}
