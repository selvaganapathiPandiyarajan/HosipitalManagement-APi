package com.example.patientHistory.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.patientHistory.Dto.PatientDto;


public interface PatientHistoryImp {
	
	
	PatientDto save(PatientDto patient);
	PatientDto findById(Integer patientId);
	List<PatientDto> findAll();
	PatientDto update(Integer patientId,PatientDto patient);
	void deleteById(Integer patientId);

}
