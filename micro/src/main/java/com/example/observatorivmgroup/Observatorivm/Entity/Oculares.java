package com.example.observatorivmgroup.Observatorivm.Entity;

public class Oculares {
 /**
  *create table Oculares (
        id char(10) not null primary key,
        apertura decimal(6,3) not null,
        longitudFocal decimal(6,3) not null,
        campoVision decimal(6,3) not null,
        marcamodelo char(10) not null,
        estadoEquipamiento char(10) not null,
        constraint fk_estadoEquipamientoOculares foreign key (estadoEquipamiento) references EstadoEquipamiento(id),
        constraint ck_menoresA0Oculares check (apertura > 0 and longitudFocal > 0 and campoVision > 0),
        constraint fk_marcamodeloOcular foreign key (marcamodelo) references MarcaModelo(idmm)
    ); 
   */   
}
