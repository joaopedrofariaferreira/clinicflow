package com.clinicflow.clinic.controller;

import com.clinicflow.clinic.dto.ClinicRequest;
import com.clinicflow.clinic.dto.ClinicResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clinic")
public class ClinicController {

    @PostMapping
    public ResponseEntity<ClinicResponse> saveClinic(@RequestBody ClinicRequest clinicRequest) {
        re
    }
}
