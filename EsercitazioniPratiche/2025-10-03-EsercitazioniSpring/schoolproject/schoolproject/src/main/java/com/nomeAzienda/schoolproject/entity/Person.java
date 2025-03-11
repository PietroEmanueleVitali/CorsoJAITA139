package com.nomeAzienda.schoolproject.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper=true)
public abstract class Person extends GenericEntity{

    private String name;
    private String surname;
    private LocalDate data_nascita;
    private String username;
    private String password;

}
