package com.example.AppoitmentDetails.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.AppoitmentDetails.Dto.ApoointmentDto;

public interface AppointmentImp  {

	
	ResponseEntity<ApoointmentDto> save(ApoointmentDto appointment);
	ApoointmentDto findById(Integer appointmentId);
	List<ApoointmentDto> findAll();
	ApoointmentDto update(Integer appointmentId,ApoointmentDto patient);
	void deleteById(Integer appointmentId);
	
	
	
}
