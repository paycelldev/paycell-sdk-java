package com.example.paycellwebclient.payment.init;

public class McParameters {

	/**
	 * Represents if the customer used Turkcell Hızlı Giriş
	 * other properties are waited if the value represents true
	 * "Y" for true
	 * "N" for false
	 */
	public String isMcSession;

	/**
	 * Phone number of the customer without county code
	 */
	public String mcPhoneNumber;

	/**
	 * Country code of the customer phone number
	 */
	public String mcPhoneCountry;

	/**
	 * Turkcell Hızlı Giriş authorization token
	 */
	public String mcAuthToken;

	public String getIsMcSession() {
		return isMcSession;
	}

	public void setIsMcSession(String isMcSession) {
		this.isMcSession = isMcSession;
	}

	public String getMcPhoneNumber() {
		return mcPhoneNumber;
	}

	public void setMcPhoneNumber(String mcPhoneNumber) {
		this.mcPhoneNumber = mcPhoneNumber;
	}

	public String getMcPhoneCountry() {
		return mcPhoneCountry;
	}

	public void setMcPhoneCountry(String mcPhoneCountry) {
		this.mcPhoneCountry = mcPhoneCountry;
	}

	public String getMcAuthToken() {
		return mcAuthToken;
	}

	public void setMcAuthToken(String mcAuthToken) {
		this.mcAuthToken = mcAuthToken;
	}

}
