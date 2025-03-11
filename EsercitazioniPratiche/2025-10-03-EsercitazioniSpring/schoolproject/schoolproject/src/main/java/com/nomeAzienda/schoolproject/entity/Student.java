package com.nomeAzienda.schoolproject.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Student extends Person { 

    private Classroom classroom;
}
