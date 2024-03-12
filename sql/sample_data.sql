-----------------------------------------------------------
-- Script para realizar pruebas de la parte programática --
-----------------------------------------------------------
use observatorio
go

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- TIPOS DE OBJETOS ASTRONÓMICOS -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into TipoObjeto(id, nombre)
	values('est', 'estrella');
insert into TipoObjeto(id, nombre)
	values('gal', 'galaxia');
insert into TipoObjeto(id, nombre)
	values('neb', 'nebulosa');
insert into TipoObjeto(id, nombre)
	values('clu', 'cumulo'); --clu de cluster

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- CONSTELACIONES ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into Constelacion(id, nombre, descripcion)
	values('const1', 'Orión', 'Orión —el Cazador— es una constelación prominente, quizás la más conocida del cielo. Sus estrellas brillantes y visibles desde ambos hemisferios hacen que esta constelación sea reconocida mundialmente. Fuente: https://es.wikipedia.org/wiki/Orión_(constelación)');
insert into Constelacion(id, nombre, descripcion)
	values('const2', 'Aquila', 'Aquila (el Águila) es una de las 48 constelaciones listadas por Ptolomeo, mencionada también por Eudoxo de Cnidos (siglo IV a. C.) y Arato (siglo III a. C.), y actualmente una de las 88 constelaciones reconocidas por la IAU. Fuente: https://es.wikipedia.org/wiki/Aquila_(constelación)');
insert into Constelacion(id, nombre, descripcion)
	values('const3', 'Aquarius', 'Acuario (el portador del agua o ánfora), es una de las 88 constelaciones reconocidas por la astronomía moderna, descrita por Claudio Ptolomeo. Su símbolo representa el flujo del agua. Fuente: https://es.wikipedia.org/wiki/Acuario_(constelación)');
insert into Constelacion(id, nombre, descripcion)
	values('const4', 'Serpens', 'Serpens (la serpiente) es una de las 88 constelaciones modernas y era una de las 48 listadas por Ptolomeo. Está dividida en dos partes: Serpens Caput, que representa la cabeza de la serpiente, situada al oeste, y Serpens Cauda, que representa la cola, al este. Fuente: https://es.wikipedia.org/wiki/Serpens');
insert into Constelacion(id, nombre, descripcion)
	values('const5', 'Hércules', 'Recibe su nombre del héroe mitológico, Hércules y es la quinta en tamaño de las 88 constelaciones modernas. También era una de las 48 constelaciones de Ptolomeo. Fuente: https://es.wikipedia.org/wiki/Hércules_(constelación)');
insert into Constelacion(id, nombre, descripcion)
	values('const6', 'Perseo', 'Perseo es una constelación del norte y representa a Perseo, héroe mitológico que decapitó a Medusa. Es una de las 48 constelaciones de Ptolomeo así como una de las 88 constelaciones modernas. Fuente: https://es.wikipedia.org/wiki/Perseo_(constelación)');
insert into Constelacion(id, nombre, descripcion)
	values('const7', 'Andromeda', 'Situada al norte del ecuador celeste, lleva el nombre de Andrómeda, la hija de Cefeo y Casiopea, que fue encadenada a una roca para ser devorada por el monstruo marino Ceto. Es más visible en las noches de otoño del hemisferio norte. Fuente: https://es.wikipedia.org/wiki/Andrómeda_(constelación)');

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- OBJETOS ASTRONÓMICOS ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- estrellas
insert into Objeto(id, tamanho, magnitud, ar, dec, nombre, descripcion, constelacion, tipo)
	values('est1', 0.000817, 0.42, 88.79, 7.4069, 'Betelgeuse', 'Betelgeuse es una estrella brillante del tipo supergigante roja. Se halla en la constelación de Orión y era la novena estrella más brillante en el cielo. Fuente: https://es.wikipedia.org/wiki/Betelgeuse', 'const1', 'est');
insert into Objeto(id, tamanho, magnitud, ar, dec, nombre, descripcion, constelacion, tipo)
	values('est2', 0.000000833, 3.41, 85.19, -1.9428, 'Alnitak', 'Alnitak es un sistema estelar que forma parte del llamado cinturón de Orión junto a Mintaka y Alnilam y con ellas forma el grupo conocido como «las tres Marías». Fuente: https://es.wikipedia.org/wiki/Alnitak', 'const1', 'est');
insert into Objeto(id, tamanho, magnitud, ar, dec, nombre, descripcion, constelacion, tipo)
	values('est3', 0.00005, 0.76, 297.69, 8.8683, 'Altair', 'Altair es la estrella más brillante de la constelación de Aquila. Los árabes, que veían en esta constelación una gran águila, la llamaron elnars-el-tair, de donde derivó el nombre de Altair. Fuente: https://es.wikipedia.org/wiki/Altair', 'const2', 'est');

-- galaxias
insert into Objeto(id, tamanho, magnitud, ar, dec, nombre, descripcion, constelacion, tipo)
	values('gal1', 0.036666667, 13.9, 311.71, -12.8481, 'Galaxia enana de Acuario', 'La galaxia Enana de Acuario es una galaxia enana e irregular que se encuentra en la constelación de Acuario. Fue catalogada por primera vez en 1966 con el número DDO 210. Fuente: https://es.wikipedia.org/wiki/Enana_de_Acuario', 'const3', 'gal');
insert into Objeto(id, tamanho, magnitud, ar, dec, nombre, descripcion, constelacion, tipo)
	values('gal2', 0.004666666, 16, 229.31, 21.5856, 'Objeto de Hoag', 'El Objeto de Hoag (PGC 54559) es una galaxia atípica del tipo conocido como galaxia anular. Su aspecto ha fascinado tanto a astrónomos aficionados como a profesionales desde que fue descubierta por Art Hoag en 1950. Fuente: https://es.wikipedia.org/wiki/Objeto_de_Hoag', 'const4', 'gal');
insert into Objeto(id, tamanho, magnitud, ar, dec, nombre, descripcion, constelacion, tipo)
	values('gal3', 192.0, 4.36, 10.68, 41.2692, 'Galaxia de Andrómeda', 'La galaxia de Andrómeda, también conocida como Galaxia Espiral M31 o NGC 224, es una galaxia espiral con un diámetro de doscientos veinte mil años luz y de unos ciento cincuenta mil años luz entre los extremos de sus brazos. Fuente: https://es.wikipedia.org/wiki/Galaxia_de_Andrómeda', 'const7', 'gal');

-- nebulosas
insert into Objeto(id, tamanho, magnitud, ar, dec, nombre, descripcion, constelacion, tipo)
	values('neb1', 16.0, 13.5, 337.41, -20.8371, 'Nebulosa de la hélice', 'La nebulosa de la Hélice, nebulosa Helix, NGC 7293 o el ojo de Dios como es popularmente llamada, es una nebulosa planetaria en la constelación de Acuario, a unos 680 años luz de distancia. Fuente: https://es.wikipedia.org/wiki/Nebulosa_de_la_Hélice', 'const2', 'neb');
insert into Objeto(id, tamanho, magnitud, ar, dec, nombre, descripcion, constelacion, tipo)
	values('neb2', 4.667, 6.0, 274.7, -13.8167, 'Nebulosa del águila', 'La nebulosa del águila se encuentra en la constelación Serpens (la serpiente). En una parte de la nebulosa están los "pilares de la creación", que forman una de las imágenes más populares de las obtenidas por el telescopio espacial Hubble. Fuente: https://es.wikipedia.org/wiki/Nebulosa_del_Águila', 'const4', 'neb');
insert into Objeto(id, tamanho, magnitud, ar, dec, nombre, descripcion, constelacion, tipo)
	values('neb3', 174.0, 3.0, 83.82, -5.3911, 'Nebulosa de Orión', 'La nebulosa de Orión, también conocida como Messier 42, M42, o NGC 1976, es una nebulosa difusa situada al sur del cinturón de Orión. Es una de las nebulosas más brillantes que existen, y puede ser observada a simple vista sobre el cielo nocturno. Fuente: https://es.wikipedia.org/wiki/Nebulosa_de_Orión#cite_note-revised_ngc-4', 'const1', 'neb');

-- cumulos
insert into Objeto(id, tamanho, magnitud, ar, dec, nombre, descripcion, constelacion, tipo)
	values('clu1', 60.0, 4.3, 35.0, 57.1333, 'Cúmulo doble de Perseo', 'El cúmulo doble de Perseo es el nombre con el que se conocen los cúmulos abiertos NGC 869 y NGC 884, ambos visibles a simple vista y situados en la constelación de Perseo a una distancia de algo más de 2300 parsecs (7600 años luz) del Sol. Fuente: https://es.wikipedia.org/wiki/Cúmulo_Doble_de_Perseo', 'const6', 'clu');
insert into Objeto(id, tamanho, magnitud, ar, dec, nombre, descripcion, constelacion, tipo)
	values('clu2', 20.0, 5.8, 250.42, 36.4603, 'Cúmulo de Hércules', 'El cúmulo de Hércules (también conocido como Gran cúmulo de Hércules, M13 o NGC 6205 y de manera informal como el Gran Racimo) es un cúmulo globular de la constelación de Hércules. Fue descubierto por el astrónomo inglés Edmond Halley en el año 1714. Fuente: https://es.wikipedia.org/wiki/Cúmulo_de_Hércules', 'const5', 'clu');

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- PROYECTOS ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into Proyecto(id, fechaIni, fechaFin, estadoProyecto, fechaFinEstimada, descripcion)
	values('proyect1', '13/12/1999', null, 'en proceso', '01/01/2022', 'Investigación sobre estrellas rojas...')
insert into Proyecto(id, fechaIni, fechaFin, estadoProyecto, fechaFinEstimada, descripcion)
	values('proyect2', '20/09/2019', '21/10/2020', 'finalizado', '01/03/2020', 'Investigación sobre cúmulos próximos...')
insert into Proyecto(id, fechaIni, fechaFin, estadoProyecto, fechaFinEstimada, descripcion)
	values('proyect3', '15/05/2021', '16/05/2021', 'cancelado', '01/01/2026', 'Investigación sobre trayecterorias de cometas...')

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- PERSONAL ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into Persona(id, nif, nombre, apellido1, apellido2, fechaNacimiento, fechaRegistro)
	values('001', '64534564F', 'Rafael', 'García', 'Carpincho', '19/03/1969', '23/12/2002')
insert into Persona(id, nif, nombre, apellido1, apellido2, fechaNacimiento, fechaRegistro)
	values('002', '74820164E', 'Marcos', 'Manzano', 'Huerta', '10/10/1983', '13/11/2002')
insert into Persona(id, nif, nombre, apellido1, apellido2, fechaNacimiento, fechaRegistro)
	values('003', '14329164T', 'Alejandra', 'González', 'Sousa', '30/01/2000', '03/06/2005')

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- INVENTARIO --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--estado equipamiento-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into EstadoEquipamiento(id, nombre)
values('libre', 'libre')
insert into EstadoEquipamiento(id, nombre)
values('reservado', 'reservado')
insert into EstadoEquipamiento(id, nombre)
values('noutil', 'no utilizable')

--marca-modelo--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--tubos opticos
insert into MarcaModelo(idmm, marca, modelo) -- reflector
values('tubo1', 'Officina Stellare', 'Ultra CRC 360 PRO');
insert into MarcaModelo(idmm, marca, modelo) -- refractor
values('tubo2', 'Skywatcher', 'ESPIRIT 150 ED PRO Triplet');
insert into MarcaModelo(idmm, marca, modelo) -- catadioptrico
values('tubo3', 'Celestron', 'EDGE HD 800 XLT 203MM');
--monturas
insert into MarcaModelo(idmm, marca, modelo) --ecuatorial motorizada
values('montura1', '10MICRON', 'GM 4000 HPS II');
insert into MarcaModelo(idmm, marca, modelo) --ecuatorial
values('montura2', 'SKYWATCHER', 'NEQ5');
insert into MarcaModelo(idmm, marca, modelo) --alt-azimutal motorizada
values('montura3', 'SKYWATCHER', 'ALLVIEW');
insert into MarcaModelo(idmm, marca, modelo) --alt-azimutal
values('montura4', 'SKYWATCHER', 'AZ3 PRONTO');
insert into MarcaModelo(idmm, marca, modelo) --mixta motorizada
values('montura5', '10MICRON', 'AZ 2000 HPS');
--oculares
insert into MarcaModelo(idmm, marca, modelo)
values('ocular1', 'EXPLORE SCIENTIFIC', '120º N2 9MM 2');
insert into MarcaModelo(idmm, marca, modelo)
values('ocular2', 'EXPLORE SCIENTIFIC', '100º N2 30MM 3');
insert into MarcaModelo(idmm, marca, modelo)
values('ocular3', 'EXPLORE SCIENTIFIC', '100º N2 25MM 2');

--tipo tubo optico----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into TipoTuboOptico(id, nombre)
values ('rfr', 'refractor');
insert into TipoTuboOptico(id, nombre)
values ('rfl', 'reflector');
insert into TipoTuboOptico(id, nombre)
values ('cat', 'catadioptrico');

--tubos opticos-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into TubosOpticos(id, apertura, longitudFocal, tipoTuboOptico, marcamodelo, estadoEquipamiento)
values('tubo1', 355.0, 1960.0, 'rfl', 'tubo1', 'libre');
insert into TubosOpticos(id, apertura, longitudFocal, tipoTuboOptico, marcamodelo, estadoEquipamiento)
values('tubo2', 150.0, 1050.0, 'rfr', 'tubo2', 'libre');
insert into TubosOpticos(id, apertura, longitudFocal, tipoTuboOptico, marcamodelo, estadoEquipamiento)
values('tubo3', 203.0, 2032.0, 'cat', 'tubo3', 'libre');

--tipo montura--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into TipoMontura(id, nombre)
values('az', 'alt-azimutal');
insert into TipoMontura(id, nombre)
values('eq', 'ecuatorial');
insert into TipoMontura(id, nombre)
values('mx', 'mixta');

--monturas------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into Montura(id, marcamodelo, tipoMontura, estadoEquipamiento, motorizada) --ecuatorial motorizada
values('montura1', 'montura1', 'eq', 'libre', 1);
insert into Montura(id, marcamodelo, tipoMontura, estadoEquipamiento, motorizada) --ecuatorial
values('montura2', 'montura2', 'eq', 'libre', 0);
insert into Montura(id, marcamodelo, tipoMontura, estadoEquipamiento, motorizada) --alt-azimutal motorizada
values('montura3', 'montura3', 'az', 'libre', 1);
insert into Montura(id, marcamodelo, tipoMontura, estadoEquipamiento, motorizada) --alt-azimutal
values('montura4', 'montura4', 'az', 'libre', 0);
insert into Montura(id, marcamodelo, tipoMontura, estadoEquipamiento, motorizada) --mixta motorizada
values('montura5', 'montura5', 'mx', 'libre', 1);

--oculares------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into Oculares(id, apertura, longitudFocal, campoVision, marcamodelo, estadoEquipamiento)
values('ocular1', 50.8, 9.0, 120, 'ocular1', 'libre');
insert into Oculares(id, apertura, longitudFocal, campoVision, marcamodelo, estadoEquipamiento)
values('ocular2', 76.2, 30.0, 100, 'ocular2', 'libre');
insert into Oculares(id, apertura, longitudFocal, campoVision, marcamodelo, estadoEquipamiento)
values('ocular3', 50.8, 25.0, 100, 'ocular3', 'libre');

--EQUIPAMIENTO-------------------------------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

insert into Equipamiento(id, idTubo, idOcular, idMontura)
values('eq1','tubo1','ocular2','montura3');
insert into Equipamiento(id, idTubo, idOcular, idMontura)
values('eq2','tubo3','ocular1','montura2');
insert into Equipamiento(id, idTubo, idOcular, idMontura)
values('eq3','tubo2','ocular3','montura1');

--DESCUBRIMIENTO-----------------------------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

insert into Descubrimiento(id, persona, proyecto, objeto, equipamiento, fechaDescubrimiento)
values('desc1', '001', null, 'est1', 'eq1', '23/05/2005')
insert into Descubrimiento(id, persona, proyecto, objeto, equipamiento, fechaDescubrimiento)
values('desc2', null, 'proyect2', 'clu1', 'eq2', '02/05/2020')

--PROYECTO PERSONA ---------------------------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

insert into ProyectoPersona(idPersona,idProyecto,fechaInicio,fechaFin)
values('001','proyect1', '23/05/2003', '24/05/2006')
insert into ProyectoPersona(idPersona,idProyecto,fechaInicio,fechaFin)
values('002','proyect3', '23/05/2003', '01/01/2010')
insert into ProyectoPersona(idPersona,idProyecto,fechaInicio,fechaFin)
values('003','proyect2', '23/05/2010', '10/03/2020')


--PERSONA ESTADO-------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

insert into PersonaEstado(idPersona, actividad, fechaInicio, fechaFin, estadoPersona)
values('001','act1', '01/01/1999', null, 'trabajando');
insert into PersonaEstado(idPersona, actividad, fechaInicio, fechaFin, estadoPersona)
values('002','act2', '01/01/2021', '02/01/2021', 'no contratado');
insert into PersonaEstado(idPersona, actividad, fechaInicio, fechaFin, estadoPersona)
values('003','act3', '01/01/1900', '01/02/2020', 'baja');


--DESGLOSE PRESUPUESTO--------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

insert into DesglosePresupuesto(idProyecto, cantidad, descripcion, numeroDesglose)
values('proyect1', 500.0, 'para comprar microscopios,no se, no me ha visto la nasa', '1')
insert into DesglosePresupuesto(idProyecto, cantidad, descripcion, numeroDesglose)
values('proyect2', 370.0, 'cacharro de cristal', '1')
insert into DesglosePresupuesto(idProyecto, cantidad, descripcion, numeroDesglose)
values('proyect1', 10.0, 'si', '2')

--DESGLOSE GASTOS-------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

insert into DesgloseGastos(idProyecto,cantidad,descripcion, numeroDesglose)
values('proyect1', 250.0, 'personas', '1')
insert into DesgloseGastos(idProyecto,cantidad,descripcion, numeroDesglose)
values('proyect2', 5.0, 'equipamiento', '1')
insert into DesgloseGastos(idProyecto,cantidad,descripcion, numeroDesglose)
values('proyect3', 0.1, 'imprevistos', '1')

--LOG OBSERVACION-------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into LogObservacion(id, ar, dec, persona, fechaObservacion, equipamiento, objeto)
values('log1', 88.79, 7.4069, '001', '14-09-2019', 'eq1', 'est1');