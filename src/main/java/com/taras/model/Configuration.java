package com.taras.model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="configuration")
public class Configuration {
	
	@Id
	private long id;	
	@Column(name="appointment_length")
	private long appointmentLength;
	@Column(name="start_time")
	private LocalTime startTime;
	@Column(name="end_time")
	private LocalTime endtTime;
	@Column(name="start_break")
	private LocalTime startBreak;
	@Column(name="end_break")
	private LocalTime endBreak;
	@Column(name="recess")
	private boolean recess;
	@Column(name="monday")
	private boolean monday;
	@Column(name="tuesday")
	private boolean tuesday;
	@Column(name="wednesday")
	private boolean wednesday;
	@Column(name="thursday")
	private boolean thursday;
	@Column(name="friday")
	private boolean friday;
	@Column(name="saturday")
	private boolean saturday;
	@Column(name="sunday")
	private boolean sunday;
	
	public Configuration () {
		
	}

	
	public Configuration(long id, long appointmentLength, LocalTime startTime, LocalTime endtTime, LocalTime startBreak,
			LocalTime endBreak, boolean recess, boolean monday, boolean tuesday, boolean wednesday, boolean thursday,
			boolean friday, boolean saturday, boolean sunday) {
		super();
		this.id = id;
		this.appointmentLength = appointmentLength;
		this.startTime = startTime;
		this.endtTime = endtTime;
		this.startBreak = startBreak;
		this.endBreak = endBreak;
		this.recess = recess;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sunday = sunday;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAppointmentLength() {
		return appointmentLength;
	}

	public void setAppointmentLength(long appointmentLength) {
		this.appointmentLength = appointmentLength;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndtTime() {
		return endtTime;
	}

	public void setEndtTime(LocalTime endtTime) {
		this.endtTime = endtTime;
	}

	public LocalTime getStartBreak() {
		return startBreak;
	}

	public void setStartBreak(LocalTime startBreak) {
		this.startBreak = startBreak;
	}

	public LocalTime getEndBreak() {
		return endBreak;
	}

	public void setEndBreak(LocalTime endBreak) {
		this.endBreak = endBreak;
	}
	
	public boolean isRecess() {
		return recess;
	}

	public void setRecess(boolean recess) {
		this.recess = recess;
	}

	public boolean isMonday() {
		return monday;
	}

	public void setMonday(boolean monday) {
		this.monday = monday;
	}

	public boolean isTuesday() {
		return tuesday;
	}

	public void setTuesday(boolean tuesday) {
		this.tuesday = tuesday;
	}

	public boolean isWednesday() {
		return wednesday;
	}

	public void setWednesday(boolean wednesday) {
		this.wednesday = wednesday;
	}

	public boolean isThursday() {
		return thursday;
	}

	public void setThursday(boolean thursday) {
		this.thursday = thursday;
	}

	public boolean isFriday() {
		return friday;
	}

	public void setFriday(boolean friday) {
		this.friday = friday;
	}

	public boolean isSaturday() {
		return saturday;
	}

	public void setSaturday(boolean saturday) {
		this.saturday = saturday;
	}

	public boolean isSunday() {
		return sunday;
	}

	public void setSunday(boolean sunday) {
		this.sunday = sunday;
	}
	
	

	
	
	
	
	
	

}
