-- PRUEBAS
USE observatorio;
go

--VISTAS
SELECT * FROM vistaConstelacion; --probado
SELECT * FROM vistaLogObservacion; --probado
SELECT * FROM estadoTodoPersonal; --probado

--FUNCIONES
SELECT dbo.gasto('proyect1'); --probado
SELECT dbo.presupuesto('proyect2'); --probado
SELECT dbo.identificacion(88.79, 7.4069); --probado
SELECT * FROM dbo.busquedaPorDescubridor('001'); --probado
SELECT * FROM dbo.busquedaPorEquipamientoDescubridor('eq1'); --probado
SELECT * FROM dbo.busquedaPorMagnitud(0.42); --probado
SELECT * FROM dbo.busquedaPorNombre('Betelgeuse'); --probado
SELECT * FROM dbo.busquedaPorTipo('estrella'); --probado
SELECT * FROM dbo.consultaDescubrimientoPersona('001'); --probado
SELECT * FROM dbo.consultaDescubrimientoProyecto('proyect2'); --probado
SELECT * FROM dbo.consultaEquipamiento(); --probado
SELECT * FROM dbo.consultaEstadoPersona('001'); --probado
SELECT * FROM dbo.consultaInvestigadorId('001'); --probado
SELECT * FROM dbo.consultaInvestigadorNIF('64534564F'); --probado
SELECT * FROM dbo.funcionObservacionesHastaFecha('05/06/2030'); --probado
SELECT * FROM dbo.funcionObservacionesIgual('14-09-2019'); --probado
SELECT * FROM dbo.FuncionProyectoEstado('finalizado'); --probado
SELECT * FROM dbo.FuncionProyectoId('proyect1'); --probado
SELECT * FROM dbo.FuncionProyectoIdPersona('001'); --probado 
SELECT * FROM dbo.FuncionProyectoIdProyecto('proyect1'); --probado

--PROCEDIMIENTOS
EXEC dbo.cambioEstadoPersona '001', 1, '20-02-2020', '20-03-2020', 'trabajando'; --probado
EXEC dbo.crearObjeto 'prueba', 4, 4, 4, 4, 'prueba', 'descripcion', 'Orión', 'est'; --probado
EXEC dbo.nuevoTipoObjeto 'prueba', 'prueba'; --probado
EXEC dbo.procCambiaEstado 'equip1', 'libre';  --probado
EXEC dbo.procConstelacion 'prueba', 'prueba', 'descripcion'; --probado
EXEC dbo.procEstadoEquipamiento 'prueba', 'prueba'; --probado
EXEC dbo.procLogObservacion '01', '001', 'est1', 'equip1', 4, 4, '23-02-2020'; --probado
EXEC dbo.procProyectoPersona '001', 'proyect1', '05/03/2003', '05/04/2003'; --probado
EXEC dbo.registrarDescubrimiento 'desc1', '001', null, 'est1', 'equip1', '27-02-2020'; --probado
EXEC dbo.registrarDescubrimiento 'desc2', null, 'proyect1', 'est2', 'equip1', '23-02-2020'; --probado
EXEC dbo.registroDesgloseGasto 'proyect1', 300.9, 'personas', 1;  --probado
EXEC dbo.registroDesglosePresupuesto 'proyect2', 303.9, 'personas', 1; --probado
EXEC dbo.registroEquipamiento 'equip1', 'tubo1', 'ocular1', 'montura1'; --probado
EXEC dbo.registroEquipamiento 'prueba', 'prueba', 'prueba', 'prueba'; --probado
EXEC dbo.registroMontura 'prueba', 0, 'SKYWATCHER', 'ALLVIEW', 'eq', 'libre'; --probado
EXEC dbo.registroMontura 'prueba', 0, 'SKYWATCHER', 'ALLVIEW', 'az', 'libre'; --probado da fallo porque ya hay una igual
EXEC dbo.registroOcular 'prueba', 5, 5, 5, 'SKYWATCHER', 'ALLVIEW', 'libre'; --probado
EXEC dbo.registroPersonal 'prueba', '76767676M', 'prueba', 'prueba', 'prueba', '12/03/1956', '03/07/2005'; --probado
EXEC dbo.registroProyecto 'prueba', '02-03-2001', 'planificado', '03-04-2001', 'prueba'; --probado
EXEC dbo.registroProyecto 'prueba', '02-03-2001', 'planificado', '03-02-2001', 'prueba'; --probado da fallo en ck_fechas
EXEC dbo.registroTipoMontura 'prueba', 'prueba'; --probado
EXEC dbo.registroTipoTubo 'prueba', 'prueba'; --probado
EXEC dbo.registroTubo 'prueba', 4, 4, 'rfr', 'SKYWATCHER', 'ALLVIEW', 'libre'; --probado

--TRIGGER
INSERT INTO PersonaEstado (idPersona, actividad, fechaInicio, fechaFin, estadoPersona)
VALUES('001', 'act1', '04-03-2020', '03-05-2020', 'baja'); --probado fechaPersonaEstado
DELETE FROM Oculares WHERE id = 'prueba'; --probado eliminaOculares
DELETE FROM Montura WHERE id = 'prueba'; --probado eliminaMontura
DELETE FROM TubosOpticos WHERE id = 'prueba'; --probado eliminaTubosOpticos
SELECT o.id, o.estadoEquipamiento, m.id, m.estadoEquipamiento, t.id, t.estadoEquipamiento
	FROM Equipamiento e INNER JOIN Oculares o ON e.idOcular = o.id INNER JOIN Montura m ON e.idMontura = m.id INNER JOIN TubosOpticos t ON e.idTubo = t.id;
DELETE FROM Proyecto WHERE id = 'proyect1'; --probado eliminacionProyecto
SELECT * FROM Proyecto;
-- Triggers de fechaObservacionValida y fechaDescubrimientoValida probados al hacer las inserciones con los procedimientos