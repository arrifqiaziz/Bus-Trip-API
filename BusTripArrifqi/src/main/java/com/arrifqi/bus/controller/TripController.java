package com.arrifqi.bus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.arrifqi.bus.model.Agency;
import com.arrifqi.bus.model.Bus;
import com.arrifqi.bus.model.Stop;
import com.arrifqi.bus.model.Trip;
import com.arrifqi.bus.payload.request.TripRequest;
import com.arrifqi.bus.payload.response.MessageResponse;
import com.arrifqi.bus.repository.AgencyRepository;
import com.arrifqi.bus.repository.BusRepository;
import com.arrifqi.bus.repository.StopRepository;
import com.arrifqi.bus.repository.TripRepository;

import io.swagger.annotations.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/trip")
public class TripController {
	@Autowired
	TripRepository tripRepository;

	@Autowired
	AgencyRepository agencyRepository;

	@Autowired
	BusRepository busRepository;

	@Autowired
	StopRepository stopRepository;

	@PostMapping("/")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addTrip(@Valid @RequestBody TripRequest tripRequest) {
		Agency agency = agencyRepository.findById(tripRequest.getAgencyId()).get();
		Bus bus = busRepository.findById(tripRequest.getBusId()).get();
		Stop sourceStop = stopRepository.findById(tripRequest.getSourceStopId()).get();
		Stop destStop = stopRepository.findById(tripRequest.getDestStopId()).get();
		Trip trip = new Trip(tripRequest.getFare(), tripRequest.getJourneyTime(), sourceStop, destStop, bus, agency);
		return ResponseEntity.ok(tripRepository.save(trip));
	}

	@GetMapping("/")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	public ResponseEntity<?> getAll() {
		List<TripRequest> dataArrResult = new ArrayList<>();
		for (Trip dataArr : tripRepository.findAll()) {
			dataArrResult.add(new TripRequest(dataArr.getId(), dataArr.getFare(), dataArr.getJourneyTime(),
					dataArr.getSourceStop().getId(), dataArr.getDestStop().getId(), dataArr.getBus().getId(),
					dataArr.getAgency().getId()));
		}
		return ResponseEntity.ok(new MessageResponse<TripRequest>(true, "Success Retrieving Data", dataArrResult));
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public ResponseEntity<?> getTripByAgencyId(@PathVariable(value = "id") Long id) {
		List<Trip> trip = tripRepository.findByAgencyId(id);
		return ResponseEntity.ok(trip);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateTrip(@PathVariable(value = "id") Long id,
			@Valid @RequestBody TripRequest tripDetail) {
		Trip trip = tripRepository.findById(id).get();
		Agency agency = agencyRepository.findById(tripDetail.getAgencyId()).get();
		Bus bus = busRepository.findById(tripDetail.getBusId()).get();
		Stop source_stop = stopRepository.findById(tripDetail.getSourceStopId()).get();
		Stop dest_stop = stopRepository.findById(tripDetail.getDestStopId()).get();
		if (trip == null) {
			return ResponseEntity.notFound().build();
		}
		trip.setFare(tripDetail.getFare());
		trip.setJourneyTime(tripDetail.getJourneyTime());
		trip.setAgency(agency);
		trip.setBus(bus);
		trip.setSourceStop(source_stop);
		trip.setDestStop(dest_stop);

		Trip updatedTrip = tripRepository.save(trip);

		return ResponseEntity.ok(new MessageResponse<Trip>(true, "Success Updating Data", updatedTrip));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteTrip(@PathVariable(value = "id") Long id) {
		String result = "";
		try {
			tripRepository.findById(id).get();

			result = "Success Deleting Data with Id: " + id;
			tripRepository.deleteById(id);

			return ResponseEntity.ok(new MessageResponse<Trip>(true, result));
		} catch (Exception e) {
			result = "Data with Id: " + id + " Not Found";
			return ResponseEntity.ok(new MessageResponse<Trip>(false, result));
		}
	}

}
