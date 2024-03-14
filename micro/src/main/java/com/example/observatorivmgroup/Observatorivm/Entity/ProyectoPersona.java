package com.example.observatorivmgroup.Observatorivm.Entity;

public class ProyectoPersona {
    /**
     * create table ProyectoPersona (
            idPersona char(10) not null,
            idProyecto char(10) not null,
            fechaInicio datetime not null,
            fechaFin datetime null,
            constraint pk_ProyectoPersona primary key (idPersona, idProyecto),
            constraint fk_proyecto foreign key (idProyecto) references Proyecto(id),
            constraint fk_persona foreign key (idPersona) references Persona(id),
            constraint ck_fechasProyectoPersona check (fechaInicio < fechaFin)
        );
     */
}
