package com.taras.services;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taras.dto.AppointmentDto;
import com.taras.dto.HourAvailabilityDto;
import com.taras.dto.Mapper;
import com.taras.dto.ScheduleByDayDto;
import com.taras.exception.ResourceNotFoundException;
import com.taras.model.Appointment;
import com.taras.model.AppointmentDate;
import com.taras.model.HourSchedule;
import com.taras.repository.AppointmentDateRepository;
import com.taras.repository.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentDateRepository appointmentDateRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository; 
	
	@Autowired
	private ConfigurationService  configurationService;
	
	
	public Appointment addAppointment(Appointment appointment) {		
		return appointmentRepository.save(appointment);
		
	}
	
	// by a GET call it brings the list of all the appointments at a certain Date along with all the hours 
	// scheduled by the configuration appointment length 
	public List<ScheduleByDayDto> getAppointments (LocalDate date) {

		AppointmentDate objRetrieved = appointmentDateRepository.findById(date).orElseThrow(() -> new ResourceNotFoundException("Fecha no existe"));
		//System.out.println("Aca es" + Arrays.toString(objRetrieved.getAppointments().toArray()));
		List<Appointment> pepes = objRetrieved.getAppointments();
		List<AppointmentDto> appointmentsScheduled = pepes.stream().map(Mapper::appointmentToAppointmentDto).collect(Collectors.toList());
		List<HourSchedule> hoursOfService = configurationService.getHourSchedule();
		List<ScheduleByDayDto> schedulePlusAppointments = new ArrayList<>();
		for (HourSchedule hourOfService : hoursOfService) {
			ScheduleByDayDto schedulePlusAppointment = new ScheduleByDayDto();
			schedulePlusAppointment.setHourOfService(hourOfService.getHour());
			schedulePlusAppointment.setAppointmentDto(null);
			for (AppointmentDto appointmentScheduled : appointmentsScheduled) {
				if(schedulePlusAppointment.getHourOfService().compareTo(appointmentScheduled.getHourAppointment())==0) {
					schedulePlusAppointment.setAppointmentDto(appointmentScheduled);
				}
			}
			schedulePlusAppointments.add(schedulePlusAppointment);
		}
		
		return schedulePlusAppointments;

	}
	
	public List<AppointmentDto> getScheduledAppointments (LocalDate date){
		AppointmentDate objRetrieved = appointmentDateRepository.findById(date).orElseThrow(() -> new ResourceNotFoundException("Fecha no existe"));
		List<Appointment> pepes = objRetrieved.getAppointments();
		return pepes.stream().map(Mapper::appointmentToAppointmentDto).collect(Collectors.toList());
	}
	
	//test for this shit
	public AppointmentDate saveAppointmentDate (AppointmentDate appointmentDate) {
		return appointmentDateRepository.save(appointmentDate);
	}
	
	//get the list of pair DATE vs Availability 
	public List<HourAvailabilityDto> getAvailabilityByDay(LocalDate date) {
		List<AppointmentDto> appointmentsByDay = getScheduledAppointments(date);
		List<HourSchedule> hours = configurationService.getHourSchedule();
		List<HourAvailabilityDto> hoursScheduled = new ArrayList<>();
		for(HourSchedule hour : hours) {
			HourAvailabilityDto hourDto = new HourAvailabilityDto();
			hourDto.setHour(hour.getHour());
			hourDto.setAvailability(false);
			for(AppointmentDto appointment : appointmentsByDay) {
				if (hourDto.getHour().compareTo(appointment.getHourAppointment())==0) {
					hourDto.setAvailability(true);
				}
			}
			hoursScheduled.add(hourDto);
		}
		return hoursScheduled;
	}

	
	
	

}
