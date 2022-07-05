package com.arrifqi.bus.payload.request;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class GetTripScheduleRequest {
	@ApiModelProperty(hidden = true)
	private Long id;
	
	private int available_seats; 
	
	private Long trip_detail;
	
	private String tripDate;
	
	public GetTripScheduleRequest() {
	}

	public GetTripScheduleRequest(Long id, @NotNull int available_seats, @NotBlank String tripDate,
			@NotBlank Long trip_detail) {
		this.id = id;
		this.available_seats = available_seats;
		this.tripDate = tripDate;
		this.trip_detail = trip_detail;
	}

	public String getTripDate() {
		return tripDate;
	}

	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}

	public int getAvailable_seats() {
		return available_seats;
	}

	public void setAvailable_seats(int available_seats) {
		this.available_seats = available_seats;
	}

	public Long getTrip_detail() {
		return trip_detail;
	}

	public void setTrip_detail(Long trip_detail) {
		this.trip_detail = trip_detail;
	}
}
