package com.example.user_service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user_service.model.Address;

public interface AddressRepo  extends JpaRepository<Address, Integer>{

}
