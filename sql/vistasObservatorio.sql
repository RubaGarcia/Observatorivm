USE observatorio;
go

-- VIEWS

-- vista EstadoPersona
CREATE VIEW estadoTodoPersonal AS
    SELECT p.nif, p.nombre, p.apellido1, p.apellido2, p.fechaNacimiento, p.fechaRegistro, e.estadoPersona, e.fechaInicio, e.fechaFin 
		FROM PersonaEstado e INNER JOIN Persona p ON p.id = e.idPersona
go

--vista log observaciones
CREATE VIEW vistaLogObservacion AS 
	SELECT p.id AS id, p.nif AS nif, o.nombre AS objeto, l.fechaObservacion AS fechaObservacion, l.equipamiento AS Equipamiento, l.ar AS ar, l.dec AS dec 
		FROM LogObservacion l INNER JOIN Persona p ON p.id = l.persona INNER JOIN Objeto o ON o.id = l.objeto
go

--vista de constelaciones
CREATE VIEW vistaConstelacion AS
	SELECT c.nombre AS constelacion, c.descripcion AS infoConstelacion, o.nombre AS objeto, o.tipo AS tipoObjeto, o.descripcion AS infoObjeto
		FROM Constelacion c INNER JOIN Objeto o ON o.constelacion = c.id
go