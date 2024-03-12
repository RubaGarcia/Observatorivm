package observatorio.presentation;

import java.util.List;

import fundamentos.Lectura;
import fundamentos.Mensaje;
import observatorio.business.InventarioBusiness;
import observatorio.domain.ConsultaInventario;

public class InventarioMenuOperations {

	@SuppressWarnings("unused")
	private InventarioMenu menu;

	public InventarioMenuOperations(InventarioMenu inventarioMenu) {
		this.menu = inventarioMenu;
	}

	public void anhadeEquipamiento() {

		Lectura lec = new Lectura ("Proporciona los datos del equipamiento a insertar");
		lec.creaEntrada("id", " ");
		lec.creaEntrada("id del tubo Optico", " ");
		lec.creaEntrada("id de los oculares", " ");
		lec.creaEntrada("id de la montura", " ");
		lec.esperaYCierra();

		boolean success = new InventarioBusiness().anhadeEquipamiento(lec.leeString("id"), lec.leeString("id del tubo �ptico"), lec.leeString("id de los oculares"),
				lec.leeString("id de la montura"));
		
		String txt;
		
		if(success) txt = "Exito al insertar el equipamiento";
		else txt="Error al insertar el equipamiento. Comprueba que los datos sean correctos y que se cumplan todas las restricciones de la tabla";
		
		Mensaje msg = new Mensaje();
		msg.escribe(txt);
	}
	
	public void anhadeMontura() {

		Lectura lec = new Lectura ("Proporciona los datos de la montura a insertar");
		lec.creaEntrada("Id", " ");
		lec.creaEntrada("Marca", " ");
		lec.creaEntrada("Modelo", " ");
		lec.creaEntrada("Tipo de montura", " ");
		lec.creaEntrada("Estado", " ");
		lec.creaEntrada("Motorizada", " ");
		lec.esperaYCierra();

		String motorizada =  lec.leeString("Motorizada");
		Boolean mot = Boolean.valueOf(motorizada);
		
		boolean success = new InventarioBusiness().anhadeMontura(lec.leeString("Id"), lec.leeString("Marca"), lec.leeString("Modelo"),
				lec.leeString("Tipo de montura"), lec.leeString("Estado"), mot);
		
		String txt;
		
		if(success) txt = "Exito al insertar la montura";
		else txt="Error al insertar la montura. Comprueba que los datos sean correctos y que se cumplan todas las restricciones de la tabla";
		
		Mensaje msg = new Mensaje();
		msg.escribe(txt);

	}
	
	
	public void anhadeTubosOpticos() {

		Lectura lec = new Lectura ("Proporciona los datos del Tubo Optico a insertar");
		lec.creaEntrada("id", " ");
		lec.creaEntrada("Apertura", " ");
		lec.creaEntrada("Longitud focal", " ");
		lec.creaEntrada("Tipo tubo", " ");
		lec.creaEntrada("Marca", " ");
		lec.creaEntrada("Modelo", " ");
		lec.creaEntrada("Estado", " ");
		lec.esperaYCierra();

		String apertura = lec.leeString("Apertura");
		Float apert = Float.valueOf(apertura);
		float ap = apert;
		String longitudFocal = lec.leeString("Longitud focal");
		Float longitud = Float.valueOf(longitudFocal);
		float lf = longitud;
		
		boolean success = new InventarioBusiness().anhadeTubosOpticos(lec.leeString("id"), ap, lf, lec.leeString("Tipo tubo"),
				lec.leeString("Marca"), lec.leeString("Modelo"),lec.leeString("Estado"));
		
		String txt;
		
		if(success) txt = "Exito al insertar el tubo optico";
		else txt="Error al insertar el tubo optico. Comprueba que los datos sean correctos y que se cumplan todas las restricciones de la tabla";
		
		Mensaje msg = new Mensaje();
		msg.escribe(txt);
	}
	

	public void anhadeOculares() {

		Lectura lec = new Lectura ("Proporciona los datos de los oculares insertar");
		lec.creaEntrada("id", " ");
		lec.creaEntrada("Apertura", " ");
		lec.creaEntrada("Longitud focal", " ");
		lec.creaEntrada("Campo de vision", " ");
		lec.creaEntrada("Marca", " ");
		lec.creaEntrada("Modelo", " ");
		lec.creaEntrada("Estado", " ");
		lec.esperaYCierra();

		String apertura = lec.leeString("Apertura");
		Float apert = Float.valueOf(apertura);
		float ap = apert;
		String longitudFocal = lec.leeString("Longitud focal");
		Float longitud = Float.valueOf(longitudFocal);
		float lf = longitud;
		String campoVision = lec.leeString("Campo de vision");
		Float campo = Float.valueOf(campoVision);
		float cv = campo;
		
		boolean success = new InventarioBusiness().anhadeOculares(lec.leeString("id"), ap, lf, cv,
				lec.leeString("Marca"), lec.leeString("Modelo"),lec.leeString("Estado"));
		
		String txt;
		
		if(success) txt = "Exito al insertar los oculares";
		else txt="Error al insertar los oculares. Comprueba que los datos sean correctos y que se cumplan todas las restricciones de la tabla";
		
		Mensaje msg = new Mensaje();
		msg.escribe(txt);
	}
	
	
	
	public void anhadeTipoMontura() {

		Lectura lec = new Lectura ("Proporciona los datos del nuevo tipo de montura");
		lec.creaEntrada("id", " ");
		lec.creaEntrada("nombre", " ");
		lec.esperaYCierra();
		
		boolean success = new InventarioBusiness().anhadeTipoMontura(lec.leeString("id"), lec.leeString("nombre"));
		
		String txt;
		
		if(success) txt = "Exito al insertar el tipo de montura";
		else txt="Error al insertar tipo de montura. Comprueba que los datos sean correctos y que se cumplan todas las restricciones de la tabla";
		
		Mensaje msg = new Mensaje();
		msg.escribe(txt);
	}
	
	
	public void anhadeTipoTubo() {

		Lectura lec = new Lectura ("Proporciona los datos del nuevo tipo de tubo optico");
		lec.creaEntrada("id", " ");
		lec.creaEntrada("nombre", " ");
		lec.esperaYCierra();
		
		boolean success = new InventarioBusiness().anhadeTipoTubo(lec.leeString("id"), lec.leeString("nombre"));
		
		String txt;
		
		if(success) txt = "Exito al insertar el tipo de tubo optico";
		else txt="Error al insertar tipo de tubo optico. Comprueba que los datos sean correctos y que se cumplan todas las restricciones de la tabla";
		
		Mensaje msg = new Mensaje();
		msg.escribe(txt);
	}
	
	
	
	public void descatalogaMontura() {
		
		Lectura lec = new Lectura ("Proporciona los datos de la montura a descatalogar");
		lec.creaEntrada("id", " ");
		lec.esperaYCierra();
		
		boolean success = new InventarioBusiness().descatalogaMontura(lec.leeString("id"));
		
		String txt;
		
		if(success) txt = "Exito al descatalogar la montura";
		else txt="Error al descatalogar la montura. Comprueba que los datos sean correctos y que se cumplan todas las restricciones de la tabla";
		
		Mensaje msg = new Mensaje();
		msg.escribe(txt);
		
	}
	
	public void descatalogaTubo() {
		
		Lectura lec = new Lectura ("Proporciona los datos del tubo optico a descatalogar");
		lec.creaEntrada("id", " ");
		lec.esperaYCierra();
		
		boolean success = new InventarioBusiness().descatalogaTubo(lec.leeString("id"));
		
		String txt;
		
		if(success) txt = "Exito al descatalogar el tubo";
		else txt="Error al descatalogar el tubo. Comprueba que los datos sean correctos y que se cumplan todas las restricciones de la tabla";
		
		Mensaje msg = new Mensaje();
		msg.escribe(txt);
		
	}

	
	public void descatalogaOcular() {
		
		Lectura lec = new Lectura ("Proporciona los datos de los oculares a descatalogar");
		lec.creaEntrada("id", " ");
		lec.esperaYCierra();
		
		boolean success = new InventarioBusiness().descatalogaOcular(lec.leeString("id"));
		
		String txt;
		
		if(success) txt = "Exito al descatalogar los oculares";
		else txt="Error al descatalogar los oculares. Comprueba que los datos sean correctos y que se cumplan todas las restricciones de la tabla";
		
		Mensaje msg = new Mensaje();
		msg.escribe(txt);
	}
	
	
	public void actualizaEstadoEquipamiento() {
		
		Lectura lec = new Lectura ("Proporciona los datos del equipamiento y el nuevo estado");
		lec.creaEntrada("id", " ");
		lec.creaEntrada("estado", " ");
		lec.esperaYCierra();
		
		boolean success = new InventarioBusiness().actualizaEstadoEquipamimento(lec.leeString("id"), lec.leeString("estado"));
		
		String txt;
		
		if(success) txt = "Exito al actualizar el estado del equipamiento";
		else txt="Error al actualizar el estado del equipamiento. Comprueba que los datos sean correctos y que se cumplan todas las restricciones de la tabla";
		
		Mensaje msg = new Mensaje();
		msg.escribe(txt);
	}
	
	public void consultaInventario() {
		List<ConsultaInventario> lista = new InventarioBusiness().consultaInventario();
		
		String txt;
				
		if(lista != null) txt = "Exito al obtener el inventario";
		else txt="Error al obtener el inventario. Comprueba que los datos sean correctos y que se cumplan todas las restricciones de la tabla";
				
		Mensaje msg = new Mensaje();
		msg.escribe(txt);
	}
	
	
}
