package com.taras.repository;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taras.model.AppointmentDate;

@Repository
public interface AppointmentDateRepository extends JpaRepository<AppointmentDate, LocalDate>{

}
