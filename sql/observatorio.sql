USE master;
go

-- Eliminar base de datos si existe (usa tabla sys del sistema)
IF EXISTS(select * from sys.databases where name='observatorio')
  DROP DATABASE observatorio;
go

-- Crea la base de datos
-- Continuando con la explicaci�n del go, aqu� nos sirve para separar
--  la instrucci�n de creaci�n (create) y de uso (use), ya que el uso
--  mostrar�a error si la base de datos no existe con anterioridad.
create database observatorio;
go

-- Usar la base de datos creada
use observatorio;
go

create table TipoObjeto (
	id char(10) not null primary key,
	nombre varchar(30) not null
);

create table Constelacion (
	id char(10) not null primary key,
	nombre varchar(30) not null,
	descripcion varchar(1000) null
);

create table Objeto (
	id char(10) not null primary key,
	tamanho decimal(12,9) not null,
	magnitud decimal(4,2) not null,
	ar decimal(7,4) not null,
	dec decimal(7,4) not null,
	nombre varchar(30) not null,
	descripcion varchar(1000) not null,
	constelacion char(10) not null,
	tipo char(10) not null, 
	constraint fk_constelacion foreign key (constelacion) references Constelacion(id),
	constraint fk_tipoObjeto foreign key (tipo) references TipoObjeto(id)
);

create table Proyecto (
	id char(10) not null primary key,
	fechaIni datetime not null,
	fechaFin datetime null,
	estadoProyecto varchar(15) not null,
	fechaFinEstimada datetime not null,
	descripcion varchar(300) not null,
	constraint ck_estadoProyecto check (estadoProyecto in ('planificado', 'en proceso', 'finalizado', 'parado', 'cancelado')),
	constraint ck_fechas check (fechaIni < fechaFinEstimada)
);

create table DesglosePresupuesto (
	idProyecto char(10) not null,
	cantidad decimal(10,2) not null,
	descripcion varchar(120) not null,
	numeroDesglose char(10) not null,
	constraint pk_DesglosePresupuesto primary key (idProyecto, numeroDesglose),
	constraint fk_ProyectoDesglosePresupuesto foreign key (idProyecto) references Proyecto(id)
);

create table DesgloseGastos (
	idProyecto char(10) not null,
	cantidad decimal(10,2) not null,
	descripcion varchar(120) not null,
	numeroDesglose char(10) not null,
	constraint pk_DesgloseGastos primary key (idProyecto, numeroDesglose),
	constraint fk_ProyectoDesgloseGastos foreign key (idProyecto) references Proyecto(id)
);

create table Persona (
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

create table PersonaEstado (
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

create table ProyectoPersona (
	idPersona char(10) not null,
	idProyecto char(10) not null,
	fechaInicio datetime not null,
	fechaFin datetime null,
	constraint pk_ProyectoPersona primary key (idPersona, idProyecto),
	constraint fk_proyecto foreign key (idProyecto) references Proyecto(id),
	constraint fk_persona foreign key (idPersona) references Persona(id),
	constraint ck_fechasProyectoPersona check (fechaInicio < fechaFin)
);

create table EstadoEquipamiento (
	id char(10) not null primary key,
	nombre varchar(30)
);

create table MarcaModelo (
	idmm char(10) not null primary key,
	marca varchar(80) not null,
	modelo varchar(80) not null,
);

create table TipoTuboOptico (
	id char(10) not null primary key,
	nombre varchar(30)
);

create table TubosOpticos (
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

create table Oculares (
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

create table TipoMontura (
	id char(10) not null primary key,
	nombre varchar(30)
);

create table Montura (
	id char(10) not null primary key,
	marcamodelo char(10) not null,
	tipoMontura char(10) not null,
	estadoEquipamiento char(10) not null,
	motorizada bit not null,
	constraint fk_estadoEquipamientoMontura foreign key (estadoEquipamiento) references EstadoEquipamiento(id),
	constraint fk_tipoMontura foreign key (tipoMontura) references TipoMontura(id),
	constraint fk_marcamodeloMontura foreign key (marcamodelo) references MarcaModelo(idmm)
);

create table Equipamiento (
	id char(10) not null primary key,
	idTubo char(10) not null,
	idOcular char(10) not null,
	idMontura char(10) not null,
	constraint fk_tubo foreign key (idTubo) references TubosOpticos(id),
	constraint fk_oculares foreign key (idOcular) references Oculares(id),
	constraint fk_montura foreign key (idMontura) references Montura(id),
	constraint u_equipamiento unique (idTubo, idOcular, idMontura)
);

create table LogObservacion (
	id char(10) not null primary key,
	persona char(10) not null,
	objeto char(10) not null,
	equipamiento char(10) not null,
	ar decimal(7,4) not null,
	dec decimal(7,4) not null,
	fechaObservacion datetime default getdate(),
	constraint fk_personaLog foreign key (persona) references Persona(id),
	constraint fk_objeto foreign key (objeto) references Objeto(id),
	constraint fk_equipamiento foreign key (equipamiento) references Equipamiento(id)
);

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