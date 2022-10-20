package com.taras.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="appointment_date")
public class AppointmentDate {
		
	@Id
	private LocalDate date;
	
	//@OneToMany(targetEntity = Appointment.class, cascade = CascadeType.ALL)
	//@JoinColumn(name="dateAppointment", referencedColumnName = "date")
	//@OneToMany (targetEntity = Appointment.class, mappedBy = "appointmentDate")
	@OneToMany(mappedBy = "appointmentDate")
	private List<Appointment> appointments;
	
	public AppointmentDate() {
		
	}	
		
	public AppointmentDate(LocalDate date) {
		super();
		this.date = date;
	}


	public AppointmentDate(LocalDate date, List<Appointment> appointments) {
		super();
		this.date = date;
		this.appointments = appointments;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	} 
	
	
	
	
	
	
	
	

}
