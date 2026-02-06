package com.example.user_service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user_service.model.BookAppointment;

public interface BookAppointmentRepo  extends JpaRepository<BookAppointment, Integer>{

}
