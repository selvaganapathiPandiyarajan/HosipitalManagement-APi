package com.example.user_service.helper;

import org.springframework.beans.BeanUtils;
import com.example.user_service.Dto.PatienthistoryDto;
import com.example.user_service.Dto.UserDto;
import com.example.user_service.model.Patienthistory;
import com.example.user_service.model.UserProfile;

public interface PatientHelper {

	public static PatienthistoryDto map(Patienthistory  patienthistory){
		if(patienthistory == null) return null;
		PatienthistoryDto patient = new PatienthistoryDto();
	    BeanUtils.copyProperties(patienthistory, patient);
		UserDto userDto =new UserDto();
		patient.setUserdto(userDto);
	    return patient;

		
}
	
	
	public static Patienthistory map(PatienthistoryDto patienthistoryDto) {
	    if (patienthistoryDto == null) return null;

	    
	    
	    Patienthistory patienthistroy = new Patienthistory();
	    BeanUtils.copyProperties(patienthistroy, patienthistroy);
        UserProfile user=new UserProfile();
	    // ❌ DO NOT map user
	    // ❌ NO UserDto here
	    
        patienthistroy.setUser(user);
	    // ❌ DO NOT create UserProfile here
	    // User relationship must be set by the parent mapper (UserHelper)

	    return patienthistroy;
	}


}
