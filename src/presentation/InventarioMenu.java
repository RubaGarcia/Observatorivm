package observatorio.presentation;

import fundamentos.Menu;

/**
 * Clase para generar el menu de gestion del inventario
 * 
 * @author Grupo 3
 * @lastmodified 27/05/2021
 * 
 */
public class InventarioMenu {

	InventarioMenuOperations imo = new InventarioMenuOperations(this);
	
	/**
	 * Metodo run al que se llama desde el exterior para lanzar el menu
	 */
	public void run() {
		
		int option;

		Menu inventarioMenu = new Menu("Menu de gestion del inventario");
		
		inventarioMenu.insertaOpcion("Consultar inventario", 1);
		
		inventarioMenu.insertaOpcion("Registrar equipamiento", 2);
		inventarioMenu.insertaOpcion("Actualizar estado del equipamiento", 3);
		
		inventarioMenu.insertaOpcion("Anhadir montura", 4);
		inventarioMenu.insertaOpcion("Anhadir tipo de montura", 5);
		inventarioMenu.insertaOpcion("Eliminar montura", 6);
		
		inventarioMenu.insertaOpcion("Anhadir tubo optico", 7);
		inventarioMenu.insertaOpcion("Anhadir tipo de tubo optico", 8);
		inventarioMenu.insertaOpcion("Eliminar tubo optico", 9);
		
		inventarioMenu.insertaOpcion("Anhadir ocular", 10);
		inventarioMenu.insertaOpcion("Eliminar ocular", 11);
		
		inventarioMenu.insertaOpcion("Volver al menu principal",99);
		
		do {
			option = inventarioMenu.leeOpcion();
			this.optionAction(option);
		}while(option!=99);
		
		inventarioMenu.cierra();

	}
	
	/**
	 * Metodo que maneja con un switch la opcion seleccionada en el menu
	 * @param option
	 */
	private void optionAction(int option) {
		switch(option) {
		case 1:
			imo.consultaInventario();
			break;
			
		case 2:
			imo.anhadeEquipamiento();
			break;
		
		case 3:
			imo.actualizaEstadoEquipamiento();
			break;
		
		case 4:
			imo.anhadeMontura();
			break;
			
		case 5:
			imo.anhadeTipoMontura();
			break;

		case 6:
			imo.descatalogaMontura();
			break;
			
		case 7:
			imo.anhadeTubosOpticos();
			break;
			
		case 8:
			imo.anhadeTipoTubo();
			break;
			
		case 9:
			imo.descatalogaTubo();
			break;
			
		case 10:
			imo.anhadeOculares();
			break;
			
		case 11:
			imo.descatalogaOcular();
			break;

		default:
			break;
		}
	}
}
