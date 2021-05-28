package com.yps.ypsconnect.model;

import java.util.regex.Pattern;

import javax.persistence.Embeddable;

import org.springframework.util.Assert;

@Embeddable
public class PhoneNumber {

	private static final String NUMBER_REGEX = "^[0-9]{10}$";
	private static final Pattern PATTERN = Pattern.compile(NUMBER_REGEX);


	private String value;
    

	public PhoneNumber(String phoneNumber) {
		Assert.isTrue(isValid(phoneNumber), "Invalid phone number!");
		this.value = phoneNumber;
	}

	protected PhoneNumber() {

	}

	public static boolean isValid(String candidate) {
		return candidate == null ? false : PATTERN.matcher(candidate).matches();
	}


	@Override
	public String toString() {
		return value;
	}
}
