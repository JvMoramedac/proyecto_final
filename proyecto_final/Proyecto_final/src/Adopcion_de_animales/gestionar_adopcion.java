package Adopcion_de_animales;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class gestionar_adopcion extends JFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldDNI;
	private JTextField textFieldNTelefono;
	private JTextField textFieldNombreMascota;
	public gestionar_adopcion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnVolverAlMenu = new JButton("Volver Al Menú");
		btnVolverAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adopciones A1 = new adopciones();
				A1.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		btnVolverAlMenu.setBounds(238, 11, 103, 23);
		contentPane.add(btnVolverAlMenu);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(27, 120, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDNI = new JLabel("D.N.I:");
		lblDNI.setBounds(27, 145, 46, 14);
		contentPane.add(lblDNI);
		
		JLabel lblTelefono = new JLabel("Nº. Telefono:");
		lblTelefono.setBounds(27, 170, 66, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblNombreMascota = new JLabel("Nombre Mascota :");
		lblNombreMascota.setBounds(27, 195, 87, 14);
		contentPane.add(lblNombreMascota);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(203, 117, 86, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(203, 142, 86, 20);
		contentPane.add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		textFieldNTelefono = new JTextField();
		textFieldNTelefono.setBounds(203, 167, 86, 20);
		contentPane.add(textFieldNTelefono);
		textFieldNTelefono.setColumns(10);
		
		textFieldNombreMascota = new JTextField();
		textFieldNombreMascota.setBounds(203, 192, 86, 20);
		contentPane.add(textFieldNombreMascota);
		textFieldNombreMascota.setColumns(10);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionar_adopcion frame = new gestionar_adopcion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
