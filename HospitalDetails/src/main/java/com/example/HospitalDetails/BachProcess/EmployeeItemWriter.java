package com.example.HospitalDetails.BachProcess;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.example.HospitalDetails.Model.doctorDetails;
import com.example.HospitalDetails.Repo.doctorRepo;

@Component
public class EmployeeItemWriter implements ItemWriter<doctorDetails> {

    private final doctorRepo repo;

    public EmployeeItemWriter(doctorRepo repo) {
        this.repo = repo;
    }

    @Override
    public void write(Chunk<? extends doctorDetails> chunk) {
        System.out.println("WRITING TO DB : " + chunk.size());
        repo.saveAll(chunk.getItems());
    }
}
