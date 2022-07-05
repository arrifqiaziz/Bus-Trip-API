package com.arrifqi.bus.payload.request;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class BusRequest {
	@ApiModelProperty(hidden = true)
	private Long id;
	
	private String code;
	
	private int capacity;
	
	private String make;
	
	private long agencyId;
	
	public BusRequest() {
	}

	public BusRequest(Long id,  @NotBlank String code, @NotNull int capacity, @NotBlank String make,
			@NotBlank Long agencyId) {
		this.id = id;
		this.code = code;
		this.capacity = capacity;
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

	public long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(long agencyId) {
		this.agencyId = agencyId;
	}
}
