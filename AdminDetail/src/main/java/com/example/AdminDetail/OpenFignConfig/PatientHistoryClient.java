package com.example.AdminDetail.OpenFignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.AdminDetail.Dto.historyDto;

@FeignClient(name = "patient-history-service", url = "http://localhost:8086") // Change port to PatientHistoryService
public interface PatientHistoryClient {

    @PostMapping("/api/patientHistory/add")
    historyDto addPatientHistory(@RequestBody historyDto dto);
}