package observatorio.presentation;

import java.sql.Date;
import java.util.List;

import fundamentos.Lectura;
import fundamentos.Mensaje;
import observatorio.business.PersonaBusiness;
import observatorio.domain.Persona;

public class PersonasMenuOperations {
	
	@SuppressWarnings("unused")
	private PersonasMenu menu;

	public PersonasMenuOperations(PersonasMenu personasMenu) {
		this.menu = personasMenu;
	}

	public void anhadePersonal() {

		Lectura lec = new Lectura ("Proporciona los datos de la persona a registrar");
		lec.creaEntrada("id", "id");
		lec.creaEntrada("nif", "nif");
		lec.creaEntrada("nombre", "nombre");
		lec.creaEntrada("apellido1", "apellido1");
		lec.creaEntrada("apellido2", "apellido2");
		lec.creaEntrada("fecha de nacimiento", "22-05-2021");
		lec.creaEntrada("fecha de registro", "22-05-2021");
		lec.esperaYCierra();
		
		String fechaNacimientoString = lec.leeString("fecha de nacimiento");
		Date fechaNacimiento;
		String fechaRegistroString = lec.leeString("fecha de registro");
		Date fechaRegistro;
		
		fechaNacimiento = Date.valueOf(fechaNacimientoString);
		fechaRegistro = Date.valueOf(fechaRegistroString);
	
		boolean success = new PersonaBusiness().anhadePersonal(lec.leeString("id"), lec.leeString("nif"), lec.leeString("nombre"),lec.leeString("apellido1"),
				lec.leeString("apellido2"), fechaNacimiento, fechaRegistro);
		
		String txt;
		
		if(success) txt = "Exito al registrar a la persona";
		else txt="Error al registrar a la persona. Comprueba que los datos sean correctos y que se cumplan todas las restricciones de la tabla";
		
		Mensaje msg = new Mensaje();
		msg.escribe(txt);
		
	}

	public void selectPersonal() {
		
		Lectura lec = new Lectura ("Proporciona el id de la persona");
		lec.creaEntrada("Id de la persona", 0); 
		lec.esperaYCierra();

		String persona = lec.leeString("Id de la persona");
		
		List<Persona> personas = new PersonaBusiness().selectPersonal(persona);
		String txt = new String();
				
		for(Persona p: personas) {
			txt=txt+p.toString()+"\n";
			
		}
				
		Mensaje msg = new Mensaje();
		msg.escribe(txt);
		
	}

	public void actualizaPersonal() {
		Lectura lec = new Lectura ("Proporciona los datos de la persona a actualizar");
		lec.creaEntrada("id", "id");
		lec.creaEntrada("actividad", "actividad");
		lec.creaEntrada("estado", "estado");
		lec.creaEntrada("fecha de inicio", "22-05-2021");
		lec.creaEntrada("fecha de fin", "22-05-2021");
		lec.esperaYCierra();
		
		String fechaInicioString = lec.leeString("fecha de inicio");
		Date fechaInicio;
		String fechaFinString = lec.leeString("fecha de fin");
		Date fechaFin;
		
		fechaInicio = Date.valueOf(fechaInicioString);
		fechaFin = Date.valueOf(fechaFinString);
	
		boolean success = new PersonaBusiness().actualizaPersonal(lec.leeString("id"), lec.leeString("actividad"), fechaInicio, fechaFin, lec.leeString("estado"));
		
		String txt;
		
		if(success) txt = "Exito al actualizar los datos de la persona";
		else txt="Error al actualizar los datos de la persona. Comprueba que los datos sean correctos y que se cumplan todas las restricciones de la tabla";
		
		Mensaje msg = new Mensaje();
		msg.escribe(txt);
		
	}

	public void eliminaPersonal() {
		
		Lectura lec = new Lectura ("Proporciona los datos de la persona a eliminar");
		lec.creaEntrada("id", "id");
		lec.esperaYCierra();
		
		boolean success = new PersonaBusiness().eliminaPersonal(lec.leeString("id"));
		
		String txt;
		
		if(success) txt = "Exito al eliminar a la persona";
		else txt="Error al eliminar a la persona. Comprueba que los datos sean correctos y que se cumplan todas las restricciones de la tabla";
		
		Mensaje msg = new Mensaje();
		msg.escribe(txt);
		
	}

}
