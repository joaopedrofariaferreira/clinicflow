package com.clinicflow.clinic.controller;

import com.clinicflow.clinic.dto.ClinicRequest;
import com.clinicflow.clinic.dto.ClinicResponse;
import com.clinicflow.clinic.model.Clinic;
import com.clinicflow.clinic.repository.ClinicRepository;
import com.clinicflow.clinic.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/clinics")
public class ClinicController {

    @Autowired
    private ClinicService clinicService;
    @Autowired
    private ClinicRepository clinicRepository;


    @PostMapping
    public ResponseEntity<ClinicResponse> createClinic (@RequestBody ClinicRequest clinicRequest) {
        ClinicResponse response = clinicService.create(clinicRequest);
        return ResponseEntity.created(URI.create("/clinics/" + response.id()))
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<ClinicResponse>> getClinic() {
        List<ClinicResponse> response = clinicRepository.findAll().stream()
                .map(clinic -> new ClinicResponse(clinic.getId(),
                        clinic.getName(),
                        clinic.getCnpj(),
                        clinic.getActive(),
                        clinic.getCreatedAt(),
                        clinic.getUpdatedAt()))
                .toList();

        return ResponseEntity.ok(response);
    }
}
