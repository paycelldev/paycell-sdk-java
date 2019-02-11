package com.example.paycellwebclient.payment.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class JsonRestClient<T, S> {

	public S request(T t, Class<S> responseClass) throws Exception{
		try {
	        String jsonRequest = JsonUtil.convertObjectToJson(t);

	        URL url = new URL(getUrl());
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("POST");
	        connection.setDoOutput(true);

	        connection.setFixedLengthStreamingMode(jsonRequest.getBytes().length);
	        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	        connection.connect();

	        try (OutputStream os = connection.getOutputStream()) {
	            os.write(jsonRequest.getBytes());
	        }
	        InputStream inputStream = connection.getInputStream();
	        String response = StreamUtil.readInputStream(inputStream);

	        return (S) JsonUtil.convertJsonToObject(response, responseClass);

	    } catch (Exception e) {
	        throw new Exception("An error occured during request method", e);
	    }
	}

	public String getUrl() {
		return null;
	}

}
