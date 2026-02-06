package com.example.patientHistory.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.patientHistory.model.Patienthistory;


public interface patientHistoryRepo   extends JpaRepository<Patienthistory, Integer> {

}
