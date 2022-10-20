package com.taras.dto;

import java.time.LocalTime;

import lombok.Data;

@Data
public class AppointmentDto {
	private long phone;
	private String name;
	private LocalTime hourAppointment;
	private String description;
	
}
