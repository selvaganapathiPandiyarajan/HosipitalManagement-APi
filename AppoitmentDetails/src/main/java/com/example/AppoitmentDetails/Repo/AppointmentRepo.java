package com.example.AppoitmentDetails.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AppoitmentDetails.model.AppointmentModel;

public interface AppointmentRepo extends JpaRepository<AppointmentModel, Integer> {

}
