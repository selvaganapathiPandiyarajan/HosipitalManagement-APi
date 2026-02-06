package com.example.HospitalDetails.BachProcess;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.HospitalDetails.Model.doctorDetails;

@Component
public class EmployeeItemProcessor implements ItemProcessor<doctorDetails, doctorDetails> {

		    @Override
	    public doctorDetails process(doctorDetails item) throws Exception {

	        // --- Sanitize string fields ---
	        item.setDoctorname(sanitize(item.getDoctorname()));
	        item.setDoctordept(sanitize(item.getDoctordept()));
	        item.setDoctorloc(sanitize(item.getDoctorloc()));
	        item.setDoctoremail(sanitize(item.getDoctoremail()));
	        item.setPassword(sanitize(item.getPassword()));
	        item.setDoctoraddress(sanitize(item.getDoctoraddress()));
	        item.setSpeacification(sanitize(item.getSpeacification()));
	        item.setDoj(sanitize(item.getDoj()));

	        // --- Handle numeric fields safely ---
	        double basicSalary = item.getBasicsalary();
	        double hra = item.getHra();
	        double allowance = item.getAllowance();
	        double deductions;
			if (item.getDeductions() != 0.0)
				deductions = item.getDeductions();
			else
				deductions = 0.0;

	        // --- Calculate salaries ---
	        double grossSalary = basicSalary + hra + allowance;
	        double netSalary = grossSalary - deductions;

	        // --- Set back to object ---
	        item.setGrosssalary(grossSalary);
	        item.setNetsalary(netSalary);
	        item.setDeductions(deductions);

	        // Optional: ensure salary string matches gross salary
	        item.setSalary(String.valueOf(grossSalary));

	        return item;
	    }

	    private String sanitize(String input) {
	        if (input == null) return null;
	        return input.replace("\0", ""); // remove null bytes
	    }
	}



