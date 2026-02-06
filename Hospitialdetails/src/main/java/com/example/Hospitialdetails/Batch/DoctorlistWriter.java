package com.example.Hospitialdetails.Batch;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.example.Hospitialdetails.Model.Doctorlist;
import com.example.Hospitialdetails.Repo.DoctorDetails;

@Component
public class DoctorlistWriter implements ItemWriter<Doctorlist> {

	private final DoctorDetails repo;

	public DoctorlistWriter(DoctorDetails repo) {
		this.repo = repo;
	}

	@Override
	public void write(Chunk<? extends Doctorlist> chunk) throws Exception {
		// TODO Auto-generated method stub
		repo.saveAll(chunk.getItems());
	}
	
	
	
	
}
