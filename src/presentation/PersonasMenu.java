package observatorio.presentation;

import fundamentos.Menu;

/**
 * Clase para generar el menu de gestion del personal
 * 
 * @author Grupo 3
 * @lastmodified 27/05/2021
 * 
 */
public class PersonasMenu {

	PersonasMenuOperations pmo = new PersonasMenuOperations(this);
	
	/**
	 * Metodo run al que se llama desde el exterior para lanzar el menu
	 */
	public void run() {
		
		int option;

		Menu personasMenu = new Menu("Menu de gestion del personal");
		personasMenu.insertaOpcion("Registrar personal", 1);
		personasMenu.insertaOpcion("Consultar informacion del personal", 2);
		personasMenu.insertaOpcion("Actualizar información del personal", 3);
		personasMenu.insertaOpcion("Eliminar personal", 4);
		personasMenu.insertaOpcion("Volver al menu principal",99);
		
		do {
			option = personasMenu.leeOpcion();
			this.optionAction(option);
		} while(option!=99);
		
		personasMenu.cierra();
		
	}
	
	/**
	 * Metodo que maneja con un switch la opcion seleccionada en el menu
	 * @param option
	 */
	private void optionAction(int option) {
		switch(option) {
		case 1:
			pmo.anhadePersonal();
			break;
			
		case 2:
			pmo.selectPersonal();
			break;
		
		case 3:
			pmo.actualizaPersonal();
			break;
		
		case 4:
			pmo.eliminaPersonal();
			break;
		
		default:
			break;
		
		}
		
	}
	
}
