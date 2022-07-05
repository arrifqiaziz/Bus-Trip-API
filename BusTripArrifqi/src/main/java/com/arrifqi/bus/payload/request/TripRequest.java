package com.arrifqi.bus.payload.request;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class TripRequest {
	@ApiModelProperty(hidden = true)
	private Long id;
	
	private int fare;
	
	private int journeyTime;
	
	private Long sourceStopId;
	
	private Long destStopId;
	
	private Long busId;
	
	private Long agencyId;
	
	public TripRequest() {
	}

	public TripRequest(Long id, @NotNull int fare, @NotBlank int journeyTime, @NotBlank Long agencyId,
			@NotBlank Long busId, @NotBlank Long sourceStopId, @NotBlank Long destStopId) {
		this.id = id;
		this.fare = fare;
		this.journeyTime = journeyTime;
		this.agencyId = agencyId;
		this.busId = busId;
		this.sourceStopId = sourceStopId;
		this.destStopId = destStopId;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public int getJourneyTime() {
		return journeyTime;
	}

	public void setJourneyTime(int journeyTime) {
		this.journeyTime = journeyTime;
	}

	public Long getSourceStopId() {
		return sourceStopId;
	}

	public void setSourceStopId(Long sourceStopId) {
		this.sourceStopId = sourceStopId;
	}

	public Long getDestStopId() {
		return destStopId;
	}

	public void setDestStopId(Long destStopId) {
		this.destStopId = destStopId;
	}

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public Long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}
}
