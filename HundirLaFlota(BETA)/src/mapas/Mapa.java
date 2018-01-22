package mapas;

import java.util.Random;

import flotas.Flota;
import flotas.Parametros;

public class Mapa {

	private int alto;
	private int ancho;

	public Mapa(final int ancho, final int alto) {
		this.alto = alto;
		this.ancho = ancho;
	}

	public int[][] crearMapaVacio() {
		int[][] posiciones = new int[Parametros.mapa.ancho][Parametros.mapa.alto];
		for (int i = 0; i < Parametros.mapa.ancho; i++) {
			for (int j = 0; j < Parametros.mapa.alto; j++) {
				posiciones[i][j] = 0;
			}
		}
		return posiciones;
	}

	public int[][] crearMapa() {
		int[][] posiciones = new int[Parametros.mapa.ancho][Parametros.mapa.alto];
		for (int i = 0; i < Parametros.mapa.ancho; i++) {
			for (int j = 0; j < Parametros.mapa.alto; j++) {
				posiciones[i][j] = 0;
			}
		}
		rellenarMapa(posiciones, Parametros.flotas);

		return posiciones;
	}

	private void rellenarMapa(int[][] emptyMap, Flota[] flota) {
		Random rnd = new Random();
		int barcosRestantes = 4;
		int pos = 0;

		while (barcosRestantes > 0) {
			int barcosRestantesBarco = flota[pos].obtenerUnidadesRestantesBarco();

			inicio: while (barcosRestantesBarco > 0) {
				int ancho = rnd.nextInt(emptyMap.length);
				int alto = rnd.nextInt(emptyMap[0].length);
				int VertHor = rnd.nextInt(4);
				if (VertHor < 2) {
					if (alto + flota[pos].obtenerClase() < emptyMap.length && emptyMap[ancho][alto] == 0) {
						int longitud = flota[pos].obtenerClase();
						while (longitud > 0) {
							emptyMap[ancho][alto] = flota[pos].obtenerClase();
							if (emptyMap[ancho][alto + 1] != 0 && flota[pos].obtenerClase() == 4) {
								switch (longitud) {
								case 4:
									emptyMap[ancho][alto] = 0;
									continue inicio;
								case 3:
									emptyMap[ancho][alto] = 0;
									emptyMap[ancho][alto - 1] = 0;
									continue inicio;
								case 2:
									emptyMap[ancho][alto] = 0;
									emptyMap[ancho][alto-1] = 0;
									emptyMap[ancho][alto-2] = 0;
									continue inicio;
								}
							} else if (emptyMap[ancho][alto + 1] != 0 && flota[pos].obtenerClase() == 3) {
								switch (longitud) {
								case 3:
									emptyMap[ancho][alto] = 0;
									continue inicio;
								case 2:
									emptyMap[ancho][alto] = 0;
									emptyMap[ancho][alto - 1] = 0;
									continue inicio;
								}
							} else if (emptyMap[ancho][alto + 1] != 0 && flota[pos].obtenerClase() == 2) {
								emptyMap[ancho][alto] = 0;
								continue inicio;
							}
							longitud--;
							alto++;
						}

					} else {
						continue inicio;
					}
					
				} else if (VertHor >= 2) {
					if (ancho + flota[pos].obtenerClase() < emptyMap[0].length && emptyMap[ancho][alto] == 0) {
						int longitud = flota[pos].obtenerClase();
						while (longitud > 0) {
							emptyMap[ancho][alto] = flota[pos].obtenerClase();
							if (emptyMap[ancho+1][alto] != 0 && flota[pos].obtenerClase() == 4) {
								switch (longitud) {
								case 4:
									emptyMap[ancho][alto] = 0;
									continue inicio;
								case 3:
									emptyMap[ancho][alto] = 0;
									emptyMap[ancho-1][alto] = 0;
									continue inicio;
								case 2:
									emptyMap[ancho][alto] = 0;
									emptyMap[ancho - 1][alto] = 0;
									emptyMap[ancho - 2][alto] = 0;
									continue inicio;
								}
							} else if (emptyMap[ancho + 1][alto] != 0 && flota[pos].obtenerClase() == 3) {
								switch (longitud) {
								case 3:
									emptyMap[ancho][alto] = 0;
									continue inicio;
								case 2:
									emptyMap[ancho][alto] = 0;
									emptyMap[ancho - 1][alto] = 0;
									continue inicio;
								}
							} else if (emptyMap[ancho + 1][alto] != 0 && flota[pos].obtenerClase() == 2) {
								emptyMap[ancho][alto] = 0;
								continue inicio;
							}
							longitud--;
							ancho++;
						}
					} else {
						continue inicio;
					}
				}
				barcosRestantesBarco--;
			}
			barcosRestantes--;
			pos++;

		}
	}

	public int obtenerAlto() {
		return this.alto;
	}

	public int obtenerAncho() {
		return this.ancho;
	}

}
