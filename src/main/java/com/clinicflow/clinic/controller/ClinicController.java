package com.clinicflow.clinic.controller;

import com.clinicflow.clinic.dto.ClinicRequest;
import com.clinicflow.clinic.dto.ClinicResponse;
import com.clinicflow.clinic.model.Clinic;
import com.clinicflow.clinic.repository.ClinicRepository;
import com.clinicflow.clinic.service.ClinicService;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@RestController
@RequestMapping("/clinics")
public class ClinicController {

    @Autowired
    private ClinicService clinicService;


    @PostMapping
    public ResponseEntity<ClinicResponse> createClinic (@RequestBody ClinicRequest clinicRequest) {
        ClinicResponse response = clinicService.create(clinicRequest);
        return ResponseEntity.created(URI.create("/clinics/" + response.id())).body(response);

    }

    @GetMapping
    public ResponseEntity<List<ClinicResponse>> getClinic() {
        List<ClinicResponse> responseList = clinicService.findAll();
        return ResponseEntity.ok().body(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicResponse> getClinicWithId(@PathVariable UUID id) {
        ClinicResponse response = clinicService.findById(id);
        return ResponseEntity.ok(response);
    }
}
