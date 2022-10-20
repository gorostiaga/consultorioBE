package com.taras.dto;

import java.time.LocalTime;

import lombok.Data;

@Data
public class ScheduleByDayDto {
	
	private LocalTime hourOfService;
	private AppointmentDto appointmentDto; 

}
