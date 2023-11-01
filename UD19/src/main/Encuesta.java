package main;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Encuesta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton radioWindows;
	private JRadioButton radioLinux;
	private JRadioButton radioMac;
	private final ButtonGroup Sistemas = new ButtonGroup();
	
	private JCheckBox checkProg;
	private JCheckBox checkDGrafico;
	private JCheckBox checkAdmin;
	
	private JSlider horas;
	/**
	 * Create the frame.
	 */
	public Encuesta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 251, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSO = new JLabel("Elige un sistema operativo:");
		lblSO.setHorizontalAlignment(SwingConstants.CENTER);
		lblSO.setBounds(15, 11, 210, 14);
		contentPane.add(lblSO);
		
		radioWindows = new JRadioButton("Windows");
		Sistemas.add(radioWindows);
		radioWindows.setBounds(68, 31, 109, 23);
		contentPane.add(radioWindows);
		
		radioLinux = new JRadioButton("Linux");
		Sistemas.add(radioLinux);
		radioLinux.setBounds(68, 57, 109, 23);
		contentPane.add(radioLinux);
		
		radioMac = new JRadioButton("Mac");
		Sistemas.add(radioMac);
		radioMac.setBounds(68, 84, 109, 23);
		contentPane.add(radioMac);
		
		JLabel lblEspecialidad = new JLabel("Elige tu especialidad:");
		lblEspecialidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspecialidad.setBounds(15, 138, 210, 14);
		contentPane.add(lblEspecialidad);
		
		checkProg = new JCheckBox("Programacion");
		checkProg.setBounds(68, 159, 109, 23);
		contentPane.add(checkProg);
		
		checkDGrafico = new JCheckBox("Diseño grafico");
		checkDGrafico.setBounds(68, 185, 109, 23);
		contentPane.add(checkDGrafico);
		
		checkAdmin = new JCheckBox("Administracion");
		checkAdmin.setBounds(68, 212, 109, 23);
		contentPane.add(checkAdmin);
		
		JLabel lblHoras = new JLabel("Horas dedicadas en el ordenador:");
		lblHoras.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoras.setBounds(15, 261, 210, 14);
		contentPane.add(lblHoras);
		
		horas = new JSlider();
		horas.setValue(0);
		horas.setMaximum(10);
		horas.setBounds(15, 285, 200, 26);
		contentPane.add(horas);
		
		JButton botonResultado = new JButton("Mostrar resultado");
		botonResultado.addActionListener(mostrar);
		botonResultado.setBounds(40, 333, 157, 23);
		contentPane.add(botonResultado);

		setLocationRelativeTo(null);
	}
	
	ActionListener mostrar = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			if(encuestaCompleta()) {
				String resultado = "Tu sistema operativo es ";
				if(radioWindows.isSelected()) {
					resultado+="Windows, ";
				}
				else if(radioLinux.isSelected()) {
					resultado+="Linux, ";
				}
				else if(radioMac.isSelected()) {
					resultado+="Mac, ";
				}
				resultado+="tu especialidad es ";
				if(checkProg.isSelected()) {
					resultado+="programacion, ";
				}
				if(checkDGrafico.isSelected()) {
					resultado+="diseño grafico, ";
				}
				if(checkAdmin.isSelected()) {
					resultado+="administracion, ";
				}
				resultado+="y tus horas al dia en el ordenador son "+horas.getValue();
				JOptionPane.showMessageDialog(null, resultado);
			}
			else {
				JOptionPane.showMessageDialog(null, "Debes responder todos los campos para ver los resultados");
			}
		}
	};
	
	private boolean encuestaCompleta() {
		return ((Sistemas.getSelection()!=null) && (checkProg.isSelected() || checkDGrafico.isSelected() || checkAdmin.isSelected()));
	}
}
