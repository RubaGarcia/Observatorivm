package observatorio.persistenceLayer;

import observatorio.domain.Objeto;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase para realizar las operaciones de seleccion y manipulacion
 * de datos concernientes a los objetos
 * 
 * @author Grupo 3
 * @lastmodified 
 *
 */
public class ObjetoDataMapper {
	
	/**
	 * Metodo para insertar a un objeto astronomico en la base de datos
	 * @param o objeto de tipo objeto que contiene todos los atributos del objeto
	 * @return true si se ha anhadido correctamente y false si se ha producido algun error al anhadir
	 */
	public boolean insertObjeto(Objeto o) {

		Connection con = SqlServerConnectionManager.getConnection();
	    
	    try {
	    	CallableStatement cstmt = null;
	    	
	    	//prepara el String con la llamada al metodo, usando call
	    	cstmt = con.prepareCall(
	                "{call dbo.crearObjeto(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
	    	cstmt.setString("id", o.getIdObjeto());
	    	cstmt.setDouble("tamanho", o.getTamanho());
	    	cstmt.setDouble("magnitud", o.getMagnitud());
	    	cstmt.setDouble("ar", o.getAR());
	    	cstmt.setDouble("dec", o.getDEC());
	    	cstmt.setString("nombre", o.getNombre());
	    	cstmt.setString("descripcion", o.getDescripcion());
	    	cstmt.setString("constelacion", o.getConstelacion());
	    	cstmt.setString("tipo", o.getTipo());
	    	cstmt.execute();
	        return true;
		} catch (SQLException e) {
			System.out.println("Error al registrar el objeto");
			e.printStackTrace();
			return false;
		}
	}
	
	public String identificaObjeto(String coordenadaAR, String coordenadaDEC) {
		String result = null;
		Connection con = SqlServerConnectionManager.getConnection();
		try {
			Statement selectStm = con.createStatement();
			String selectStmText = "SELECT dbo.identificacion("+coordenadaAR+","+coordenadaDEC+") AS nombre";
			ResultSet results = selectStm.executeQuery(selectStmText);
			if (results.next()) {
				result = results.getString("nombre");
			}
			selectStm.close();
		} catch (SQLException e) {
			System.out.println("Excepcion al identificar objetos en las coordenadas: "+coordenadaAR+"º AR, "+coordenadaDEC+"º DEC");
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Objeto> infoConstelacion(String idConstelacion) {
		List<Objeto> result = new LinkedList<Objeto>();
		Connection con = SqlServerConnectionManager.getConnection();
		try {
			Statement selectStm = con.createStatement();
			String selectStmText = "SELECT * FROM dbo.ObjetosDeConstelacion('"+idConstelacion+"')";
			ResultSet results = selectStm.executeQuery(selectStmText);
			while(results.next()) {
				result.add(processObjeto(results));
			}
			selectStm.close();
		} catch (SQLException e) {
			System.out.println("Excepcion al buscar objetos en la constelacion con ID: "+idConstelacion);
			e.printStackTrace();
		}
		return result;
	}
	
	public Objeto selectObjetoById(String idObjeto) {
		Objeto result = null;
		Connection con = SqlServerConnectionManager.getConnection();
		try {
			Statement selectStm = con.createStatement();
			String selectStmText = "SELECT * FROM Objeto WHERE id = " + idObjeto + "";
			ResultSet results = selectStm.executeQuery(selectStmText);
			if(results.next()) {
				result = this.processObjeto(results);
			}
			selectStm.close();
		} catch (SQLException e) {
			System.out.println("Excepcion al obtener al objeto con id: '"+idObjeto+"'");
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Metodo privado de apoyo. Recibe un ResultSet de un objeto astronomico
	 * y devuelve un Objeto con los datos del ResultSet
	 * @param results
	 * @return
	 */
	private Objeto processObjeto(ResultSet results) {

		Objeto result = null;
		try {
			String nombre = results.getString("NombreObjeto");
			String constelacion = results.getString("Constelacion");
			String descripcion = results.getString("Descripcion");
			double tamanho = results.getDouble("Tamaño");
			double magnitud = results.getDouble("MagnitudEstelar");
			double ar = results.getDouble("CoordenadaAr");
			double dec = results.getDouble("CoordenadaDec");
			String tipoObjeto = results.getString("TipoObjeto");

			result = new Objeto(null, tamanho, magnitud, ar, dec, nombre,
					descripcion, constelacion, tipoObjeto);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
}
