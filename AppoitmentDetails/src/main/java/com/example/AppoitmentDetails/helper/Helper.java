package com.example.AppoitmentDetails.helper;

import org.springframework.beans.BeanUtils;

import com.example.AppoitmentDetails.Dto.ApoointmentDto;
import com.example.AppoitmentDetails.model.AppointmentModel;



public interface Helper {

	
	
	public static ApoointmentDto map(AppointmentModel appointment) {
	    if (appointment == null) return null;

	    ApoointmentDto Dto = new ApoointmentDto();
	    BeanUtils.copyProperties(appointment, Dto);

	    return Dto;
	}
	public static AppointmentModel  map(ApoointmentDto apoointmentdto) {
	    if (apoointmentdto == null) return null;

	    AppointmentModel dto = new AppointmentModel();
	    BeanUtils.copyProperties(apoointmentdto, dto);

	    // ❌ DO NOT map UserProfile here
	    // User relationship must be set by parent mapper (UserHelper)

	    return dto;
	}

}

