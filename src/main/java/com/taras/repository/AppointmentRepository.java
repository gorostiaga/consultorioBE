package com.taras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taras.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
