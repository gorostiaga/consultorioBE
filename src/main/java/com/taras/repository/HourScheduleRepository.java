package com.taras.repository;

import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taras.model.HourSchedule;

@Repository
public interface HourScheduleRepository extends JpaRepository<HourSchedule, LocalTime>{

}
