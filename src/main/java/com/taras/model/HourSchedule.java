package com.taras.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;

//to save the scheduled hours in a working day

@Entity
public class HourSchedule {
	@Id
	private LocalTime hour;

	
	public HourSchedule() {
		
	}
	
	public HourSchedule(LocalTime hour) {
		super();
		this.hour = hour;
	}

	public LocalTime getHour() {
		return hour;
	}

	public void setHour(LocalTime hour) {
		this.hour = hour;
	}
	
	
}
