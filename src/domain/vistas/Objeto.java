package observatorio.domain.vistas;

/**
 * Clase del dominio que representa a los objetos
 * 
 * @author Grupo E
 * @lastmodified 22-05-2021
 *
 */
public class Objeto {

	private String idObjeto; //el tipo de dato en la bd es char
	private double tamanho; //el tipo de dato en la bd es decimal
	private double magnitud; //el tipo de dato en la bd es decimal
	private double ar; //el tipo de dato en la bd es decimal
	private double dec; //el tipo de dato en la bd es decimal
	private String nombre; //el tipo de dato en la bd es varchar
	private String descripcion; //el tipo de dato en la bd es varchar
	private String constelacion; //el tipo de dato en la bd es char
	private String tipo; //el tipo de dato en la bd es char

	/**
	 * Constructor de la clase. Recibe el valor de todos los atributos, incluido el id
	 * @param idObjeto
	 * @param tamanho
	 * @param magnitud
	 * @param ar
	 * @param dec
	 * @param nombre
	 * @param descripcion
	 * @param constelacion
	 * @param tipo 
	 */
	public Objeto(String idObjeto, double tamanho, double magnitud, double ar, double dec,
			String nombre, String descripcion, String constelacion, String tipo) {
		
		this.idObjeto = idObjeto;
		this.tamanho = tamanho;
		this.magnitud = magnitud;
		this.ar = ar;
		this.dec = dec;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.constelacion = constelacion;
		this.tipo = tipo;
		
	}
	
	/*
	 * Getters y Setters de los atributos de clase
	 */
	public String getIdObjeto() {
		return idObjeto;
	}

	public void setIdObjeto(String idObjeto) {
		this.idObjeto = idObjeto;
	}

	public double getTamanho() {
		return tamanho;
	}

	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}
	
	public double getMagnitud() {
		return magnitud;
	}

	public void setMagnitud(double magnitud) {
		this.magnitud = magnitud;
	}
	
	public double getAR() {
		return ar;
	}

	public void setAR(double ar) {
		this.ar = ar;
	}
	
	public double getDEC() {
		return dec;
	}

	public void setDEC(double dec) {
		this.dec = dec;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getConstelacion() {
		return constelacion;
	}

	public void setConstelacion(String constelacion) {
		this.constelacion = constelacion;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Sobre escribe el método toString() para
	 * devolver los datos del objeto.
	 * 
	 */
	@Override
	public String toString() {
		return ("Objeto con id: "+this.getIdObjeto()+". Nombre: "+this.getNombre()+". Coordenadas: AR "+this.getAR()+"º, DEC "+this.getDEC()+". Magnitud: "+this.getMagnitud()+". Tamanho: "+this.getTamanho()+". Constelacion: "+this.getConstelacion()+". Tipo: "+this.getTipo()+". Descripcion: "+this.getDescripcion());
	}
}
