package observatorio.business;

import java.sql.Date;
import java.util.List;

import observatorio.domain.Persona;
import observatorio.persistenceLayer.PersonasDataMapper;

public class PersonaBusiness {

	/** metodo de la capa de negocio que actualiza el estado de la persona
	 * @param idPersona id de la persona que se quiere a�adir un nuevo estado de actividad
	 * @param actividad id de la actividad de la persona pasada como parametro
	 * @param fechaInicio fecha de inicio del estado de actividad
	 * @param fechaFin fecha de fin del estado de actividad
	 * @param estadoPersona estado de actividad de la persona
	 * @return true si se ha a�adido el estado de actividad y false en otro caso
	 */
	public boolean actualizaPersonal(String idPersona, String actividad, Date fechaInicio, Date fechaFin, String estadoPersona) {
		return new PersonasDataMapper().actualizaPersonal(idPersona, actividad, fechaInicio, fechaFin, estadoPersona);
	}
	
	/** metodo de la capa de negocio que recoge los estados de actividad de las personas
	 * @param persona id de la persona de la que se quieren ver los estados de actividad o null si es de todos
	 * @return lista de personas con sus estados de actividad
	 */
	public List<Persona> selectPersonal(String persona) {
		return new PersonasDataMapper().selectPersonal(persona);
	}
	
	/** m�todo de la capa de negocio que a�ade una persona a la base de datos
	 * @param id id de la persona
	 * @param nif nif de la persona
	 * @param nombre nombre de la persona
	 * @param apellido1 primer apellido de la persona
	 * @param apellido2 segundo apellido de la persona
	 * @param fechaNacimiento fecha de nacimiento de la persona
	 * @param fechaRegistro fecha de registro de la persona
	 * @return true si se ha a�adido, false si ha habido algun error
	 */
	public boolean anhadePersonal(String id, String nif, String nombre, String apellido1, String apellido2,
			Date fechaNacimiento, Date fechaRegistro) {
		Persona pers = new Persona(id, nif, nombre, apellido1, apellido2, fechaNacimiento, fechaRegistro);
		return new PersonasDataMapper().anhadePersonal(pers);
	}
	
	/** m�todo de la capa de negocio que elimina a una persona
	 * @param pers id de la persona eliminada
	 * @return true si se ha eliminado, false si hay error
	 */
	public boolean eliminaPersonal(String pers) {
		return new PersonasDataMapper().eliminaPersonal(pers);
	}
}
