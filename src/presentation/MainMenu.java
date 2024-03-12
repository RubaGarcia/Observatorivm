package observatorio.presentation;

import fundamentos.*; //cargamos el paquete fundamentos

/**
 * Clase para la implementacion del menu principal
 * de la aplicacion.
 * 
 * @author Grupo 3
 * @lastmodified 27/05/2021
 *
 */
public class MainMenu {

	/**
	 * Metodo run al que se llama desde el exterior para lanzar el menu
	 */
	public void run() {
		
		int option;
		
		Menu mainMenu = new Menu("Menu principal");
		mainMenu.insertaOpcion("Gestion de objetos", 1);
		mainMenu.insertaOpcion("Gestion de proyectos", 2);
		mainMenu.insertaOpcion("Gestion del inventario", 3);
		mainMenu.insertaOpcion("Gestion del personal", 4);
		mainMenu.insertaOpcion("Gestion de descubrimientos", 5);
		mainMenu.insertaOpcion("Gestion de observaciones", 6);		
		mainMenu.insertaOpcion("Salir de la aplicacion", 99);
		
		do {
			option = mainMenu.leeOpcion();
			this.optionAction(option);
		} while(option!=99);
		
		mainMenu.cierra();
		
	}
	
	/**
	 * Metodo que maneja con un switch la opcion seleccionada en el menu
	 * @param option
	 */
	private void optionAction(int option) {
		
		switch(option) {
		case 1:
			new ObjetoMenu().run();
			break;
		
		case 2:
			/* new ProyectoMenu().run(); */
			break;
		
		case 3:
			new InventarioMenu().run();
			break;
		
		case 4:
			new PersonasMenu().run();
			break;
		
		case 5:
			/* DESCUBRIMIENTO */
			break;
			
		case 6:
			new ObservacionesMenu().run();
			break;
			
		default:
			break;
			
		}
		
	}
	
}
