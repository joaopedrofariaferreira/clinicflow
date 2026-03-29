package com.clinicflow.clinic.service;

import com.clinicflow.clinic.dto.ClinicRequest;
import com.clinicflow.clinic.dto.ClinicResponse;
import com.clinicflow.clinic.mapper.ClinicMapper;
import com.clinicflow.clinic.model.Clinic;
import com.clinicflow.clinic.repository.ClinicRepository;
import com.clinicflow.exception.ClinicAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicService {

    @Autowired
    private ClinicMapper clinicMapper;
    @Autowired
    private ClinicRepository clinicRepository;

    public ClinicResponse create (ClinicRequest request){
        if (clinicRepository.existsByCnpj(request.cnpj())) {
            throw new ClinicAlreadyExistsException("Clinic with this CNPJ already exists");
        }
        Clinic clinic = clinicMapper.toEntity(request); //crio uma clinica, chamando o método ToEntity
        clinic.setActive(true); //seto status
        Clinic savedClinic = clinicRepository.save(clinic); //Crio outra clinica e salvo com as informaçoes de antes
        return clinicMapper.toResponse(savedClinic); // retorno a clinica salva
    }

    public List<Clinic> findAll(){
        List<Clinic> clinics = clinicRepository.findAll();
        return clinics;
    }
}
