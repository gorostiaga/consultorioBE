package com.taras.model;

import java.sql.Date;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="appointment")
public class Appointment {
	
//	@Id 
//	@Column(name = "id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;	
	
	@Id
	@Column(name="phone")
	private long phone;
	
	@Column(name="name_patient")
	private String name;
	
	@Column(name="hour_appointment")
	private LocalTime hourAppointment;
	
	@Column(name="description")
	private String description; 
	
	//@ManyToOne(targetEntity = AppointmentDate.class , cascade = CascadeType.ALL)
	//@JoinColumn(name="date", referencedColumnName = "dateAppointment")
	//@ManyToOne(targetEntity = AppointmentDate.class, cascade = CascadeType.ALL)
	//@JoinColumn(referencedColumnName = "date")
	@ManyToOne(targetEntity = AppointmentDate.class,cascade = CascadeType.ALL)
	//@JoinColumn(referencedColumnName = "date")
	private AppointmentDate appointmentDate; 

	//	@ManyToOne(fetch = FetchType.LAZY)
	//	@JoinColumn(name="date_id")
	//	private AppointmentDate appointmentDate;	
	public Appointment() {

	}
	
	

	public Appointment(AppointmentDate appointmentDate) {
		super();
		this.appointmentDate = appointmentDate;
	}

			
	public Appointment(long phone, String name, LocalTime hourAppointment, String description,
			AppointmentDate appointmentDate) {
		super();
		this.phone = phone;
		this.name = name;
		this.hourAppointment = hourAppointment;
		this.description = description;
		this.appointmentDate = appointmentDate;
	}


//	public long getId() {
//		return id;
//	}
//
//
//	public void setId(long id) {
//		this.id = id;
//	}



	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalTime getHourAppointment() {
		return hourAppointment;
	}

	public void setHourAppointment(LocalTime hourAppointment) {
		this.hourAppointment = hourAppointment;
	}

	public AppointmentDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(AppointmentDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	

}
