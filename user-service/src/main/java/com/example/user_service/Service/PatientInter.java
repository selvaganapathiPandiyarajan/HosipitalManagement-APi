package com.example.user_service.Service;

import java.util.List;

import com.example.user_service.Dto.PatienthistoryDto;

public interface PatientInter {

	PatienthistoryDto save(PatienthistoryDto patient);
	PatienthistoryDto findById(Integer patientId);
	List<PatienthistoryDto> findAll();
	PatienthistoryDto update(Integer patientId,PatienthistoryDto patient);
	void deleteById(Integer patientId);

}
