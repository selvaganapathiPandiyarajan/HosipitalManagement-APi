package com.example.Hospitialdetails.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Hospitialdetails.Model.Doctorlist;

@Repository
public interface DoctorDetails extends JpaRepository<Doctorlist, Integer> {

}
