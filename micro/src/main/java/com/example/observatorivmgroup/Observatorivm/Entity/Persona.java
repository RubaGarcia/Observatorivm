package com.example.observatorivmgroup.Observatorivm.Entity;

public class Persona {
    /**
     * create table Persona (
            id char(10) not null primary key,
            nif char(10) not null unique,
            nombre varchar(30) not null,
            apellido1 varchar(30) not null,
            apellido2 varchar(30) null,
            fechaNacimiento datetime not null,
            fechaRegistro datetime not null default getdate(),
            constraint ck_nif check (nif like ('[KLMXYZ0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]')),
            constraint ck_fechasPersona check (fechaNacimiento < fechaRegistro)
        );
     */
}
