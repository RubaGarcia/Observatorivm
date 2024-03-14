package com.example.observatorivmgroup.Observatorivm.Entity;

public class Descubrimiento {
    /*
     * 
    create table Descubrimiento (
        id char(10) not null primary key,
        persona char(10) null,
        proyecto char(10) null,
        objeto char(10) not null,
        equipamiento char(10) not null,
        fechaDescubrimiento datetime not null default getdate(),
        constraint fk_personaDescubrimiento foreign key (persona) references Persona(id),
        constraint fk_proyectoDescubrimiento foreign key (proyecto) references Proyecto(id),
        constraint fk_objetoDescubrimiento foreign key (objeto) references Objeto(id),
        constraint fk_equipamientoDescubrimiento foreign key (equipamiento) references Equipamiento(id),
        constraint ck_personaProyectoDescubrimiento check ((persona is null and proyecto is not null) or (persona is not null and proyecto is null))
    );
     */
}
