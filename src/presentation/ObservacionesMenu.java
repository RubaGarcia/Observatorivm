package observatorio.presentation;

import fundamentos.Menu;

/**
 * Clase para generar el menu de gestion de las observaciones
 * 
 * @author Grupo 3
 * @lastmodified 27/05/2021
 * 
 */
public class ObservacionesMenu {

	ObservacionesMenuOperations omo = new ObservacionesMenuOperations(this);
	
	/**
	 * Metodo run al que se llama desde el exterior para lanzar el menu
	 */
	public void run() {
		
		int option;

		Menu observacionesMenu = new Menu("Menu de gestion de las observaciones");
		observacionesMenu.insertaOpcion("Anhade observacion", 1);
		observacionesMenu.insertaOpcion("Muestra observaciones", 2);
		observacionesMenu.insertaOpcion("Salir del menu de observaciones",99);
		
		do {
			option = observacionesMenu.leeOpcion();
			this.optionAction(option);
		} while(option!=99);
		
		observacionesMenu.cierra();
		
	}
	
	/**
	 * Metodo que maneja con un switch la opcion seleccionada en el menu
	 * @param option
	 */
	private void optionAction(int option) {
		switch(option) {
		case 1:
			omo.anhadeObservacion(); //operacion para registrar una nueva observacion
			break;
			
		case 2:
			omo.selectObservacion(); //operacion para mostrar observaciones
			break;
		
		default:
			break;
			
		
		}
	}
	
}
