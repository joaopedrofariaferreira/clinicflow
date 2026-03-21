package com.clinicflow.clinic.dto;
import java.time.LocalDateTime;
import java.util.UUID;
//Quando criamos uma record, apeans declaramos o que precisamos, por padrão, umaclasse record já gera acessores
public record ClinicResponse (    UUID id,
                                  String name,
                                  Boolean active,
                                  LocalDateTime createdAt,
                                  LocalDateTime updatedAt){

}
