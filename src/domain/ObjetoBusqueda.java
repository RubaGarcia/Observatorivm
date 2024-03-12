package observatorio.domain;

/**
 * Clase del dominio que representa a los objetos, resultado de una busqueda
 * 
 * @author Grupo E
 * @lastmodified 22-05-2021
 *
 */
public class ObjetoBusqueda {

	private String nombre;
	private String constelacion;
	private String descripcion;
	private double tamanho;
	private double magnitud;
	private double ar;
	private double dec;
	private String tipoObjeto;
	private String descubridor;
	private String montura;
	private String ocular;
	private String tubo;

	public ObjetoBusqueda(String nombre, String constelacion, String descripcion, double tamanho,
			double magnitud, double ar, double dec, String tipoObjeto, String descubridor,
			String montura, String ocular, String tubo) {
		
		this.nombre = nombre;
		this.constelacion = constelacion;
		this.descripcion = descripcion;
		this.tamanho = tamanho;
		this.magnitud = magnitud;
		this.ar = ar;
		this.dec = dec;
		this.tipoObjeto = tipoObjeto;
		this.descubridor = descubridor;
		this.montura = montura;
		this.ocular = ocular;
		this.tubo = tubo;
		
	}
	
	public double getTamanho() {
		return tamanho;
	}
	
	public double getMagnitud() {
		return magnitud;
	}

	public double getAR() {
		return ar;
	}

	public double getDEC() {
		return dec;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public String getConstelacion() {
		return constelacion;
	}

	public String getTipo() {
		return tipoObjeto;
	}
	
	public String getDescubridor() {
		return descubridor;
	}
	
	public String getMontura() {
		return montura;
	}
	
	public String getOcular() {
		return ocular;
	}
	
	public String getTubo() {
		return tubo;
	}

	/**
	 * Sobre escribe el método toString() para
	 * devolver los datos del objeto resultado de la busqueda.
	 * 
	 */
	@Override
	public String toString() {
		return ("Objeto con nombre: "+this.getNombre()+". Coordenadas: AR "+this.getAR()+"º, DEC "+this.getDEC()+". Magnitud: "+this.getMagnitud()+
				". Tamanho: "+this.getTamanho()+". Constelacion: "+this.getConstelacion()+". Tipo: "+this.getTipo()+". Descripcion: "+this.getDescripcion()+
				". Descubridor: "+this.getDescubridor()+". Montura: "+this.getMontura()+". Ocular: "+this.getOcular()+". Tubo: "+this.getTubo());
	}
}
