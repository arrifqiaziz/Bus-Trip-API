package com.arrifqi.bus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arrifqi.bus.model.Trip;
import com.arrifqi.bus.model.TripSchedule;
import com.arrifqi.bus.payload.request.GetTripScheduleRequest;
import com.arrifqi.bus.payload.response.MessageResponse;
import com.arrifqi.bus.repository.TicketRepository;
import com.arrifqi.bus.repository.TripRepository;
import com.arrifqi.bus.repository.TripScheduleRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/trip_schedule")
public class TripScheduleController {

	@Autowired
	TripScheduleRepository tripScheduleRepository;

	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	TripRepository tripRepository;

	@PostMapping("/")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addTripSchedule(@Valid @RequestBody GetTripScheduleRequest tripScheduleRequest) {
		Trip trip = tripRepository.findById(tripScheduleRequest.getTrip_detail()).get();
		TripSchedule trip_schedule = new TripSchedule(tripScheduleRequest.getTripDate(),
				tripScheduleRequest.getAvailable_seats(), trip);
		return ResponseEntity.ok(new MessageResponse<TripSchedule>(true, "Success Adding Data",
				tripScheduleRepository.save(trip_schedule)));
	}

	@GetMapping("/")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public ResponseEntity<?> getAll() {
		List<GetTripScheduleRequest> dataArrResult = new ArrayList<>();
		for (TripSchedule dataArr : tripScheduleRepository.findAll()) {
			dataArrResult.add(new GetTripScheduleRequest(dataArr.getId(), dataArr.getAvailableSeats(),
					dataArr.getTripDate(), dataArr.getTripDetail().getId()));
		}
		return ResponseEntity
				.ok(new MessageResponse<GetTripScheduleRequest>(true, "Success Retrieving Data", dataArrResult));
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public ResponseEntity<?> getTripScheduleById(@PathVariable(value = "id") Long id) {
		TripSchedule trip_schedule = tripScheduleRepository.findById(id).get();
		if (trip_schedule == null) {
			return ResponseEntity.notFound().build();
		} else {
			GetTripScheduleRequest dataResult = new GetTripScheduleRequest(trip_schedule.getId(),
					trip_schedule.getAvailableSeats(), trip_schedule.getTripDate(),
					trip_schedule.getTripDetail().getId());
			return ResponseEntity
					.ok(new MessageResponse<GetTripScheduleRequest>(true, "Success Retrieving Data", dataResult));
		}
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateTripSchedule(@PathVariable(value = "id") Long id,
			@Valid @RequestBody GetTripScheduleRequest trip_schedule_detail) {
		TripSchedule trip_schedule = tripScheduleRepository.findById(id).get();
		Trip trip = tripRepository.findById(trip_schedule_detail.getTrip_detail()).get();
		if (trip_schedule == null) {
			return ResponseEntity.notFound().build();
		}
		trip_schedule.setAvailableSeats(trip_schedule_detail.getAvailable_seats());
		trip_schedule.setTripDate(trip_schedule_detail.getTripDate());
		trip_schedule.setTripDetail(trip);

		TripSchedule updatedTripSchedule = tripScheduleRepository.save(trip_schedule);

		return ResponseEntity.ok(new MessageResponse<TripSchedule>(true, "Success Updating Data", updatedTripSchedule));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteTripSchedule(@PathVariable(value = "id") Long id) {
		String result = "";
		try {
			tripScheduleRepository.findById(id).get();

			result = "Success Deleting Data with Id: " + id;
			tripScheduleRepository.deleteById(id);

			return ResponseEntity.ok(new MessageResponse<TripSchedule>(true, result));
		} catch (Exception e) {
			result = "Data with Id: " + id + " Not Found";
			return ResponseEntity.ok(new MessageResponse<TripSchedule>(false, result));
		}
	}

}
