package com.arrifqi.bus.payload.request;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class TicketRequest {
	
	@ApiModelProperty(hidden = true)
	private Long id;
	
	private int seatNumber;
	
	private Boolean cancellable;
	
	private String journeyDate;
	
	private Long passegerId;
	
	private Long tripScheduleId;
	
	public TicketRequest() {
	}

	public TicketRequest(Long id, @NotNull Boolean cancellable, @NotBlank String journeyDate,
			@NotNull int seatNumber, @NotBlank Long passegerId, @NotBlank Long tripScheduleId) {
		this.id = id;
		this.cancellable = cancellable;
		this.journeyDate = journeyDate;
		this.seatNumber = seatNumber;
		this.passegerId = passegerId;
		this.tripScheduleId = tripScheduleId;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Boolean getCancellable() {
		return cancellable;
	}

	public void setCancellable(Boolean cancellable) {
		this.cancellable = cancellable;
	}

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyData) {
		this.journeyDate = journeyData;
	}

	public Long getPassegerId() {
		return passegerId;
	}

	public void setPassegerId(Long passegerId) {
		this.passegerId = passegerId;
	}

	public Long getTripScheduleId() {
		return tripScheduleId;
	}

	public void setTripScheduleId(Long tripScheduleId) {
		this.tripScheduleId = tripScheduleId;
	}
}
