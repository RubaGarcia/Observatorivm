USE observatorio;
go

-- TRIGGER

-- comprobar que las fechas de los estados de actividad de las personas sean correctas
CREATE or alter TRIGGER fechasPersonaEstado ON PersonaEstado FOR INSERT, UPDATE AS
BEGIN
	DECLARE @filas int
	SELECT @filas = count(*) FROM inserted
	IF NOT ((SELECT count(*) FROM inserted i, inserted d WHERE i.idPersona = d.idPersona AND i.fechaInicio <> d.fechaInicio 
		AND ((i.fechaInicio < d.fechaInicio AND i.fechaFin < d.fechaFin) OR (i.fechaInicio > d.fechaInicio AND i.fechaFin > d.fechaFin))) = @filas - 1)
		-- habrá una fila en la que esto no se cumpla, el mismo ya que se compara con la misma tabla, si hay mas que no lo cumplen hay un error
	BEGIN 
		ROLLBACK TRANSACTION
		RAISERROR('No es valido el estado de esta persona', 16, 1)
		RETURN
	END

	IF NOT EXISTS (SELECT * FROM inserted i INNER JOIN Persona p ON i.idPersona = p.id WHERE fechaRegistro < fechaInicio)
	BEGIN
		ROLLBACK TRANSACTION
		RAISERROR('No es valido el estado de esta persona', 16, 1)
		RETURN
	END
END
go

-- comprobar que las fechas de las personas dentro de los proyectos sean correctas
CREATE or alter TRIGGER fechasPersonaProyecto ON ProyectoPersona FOR INSERT, UPDATE AS
BEGIN
	DECLARE @filas int
	SELECT @filas = count(*) FROM inserted
	IF ((SELECT count(*) FROM inserted i, inserted d WHERE i.idPersona = d.idPersona AND i.fechaInicio <> d.fechaInicio 
		AND ((i.fechaInicio < d.fechaInicio AND i.fechaFin < d.fechaFin) OR (i.fechaInicio > d.fechaInicio AND i.fechaFin > d.fechaFin)
		OR (i.fechaInicio < d.fechaInicio AND i.fechaFin > d.fechaFin) OR (i.fechaInicio > d.fechaInicio AND i.fechaFin > d.fechaFin))) <> 1)
		-- habrá una fila en la que esto no se cumpla, el mismo ya que se compara con la misma tabla, si hay mas que no lo cumplen hay un error
	BEGIN 
		ROLLBACK TRANSACTION
		RAISERROR('No es valido el estado de esta persona', 16, 1)
		RETURN
	END

	IF NOT EXISTS (SELECT * FROM inserted i INNER JOIN Persona p ON i.idPersona = p.id WHERE fechaRegistro < fechaInicio)
	BEGIN
		ROLLBACK TRANSACTION
		RAISERROR('No es valido el estado de esta persona', 16, 1)
		RETURN
	END
END
go

-- actualización del estado de oculares al eliminarlo
CREATE or alter TRIGGER eliminaOculares ON Oculares INSTEAD OF DELETE AS
BEGIN
	UPDATE Oculares SET estadoEquipamiento = 'noutil' WHERE id IN (SELECT id FROM deleted)
	RETURN
END
go

-- actualización del estado de Montura al eliminarlo
CREATE or alter TRIGGER eliminaMontura ON Montura INSTEAD OF DELETE AS
BEGIN
	UPDATE Montura SET estadoEquipamiento = 'noutil' WHERE id IN (SELECT id FROM deleted)
	RETURN
END
go

-- actualización del estado de TubosOpticos al eliminarlo
CREATE or alter TRIGGER eliminaTubosOpticos ON TubosOpticos INSTEAD OF DELETE AS
BEGIN
	UPDATE TubosOpticos SET estadoEquipamiento = 'noutil' WHERE id IN (SELECT id FROM deleted)
	RETURN
END
go

-- eliminacion en proyecto que quede como cancelado
CREATE or alter TRIGGER eliminacionProyecto ON Proyecto INSTEAD OF DELETE AS
BEGIN
		UPDATE Proyecto SET estadoProyecto = 'cancelado' WHERE id IN (SELECT id FROM deleted)
		RETURN
END
go

-- comprobar observación en fecha válida
CREATE or alter TRIGGER fechaObservacionValida ON LogObservacion AFTER INSERT AS
BEGIN
    -- la fecha de observación debería estar entre las de inicio y fin del proyecto en que estuviera trabajando la persona
    IF EXISTS(SELECT * FROM inserted i INNER JOIN PersonaEstado pe ON i.persona=pe.idPersona 
					WHERE ((i.fechaObservacion NOT BETWEEN pe.fechaInicio AND pe.fechaFin)
					OR (i.fechaObservacion <= pe.fechaInicio AND pe.fechaFin is not null)) AND pe.EstadoPersona <> 'trabajando')
    BEGIN
        ROLLBACK TRANSACTION
        RAISERROR('La persona no estaba trabajando cuando anotó la observación', 16, 1)
        RETURN
    END
END
go

-- comprobar descubrimiento en fecha válida
CREATE or alter TRIGGER fechaDescubrimientoValida ON Descubrimiento AFTER INSERT AS
BEGIN
    -- la fecha de registro del descubrimiento debería estar entre las de inicio y fin del proyecto en que estuviera trabajando la persona
    IF EXISTS(SELECT * FROM inserted i INNER JOIN PersonaEstado pe ON i.persona=pe.idPersona 
					WHERE i.persona IS NOT NULL AND (i.fechaDescubrimiento NOT BETWEEN pe.fechaInicio AND pe.fechaFin AND pe.estadoPersona <> 'trabajando'))
    BEGIN
        ROLLBACK TRANSACTION
        RAISERROR('La persona no estaba trabajando cuando registró el descubrimiento', 16, 1)
        RETURN
    END
	IF EXISTS(SELECT * FROM inserted i INNER JOIN Proyecto p ON i.proyecto = p.id
					WHERE i.proyecto IS NOT NULL AND (i.fechaDescubrimiento NOT BETWEEN p.fechaIni AND p.fechaFin AND p.estadoProyecto <> 'en proceso'))
	BEGIN
        ROLLBACK TRANSACTION
        RAISERROR('El proyecto no estaba en curso cuando registró el descubrimiento', 16, 1)
        RETURN
    END
END
go