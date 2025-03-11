package com.nomeAzienda.schoolproject.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Classroom extends GenericEntity{


    private String section;

}
