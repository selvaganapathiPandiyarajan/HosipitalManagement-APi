package com.example.patientHistory.Helper;

import org.springframework.beans.BeanUtils;

import com.example.patientHistory.Dto.PatientDto;
import com.example.patientHistory.model.Patienthistory;

public interface PatientHelper {



	public static PatientDto map(Patienthistory patienthistory) {
	    if (patienthistory == null) return null;

	    PatientDto patientDto = new PatientDto();
	    BeanUtils.copyProperties(patienthistory, patientDto);

	    return patientDto;
	}
	public static Patienthistory map(PatientDto patienthistoryDto) {
	    if (patienthistoryDto == null) return null;

	    Patienthistory patienthistory = new Patienthistory();
	    BeanUtils.copyProperties(patienthistoryDto, patienthistory);

	    // ❌ DO NOT map UserProfile here
	    // User relationship must be set by parent mapper (UserHelper)

	    return patienthistory;
	}





}

