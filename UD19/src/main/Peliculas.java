package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Peliculas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField insertarPelicula;
	private JComboBox<String> menuPeliculas;
	private JButton addPeli;
	
	/**
	 * Create the frame.
	 */
	public Peliculas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 334);
		setTitle("Peliculas");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuPeliculas = new JComboBox<String>();
		menuPeliculas.setBounds(368, 64, 221, 31);
		contentPane.add(menuPeliculas);
		
		JLabel lblEscribe = new JLabel("Escribe el título de una película");
		lblEscribe.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscribe.setBounds(62, 30, 199, 14);
		contentPane.add(lblEscribe);
		
		JLabel lblPeliculas = new JLabel("Películas");
		lblPeliculas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeliculas.setBounds(368, 30, 221, 14);
		contentPane.add(lblPeliculas);
		
		insertarPelicula = new JTextField();
		insertarPelicula.setBounds(62, 69, 199, 20);
		contentPane.add(insertarPelicula);
		insertarPelicula.setColumns(10);
		
		addPeli = new JButton("Añadir");
		addPeli.addActionListener(nueva_peli);
		addPeli.setBounds(62, 100, 89, 23);
		contentPane.add(addPeli);
		
		setLocationRelativeTo(null);
	}
	
	ActionListener nueva_peli = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String nombre_peli = insertarPelicula.getText();
			if(!nombre_peli.equals("")) {
				insertarPelicula.setText("");
				menuPeliculas.addItem(nombre_peli);
			}
		}
	};
}
