package Adopcion_de_animales;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class gestionar_adopcion extends JFrame {
	private JTextField cajaNombre;
	private JTextField cajaDNI;
	private JTextField cajaNTelefono;
	private JTextField cajaNombreMascota;
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
		
		cajaNombre = new JTextField();
		cajaNombre.setBounds(203, 117, 86, 20);
		contentPane.add(cajaNombre);
		cajaNombre.setColumns(10);
		
		cajaDNI = new JTextField();
		cajaDNI.setBounds(203, 142, 86, 20);
		contentPane.add(cajaDNI);
		cajaDNI.setColumns(10);
		
		cajaNTelefono = new JTextField();
		cajaNTelefono.setBounds(203, 167, 86, 20);
		contentPane.add(cajaNTelefono);
		cajaNTelefono.setColumns(10);
		
		cajaNombreMascota = new JTextField();
		cajaNombreMascota.setBounds(203, 192, 86, 20);
		contentPane.add(cajaNombreMascota);
		cajaNombreMascota.setColumns(10);
		
		JButton btnAdoptarAnimal = new JButton("Adoptar Animal");
		btnAdoptarAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConexionMySQL conexion = new ConexionMySQL("root", "" , "centro_de_adopcon");
				try {
					conexion.conectar();
					String sentencia = "INSERT INTO adopcion (Nombre, D.N.I, Nº.Telefono, Nombre Mascota ) VALUES ('" + cajaNombre.getText() + "','" + cajaDNI.getText()+ "','" + cajaNTelefono.getText() + "','" + cajaNombreMascota.getText()+"')";
					conexion.ejecutarInsertDeleteUpdate(sentencia);
					conexion.desconectar();
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAdoptarAnimal.setBounds(88, 11, 140, 23);
		contentPane.add(btnAdoptarAnimal);
		
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
