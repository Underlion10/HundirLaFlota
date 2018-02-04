package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lectura.Lectura;
import lienzo.Lienzo;

public class Ventana extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	static String coordenada;
	public Image target = new ImageIcon(getClass().getResource("/recursos/target.png")).getImage();
	

	public Ventana() {
		super("Hundir La Flota");
		setIconImage(target);
		setSize(800,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		Container cn = getContentPane();
		JPanel cp = new JPanel();
		cp.setBackground(new Color(45,170,90));
		cp.setLayout(new FlowLayout());
		JLabel label = new JLabel("Introduce una coordenada: ");
		JTextField campoX = new JTextField(1);
		JTextField campoY = new JTextField(2);
		JButton botonCoo = new JButton("Atacar");
		cp.add(label);
		cp.add(campoY);
		cp.add(campoX);
		cp.add(botonCoo);
		botonCoo.addActionListener(new Lectura(campoX, campoY));
		JPanel db = new JPanel();
		db.setLayout(new GridLayout());
		db.add(new Lienzo());
		cn.add(cp, BorderLayout.NORTH);
		cn.add(db, BorderLayout.CENTER);
		cn.repaint();
	}
}
