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

import com.arrifqi.bus.model.Agency;
import com.arrifqi.bus.model.Bus;
import com.arrifqi.bus.payload.request.BusCustomRequest;
import com.arrifqi.bus.payload.request.BusRequest;
import com.arrifqi.bus.payload.response.MessageResponse;
import com.arrifqi.bus.repository.AgencyRepository;
import com.arrifqi.bus.repository.BusRepository;
import com.arrifqi.bus.repository.TripRepository;

import io.swagger.annotations.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

	@Autowired
	BusRepository busRepository;

	@Autowired
	AgencyRepository agencyRepository;
	
	@Autowired
	TripRepository tripRepository;

	@PostMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addBusByAgencyId(@PathVariable(value = "id") Long id,
			@Valid @RequestBody BusCustomRequest busCustomRequest) {
		Agency agency = agencyRepository.findById(id).get();
		Bus bus = new Bus(busCustomRequest.getCode(), busCustomRequest.getCapacity(), busCustomRequest.getMake(), agency);
		return ResponseEntity.ok(busRepository.save(bus));
	}
	
	@GetMapping("/")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAll() {
		List<BusRequest> dataArrResult = new ArrayList<>();
		for (Bus dataArr : busRepository.findAll()) {
			dataArrResult.add(new BusRequest(dataArr.getId(),dataArr.getCode(), dataArr.getCapacity(), 
					dataArr.getMake(), dataArr.getAgency().getId()));
		}
		return ResponseEntity.ok(new MessageResponse<BusRequest>(true, "Success Retrieving Data", dataArrResult));
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getBusByAgencyId(@PathVariable(value = "id") Long id) {
		List<Bus> bus = busRepository.findByAgencyId(id);
		return ResponseEntity.ok(bus);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateBus(@PathVariable(value = "id") Long id,
			@Valid @RequestBody BusRequest busDetail) {
		Bus bus = busRepository.findById(id).get();
		Agency agency = agencyRepository.findById(busDetail.getAgencyId()).get();
		if (bus == null) {
			return ResponseEntity.notFound().build();
		}
		bus.setCode(busDetail.getCode());
		bus.setCapacity(busDetail.getCapacity());
		bus.setMake(busDetail.getMake());
		bus.setAgency(agency);
		
		Bus updatedBus = busRepository.save(bus);

		return ResponseEntity.ok(new MessageResponse<Bus>(true, "Success Updating Data", updatedBus));
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteBus(@PathVariable(value = "id") Long id) {
		String result = "";
		try {
			busRepository.findById(id).get();

			result = "Success Deleting Data with Id: " + id;
			busRepository.deleteById(id);

			return ResponseEntity.ok(new MessageResponse<Bus>(true, result));
		} catch (Exception e) {
			result = "Data with Id: " + id + " Not Found";
			return ResponseEntity.ok(new MessageResponse<Bus>(false, result));
		}
	}

}
