package com.arrifqi.bus.payload.request;

import io.swagger.annotations.ApiModelProperty;

public class UserCustomRequest {
	
	@ApiModelProperty(hidden = true)
	private Long id;

	private String firstName;

	private String lastName;

	private String mobileNumber;

	public UserCustomRequest() {
	}

	public UserCustomRequest(String firstName, String lastName, String mobileNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
