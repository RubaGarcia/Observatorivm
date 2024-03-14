package com.example.observatorivmgroup.Observatorivm.Entity;

public class TubosOpticos {
    /**
     * create table TubosOpticos (
            id char(10) not null primary key,
            apertura decimal(6,3) not null,
            longitudFocal decimal(7,3) not null,
            tipoTuboOptico char(10) not null,
            marcamodelo char(10) not null,
            estadoEquipamiento char(10) not null,
            constraint fk_tipo foreign key (tipoTuboOptico) references TipoTuboOptico(id),
            constraint fk_estadoEquipamientoTubosOpticos foreign key (estadoEquipamiento) references EstadoEquipamiento(id),
            constraint ck_menoresA0 check (apertura > 0 and longitudFocal > 0),
            constraint fk_marcamodeloTubo foreign key (marcamodelo) references MarcaModelo(idmm)
        );
     */
}
