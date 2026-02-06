package com.example.user_service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user_service.model.Patienthistory;

public interface PatienthistoryRepo  extends JpaRepository<Patienthistory, Integer>{

}
