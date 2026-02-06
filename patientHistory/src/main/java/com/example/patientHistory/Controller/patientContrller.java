package com.example.patientHistory.Controller;

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

import com.example.patientHistory.Dto.PatientDto;
import com.example.patientHistory.Service.patientHistoryService;




@RestController
@RequestMapping("api/patientHistory")
public class patientContrller {
	
	@Autowired
	private patientHistoryService patienthistoryservice;

	@PostMapping("/add")
	public ResponseEntity<PatientDto> post(@RequestBody PatientDto patienthistorydto)
	{
		
		PatientDto dbUser=patienthistoryservice.save(patienthistorydto);
		System.out.println(dbUser);


	    return ResponseEntity
	            .status(HttpStatus.CREATED)
	            .body(dbUser);
	}
	@GetMapping("/get/{historyId}")
	public ResponseEntity<PatientDto> findById(@PathVariable Integer historyId)
	{
		PatientDto dbUser=patienthistoryservice.findById(historyId);
		 return ResponseEntity.ok(dbUser);
		
	}
	@PutMapping("/edit/{historyId}")
	public ResponseEntity<PatientDto> update(
	        @PathVariable Integer historyId,
	        @RequestBody PatientDto dto) {

	    return ResponseEntity.ok(patienthistoryservice.update(historyId, dto));
	}

	@DeleteMapping("/delete/{patientHistoryId}")
	public ResponseEntity<Boolean> deletebyId(@PathVariable Integer patientHistoryId)
	{
		patienthistoryservice.deleteById(patientHistoryId);
		return ResponseEntity.ok(true);
	}
	
}
