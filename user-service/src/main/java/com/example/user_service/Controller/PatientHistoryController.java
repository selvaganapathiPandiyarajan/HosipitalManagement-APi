package com.example.user_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_service.Dto.PatienthistoryDto;
import com.example.user_service.Service.PatientHistoryService;

@RestController
@RequestMapping("api/patientHistory")
public class PatientHistoryController {
	
	@Autowired
	private PatientHistoryService patienthistoryservice;

	@PostMapping("/add")
	public ResponseEntity<PatienthistoryDto>post(@RequestBody PatienthistoryDto patienthistorydto)
	{
		
		PatienthistoryDto dbUser=patienthistoryservice.save(patienthistorydto);
		System.out.println(dbUser);
		 return ResponseEntity.status(HttpStatus.CREATED).body(dbUser);
	}
	@GetMapping("/{historyId}")
	public ResponseEntity<PatienthistoryDto> findById(@PathVariable Integer historyId)
	{
		PatienthistoryDto dbUser=patienthistoryservice.findById(historyId);
		 return ResponseEntity.ok(dbUser);
		
	}
	@PutMapping("/patienthistory/{historyId}")
	public ResponseEntity<PatienthistoryDto> update(
	        @PathVariable Integer historyId,
	        @RequestBody PatienthistoryDto dto) {

	    return ResponseEntity.ok(patienthistoryservice.update(historyId, dto));
	}

	@DeleteMapping("/{patientHistoryId}")
	public ResponseEntity<Boolean> deletebyId(@PathVariable Integer patientHistoryId)
	{
		patienthistoryservice.deleteById(patientHistoryId);
		return ResponseEntity.ok(true);
	}
	
}
