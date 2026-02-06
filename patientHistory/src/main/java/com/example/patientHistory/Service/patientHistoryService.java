package com.example.patientHistory.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.patientHistory.Dto.PatientDto;
import com.example.patientHistory.Helper.PatientHelper;
import com.example.patientHistory.Repo.patientHistoryRepo;
import com.example.patientHistory.model.Patienthistory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class patientHistoryService  implements PatientHistoryImp{

	@Autowired
	private patientHistoryRepo patienthistoryrepo;
	
	@Override
	public PatientDto save(PatientDto patientDto) {
		 Patienthistory entity =PatientHelper.map(patientDto);
	        Patienthistory saved = patienthistoryrepo.save(entity);

	        PatientDto response = PatientHelper.map(saved);
	        return response;
		
	}


	@Override
	public PatientDto findById(Integer historyId) {
		
		return patienthistoryrepo.findById(historyId)
				.map(PatientHelper::map)
				.orElseThrow(()->new RuntimeException("user not found"));

		
	}

	@Override
	public List<PatientDto> findAll() {

		  List<Patienthistory> patients = patienthistoryrepo.findAll();

		    List<PatientDto> result = new ArrayList<>();
			for (Patienthistory patient : patients) {
		        result.add(PatientHelper.map(patient));
		    }

		    return result;
		
		
	}
	@Override
	public PatientDto update(Integer historyId, PatientDto dto) {

	    // 1️⃣ Fetch existing record
	    Patienthistory entity = patienthistoryrepo.findById(historyId)
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
	    entity.setIcuNo(dto.getIcuNo());
	    entity.setPatientDetails(dto.getPatientDetails());
	   



	 

	    // 4️⃣ Save & return
	    return PatientHelper.map(patienthistoryrepo.save(entity));
	}


	@Override
	public void deleteById(Integer historyId) {
		// TODO Auto-generated method stub
		patienthistoryrepo.deleteById(historyId);

	}


}
