package com.example.AppoitmentDetails.Controller;

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

import com.example.AppoitmentDetails.Dto.ApoointmentDto;
import com.example.AppoitmentDetails.Dto.UserDto;
import com.example.AppoitmentDetails.Service.AppointmentService;

@RestController
@RequestMapping("appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping("/add")
	public ResponseEntity<ResponseEntity<ApoointmentDto>> post(@RequestBody ApoointmentDto apoointmentdto)
	{
		
		ResponseEntity<ApoointmentDto> dbUser=appointmentService.save(apoointmentdto);
		 return ResponseEntity.status(HttpStatus.CREATED).body(dbUser);
	}
	@GetMapping("/get/{appointmentId}")
	public ResponseEntity<ApoointmentDto> findById(@PathVariable Integer appointmentId)
	{
		ApoointmentDto dbUser=appointmentService.findById(appointmentId);
		 return ResponseEntity.ok(dbUser);
		
	}
	 @GetMapping("/getData/{username}")
	    public ResponseEntity<UserDto> getUser(@PathVariable String username) {
            System.out.println("hello inside");
	        UserDto user = appointmentService.getUserByUsername(username);
	        return ResponseEntity.ok(user);
	    }

	@PutMapping("/edit/{appointmentId}")
	public ResponseEntity<ApoointmentDto> update(
	        @PathVariable Integer appointmentId,
	        @RequestBody ApoointmentDto dto) {

	    return ResponseEntity.ok(appointmentService.update(appointmentId, dto));
	}
     
	@DeleteMapping("/delete/{appointmentId}")
	public ResponseEntity<Boolean> deletebyId(@PathVariable Integer appointmentId)
	{
		appointmentService.deleteById(appointmentId);
		return ResponseEntity.ok(true);
	}
	

	
	
	
	
	
}
