package com.example.HospitalDetails.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HospitalDetails.Model.doctorDetails;

public interface doctorRepo extends JpaRepository<doctorDetails, Integer> {

}
