package observatorio.presentation;

import fundamentos.Menu;

/**
 * Clase para generar el menu de busqueda de objetos.
 * 
 * @author Grupo 3
 * @lastmodified 
 * 
 */
public class BusquedaMenu {
	
	BusquedaMenuOperations bmo = new BusquedaMenuOperations(this);
	
	/**
	 * Metodo run al que se llama desde el exterior para lanzar el menu
	 */
	public void run() {
		
		int option;

		Menu objetoMenu = new Menu("Menu de busqueda de objetos");
		objetoMenu.insertaOpcion("Busqueda por tipo", 1);
		objetoMenu.insertaOpcion("Busqueda por nombre", 2);
		objetoMenu.insertaOpcion("Busqueda por magnitud", 3);
		objetoMenu.insertaOpcion("Busqueda por descubridor", 4);
		objetoMenu.insertaOpcion("Busqueda por equipamiento utilizado", 5);
		objetoMenu.insertaOpcion("Volver al menu de gestion de objetos astronomicos",99);
		
		do {
			option = objetoMenu.leeOpcion();
			this.optionAction(option);
		} while(option!=99);
		
		objetoMenu.cierra();
		
	}
	
	/**
	 * Metodo que maneja con un switch la opcion seleccionada en el menu
	 * @param option
	 */
	private void optionAction(int option) {
		
		switch(option) {
		case 1:
			bmo.buscaPorTipo(); //operacion para buscar por tipo de objeto
			break;
			
		case 2:
			bmo.buscaPorNombre(); //operacion para buscar por nombre
			break;
		
		case 3:
			bmo.buscaPorMagnitud(); //operacion para buscar por magnitud
			break;
			
		case 4:
			bmo.buscaPorDescubridor(); //operacion para buscar por descubridor
			break;
			
		case 5:
			bmo.buscaPorEquipamiento(); //operacion para buscar por equipamiento
			break;

		default:
			break;
		
		}
		
	}

}
