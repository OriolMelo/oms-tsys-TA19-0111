package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Saludador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	
	public Saludador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Saludador");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escribe un nombre para saludar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(75, 63, 277, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(75, 111, 277, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("¡Saludar!");
		
		btnNewButton.addActionListener(saludar);
		btnNewButton.setBounds(168, 180, 89, 23);
		contentPane.add(btnNewButton);
		
		setLocationRelativeTo(null);
	}
	
	
	ActionListener saludar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String nombre = textField.getText();
			if(!nombre.equals("")) {
				setVisible(false);
				textField.setText("");
				JOptionPane.showMessageDialog(null, "¡Hola " + nombre + "!");
				setVisible(true);
			}
		}
	};
}
