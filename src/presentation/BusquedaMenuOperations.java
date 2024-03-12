package observatorio.presentation;

import java.util.List;

import observatorio.business.BusquedaBusiness;
import observatorio.domain.ObjetoBusqueda;
import fundamentos.Lectura;
import fundamentos.Mensaje;

/**
 * Clase que contiene las operaciones a realizar cuando se selecciona una opcion
 * en el menu de objetos.
 * 
 * @author Grupo 3
 * @lastmodified 27/05/2021
 *
 */
public class BusquedaMenuOperations {

	@SuppressWarnings("unused")
	private BusquedaMenu bm;

	/**
	 * Constructor. Se le pasa el menu.
	 * @param menu
	 */
	public BusquedaMenuOperations(BusquedaMenu menu) {
		
		this.bm = menu;
		
	}

	public void buscaPorTipo() {

		Lectura lec = new Lectura ("Indica el tipo de los objetos a buscar");
		lec.creaEntrada("Tipo", "tipo");
		lec.esperaYCierra();

		List<ObjetoBusqueda> objetosEncontrados = new BusquedaBusiness().buscaObjetosPorTipo(lec.leeString("Tipo"));
		String txt = new String();
		
		for(ObjetoBusqueda o: objetosEncontrados) {
			txt=txt+o.toString()+"\n";
		}

		Mensaje msg = new Mensaje();
		msg.escribe(txt);
		
	}

	public void buscaPorNombre() {

		Lectura lec = new Lectura ("Indica el nombre del/los objeto(s) a buscar");
		lec.creaEntrada("Nombre", "nombre");
		lec.esperaYCierra();

		List<ObjetoBusqueda> objetosEncontrados = new BusquedaBusiness().buscaObjetosPorNombre(lec.leeString("Nombre"));
		String txt = new String();
		
		for(ObjetoBusqueda o: objetosEncontrados) {
			txt=txt+o.toString()+"\n";
		}

		Mensaje msg = new Mensaje();
		msg.escribe(txt);
		
	}

	public void buscaPorMagnitud() {

		Lectura lec = new Lectura ("Indica la magnitud de los objetos a buscar");
		lec.creaEntrada("Magnitud", "magnitud");
		lec.esperaYCierra();

		List<ObjetoBusqueda> objetosEncontrados = new BusquedaBusiness().buscaObjetosPorMagnitud(lec.leeString("Magnitud"));
		String txt = new String();
		
		for(ObjetoBusqueda o: objetosEncontrados) {
			txt=txt+o.toString()+"\n";
		}

		Mensaje msg = new Mensaje();
		msg.escribe(txt);
		
	}

	public void buscaPorDescubridor() {

		Lectura lec = new Lectura ("Indica el descubridor de los objetos a buscar");
		lec.creaEntrada("Descubridor", "descubridor");
		lec.esperaYCierra();

		List<ObjetoBusqueda> objetosEncontrados = new BusquedaBusiness().buscaObjetosPorDescubridor(lec.leeString("Descubridor"));
		String txt = new String();
		
		for(ObjetoBusqueda o: objetosEncontrados) {
			txt=txt+o.toString()+"\n";
		}

		Mensaje msg = new Mensaje();
		msg.escribe(txt);
		
	}

	public void buscaPorEquipamiento() {
		
		Lectura lec = new Lectura ("Indica el id del equipamiento utilizado en el descubrimiento de los objetos a buscar");
		lec.creaEntrada("Equipamiento", "id equipamiento");
		lec.esperaYCierra();

		List<ObjetoBusqueda> objetosEncontrados = new BusquedaBusiness().buscaObjetosPorEquipamiento(lec.leeString("Equipamiento"));
		String txt = new String();
		
		for(ObjetoBusqueda o: objetosEncontrados) {
			txt=txt+o.toString()+"\n";
		}

		Mensaje msg = new Mensaje();
		msg.escribe(txt);
		
	}

}
