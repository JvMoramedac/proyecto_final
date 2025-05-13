package Adopcion_de_animales;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class adopciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adopciones frame = new adopciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public adopciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGestionarMascota = new JButton("Gestionar Mascotas");
		btnGestionarMascota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar_agragar_mascota M1 = new modificar_agragar_mascota();
				M1.setVisible(true);
			}
		});
		btnGestionarMascota.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGestionarMascota.setBounds(116, 167, 215, 39);
		contentPane.add(btnGestionarMascota);
		
		JButton btnResgistrarAdopción = new JButton("Registrar Adopción");
		btnResgistrarAdopción.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionar_adopcion M2 = new gestionar_adopcion ();
				M2.setVisible(true);
			}
		});
		btnResgistrarAdopción.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnResgistrarAdopción.setBounds(116, 217, 207, 33);
		contentPane.add(btnResgistrarAdopción);
		
		JLabel lblGestiondeAdopcion = new JLabel("Gestión De Adopción");
		lblGestiondeAdopcion.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblGestiondeAdopcion.setBounds(84, 11, 285, 78);
		contentPane.add(lblGestiondeAdopcion);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(adopciones.class.getResource("/imagenes/perro.png")));
		lblNewLabel.setBounds(58, 167, 40, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(adopciones.class.getResource("/imagenes/humano.png")));
		lblNewLabel_1.setBounds(60, 211, 40, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(60, 211, 40, 39);
		contentPane.add(lblNewLabel_3);
	}
}
