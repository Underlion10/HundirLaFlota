package hilo;
import flotas.Parametros;

public class Hilo {

	public static void main(String[] args) {
		Parametros.tempo = System.currentTimeMillis();
		int[][] MAPA = Parametros.posiciones;
		for (int i = 0; i < MAPA.length; i++) {
			System.out.print("|");
			for (int j = 0; j < MAPA[i].length; j++) {
				System.out.print(MAPA[i][j]);
				if (j != MAPA[i].length - 1)
					System.out.print("\t");
			}
			System.out.println("|");
		}
		
		int[][] MAPA2 = Parametros.posicionesIA;
		for(int i = 0; i < MAPA2.length; i++) {
			System.out.println("-");
		}
		for (int i = 0; i < MAPA2.length; i++) {
			System.out.print("|");
			for (int j = 0; j < MAPA2[i].length; j++) {
				System.out.print(MAPA2[i][j]);
				if (j != MAPA2[i].length - 1)
					System.out.print("\t");
			}
			System.out.println("|");
		}
		Parametros.ventana.setVisible(true);
	}
}
