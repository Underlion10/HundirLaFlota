package flotas;

import mapas.Mapa;
import ventana.Ventana;

public class Parametros {
	
	public static String BarcoA;
	public static String BarcoB;
	public static String BarcoC;
	
	public static Flota flota1 = new Flota(1,4);
	public static Flota flota2 = new Flota(2,3);
	public static Flota flota3 = new Flota(3,2);
	public static Flota flota4 = new Flota(4,1);
	
	
	public static Flota[] flotas = {flota1, flota2, flota3,flota4};
	
	public static int alto = 10;
	public static int ancho = 10;
	
	public static int ladoC = 20;
	public static int puntoInicialX = 100;
	public static int puntoInicialY = 50;
	
	public static int puntoInicialXIA = 500;
	public static int puntoInicialYIA = 50;
	
	public static Mapa mapa = new Mapa(ancho, alto);
	public static int[][] posiciones = mapa.crearMapa();
	public static int[][] mapaInicial = mapa.crearMapaVacio();
	
	public static int[][] posicionesIA = mapa.crearMapa();
	public static int[][] mapaInicialIA = mapa.crearMapaVacio();
	
	public static Ventana ventana = new Ventana();
	
	public static int convertirChar(char letra) {
		
		char[] coordenadasX = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
		int posicionX = 0;
		for (int i = 0; i < coordenadasX.length; i++) {
			if (letra == coordenadasX[i]) {
				posicionX = i;
				break;
			}
		}
		return posicionX;
	}
	
	public static long tempo;
	
	public static boolean enJuego;
}
