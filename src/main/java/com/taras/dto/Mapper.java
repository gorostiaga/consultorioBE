package com.taras.dto;

import com.taras.model.Appointment;

public class Mapper {
	
	
	public static AppointmentDto appointmentToAppointmentDto (Appointment appointment) {
		AppointmentDto appointmentDto = new AppointmentDto();
		appointmentDto.setPhone(appointment.getPhone());
		appointmentDto.setName(appointment.getName());
		appointmentDto.setHourAppointment(appointment.getHourAppointment());
		appointmentDto.setDescription(appointment.getDescription());
		
		return appointmentDto;
	}

}
