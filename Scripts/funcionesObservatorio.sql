USE observatorio;
go

--FUNCIONES

--campos calculados
CREATE or alter FUNCTION presupuesto (@proyecto char(10)) RETURNS decimal(10,2) AS
BEGIN
	DECLARE @presupuesto decimal(10,2)
	SELECT @presupuesto=sum(cantidad) FROM DesglosePresupuesto WHERE idProyecto=@proyecto
	RETURN @presupuesto
END
go

CREATE or alter FUNCTION gasto (@proyecto char(10)) RETURNS decimal(10,2) AS
BEGIN
	DECLARE @gasto decimal(10,2)
	SELECT @gasto=sum(cantidad) FROM DesgloseGastos WHERE idProyecto=@proyecto
	RETURN @gasto
END
go

ALTER TABLE Proyecto 
	ADD presupuesto AS dbo.presupuesto(id);
ALTER TABLE Proyecto
	ADD gasto AS dbo.gasto(id);
go

--busquedas
CREATE or alter FUNCTION busquedaPorTipo (@tipo varchar(30)) RETURNS table AS
	RETURN (SELECT o.nombre AS NombreObjeto, o.constelacion AS Constelacion, o.descripcion AS Descripcion, 
			o.tamanho AS Tamaño, o.magnitud AS MagnitudEstelar, o.ar AS CoordenadaAr, o.dec AS CoordenadaDec, 
			t.nombre AS TipoObjeto, d.persona AS Descubridor, e.idMontura AS Montura, e.idOcular AS Ocular, e.idTubo AS TuboOptico
			FROM Objeto o INNER JOIN TipoObjeto t ON o.tipo = t.id INNER JOIN Descubrimiento d ON o.id = d.objeto
			INNER JOIN Equipamiento e ON d.equipamiento = e.id  WHERE t.nombre = @tipo and d.persona is not NULL
			UNION 
			SELECT o.nombre AS NombreObjeto, o.constelacion AS Constelacion, o.descripcion AS Descripcion, 
			o.tamanho AS Tamaño, o.magnitud AS MagnitudEstelar, o.ar AS CoordenadaAr, o.dec AS CoordenadaDec, 
			t.nombre AS TipoObjeto, d.proyecto AS Descubridor, e.idMontura AS Montura, e.idOcular AS Ocular, e.idTubo AS TuboOptico
			FROM Objeto o INNER JOIN TipoObjeto t ON o.tipo = t.id INNER JOIN Descubrimiento d ON o.id = d.objeto
			INNER JOIN Equipamiento e ON d.equipamiento = e.id  WHERE t.nombre = @tipo and d.proyecto is not NULL) 
go

CREATE or alter FUNCTION busquedaPorNombre (@nombre varchar(30)) RETURNS table AS
	RETURN (SELECT o.nombre AS NombreObjeto, o.constelacion AS Constelacion, o.descripcion AS Descripcion, 
			o.tamanho AS Tamaño, o.magnitud AS MagnitudEstelar, o.ar AS CoordenadaAr, o.dec AS CoordenadaDec, 
			t.nombre AS TipoObjeto, d.persona AS Descubridor, e.idMontura AS Montura, e.idOcular AS Ocular, e.idTubo AS TuboOptico
			FROM Objeto o INNER JOIN TipoObjeto t ON o.tipo = t.id INNER JOIN Descubrimiento d ON o.id = d.objeto
			INNER JOIN Equipamiento e ON d.equipamiento = e.id  WHERE o.nombre = @nombre and d.persona is not NULL
			UNION 
			SELECT o.nombre AS NombreObjeto, o.constelacion AS Constelacion, o.descripcion AS Descripcion, 
			o.tamanho AS Tamaño, o.magnitud AS MagnitudEstelar, o.ar AS CoordenadaAr, o.dec AS CoordenadaDec, 
			t.nombre AS TipoObjeto, d.proyecto AS Descubridor, e.idMontura AS Montura, e.idOcular AS Ocular, e.idTubo AS TuboOptico
			FROM Objeto o INNER JOIN TipoObjeto t ON o.tipo = t.id INNER JOIN Descubrimiento d ON o.id = d.objeto
			INNER JOIN Equipamiento e ON d.equipamiento = e.id  WHERE o.nombre = @nombre and d.proyecto is not NULL) 
go

CREATE or alter FUNCTION busquedaPorMagnitud (@magnitud decimal(4,2)) RETURNS table AS
	RETURN (SELECT o.nombre AS NombreObjeto, o.constelacion AS Constelacion, o.descripcion AS Descripcion, 
			o.tamanho AS Tamaño, o.magnitud AS MagnitudEstelar, o.ar AS CoordenadaAr, o.dec AS CoordenadaDec, 
			t.nombre AS TipoObjeto, d.persona AS Descubridor, e.idMontura AS Montura, e.idOcular AS Ocular, e.idTubo AS TuboOptico
			FROM Objeto o INNER JOIN TipoObjeto t ON o.tipo = t.id INNER JOIN Descubrimiento d ON o.id = d.objeto
			INNER JOIN Equipamiento e ON d.equipamiento = e.id  WHERE o.magnitud = @magnitud and d.persona is not NULL
			UNION 
			SELECT o.nombre AS NombreObjeto, o.constelacion AS Constelacion, o.descripcion AS Descripcion, 
			o.tamanho AS Tamaño, o.magnitud AS MagnitudEstelar, o.ar AS CoordenadaAr, o.dec AS CoordenadaDec, 
			t.nombre AS TipoObjeto, d.proyecto AS Descubridor, e.idMontura AS Montura, e.idOcular AS Ocular, e.idTubo AS TuboOptico
			FROM Objeto o INNER JOIN TipoObjeto t ON o.tipo = t.id INNER JOIN Descubrimiento d ON o.id = d.objeto
			INNER JOIN Equipamiento e ON d.equipamiento = e.id  WHERE o.magnitud = @magnitud and d.proyecto is not NULL) 
go

CREATE or alter FUNCTION busquedaPorDescubridor (@id char(10)) RETURNS table AS
	RETURN (SELECT o.nombre AS NombreObjeto, o.constelacion AS Constelacion, o.descripcion AS Descripcion, 
			o.tamanho AS Tamaño, o.magnitud AS MagnitudEstelar, o.ar AS CoordenadaAr, o.dec AS CoordenadaDec, 
			t.nombre AS TipoObjeto, d.persona AS Descubridor, e.idMontura AS Montura, e.idOcular AS Ocular, e.idTubo AS TuboOptico
			FROM Objeto o INNER JOIN TipoObjeto t ON o.tipo = t.id INNER JOIN Descubrimiento d ON o.id = d.objeto
			INNER JOIN Equipamiento e ON d.equipamiento = e.id  WHERE d.persona = @id 
			UNION 
			SELECT o.nombre AS NombreObjeto, o.constelacion AS Constelacion, o.descripcion AS Descripcion, 
			o.tamanho AS Tamaño, o.magnitud AS MagnitudEstelar, o.ar AS CoordenadaAr, o.dec AS CoordenadaDec, 
			t.nombre AS TipoObjeto, d.proyecto AS Descubridor, e.idMontura AS Montura, e.idOcular AS Ocular, e.idTubo AS TuboOptico
			FROM Objeto o INNER JOIN TipoObjeto t ON o.tipo = t.id INNER JOIN Descubrimiento d ON o.id = d.objeto
			INNER JOIN Equipamiento e ON d.equipamiento = e.id  WHERE d.proyecto = @id) 
go

CREATE or alter FUNCTION busquedaPorEquipamientoDescubridor (@id char(10)) RETURNS table AS
	RETURN (SELECT o.nombre AS NombreObjeto, o.constelacion AS Constelacion, o.descripcion AS Descripcion, 
			o.tamanho AS Tamaño, o.magnitud AS MagnitudEstelar, o.ar AS CoordenadaAr, o.dec AS CoordenadaDec, 
			t.nombre AS TipoObjeto, d.persona AS Descubridor, e.idMontura AS Montura, e.idOcular AS Ocular, e.idTubo AS TuboOptico
			FROM Objeto o INNER JOIN TipoObjeto t ON o.tipo = t.id INNER JOIN Descubrimiento d ON o.id = d.objeto
			INNER JOIN Equipamiento e ON d.equipamiento = e.id  WHERE d.equipamiento = @id and d.persona is not NULL
			UNION 
			SELECT o.nombre AS NombreObjeto, o.constelacion AS Constelacion, o.descripcion AS Descripcion, 
			o.tamanho AS Tamaño, o.magnitud AS MagnitudEstelar, o.ar AS CoordenadaAr, o.dec AS CoordenadaDec, 
			t.nombre AS TipoObjeto, d.proyecto AS Descubridor, e.idMontura AS Montura, e.idOcular AS Ocular, e.idTubo AS TuboOptico
			FROM Objeto o INNER JOIN TipoObjeto t ON o.tipo = t.id INNER JOIN Descubrimiento d ON o.id = d.objeto
			INNER JOIN Equipamiento e ON d.equipamiento = e.id  WHERE d.equipamiento = @id and d.proyecto is not NULL) 
go

--identificacion
CREATE or alter FUNCTION identificacion (@coordenadaAr decimal(7,4), @coordenadaDec decimal(7,4)) RETURNS varchar(30) AS
BEGIN
	DECLARE @nombre varchar(30)
	SELECT @nombre=nombre FROM Objeto WHERE (ar = @coordenadaAr and dec = @coordenadaDec) or 
			(ar BETWEEN @coordenadaAr+2.5 AND @coordenadaAr-2.5 and dec BETWEEN @coordenadaDec+7.5 AND @coordenadaDec-7.5)
	RETURN @nombre
END
go

--info constelacion
CREATE or alter FUNCTION ObjetosDeConstelacion (@constelacion varchar(30)) RETURNS table AS
	RETURN (SELECT o.nombre FROM Constelacion c INNER JOIN Objeto o ON c.id = o.constelacion WHERE c.nombre = @constelacion)
go

--consulta investigador
CREATE or alter FUNCTION consultaInvestigadorId (@id char(10)) RETURNS table AS
	RETURN (SELECT p.nombre, p.apellido1, p.apellido2, p.fechaNacimiento, p.fechaRegistro, p.nif, e.estadoPersona, pr.fechaInicio, pr.fechaFin, pr.idProyecto 
			FROM Persona p INNER JOIN PersonaEstado e ON p.id = e.idPersona INNER JOIN ProyectoPersona pr ON p.id = pr.idPersona WHERE p.id = @id)
go

CREATE or alter FUNCTION consultaInvestigadorNIF (@nif char(10)) RETURNS table AS
	RETURN (SELECT p.nombre, p.apellido1, p.apellido2, p.fechaNacimiento, p.fechaRegistro, p.nif, e.estadoPersona, pr.fechaInicio, pr.fechaFin, pr.idProyecto 
			FROM Persona p INNER JOIN PersonaEstado e ON p.id = e.idPersona INNER JOIN ProyectoPersona pr ON p.id = pr.idPersona WHERE p.nif = @nif)
go

--consulta descubrimiento
CREATE or alter FUNCTION consultaDescubrimientoPersona (@persona char(10)) RETURNS table AS
	RETURN (SELECT d.id, d.persona, d.objeto, d.equipamiento, d.fechaDescubrimiento FROM Descubrimiento d WHERE persona = @persona)
go

CREATE or alter FUNCTION consultaDescubrimientoProyecto (@proyecto char(10)) RETURNS table AS
	RETURN (SELECT d.id, d.proyecto, d.objeto, d.equipamiento, d.fechaDescubrimiento FROM Descubrimiento d WHERE proyecto = @proyecto)
go

--consulta equipamiento
CREATE or alter FUNCTION consultaEquipamiento () RETURNS table AS
	RETURN (SELECT t.id AS Tubo, qt.nombre AS EstadoTubo, m.id AS Montura, qm.nombre AS EstadoMontura, o.id AS Ocular, qo.nombre AS EstadoOcular
			FROM Equipamiento e INNER JOIN TubosOpticos t ON e.idTubo = t.id INNER JOIN EstadoEquipamiento qt ON t.estadoEquipamiento = qt.id
			INNER JOIN Montura m ON e.idMontura = m.id INNER JOIN EstadoEquipamiento qm ON m.estadoEquipamiento = qm.id
			INNER JOIN Oculares o ON e.idOcular = o.id INNER JOIN EstadoEquipamiento qo ON o.estadoEquipamiento = qo.id)
go

--consulta estado persona
CREATE or alter FUNCTION consultaEstadoPersona (@idPersona char(10)) RETURNS table AS
    RETURN (SELECT e.idPersona, e.estadoPersona, e.fechaInicio, e.fechaFin FROM PersonaEstado e WHERE e.idPersona = @idPersona)
go

--consulta observaciones
CREATE or alter FUNCTION funcionObservacionesHastaFecha (@fechaObservacion datetime) RETURNS table AS
	RETURN SELECT * FROM LogObservacion WHERE @fechaObservacion >= fechaObservacion;
go

CREATE or alter FUNCTION funcionObservacionesIgual (@fechaObservacion datetime) RETURNS table AS
	RETURN SELECT * FROM LogObservacion WHERE @fechaObservacion = fechaObservacion;
go

--consulta de proyectos
CREATE or alter FUNCTION FuncionProyectoId (@id char(10)) RETURNS table AS
    RETURN (SELECT * FROM Proyecto where proyecto.id = @id)
go

CREATE or alter FUNCTION FuncionProyectoEstado (@estado varchar(15)) RETURNS table AS
    RETURN (SELECT * FROM Proyecto WHERE estadoProyecto = @estado)
go

--consulta de personas en proyectos
CREATE or alter FUNCTION FuncionProyectoIdPersona (@id char(10)) RETURNS table AS
    RETURN (SELECT * FROM ProyectoPersona where proyectoPersona.idPersona = @id);
go

CREATE or alter FUNCTION FuncionProyectoIdProyecto (@id char(10)) RETURNS table AS
    RETURN (SELECT * FROM ProyectoPersona where proyectoPersona.idProyecto = @id);
go