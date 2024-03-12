package observatorio.persistenceLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import observatorio.domain.ObjetoBusqueda;

public class BusquedaDataMapper {

	/**
	 * Busqueda de objetos por tipo.
	 * @param tipo el tipo de los objetos a buscar
	 * @return una lista con los objetos encontrados
	 */
	public List<ObjetoBusqueda> buscaObjetosPorTipo (String tipo) {

		List<ObjetoBusqueda> result = new LinkedList<ObjetoBusqueda>();
		Connection con = SqlServerConnectionManager.getConnection();
		try {
			Statement selectStm = con.createStatement();
			String selectStmText = "SELECT * FROM dbo.busquedaPorTipo('" + tipo + "')";
			ResultSet results = selectStm.executeQuery(selectStmText);
			while(results.next()) {
				result.add(this.processObjetoBusqueda(results));
			}
			selectStm.close();
		} catch (SQLException e) {
			System.out.println("Excepcion al obtener objetos del tipo: '"+tipo+"'");
			e.printStackTrace();
		}
		return result;

	}

	/**
	 * Busqueda de objetos por nombre.
	 * @param nombre el nombrede los objetos a buscar
	 * @return una lista con los objetos encontrados
	 */
	public List<ObjetoBusqueda> buscaObjetosPorNombre (String nombre) {

		List<ObjetoBusqueda> result = new LinkedList<ObjetoBusqueda>();
		Connection con = SqlServerConnectionManager.getConnection();
		try {
			Statement selectStm = con.createStatement();
			String selectStmText = "SELECT * FROM dbo.busquedaPorNombre('" + nombre + "')";
			ResultSet results = selectStm.executeQuery(selectStmText);
			while(results.next()) {
				result.add(this.processObjetoBusqueda(results));
			}
			selectStm.close();
		} catch (SQLException e) {
			System.out.println("Excepcion al obtener objetos llamados: '"+nombre+"'");
			e.printStackTrace();
		}
		return result;

	}
	
	/**
	 * Busqueda de objetos por magnitud.
	 * @param magnitud la magnitud de los objetos a buscar
	 * @return una lista con los objetos encontrados
	 */
	public List<ObjetoBusqueda> buscaObjetosPorMagnitud (String magnitud) {

		List<ObjetoBusqueda> result = new LinkedList<ObjetoBusqueda>();
		Connection con = SqlServerConnectionManager.getConnection();
		try {
			Statement selectStm = con.createStatement();
			String selectStmText = "SELECT * FROM dbo.busquedaPorMagnitud(" + magnitud + ")";
			ResultSet results = selectStm.executeQuery(selectStmText);
			while(results.next()) {
				result.add(this.processObjetoBusqueda(results));
			}
			selectStm.close();
		} catch (SQLException e) {
			System.out.println("Excepcion al obtener objetos con magnitud estelar: '"+magnitud+"'");
			e.printStackTrace();
		}
		return result;

	}
	
	/**
	 * Busqueda de objetos por descubridor.
	 * @param descubridor el descubridor de los objetos a buscar
	 * @return una lista con los objetos encontrados
	 */
	public List<ObjetoBusqueda> buscaObjetosPorDescubridor (String descubridor) {

		List<ObjetoBusqueda> result = new LinkedList<ObjetoBusqueda>();
		Connection con = SqlServerConnectionManager.getConnection();
		try {
			Statement selectStm = con.createStatement();
			String selectStmText = "SELECT * FROM dbo.busquedaPorDescubridor(" + descubridor + ")";
			ResultSet results = selectStm.executeQuery(selectStmText);
			while(results.next()) {
				result.add(this.processObjetoBusqueda(results));
			}
			selectStm.close();
		} catch (SQLException e) {
			System.out.println("Excepcion al obtener objetos descubiertos por: '"+descubridor+"'");
			e.printStackTrace();
		}
		return result;

	}
	
	/**
	 * Busqueda de objetos por el equipamiento utilizado en su descubrimiento.
	 * @param equipamiento el equipamiento utilizado en su descubrimiento
	 * @return una lista con los objetos encontrados
	 */
	public List<ObjetoBusqueda> buscaObjetosPorEquipamiento (String equipamiento) {

		List<ObjetoBusqueda> result = new LinkedList<ObjetoBusqueda>();
		Connection con = SqlServerConnectionManager.getConnection();
		try {
			Statement selectStm = con.createStatement();
			String selectStmText = "SELECT * FROM dbo.busquedaPorEquipamientoDescubridor('" + equipamiento + "')";
			ResultSet results = selectStm.executeQuery(selectStmText);
			while(results.next()) {
				result.add(this.processObjetoBusqueda(results));
			}
			selectStm.close();
		} catch (SQLException e) {
			System.out.println("Excepcion al obtener objetos descubiertos con el equipamiento de id: '"+equipamiento+"'");
			e.printStackTrace();
		}
		return result;

	}

	/**
	 * Metodo privado de apoyo. Recibe un ResultSet de un objeto resultado de una busqueda
	 * y devuelve un objeto ObjetoBusqueda con los datos del ResultSet.
	 * @param results
	 * @return
	 */
	private ObjetoBusqueda processObjetoBusqueda(ResultSet results) {

		ObjetoBusqueda result = null;
		try {
			String nombre = results.getString("NombreObjeto");
			String constelacion = results.getString("Constelacion");
			String descripcion = results.getString("Descripcion");
			double tamanho = results.getDouble("Tama�o");
			double magnitud = results.getDouble("MagnitudEstelar");
			double ar = results.getDouble("CoordenadaAr");
			double dec = results.getDouble("CoordenadaDec");
			String tipoObjeto = results.getString("TipoObjeto");
			String descubridor = results.getString("Descubridor");
			String montura = results.getString("Montura");
			String ocular = results.getString("Ocular");
			String tubo = results.getString("TuboOptico");

			result = new ObjetoBusqueda(nombre, constelacion, descripcion, tamanho, magnitud,
					ar, dec, tipoObjeto, descubridor, montura, ocular, tubo);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
		
	}

}
