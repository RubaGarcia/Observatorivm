package observatorio.persistenceLayer;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase para obtener la conexi�n al servidor SQL Server.
 * 
 * @author Pablo S�nchez Barreiro
 * @coauthor Diego Garc�a Saiz
 * @lastMofidied 23/03/2021
 */
public class SqlServerConnectionManager {
	
	
	protected static Connection connection; //atributo est�tico que almacena la conexi�n
	
	/*
	 * Atributos de acceso a la Base de Datos.
	 * 
	 * ATENCI�N: CAMBIAR CON LOS VUESTROS
	 */
	protected static String dbName = "observatorio"; //Nombre de la base de datos
	protected static String user = "observatorium"; //Usuario de la base de datos
	protected static String pass = "observatorium"; //Contrase�a del usuario de la base de datos
	protected static String ipPort = "127.0.0.1:1433"; //IP y puerto de acceso a la base de datos
	
	/**
	 * M�todo est�tico para obtener la conexi�n.
	 * Si el atributo "connection" no ha sido inicializado (null)
	 * se inicializa creando una nueva conexi�n con el servidor
	 * y la base de datos en cuesti�n
	 * @return
	 */
	public static Connection getConnection() {
		
		if (connection == null) { //Si la conexi�n no fue inicializada, lo hacemos ahora
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //comprueba que el driver de sql server est� instalado
				connection = DriverManager.getConnection("jdbc:sqlserver://"+ipPort, user, pass); // conexi�n a la BD
				SqlServerConnectionManager.executeSqlStatement("use "+dbName, "Error al hacer 'use "+dbName+"'"); //ejecutar "use" para usar la base de datos
			} catch (SQLException e) {
				System.out.println("Database connection not available");
				System.out.println("Error Code =" + e.getErrorCode());
				System.out.println("Error State = "+e.getSQLState());
				System.out.println(e);
			} catch (ClassNotFoundException e) {
				System.out.println("SQLServer connector driver not found");
			}
		}
		return connection; //retorna la conexi�n
	}
	
	/**
	 * M�todo est�tico para ejecutar operaciones SQL y manejar los errores.
	 * Recibe como par�metros la instrucci�n (statement) en formato tipo String
	 * y un mensaje de error personalizado para mostrarlo en caso de que la
	 * instrucci�n no funcione correctamente.
	 * 
	 * IMPORTANTE: este m�todo s�lo puede ser llamado para operaciones de INSERT, UPDATE
	 * y DELETE. No debe usarse para realizar SELECTs ni llamadas a PROCEDIMIENTO, las ejecuciones
	 * de ese tipo de operaciones tendr�n que implementarse en sus respectivos m�todos.
	 * 
	 * @param stringStatement
	 * @param exceptionMsg
	 */
	public static boolean executeSqlStatement(String stringStatement, String exceptionMsg) {
		Connection con = SqlServerConnectionManager.getConnection(); //conectamos con la base de datos
		try {
			System.out.println("Ejecutando: "+stringStatement);
			Statement stm = con.createStatement(); //nuevo statement
			stm.execute(stringStatement); //ejecuta el statement dado como par�metro
			stm.close(); //cierra el statement
			
			
		} catch (SQLException e) {
			System.out.println("Error Code =" + e.getErrorCode());
			System.out.println("Error State = "+e.getSQLState());
			System.out.println("Error Messange = "+e.getMessage());
			System.out.println("User personalized error message: '"+exceptionMsg+"'"); //si se produce una exceci�n del SQL, se muestra el error personalizado del usuario
			e.printStackTrace();
			return false; //Si se llega hasta aqu�, algo fall� en la ejecuci�n. Retornamos false.
		} 
		
		return true; //si se ha llegado hasta aqu� es porque la ejecuci�n ha sido correcta
	}
	
	

}
