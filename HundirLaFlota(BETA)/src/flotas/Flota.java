package flotas;

public class Flota {

	private int clase;
	private boolean hundido = false;
	private boolean hundidoIA = false;
	private int unidadesRestantes;
	private int unidadesRestantesIA;
	private  int unidadesRestantesBarco;
	private  int unidadesRestantesBarcoIA;
	private int unidadesHundidas;
	private int unidadesHundidasIA;
	private int[] partesBarco;
	
	public Flota(final int clase, int Brestantes) {
		this.clase = clase;
		unidadesRestantes = clase*Brestantes;
		unidadesRestantesIA = clase*Brestantes;
		unidadesRestantesBarco = Brestantes;
		unidadesRestantesBarcoIA = Brestantes;
		unidadesHundidas = 0;
		unidadesHundidasIA = 0;
		partesBarco = new int[clase];
		for(int i = 0; i < partesBarco.length; i++) {
			partesBarco[i] = clase; 
		}
	}
	
	public int obtenerClase() {
		return this.clase;
	}
	
	public boolean isHundido() {
		return this.hundido;
	}
	
	public boolean isHundidoIA() {
		return this.hundidoIA;
	}
	
	public void defHundido(boolean hundido) {
		this.hundido = hundido;
	}
	
	public void defHundidoIA(boolean hundidoIA) {
		this.hundidoIA = hundidoIA;
	}
	
	public int obtenerUnidadesRestantes() {
		return this.unidadesRestantes;
	}
	
	public void definirUnidadesRestantes() {
		this.unidadesRestantes -= 1;
	}
	
	public int obtenerUnidadesRestantesIA() {
		return this.unidadesRestantesIA;
	}
	
	public void definirUnidadesRestantesIA() {
		this.unidadesRestantesIA -= 1;
	}
	
	public int obtenerUnidadesRestantesBarco() {
		return this.unidadesRestantesBarco;
	}
	
	public void definirUnidadesRestantesBarco() {
		this.unidadesRestantesBarco -= 1;
	}
	
	public int obtenerUnidadesRestantesBarcoIA() {
		return this.unidadesRestantesBarcoIA;
	}
	
	public void definirUnidadesRestantesBarcoIA() {
		this.unidadesRestantesBarcoIA -= 1;
	}
	
	public int obtenerUnidadesHundidas() {
		return this.unidadesHundidas;
	}
	
	public void definirUnidadesHundidas() {
		this.unidadesHundidas += 1;
	}
	
	public int obtenerUnidadesHundidasIA() {
		return this.unidadesHundidasIA;
	}
	
	public void definirUnidadesHundidasIA() {
		this.unidadesHundidasIA += 1;
	}
	
	public int[] getPartesBarco() {
		return partesBarco;
	}
	
	public void vaciarPartesBarco(int pos) {
		partesBarco[pos] = 0;
	}

}
