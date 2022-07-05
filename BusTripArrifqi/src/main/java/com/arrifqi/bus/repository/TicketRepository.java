package com.arrifqi.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arrifqi.bus.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
