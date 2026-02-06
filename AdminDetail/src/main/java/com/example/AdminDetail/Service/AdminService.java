package com.example.AdminDetail.Service;

import org.springframework.stereotype.Service;

import com.example.AdminDetail.Dto.historyDto;
import com.example.AdminDetail.OpenFignConfig.PatientHistoryClient;


@Service
public class AdminService {

    private final PatientHistoryClient patientHistoryClient;

    public AdminService(PatientHistoryClient patientHistoryClient) {
        this.patientHistoryClient = patientHistoryClient;
    }

    public historyDto createPatientHistory(historyDto dto) {
        return patientHistoryClient.addPatientHistory(dto);
    }
}
