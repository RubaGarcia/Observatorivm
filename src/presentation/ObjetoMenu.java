package observatorio.presentation;

import fundamentos.Menu;

/**
 * Clase para generar el menu de gestion de objetos
 * @author Grupo 3
 * @lastmodified 27/05/2021
 * 
 */
public class ObjetoMenu {
	
	ObjetosMenuOperations omo = new ObjetosMenuOperations(this);
	
	/**
	 * Metodo run al que se llama desde el exterior para lanzar el menu
	 */
	public void run() {
		
		int option;

		Menu objetoMenu = new Menu("Menu de gestion de los objetos");
		objetoMenu.insertaOpcion("Buscar objetos", 1);
		objetoMenu.insertaOpcion("Registrar un objeto", 2);
		objetoMenu.insertaOpcion("Identificar un objeto",3);
		objetoMenu.insertaOpcion("Consulta informacion de constelacion", 4);
		objetoMenu.insertaOpcion("Salir del menu de objetos astronomicos", 99);
		
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
			new BusquedaMenu().run();
			break;
			
		case 2:
			omo.registraObjeto();
			break;
		
		case 3:
			omo.identificaObjeto();
			break;
			
		case 4:
			omo.infoConstelacion();
			break;
			
		default:
			break;
		
		}
	}

}
