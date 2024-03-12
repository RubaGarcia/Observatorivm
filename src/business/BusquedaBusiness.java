package observatorio.business;

import observatorio.persistenceLayer.BusquedaDataMapper;
import observatorio.domain.ObjetoBusqueda;
import java.util.List;

/**
 * Clase con las operaciones de negocio de las busquedas.
 * Es con esta clase con la que la interfaz grafica (capa de presentacion)
 * se comunica.
 * 
 * @author Grupo E
 * @lastmodified 
 *
 */
public class BusquedaBusiness {

	/**
	 * Metodo que retorna una lista de los objetos con el tipo indicado
	 * @param tipo
	 * @return
	 */
	public List<ObjetoBusqueda> buscaObjetosPorTipo(String tipo) {

		return (new BusquedaDataMapper().buscaObjetosPorTipo(tipo));
	}

	/**
	 * Metodo que retorna una lista de los objetos con la magnitud estelar indicada
	 * @param magnitud
	 * @return
	 */
	public List<ObjetoBusqueda> buscaObjetosPorMagnitud(String magnitud) {

		return (new BusquedaDataMapper().buscaObjetosPorMagnitud(magnitud));
	}

	/**
	 * Metodo que retorna una lista de los objetos con el nombre indicado
	 * @param nombre
	 * @return
	 */
	public List<ObjetoBusqueda> buscaObjetosPorNombre(String nombre) {

		return (new BusquedaDataMapper().buscaObjetosPorNombre(nombre));
	}
	
	/**
	 * Metodo que retorna una lista de los objetos descubiertos por la persona indicada
	 * @param descubridor
	 * @return
	 */
	public List<ObjetoBusqueda> buscaObjetosPorDescubridor(String descubridor) {

		return (new BusquedaDataMapper().buscaObjetosPorDescubridor(descubridor));
	}
	
	/**
	 * Metodo que retorna una lista de los objetos descubiertos utilizando el equipamiento
	 * indicado
	 * @param equipamiento
	 * @return
	 */
	public List<ObjetoBusqueda> buscaObjetosPorEquipamiento(String equipamiento) {

		return (new BusquedaDataMapper().buscaObjetosPorEquipamiento(equipamiento));
	}

}
