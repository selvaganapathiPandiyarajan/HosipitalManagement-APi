package com.example.AdminDetail.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AdminDetail.Dto.historyDto;
import com.example.AdminDetail.Service.AdminService;

@RestController
@RequestMapping("/adminget")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/history")
    public ResponseEntity<historyDto> addHistory(@RequestBody historyDto dto) {
    	historyDto saved = adminService.createPatientHistory(dto);
        return ResponseEntity.ok(saved);
    }
}


