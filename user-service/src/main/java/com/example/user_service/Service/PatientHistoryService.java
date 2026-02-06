package com.example.user_service.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user_service.Dto.AddressDto;
import com.example.user_service.Dto.PatienthistoryDto;
import com.example.user_service.Dto.UserDto;
import com.example.user_service.Repo.PatienthistoryRepo;
import com.example.user_service.Repo.UserRepo;
import com.example.user_service.helper.AddressHelper;
import com.example.user_service.helper.PatientHelper;
import com.example.user_service.helper.UserHelper;
import com.example.user_service.model.Address;
import com.example.user_service.model.Patienthistory;
import com.example.user_service.model.UserProfile;

@Service
public class PatientHistoryService implements PatientInter {

	@Autowired
	private PatienthistoryRepo patienthistoryRepo;
	
	@Autowired
	private UserRepo userrepo;
	
	@Override
	public PatienthistoryDto save(PatienthistoryDto patient) {
		Patienthistory patientHistory = PatientHelper.map(patient);
		Patienthistory dbuser= patienthistoryRepo.save(patientHistory);
		PatienthistoryDto result = PatientHelper.map(dbuser);
		
		// TODO Auto-generated method stub
		return result;
		// TODO Auto-generated method stub
	}

	@Override
	public PatienthistoryDto findById(Integer historyId) {
		
		return patienthistoryRepo.findById(historyId)
				.map(PatientHelper::map)
				.orElseThrow(()->new RuntimeException("user not found"));

		
	}

	@Override
	public List<PatienthistoryDto> findAll() {

		  List<Patienthistory> patients = patienthistoryRepo.findAll();

		    List<PatienthistoryDto> result = new ArrayList<>();
			for (Patienthistory patient : patients) {
		        result.add(PatientHelper.map(patient));
		    }

		    return result;
		
		
	}
	@Override
	public PatienthistoryDto update(Integer historyId, PatienthistoryDto dto) {

	    // 1️⃣ Fetch existing record
	    Patienthistory entity = patienthistoryRepo.findById(historyId)
	            .orElseThrow(() ->
	                    new RuntimeException("Patient history not found with id " + historyId));

	    // 2️⃣ Update simple fields
	    entity.setTemp(dto.getTemp());
	    entity.setbP(dto.getbP());
	    entity.setWeight(dto.getWeight());
	    entity.setSymtoms(dto.getSymtoms());
	    entity.setPercerption(dto.getPercerption());
	    entity.setAppointmentDate(dto.getAppointmentDate());
	    entity.setNextAppointmentDate(dto.getNextAppointmentDate());
	    entity.setDoctorId(dto.getDoctorId());
	    entity.setDoctorName(dto.getDoctorName());
	    entity.setDoctorDesignation(dto.getDoctorDesignation());
	    entity.setAmount(dto.getAmount());
	    entity.setEmail(dto.getEmail());
	    entity.setAge(dto.getAge());
	    entity.setDoctorDest(dto.getDoctorDest());

	    // 3️⃣ Update USER relation (IMPORTANT)
	    if (dto.getUserdto() != null) {
	        UserProfile user = userrepo.findById(dto.getUserdto().getUserId())
	                .orElseThrow(() ->
	                        new RuntimeException("User not found with id " + dto.getUserdto().getUserId()));

	        entity.setUser(user);
	    }

	    // 4️⃣ Save & return
	    return PatientHelper.map(patienthistoryRepo.save(entity));
	}


	@Override
	public void deleteById(Integer historyId) {
		// TODO Auto-generated method stub
		patienthistoryRepo.deleteById(historyId);

	}

}
