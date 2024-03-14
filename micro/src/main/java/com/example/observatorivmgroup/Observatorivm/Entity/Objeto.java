package com.example.observatorivmgroup.Observatorivm.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Objeto")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Objeto {
    /*
create table Objeto ( 
    id char(10) not null primary key, 
    tamanho decimal(1) not null, 
    magnitud decimal(4,2) not null, 
    ar decimal(7,4) not null, 
    dec decimal(7,4) not null, 
 

 
    nombre varchar(30) not null, 
    descripcion varchar(80) not null, 
    constelacion char(10) not null, 
    tipo char(10) not null,  
    constraint fk_constelacion foreign key (constelacion) references Constelacion(id), 
    constraint fk_tipoObjeto foreign key (tipo) references TipoObjeto(id) 
); 
    
     */

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tamanho")
    private Double tamanho;

    @Column(name = "magnitud")
    private Double magnitud;

    @Column(name = "ar")
    private Double ar;

    @Column(name = "dec")
    private Double dec;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "constelacion")
    private String constelacion;

    @Column(name = "tipo")
    private String tipo;

    

}
