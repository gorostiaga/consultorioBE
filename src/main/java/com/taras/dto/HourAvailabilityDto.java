package com.taras.dto;

import java.time.LocalTime;

import lombok.Data;


//this class will not be part of the persistence of the DB only for reference. 

@Data
public class HourAvailabilityDto {
	
	private LocalTime hour; 
	private boolean availability; 

}
