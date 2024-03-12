USE observatorio;
go

--PROCEDIMIENTOS

--procedimiento para errores
CREATE or alter PROCEDURE usp_showerrorinfo
AS
    SELECT  ERROR_NUMBER() AS [Numero de Error],
            ERROR_STATE() AS [Estado del Error],
            ERROR_SEVERITY() AS [Severidad del Error],
            ERROR_LINE() AS [Linea],
            ISNULL(ERROR_PROCEDURE(), 'No esta en un proc') AS [Procedimiento],
            ERROR_MESSAGE() AS [Mensaje]
go

--registro equipamiento
CREATE or alter PROCEDURE registroEquipamiento @idEquip char(10), @idTubo char(10), @idOcular char(10), @idMontura char(10) AS
	BEGIN TRY
		BEGIN TRANSACTION
			IF EXISTS (SELECT id FROM Equipamiento WHERE (idTubo = @idTubo AND idOcular = @idOcular AND idMontura = @idMontura) OR id = @idEquip)
				RAISERROR('Ya existe un equipamiento con estos componentes', 16, 1)
			INSERT INTO Equipamiento(id, idTubo, idOcular, idMontura)
			VALUES(@idEquip, @idTubo, @idOcular, @idMontura)
		COMMIT TRANSACTION
	END TRY

	BEGIN CATCH
		ROLLBACK TRANSACTION
		EXEC usp_showerrorinfo
	END CATCH
	RETURN
go

--registro tubos opticos
CREATE or alter PROCEDURE registroTubo @idTubo char(10), @apertura decimal(6,3), @longitudFocal decimal(7,3), @tipoTuboOptico char(10), @marca varchar(80), @modelo varchar(80), @estadoEquipamiento char(10) AS
	BEGIN TRY
		BEGIN TRANSACTION
			IF EXISTS (SELECT id FROM TubosOpticos t INNER JOIN MarcaModelo m ON t.marcamodelo = m.idmm
				WHERE apertura = @apertura AND longitudFocal = @longitudFocal AND tipoTuboOptico = @tipoTuboOptico AND estadoEquipamiento = @estadoEquipamiento AND marca = @marca AND modelo = @modelo)
					RAISERROR('Ya existe un tubo con las mismas caracteristicas', 16, 1)
			IF NOT EXISTS (SELECT idmm FROM MarcaModelo WHERE marca = @marca AND modelo = @modelo)
				INSERT INTO MarcaModelo (marca, modelo)
					VALUES (@marca, @modelo)
			DECLARE @idmm char(10)
			SELECT @idmm = idmm FROM MarcaModelo WHERE marca = @marca AND modelo = @modelo
			INSERT INTO TubosOpticos(id, apertura, longitudFocal, tipoTuboOptico, marcamodelo, estadoEquipamiento)
				VALUES(@idTubo, @apertura, @longitudFocal, @tipoTuboOptico, @idmm, @estadoEquipamiento)
		COMMIT TRANSACTION
	END TRY

	BEGIN CATCH
		ROLLBACK TRANSACTION
		EXEC usp_showerrorinfo
	END CATCH
	RETURN
go

--registro tipo de tubo optico
CREATE or alter PROCEDURE registroTipoTubo @id char(10), @nombre varchar(30) AS
	BEGIN TRY
		BEGIN TRANSACTION
			IF EXISTS (SELECT id FROM TipoTuboOptico WHERE nombre = @nombre OR id=@id)
				RAISERROR('Ya existe este tipo de tubo optico', 16, 1)
			INSERT INTO TipoTuboOptico(id, nombre)
				VALUES(@id, @nombre)
		COMMIT TRANSACTION
	END TRY

	BEGIN CATCH
		ROLLBACK TRANSACTION
		EXEC usp_showerrorinfo
	END CATCH
	RETURN
go

--registro oculares
CREATE or alter PROCEDURE registroOcular @idOcular char(10), @apertura decimal(6,3), @longitudFocal decimal(6,3), @campoVision decimal(6,3), @marca varchar(80), @modelo varchar(80), @estadoEquipamiento char(10) AS
	BEGIN TRY
		BEGIN TRANSACTION
			IF EXISTS (SELECT id FROM Oculares o INNER JOIN MarcaModelo m ON o.marcamodelo = m.idmm
				WHERE apertura = @apertura AND longitudFocal = @longitudFocal AND campoVision = @campoVision AND estadoEquipamiento = @estadoEquipamiento AND marca = @marca AND modelo = @modelo)
					RAISERROR('Ya existe un ocular con las mismas caracteristicas', 16, 1)
			IF NOT EXISTS (SELECT idmm FROM MarcaModelo WHERE marca = @marca AND modelo = @modelo)
			INSERT INTO MarcaModelo (marca, modelo)
				VALUES (@marca, @modelo)
			DECLARE @idmm char(10)
			SELECT @idmm = idmm FROM MarcaModelo WHERE marca = @marca AND modelo = @modelo
			INSERT INTO Oculares(id, apertura, longitudFocal, campoVision, marcamodelo, estadoEquipamiento)
			VALUES(@idOcular, @apertura, @longitudFocal, @campoVision, @idmm, @estadoEquipamiento)
		COMMIT TRANSACTION
	END TRY

	BEGIN CATCH
		ROLLBACK TRANSACTION
		EXEC usp_showerrorinfo
	END CATCH
	RETURN
go

--registro de montura
CREATE or alter PROCEDURE registroMontura @id char(10), @motorizada bit, @marca varchar(80), @modelo varchar(80), @tipoMontura char(10), @estadoEquipamiento char(10) AS
	BEGIN TRY
		BEGIN TRANSACTION
			IF EXISTS (SELECT id FROM Montura t INNER JOIN MarcaModelo m ON t.marcamodelo = m.idmm
				WHERE motorizada = @motorizada AND tipoMontura = @tipoMontura AND estadoEquipamiento = @estadoEquipamiento AND marca = @marca AND modelo = @modelo)
					RAISERROR('Ya existe una montura con las mismas caracteristicas', 16, 1)
			IF NOT EXISTS (SELECT idmm FROM MarcaModelo WHERE marca = @marca AND modelo = @modelo)
			INSERT INTO MarcaModelo (marca, modelo)
				VALUES (@marca, @modelo)
			DECLARE @idmm char(10)
			SELECT @idmm = idmm FROM MarcaModelo WHERE marca = @marca AND modelo = @modelo
			INSERT INTO Montura(id, marcamodelo, tipoMontura, estadoEquipamiento, motorizada)
				VALUES(@id, @idmm, @tipoMontura, @estadoEquipamiento, @motorizada)
		COMMIT TRANSACTION
	END TRY

	BEGIN CATCH
		ROLLBACK TRANSACTION
		EXEC usp_showerrorinfo
	END CATCH
	RETURN
go

--registro tipo de montura
CREATE or alter PROCEDURE registroTipoMontura @id char(10), @nombre varchar(30) AS
	BEGIN TRY
		BEGIN TRANSACTION
		IF EXISTS (SELECT id FROM TipoMontura WHERE nombre = @nombre OR id=@id)
			RAISERROR('Ya existe este tipo de montura', 16, 1)
			INSERT INTO TipoMontura(id, nombre)
				VALUES(@id, @nombre)
		COMMIT TRANSACTION
	END TRY

	BEGIN CATCH
		ROLLBACK TRANSACTION
		EXEC usp_showerrorinfo
	END CATCH
	RETURN
go

--registro proyecto: se registra un proyecto como tal, y luego, de forma iterativa se van anhadiendo el desglose del presupuesto y de los gastos
CREATE or alter PROCEDURE registroProyecto @id char(10), @fechaIni datetime, @estadoProyecto varchar(15), @fechaFinEstimada datetime, @descripcion varchar(80) AS
	BEGIN TRY
		BEGIN TRANSACTION
			IF EXISTS (SELECT id FROM Proyecto WHERE fechaIni = @fechaIni AND fechaFinEstimada = @fechaFinEstimada AND estadoProyecto = @estadoProyecto AND descripcion = @descripcion)
				RAISERROR('Ya hay un proyecto con las mismas caracteristicas', 16, 1)
			INSERT INTO Proyecto(id, fechaIni, estadoProyecto, fechaFinEstimada, descripcion)
				VALUES(@id, @fechaIni, @estadoProyecto, @fechaFinEstimada, @descripcion)
		COMMIT TRANSACTION
	END TRY

	BEGIN CATCH
		ROLLBACK TRANSACTION
		EXEC usp_showerrorinfo
	END CATCH
	RETURN
go

CREATE or alter PROCEDURE registroDesglosePresupuesto @idProyecto char(10), @cantidad decimal(10,2), @descripcion varchar(30), @numeroDesglose char(10) AS
	BEGIN TRY
		BEGIN TRANSACTION
			IF EXISTS (SELECT * FROM DesglosePresupuesto WHERE idProyecto = @idProyecto AND numeroDesglose = @numeroDesglose)
				RAISERROR('Ya existe un desglose con esas características', 16, 1)
			INSERT INTO DesglosePresupuesto(idProyecto, cantidad, descripcion, numeroDesglose)
				VALUES(@idProyecto, @cantidad, @descripcion, @numeroDesglose)
		COMMIT TRANSACTION
	END TRY

	BEGIN CATCH
		ROLLBACK TRANSACTION
		EXEC usp_showerrorinfo
	END CATCH
	RETURN
go

CREATE or alter PROCEDURE registroDesgloseGasto @idProyecto char(10), @cantidad decimal(10,2), @descripcion varchar(30), @numeroDesglose char(10) AS
	BEGIN TRY
		BEGIN TRANSACTION
			IF EXISTS (SELECT * FROM DesgloseGastos WHERE idProyecto = @idProyecto AND numeroDesglose = @numeroDesglose)
				RAISERROR('Ya existe un desglose con esas características', 16, 1)
			INSERT INTO DesgloseGastos(idProyecto, cantidad, descripcion, numeroDesglose)
			VALUES(@idProyecto, @cantidad, @descripcion, @numeroDesglose)
		COMMIT TRANSACTION
	END TRY

	BEGIN CATCH
		ROLLBACK TRANSACTION
		EXEC usp_showerrorinfo
	END CATCH
	RETURN
go

--insercion investigador
CREATE or alter PROCEDURE registroPersonal @id char(10), @nif char(10), @nombre varchar(30), @apellido1 varchar(30), @apellido2 varchar(30) = NULL, 
								   @fechaNacimiento datetime, @fechaRegistro datetime = getdate AS
BEGIN TRY
	BEGIN TRANSACTION
	IF EXISTS (SELECT id FROM Persona WHERE id = @id OR nif = @nif)
		RAISERROR('No es posible registrar a esta persona', 16, 1)
	INSERT INTO Persona (id, nif, nombre, apellido1, apellido2, fechaNacimiento, fechaRegistro)
		VALUES (@id, @nif, @nombre, @apellido1, @apellido2, @fechaNacimiento, @fechaRegistro)
	COMMIT TRANSACTION
END TRY

BEGIN CATCH
	ROLLBACK TRANSACTION
	exec usp_showerrorinfo
END CATCH
RETURN
go

--insercion objetos
CREATE or alter PROCEDURE crearObjeto @id char(10), @tamanho decimal(4,2), @magnitud decimal(4,2), @ar decimal(7,4), @dec decimal(7,4), @nombre varchar(30), 
							 @descripcion varchar(80), @constelacion char(30), @tipo char(10) AS
BEGIN TRY
	BEGIN TRANSACTION
		IF EXISTS (SELECT id FROM Objeto WHERE id = @id OR nombre = @nombre)
			RAISERROR('Ya existe dicho objeto', 16, 1)
		DECLARE @const char(10)
		SELECT @const=id FROM Constelacion WHERE nombre=@constelacion
		INSERT INTO Objeto (id, tamanho, magnitud, ar, dec, nombre, descripcion, constelacion, tipo)
			VALUES (@id, @tamanho, @magnitud, @ar, @dec, @nombre, @descripcion, @const, @tipo)
	COMMIT TRANSACTION
END TRY

BEGIN CATCH
	ROLLBACK TRANSACTION
	exec usp_showerrorinfo
END CATCH
RETURN
go

--registro descubrimiento
CREATE or alter PROCEDURE registrarDescubrimiento @id char(10), @persona char(10) = NULL, @proyecto char(10) = NULL, @objeto char(10), @equipamiento char(10), 
										 @fechaDescubrimiento datetime = getdate AS
BEGIN TRY
	BEGIN TRANSACTION
		IF EXISTS (SELECT id FROM Descubrimiento 
			WHERE ((persona = @persona OR proyecto = @proyecto) AND objeto = @objeto AND equipamiento = @equipamiento AND fechaDescubrimiento = @fechaDescubrimiento))
			RAISERROR('El descubrimiento ya ha sido realizado', 16, 1)
		IF EXISTS (SELECT id FROM Descubrimiento WHERE id = @id)
			RAISERROR('El id ya esta registrado', 16, 1)
		INSERT INTO Descubrimiento (id, persona, proyecto, objeto, equipamiento, fechaDescubrimiento)
			VALUES (@id, @persona, @proyecto, @objeto, @equipamiento, @fechaDescubrimiento)
	COMMIT TRANSACTION
END TRY

BEGIN CATCH
	ROLLBACK TRANSACTION
	EXEC usp_showerrorinfo
END CATCH
RETURN
go

--insercion tipo de objeto
CREATE or alter PROCEDURE nuevoTipoObjeto @id char(10), @nombre varchar(30) AS
BEGIN TRY
    BEGIN TRANSACTION
		IF EXISTS (SELECT id FROM TipoObjeto WHERE id = @id OR nombre = @nombre)
			RAISERROR('El tipo de objeto ya está registrado', 16, 1)
		INSERT INTO TipoObjeto(id, nombre)
			VALUES (@id, @nombre)
    COMMIT TRANSACTION
END TRY

BEGIN CATCH
    ROLLBACK TRANSACTION
    exec usp_showerrorinfo
END CATCH
RETURN
go

--insercion persona-estado
CREATE or alter PROCEDURE cambioEstadoPersona @idPersona char(10), @actividad char(10), @fechaInicio datetime, @fechaFin datetime, @estadoPersona varchar(30)
AS
BEGIN TRY
    BEGIN TRANSACTION
		IF EXISTS (SELECT actividad FROM personaEstado WHERE idPersona = @idPersona AND fechaInicio <= @fechaInicio)
			RAISERROR('La persona ya tiene un periodo de actividad abierto en esta fecha', 16, 1)
		INSERT INTO PersonaEstado (idPersona, actividad, fechaInicio, fechaFin, estadoPersona)
		    VALUES (@idPersona, @actividad, @fechaInicio, @fechaFin, @estadoPersona)
    COMMIT TRANSACTION
END TRY

BEGIN CATCH
    ROLLBACK TRANSACTION
    exec usp_showerrorinfo
END CATCH
RETURN
go

--insercion de una observacion
CREATE or alter PROCEDURE procLogObservacion @id char(10), @persona char(10), @objeto char(10), @equipamiento char(10), @ar decimal(7,4), 
											@dec decimal(7,4), @fechaObservacion datetime
AS
BEGIN TRY
	BEGIN TRANSACTION
		IF EXISTS (SELECT id FROM LogObservacion WHERE id = @id)
			RAISERROR('Ya hay un log con ese id', 16, 1)
		IF EXISTS (SELECT id FROM LogObservacion 
			WHERE persona = @persona AND objeto = @objeto AND equipamiento = @equipamiento AND ar = @ar AND dec = @dec AND fechaObservacion = @fechaObservacion)
			RAISERROR('Ya hay un loc con esas caracteristicas', 16, 1)
		INSERT INTO LogObservacion (id, persona, objeto, equipamiento, ar, dec, fechaObservacion)
			VALUES (@id, @persona, @objeto, @equipamiento, @ar, @dec, @fechaObservacion)
    COMMIT TRANSACTION
END TRY

BEGIN CATCH
	ROLLBACK TRANSACTION
    exec usp_showerrorinfo
END CATCH
RETURN
go

--insertar el estado de un equipamiento
CREATE or alter PROCEDURE procEstadoEquipamiento @id char(10), @nombre varchar(30)
AS
BEGIN TRY
    BEGIN TRANSACTION
		IF EXISTS (SELECT id FROM estadoEquipamiento WHERE id = @id AND nombre = @nombre)
			RAISERROR('No se puede añadir este estado', 16, 1)
		INSERT INTO EstadoEquipamiento(id, nombre)
			VALUES (@id, @nombre)
    COMMIT TRANSACTION
END TRY

BEGIN CATCH
    ROLLBACK TRANSACTION
    exec usp_showerrorinfo
END CATCH
go

--insertar una constelacion
CREATE or alter PROCEDURE procConstelacion @id char(10), @nombre varchar(30), @descripcion varchar(80)
AS
BEGIN TRY
    BEGIN TRANSACTION
		IF EXISTS (SELECT id FROM Constelacion WHERE id = @id AND nombre = @nombre)
			RAISERROR('La constelacion ya existe', 16, 1)
		INSERT INTO Constelacion(id,nombre,descripcion)
			VALUES (@id, @nombre,@descripcion)
    COMMIT TRANSACTION
END TRY

BEGIN CATCH
    ROLLBACK TRANSACTION
    exec usp_showerrorinfo
END CATCH
RETURN
go

-- insertar una persona en un proyecto
CREATE or alter PROCEDURE procProyectoPersona @idPersona char(10), @idProyecto char(10), @FechaInicio datetime, @FechaFin datetime
AS
BEGIN TRY
    BEGIN TRANSACTION
		IF EXISTS (SELECT idPersona FROM ProyectoPersona WHERE idPersona = @idPersona AND idProyecto = @idProyecto AND fechaInicio = @fechaInicio)
			RAISERROR('No se puede añadir a la persona', 16, 1)
		INSERT INTO ProyectoPersona(idPersona,idProyecto,fechaInicio, fechaFin)
			VALUES (@idPersona,@idProyecto,@FechaInicio, @FechaFin)
    COMMIT TRANSACTION
END TRY

BEGIN CATCH
    ROLLBACK TRANSACTION
    exec usp_showerrorinfo
END CATCH
RETURN
go

-- actualizar estado equipamiento
CREATE or alter PROCEDURE procCambiaEstado @idEquipamiento char(10), @nombreEstado varchar(30)
AS
BEGIN TRY
	BEGIN TRANSACTION
		DECLARE @idTubo char(10)
		DECLARE @idOcular char(10)
		DECLARE @idMontura char(10)
		SELECT @idTubo = idTubo, @idMontura = idMontura, @idOcular = idOcular FROM Equipamiento WHERE id = @idEquipamiento
		DECLARE @idEstado char(10)
		SELECT @idEstado = id FROM EstadoEquipamiento WHERE @nombreEstado = nombre
		UPDATE TubosOpticos SET estadoEquipamiento = @idEstado WHERE id = @idTubo
		UPDATE Oculares SET estadoEquipamiento = @idEstado WHERE id = @idOcular
		UPDATE Montura SET estadoEquipamiento = @idEstado WHERE id = @idMontura
	COMMIT TRANSACTION
END TRY

BEGIN CATCH
	ROLLBACK TRANSACTION
	exec usp_showerrorinfo
END CATCH
RETURN
go