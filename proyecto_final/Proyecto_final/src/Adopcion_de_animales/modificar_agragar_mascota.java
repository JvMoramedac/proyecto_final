package Adopcion_de_animales;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class modificar_agragar_mascota extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modificar_agragar_mascota frame = new modificar_agragar_mascota();
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
	public modificar_agragar_mascota() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnModificar = new JButton("Modificar Mascota");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModificar.setBounds(10, 117, 211, 23);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar_mascota MA1 = new modificar_mascota();
				MA1.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnModificar);
		
		JButton btnAgregarMascota = new JButton("Agregar Mascota");
		btnAgregarMascota.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAgregarMascota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestionar_Mascotas M3 = new Gestionar_Mascotas();
				M3.setVisible(true);			}
		});
		btnAgregarMascota.setBounds(231, 117, 193, 23);
		contentPane.add(btnAgregarMascota);
	}

}
