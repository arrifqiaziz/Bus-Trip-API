package com.arrifqi.bus.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.arrifqi.bus.model.User;

import io.swagger.annotations.ApiModelProperty;

public class BusCustomRequest {
	
	@ApiModelProperty(hidden = true)
	private Long id;

	private String code;

	private int capacity;

	private String make;

	@ApiModelProperty(hidden = true)
	private User agencyId;

	public BusCustomRequest() {
	}

	public BusCustomRequest(Long id, @NotNull int capacity, @NotBlank String code, @NotBlank String make,
			@NotBlank User agencyId) {
		this.id = id;
		this.capacity = capacity;
		this.code = code;
		this.make = make;
		this.agencyId = agencyId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public User getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(User agencyId) {
		this.agencyId = agencyId;
	}
}
