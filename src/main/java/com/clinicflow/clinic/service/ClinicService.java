package com.clinicflow.clinic.service;

import com.clinicflow.clinic.dto.ClinicRequest;
import com.clinicflow.clinic.dto.ClinicResponse;
import com.clinicflow.clinic.mapper.ClinicMapper;
import com.clinicflow.clinic.model.Clinic;
import com.clinicflow.clinic.repository.ClinicRepository;
import com.clinicflow.exception.ClinicAlreadyExistsException;
import com.clinicflow.exception.ClinicNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClinicService {

    @Autowired
    private ClinicMapper clinicMapper;
    @Autowired
    private ClinicRepository clinicRepository;

    public ClinicResponse create(ClinicRequest request) {
        if (clinicRepository.existsByCnpj(request.cnpj())) {
            throw new ClinicAlreadyExistsException("Clinic with this CNPJ already exists");
        }
        Clinic clinic = clinicMapper.toEntity(request); //crio uma clinica, chamando o método ToEntity
        clinic.setActive(true); //seto status
        Clinic savedClinic = clinicRepository.save(clinic); //Crio outra clinica e salvo com as informaçoes de antes
        return clinicMapper.toResponse(savedClinic); // retorno a clinica salva
    }

    public List<ClinicResponse> findAll() {
        List<ClinicResponse> response = clinicRepository.findAll().stream()
                .map(clinic -> new ClinicResponse(clinic.getId(),
                        clinic.getName(),
                        clinic.getCnpj(),
                        clinic.getActive(),
                        clinic.getCreatedAt(),
                        clinic.getUpdatedAt()))
                .toList();
        return response;
    }

    public ClinicResponse findById(UUID id) {
        Clinic clinic = clinicRepository.findById(id).orElseThrow(()-> new ClinicNotFoundException("Clinic with this id does not exist"));
        return clinicMapper.toResponse(clinic); //retorna um clinic Response
    }
}
