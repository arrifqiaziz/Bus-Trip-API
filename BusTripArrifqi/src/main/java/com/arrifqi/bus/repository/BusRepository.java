package com.arrifqi.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arrifqi.bus.model.Bus;

import java.util.List;

public interface BusRepository extends JpaRepository<Bus, Long> {
    @Query(value = "SELECT * FROM bus WHERE agency_id = :id", nativeQuery = true)
    List<Bus> findByAgencyId(Long id);
}
