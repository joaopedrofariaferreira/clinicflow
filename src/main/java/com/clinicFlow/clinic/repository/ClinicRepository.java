package com.clinicFlow.clinic.repository;

import com.clinicFlow.clinic.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClinicRepository extends JpaRepository<Clinic, UUID> {

}
