package com.example.observatorivmgroup.Observatorivm.Entity;

public class PersonaEstado {
    /**
     * create table PersonaEstado (
            idPersona char(10) not null,
            actividad char(10) not null,
            fechaInicio datetime not null,
            fechaFin datetime null,
            estadoPersona varchar(30) not null,
            constraint pk_PersonaEstado primary key (idPersona, fechaInicio),
            constraint fk_PersonaPersonaEstado foreign key (idPersona) references Persona(id),
            constraint ck_estadoPersona check (estadoPersona in ('trabajando', 'baja', 'no contratado')),
            constraint ck_fechasPersonaEstado check (fechaInicio < fechaFin)
        );
     */
}
