package com.example.observatorivmgroup.Observatorivm.Entity;

public class Proyecto {
    /**
     * create table Proyecto (
            id char(10) not null primary key,
            fechaIni datetime not null,
            fechaFin datetime null,
            estadoProyecto varchar(15) not null,
            fechaFinEstimada datetime not null,
            descripcion varchar(300) not null,
            constraint ck_estadoProyecto check (estadoProyecto in ('planificado', 'en proceso', 'finalizado', 'parado', 'cancelado')),
            constraint ck_fechas check (fechaIni < fechaFinEstimada)
        );
     */
}
