package lienzo;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import flotas.Parametros;

public class Lienzo extends JPanel {

	private static final long serialVersionUID = 1L;

	public void paint(Graphics g) {
			super.paint(g);

			dibujar(g);
			g.drawString("Restantes", 10, 40);
			dibujarRestantes(g);
			g.drawString("Hundidos", 310, 40);
			dibujarHundidos(g);

			dibujarIA(g);
			g.drawString("Restantes", 410, 40);
			dibujarRestantesIA(g);
			g.drawString("Hundidos", 710, 40);
			dibujarHundidosIA(g);

			g.drawString("Tiempo de Partida : " + (System.currentTimeMillis() - Parametros.tempo) / 1000, 340, 280);

			if (!Parametros.enJuego) {
				g.setColor(Color.black);
				g.drawString("Tu Turno", 10, 320);
			} else if (Parametros.enJuego) {
				g.setColor(Color.black);
				g.drawString("Turno Rival", 710, 320);
			}

			repaint();
		
	}

	private void crearRect(Graphics g, int posX, int posY) {
		g.fillRect(posX, posY, Parametros.ladoC, Parametros.ladoC);
		g.setColor(Color.black);
		g.drawRect(posX, posY, Parametros.ladoC, Parametros.ladoC);
	}

	private void crearRectPre(Graphics g, int posX, int posY) {
		g.fillRect(posX, posY, Parametros.ladoC / 2, Parametros.ladoC / 2);
		g.setColor(Color.black);
		g.drawRect(posX, posY, Parametros.ladoC / 2, Parametros.ladoC / 2);
	}

	// jugador Activo.

	private void dibujar(Graphics g) {
		int[][] posiciones = Parametros.mapaInicial;
		int posX = Parametros.puntoInicialX;
		int posY = Parametros.puntoInicialY;
		char[] coordenadasX = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
		for (int i = 0; i < posiciones.length; i++) {
			for (int j = 0; j < posiciones[i].length; j++) {
				g.setColor(Color.black);
				g.drawString(j + 1 + "", posX + 5, Parametros.puntoInicialY - 10);
				g.drawString(coordenadasX[i] + "", Parametros.puntoInicialX - 20, posY + 15);
				switch (posiciones[i][j]) {
				case 0:
					g.setColor(Color.blue);
					crearRect(g, posX, posY);
					if (posX + Parametros.ladoC == 300) {
						posX = Parametros.puntoInicialX;
						posY += Parametros.ladoC;
						break;
					}
					posX += Parametros.ladoC;
					break;
				case 1:
					g.setColor(Color.red);
					crearRect(g, posX, posY);
					if (posX + Parametros.ladoC == 300) {
						posX = Parametros.puntoInicialX;
						posY += Parametros.ladoC;
						break;
					}
					posX += Parametros.ladoC;
					break;
				case 2:
					g.setColor(Color.green);
					crearRect(g, posX, posY);
					if (posX + Parametros.ladoC == 300) {
						posX = Parametros.puntoInicialX;
						posY += Parametros.ladoC;
						break;
					}
					posX += Parametros.ladoC;
					break;
				case 3:
					g.setColor(Color.yellow);
					crearRect(g, posX, posY);
					if (posX + Parametros.ladoC == 300) {
						posX = Parametros.puntoInicialX;
						posY += Parametros.ladoC;
						break;
					}
					posX += Parametros.ladoC;
					break;
				case 4:
					g.setColor(Color.orange);
					crearRect(g, posX, posY);
					if (posX + Parametros.ladoC == 300) {
						posX = Parametros.puntoInicialX;
						posY += Parametros.ladoC;
						break;
					}
					posX += Parametros.ladoC;
					break;
				}
			}
		}
	}

	private void dibujarRestantes(Graphics g) {
		int posXpre = 20;
		int posYpre = 60;

		dibujarUnidades(g, 1, posXpre, posYpre, Color.red);
		posYpre += Parametros.ladoC / 2 + 10;
		posXpre = 20;

		dibujarUnidades(g, 2, posXpre, posYpre, Color.green);
		posYpre += Parametros.ladoC / 2 + 10;
		posXpre = 20;

		dibujarUnidades(g, 3, posXpre, posYpre, Color.yellow);
		posYpre += Parametros.ladoC / 2 + 10;
		posXpre = 20;

		dibujarUnidades(g, 4, posXpre, posYpre, Color.orange);
		posYpre += Parametros.ladoC / 2 + 10;
		posXpre = 20;

	}
	
	private void dibujarUnidades(Graphics g, int pos, int posXpre, int posYpre, Color color) {
		if (Parametros.flotas[pos-1].obtenerUnidadesRestantesBarco() > 0) {
			for (int i = 0; i < Parametros.flotas[pos-1].obtenerClase(); i++) {
				g.setColor(color);
				crearRectPre(g, posXpre, posYpre);
				posXpre += Parametros.ladoC / 2;
			}
		}
	}

	private void dibujarHundidos(Graphics g) {
		int posXH = 320;
		int posYH = 60;
		dibujarUnidadesHundidas(g, 1, posXH, posYH, Color.red);
		posYH += Parametros.ladoC / 2 + 10;
		posXH = 320;

		dibujarUnidadesHundidas(g, 2, posXH, posYH, Color.green);
		posYH += Parametros.ladoC / 2 + 10;
		posXH = 320;

		dibujarUnidadesHundidas(g, 3, posXH, posYH, Color.yellow);
		posYH += Parametros.ladoC / 2 + 10;
		posXH = 320;

		dibujarUnidadesHundidas(g, 4, posXH, posYH, Color.orange);
		posYH += Parametros.ladoC / 2 + 10;
		posXH = 320;
		
	}
	
	private void dibujarUnidadesHundidas(Graphics g, int pos, int posXH, int posYH, Color color){
		if (Parametros.flotas[pos-1].obtenerUnidadesHundidas() > 0) {
			for (int i = 0; i < Parametros.flotas[pos-1].obtenerClase(); i++) {
				g.setColor(color);
				crearRectPre(g, posXH, posYH);
				posXH += Parametros.ladoC / 2;
			}
		}
	}

	// JUGADOR IA

	private void dibujarIA(Graphics g) {
		int[][] posiciones = Parametros.mapaInicialIA;
		int posX = Parametros.puntoInicialXIA;
		int posY = Parametros.puntoInicialYIA;
		char[] coordenadasX = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
		for (int i = 0; i < posiciones.length; i++) {
			for (int j = 0; j < posiciones[i].length; j++) {
				g.setColor(Color.black);
				g.drawString(j + 1 + "", posX + 5, Parametros.puntoInicialYIA - 10);
				g.drawString(coordenadasX[i] + "", Parametros.puntoInicialXIA - 20, posY + 15);
				switch (posiciones[i][j]) {
				case 0:
					g.setColor(Color.blue);
					crearRect(g, posX, posY);
					if (posX + Parametros.ladoC == 700) {
						posX = Parametros.puntoInicialXIA;
						posY += Parametros.ladoC;
						break;
					}
					posX += Parametros.ladoC;
					break;
				case 1:
					g.setColor(Color.red);
					crearRect(g, posX, posY);
					if (posX + Parametros.ladoC == 700) {
						posX = Parametros.puntoInicialXIA;
						posY += Parametros.ladoC;
						break;
					}
					posX += Parametros.ladoC;
					break;
				case 2:
					g.setColor(Color.green);
					crearRect(g, posX, posY);
					if (posX + Parametros.ladoC == 700) {
						posX = Parametros.puntoInicialXIA;
						posY += Parametros.ladoC;
						break;
					}
					posX += Parametros.ladoC;
					break;
				case 3:
					g.setColor(Color.yellow);
					crearRect(g, posX, posY);
					if (posX + Parametros.ladoC == 700) {
						posX = Parametros.puntoInicialXIA;
						posY += Parametros.ladoC;
						break;
					}
					posX += Parametros.ladoC;
					break;
				case 4:
					g.setColor(Color.orange);
					crearRect(g, posX, posY);
					if (posX + Parametros.ladoC == 700) {
						posX = Parametros.puntoInicialXIA;
						posY += Parametros.ladoC;
						break;
					}
					posX += Parametros.ladoC;
					break;
				}
			}
		}
	}

	private void dibujarRestantesIA(Graphics g) {
		int posXpre = 410;
		int posYpre = 60;
		
		dibujarUnidadesIA(g, 1, posXpre, posYpre, Color.red);
		posYpre += Parametros.ladoC / 2 + 10;
		posXpre = 410;
		
		dibujarUnidadesIA(g, 2, posXpre, posYpre, Color.green);
		posYpre += Parametros.ladoC / 2 + 10;
		posXpre = 410;
		
		dibujarUnidadesIA(g, 3, posXpre, posYpre, Color.yellow);
		posYpre += Parametros.ladoC / 2 + 10;
		posXpre = 410;
		
		dibujarUnidadesIA(g, 4, posXpre, posYpre, Color.orange);
		posYpre += Parametros.ladoC / 2 + 10;
		posXpre = 410;

	}
	
	private void dibujarUnidadesIA(Graphics g, int pos, int posXpre, int posYpre, Color color) {
		if (Parametros.flotas[pos-1].obtenerUnidadesRestantesBarcoIA() > 0) {
			for (int i = 0; i < Parametros.flotas[pos-1].obtenerClase(); i++) {
				g.setColor(color);
				crearRectPre(g, posXpre, posYpre);
				posXpre += Parametros.ladoC / 2;
			}
		}
	}

	private void dibujarHundidosIA(Graphics g) {
		int posXH = 720;
		int posYH = 60;
		
		dibujarUnidadesHundidasIA(g,1,posXH, posYH, Color.red);
		posYH += Parametros.ladoC / 2 + 10;
		posXH = 720;

		dibujarUnidadesHundidasIA(g,2,posXH, posYH, Color.green);
		posYH += Parametros.ladoC / 2 + 10;
		posXH = 720;
		
		dibujarUnidadesHundidasIA(g,3,posXH, posYH, Color.yellow);
		posYH += Parametros.ladoC / 2 + 10;
		posXH = 720;

		dibujarUnidadesHundidasIA(g,4,posXH, posYH, Color.orange);
		posYH += Parametros.ladoC / 2 + 10;
		posXH = 720;
	}
	
	private void dibujarUnidadesHundidasIA(Graphics g, int pos, int posXH, int posYH, Color color) {
		if (Parametros.flotas[pos-1].isHundidoIA()) {
			for (int i = 0; i < Parametros.flotas[pos-1].obtenerClase(); i++) {
				g.setColor(color);
				crearRectPre(g, posXH, posYH);
				posXH += Parametros.ladoC / 2;
			}
		}
	}


}
