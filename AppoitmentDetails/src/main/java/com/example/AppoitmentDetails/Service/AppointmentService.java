package com.example.AppoitmentDetails.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.AppoitmentDetails.Dto.ApoointmentDto;
import com.example.AppoitmentDetails.Dto.UserDto;
import com.example.AppoitmentDetails.Repo.AppointmentRepo;
import com.example.AppoitmentDetails.helper.Helper;
import com.example.AppoitmentDetails.model.AppointmentModel;


@Service
public class AppointmentService implements AppointmentImp {

	
	@Autowired
	private AppointmentRepo appintmentrepo;
	@Autowired
    private RestTemplate restTemplate;




	@Override
	public ResponseEntity<ApoointmentDto> save(ApoointmentDto appointment) {

		     AppointmentModel	entity =Helper.map(appointment);
	        AppointmentModel saved = appintmentrepo.save(entity);

	         ApoointmentDto response = Helper.map(saved);
	        return ResponseEntity.ok(response);

		
	}

	@Override
	public ApoointmentDto findById(Integer appointmentId) {
		return appintmentrepo.findById(appointmentId)
				.map(Helper::map)
				.orElseThrow(()->new RuntimeException("Record not found"));


		
		
	}
	  public UserDto getUserByUsername(String username) {

	        String url = "http://localhost:8085/auth/getuser/" + username;

	        return restTemplate.getForObject(url, UserDto.class);
	    }

	@Override
	public List<ApoointmentDto> findAll() {

		List<AppointmentModel> appointments = appintmentrepo.findAll();

	    List<ApoointmentDto> result = new ArrayList<>();
		for (AppointmentModel appointment : appointments) {
	        result.add(Helper.map(appointment));
	    }

	    return result;
	

		
		
	}

		@Override
		public  ApoointmentDto update(Integer appointmentId, ApoointmentDto dto) {

AppointmentModel entity = appintmentrepo.findById(appointmentId)
		        .orElseThrow(() ->
		            new RuntimeException("Appointment not found: " + appointmentId)
		        );

		    entity.setUsername(dto.getUsername());
		    entity.setPhoneno(dto.getPhoneno());
		    entity.setCity(dto.getCity());
		    entity.setDoctorname(dto.getDoctorname());
		    entity.setDctordept(dto.getDctordept());
		    entity.setStatus(dto.getStatus());
		    entity.setAppointmentdate(dto.getAppointmentdate());
		    return Helper.map(appintmentrepo.save(entity));

		}

		
	

	@Override
	public void deleteById(Integer appointmentId) {
		// TODO Auto-generated method stub
		appintmentrepo.deleteById(appointmentId);

	}

}
