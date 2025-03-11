package com.nomeAzienda.schoolproject.entity;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Teacher extends Person {

    private List<Classroom> classList;

}
