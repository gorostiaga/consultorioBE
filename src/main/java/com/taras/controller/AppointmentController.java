package com.taras.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taras.dto.AppointmentDto;
import com.taras.dto.HourAvailabilityDto;
import com.taras.dto.ScheduleByDayDto;
import com.taras.model.Appointment;
import com.taras.model.AppointmentDate;
import com.taras.services.AppointmentService;

@CrossOrigin(origins= "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	// get all the appointments base on one Date, it is required by the webpage
	@GetMapping("/date")
	public ResponseEntity<List<ScheduleByDayDto>> getAppointmentsByDate (@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
		List<ScheduleByDayDto> appointmentDate = appointmentService.getAppointments(date);
		//appointmentDate.forEach(e -> System.out.println("los fonos en controller son " + e.getPhone()));	
		return ResponseEntity.ok(appointmentDate);
	}
	
	//Save an appointment entity from the phone
	@PostMapping
	public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment){
		//System.out.println(appointment.getAppointmentDate().getDate().toString());
		Appointment appointmentResult = appointmentService.addAppointment(appointment); 
		return ResponseEntity.ok(appointmentResult);
	}
	
	//test for this shit
	@PostMapping("/save")
	public ResponseEntity<AppointmentDate> saveAppointmentDate(@RequestBody AppointmentDate appointmentDate) {
		AppointmentDate appointmentDateResult = appointmentService.saveAppointmentDate(appointmentDate);
		return ResponseEntity.ok(appointmentDateResult);
	}
	
	//get the list of the availability of hours per day
	@GetMapping("/query/{date}")
	public ResponseEntity<List<HourAvailabilityDto>> getAvailabilityByDay(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
		List<HourAvailabilityDto> hourAvailability = appointmentService.getAvailabilityByDay(date);
		return ResponseEntity.ok(hourAvailability);
	}

}
