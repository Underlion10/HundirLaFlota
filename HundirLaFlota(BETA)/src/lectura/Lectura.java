package lectura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import flotas.Parametros;
import lienzo.Lienzo;

public class Lectura extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField coordenadasX;
	private JTextField coordenadasY;

	private char x;
	private int y;

	Lienzo lienzo = new Lienzo();

	private int barcosTotales = 20;
	private int barcosTotalesIA = 20;

	private boolean probada;
	private int turno = 0;

	private String[] respuestasIntentadas = new String[Parametros.ancho * Parametros.alto];

	public Lectura(JTextField coordenadasX, JTextField coordenadasY) {
		this.coordenadasX = coordenadasX;
		this.coordenadasY = coordenadasY;
	}

	public void actionPerformed(ActionEvent arg0) {
		Parametros.enJuego = false;
		partida:

		while (enJuego()) {

			if (Parametros.enJuego) {
				Random rnd = new Random();
				probada = false;
				int posicionXIA = rnd.nextInt(10);
				char[] letras = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
				x = letras[posicionXIA];
				coordenadasX.setText(x + "");
				y = rnd.nextInt(10) + 1;
				coordenadasY.setText(y + "");
				String coor = x + "" + y;
				for (int i = 0; i < respuestasIntentadas.length; i++) {
					if (respuestasIntentadas[i] != null) {
						if (respuestasIntentadas[i].equals(coor)) {
							probada = true;
						}
					}
				}

				if (!probada) {
					respuestasIntentadas[turno] = coor;
					System.out.println(respuestasIntentadas[turno]);
					turno++;
					if (TocadoIA()) {
						JOptionPane.showMessageDialog(null, "Tocado !!!");
						barcosTotalesIA--;
						coordenadasX.setText("");
						coordenadasY.setText("");
						datoExistenteIA(posicionXIA, y);
						lienzo.repaint();
						Parametros.enJuego = false;
						continue partida;
					} else {
						JOptionPane.showMessageDialog(null, "Agua !!!");
						coordenadasX.setText("");
						coordenadasY.setText("");
						Parametros.enJuego = false;
						continue partida;
					}
				} else {
					continue partida;
				}
			}

			try {
				x = coordenadasX.getText().charAt(0);
			} catch (StringIndexOutOfBoundsException e) {

			}

			int cX = Parametros.convertirChar(x);

			try {
				y = Integer.parseInt(coordenadasY.getText());
			} catch (NumberFormatException e) {
				coordenadasY.setText("");
				return;
			}

			if ((x < 65 || x > 74) || y > 10) {
				JOptionPane.showMessageDialog(null, "Se ha producido un error:", "Introduzca un valor correcto", 2);
				coordenadasX.setText("");
				coordenadasY.setText("");
				return;
			}
			if (Tocado()) {
				JOptionPane.showMessageDialog(null, "Tocado !!!");
				barcosTotales--;
				coordenadasX.setText("");
				coordenadasY.setText("");
				datoExistente(cX, y);
				lienzo.repaint();
				Parametros.enJuego = true;
				continue partida;
			} else {
				JOptionPane.showMessageDialog(null, "Agua !!!");
				coordenadasX.setText("");
				coordenadasY.setText("");
				Parametros.enJuego = true;
				continue partida;
			}

		}

		if (barcosTotales == 0) {
			JOptionPane.showMessageDialog(null, "Has ganado !!", "YOU WON", 1);
			System.exit(0);
		} else if (barcosTotalesIA == 0) {
			JOptionPane.showMessageDialog(null, "Has perdido !!", "GAME OVER", 1);
			System.exit(0);
		}

	}

	private boolean Tocado() {
		boolean tocado = false;
		int posicionX = Parametros.convertirChar(x);

		if (Parametros.posiciones[posicionX][y - 1] != 0) {
			tocado = true;
			switch (Parametros.posiciones[posicionX][y - 1]) {
			case 1:
				tocado(1);
				break;
			case 2:
				tocado(2);
				break;
			case 3:
				tocado(3);
				break;
			case 4:
				tocado(4);
				break;
			}

		}
		return tocado;
	}

	private void tocado(int pos) {
		Parametros.flotas[pos - 1].definirUnidadesRestantes();
		if (Parametros.flotas[pos - 1].obtenerUnidadesRestantes() == 0) {
			Parametros.flotas[pos - 1].defHundido(true);
			Parametros.flotas[pos - 1].definirUnidadesHundidas();
			Parametros.flotas[pos - 1].definirUnidadesRestantesBarco();

		}

	}

	public void datoExistente(int cX, int y) {
		switch (Parametros.posiciones[cX][y - 1]) {
		case 1:
			colocarDato(cX, y, 1);
			break;
		case 2:
			colocarDato(cX, y, 2);
			break;
		case 3:
			colocarDato(cX, y, 3);
			break;
		case 4:
			colocarDato(cX, y, 4);
			break;
		}
	}

	private void colocarDato(int cX, int y, int num) {
		Parametros.posiciones[cX][y - 1] = 0;
		Parametros.mapaInicial[cX][y - 1] = num;
	}

	private boolean TocadoIA() {
		boolean tocado = false;
		int posicionX = Parametros.convertirChar(x);

		if (Parametros.posicionesIA[posicionX][y - 1] != 0) {
			tocado = true;
			switch (Parametros.posicionesIA[posicionX][y - 1]) {
			case 1:
				tocadoIA(1);
				break;
			case 2:
				tocadoIA(2);
				break;
			case 3:
				tocadoIA(3);
				break;
			case 4:
				tocadoIA(4);
				break;
			}
		}
		return tocado;
	}

	private void tocadoIA(int pos) {
		Parametros.flotas[pos - 1].definirUnidadesRestantesIA();
		if (Parametros.flotas[pos - 1].obtenerUnidadesRestantesIA() == 0) {
			Parametros.flotas[pos - 1].defHundidoIA(true);
			Parametros.flotas[pos - 1].definirUnidadesHundidasIA();
			Parametros.flotas[pos - 1].definirUnidadesRestantesBarcoIA();
		}

	}

	public void datoExistenteIA(int cX, int y) {
		switch (Parametros.posicionesIA[cX][y - 1]) {
		case 1:
			colocarDatoIA(cX, y, 1);
			break;
		case 2:
			colocarDatoIA(cX, y, 2);
			break;
		case 3:
			colocarDatoIA(cX, y, 3);
			break;
		case 4:
			colocarDatoIA(cX, y, 4);
			break;
		}
	}

	private void colocarDatoIA(int cX, int y, int num) {
		Parametros.posicionesIA[cX][y - 1] = 0;
		Parametros.mapaInicialIA[cX][y - 1] = num;
	}

	public boolean enJuego() {
		if (barcosTotales == 0 || barcosTotalesIA == 0)
			return false;
		return true;
	}

	public char obtenerX() {
		return this.x;
	}

	public int obtenerY() {
		return this.y;
	}
}
