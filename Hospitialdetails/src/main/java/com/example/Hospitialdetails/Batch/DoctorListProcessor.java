package com.example.Hospitialdetails.Batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.Hospitialdetails.Model.Doctorlist;
@Component
public class DoctorListProcessor implements ItemProcessor<Doctorlist, Doctorlist>  {

	@Override
	public Doctorlist process(Doctorlist doctorlist) throws Exception {
		
		double grossVal =(doctorlist.getBasicsalary() + doctorlist.getHra() + doctorlist .getAllowance());
		double grossSalary=grossVal * doctorlist.getMonth();
		
		double netSalary =grossSalary - doctorlist.getDeductions();
		
		doctorlist.setGrosssalary(grossSalary);
		doctorlist.setNetsalary(netSalary);
		
		// TODO Auto-generated method stub
		return doctorlist;
	}

}
