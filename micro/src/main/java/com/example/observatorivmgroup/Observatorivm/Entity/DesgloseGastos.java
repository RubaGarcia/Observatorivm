package com.example.observatorivmgroup.Observatorivm.Entity;

public class DesgloseGastos {
    /**
     * create table DesgloseGastos (
            idProyecto char(10) not null,
            cantidad decimal(10,2) not null,
            descripcion varchar(120) not null,
            numeroDesglose char(10) not null,
            constraint pk_DesgloseGastos primary key (idProyecto, numeroDesglose),
            constraint fk_ProyectoDesgloseGastos foreign key (idProyecto) references Proyecto(id)
        );
     */
}
