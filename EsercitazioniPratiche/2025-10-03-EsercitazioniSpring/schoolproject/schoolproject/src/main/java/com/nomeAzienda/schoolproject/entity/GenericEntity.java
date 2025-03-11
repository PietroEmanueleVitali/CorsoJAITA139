package com.nomeAzienda.schoolproject.entity;


import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data //get, set, to string, equals, equals hascode, constructor
@SuperBuilder
public abstract class GenericEntity implements IMappable{

    private final Long id; //vuol dire che deve per forza essere inizializzata (se uso la keyword final)

}
