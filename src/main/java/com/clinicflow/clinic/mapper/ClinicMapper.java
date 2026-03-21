package com.clinicflow.clinic.mapper;

import com.clinicflow.clinic.dto.ClinicRequest;
import com.clinicflow.clinic.dto.ClinicResponse;
import com.clinicflow.clinic.model.Clinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClinicMapper {

    public Clinic toEntity(ClinicRequest request){
        Clinic clinic = new Clinic();
        clinic.setName(request.name());
        return clinic;
    }

    public ClinicResponse toResponse(Clinic clinic){
        return new ClinicResponse(
                clinic.getId(),
                clinic.getName(),
                clinic.getActive(),
                clinic.getCreatedAt(),
                clinic.getUpdatedAt()
        );
    }
}
