package com.taras.services;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taras.repository.ConfigurationRepository;
import com.taras.repository.HourScheduleRepository;
import com.taras.model.HourSchedule;
import com.taras.model.Configuration;

@Service
public class ConfigurationService {
	
	@Autowired
	private ConfigurationRepository configurationRepository;
	@Autowired
	private HourScheduleRepository hourSheduleRepository; 
	

	public List<Configuration> getAllConfiguration() {		
		return configurationRepository.findAll();
	}
	
	public Configuration saveConfiguration(Configuration configuration) {
		
		List<HourSchedule> hoursOfAppointment = new ArrayList<>();
		LocalTime startedHour = configuration.getStartTime();
		if(configuration.isRecess()) {
			while(startedHour.compareTo(configuration.getStartBreak())<0) {
				HourSchedule hour = new HourSchedule();
				hour.setHour(startedHour);
				hoursOfAppointment.add(hour);
				startedHour = startedHour.plusMinutes(configuration.getAppointmentLength());
			}
			startedHour = configuration.getEndBreak();
			while (startedHour.compareTo(configuration.getEndtTime())<0){
				HourSchedule hour = new HourSchedule();
				hour.setHour(startedHour);
				hoursOfAppointment.add(hour);
				startedHour = startedHour.plusMinutes(configuration.getAppointmentLength());
			}
		} else {
			while (startedHour.compareTo(configuration.getEndtTime())<0) {
				HourSchedule hour = new HourSchedule();
				hour.setHour(startedHour);
				hoursOfAppointment.add(hour);
				startedHour = startedHour.plusMinutes(configuration.getAppointmentLength());
				
			}
		}
		List<HourSchedule> hoursAppointment = hourSheduleRepository.saveAll(hoursOfAppointment); 		
		return configurationRepository.save(configuration);
	}
	
	public List<HourSchedule> getHourSchedule(){
		return hourSheduleRepository.findAll();
	}
}
