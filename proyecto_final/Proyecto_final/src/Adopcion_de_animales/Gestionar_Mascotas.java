package Adopcion_de_animales;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class Gestionar_Mascotas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField cajanombre;
	public JTextField cajaespecie;
	public JTextField cajaraza;
	public JTextField cajaedad;
	public JTextField cajachip;
    private DefaultTableModel modeloTabla;
    private JTable tablaMascotas;



	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestionar_Mascotas frame = new Gestionar_Mascotas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Gestionar_Mascotas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnVolverAlMenu = new JButton("Volver Al Menú");
		btnVolverAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolverAlMenu.setBounds(241, 11, 108, 23);
		contentPane.add(btnVolverAlMenu);
		
		cajanombre = new JTextField();
		cajanombre.setBounds(338, 113, 86, 20);
		contentPane.add(cajanombre);
		cajanombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setBackground(new Color(0, 255, 128));
		lblNombre.setBounds(10, 116, 59, 14);
		contentPane.add(lblNombre);
		
		JLabel lblEspecie = new JLabel("Especie :");
		lblEspecie.setBounds(10, 158, 59, 14);
		contentPane.add(lblEspecie);
		
		JLabel lblRaza = new JLabel("Raza :");
		lblRaza.setBounds(10, 196, 46, 14);
		contentPane.add(lblRaza);
		
		JLabel lblEdad = new JLabel("Edad :");
		lblEdad.setBounds(10, 236, 46, 14);
		contentPane.add(lblEdad);
		
		cajaespecie = new JTextField();
		cajaespecie.setBounds(338, 155, 86, 20);
		contentPane.add(cajaespecie);
		cajaespecie.setColumns(10);
		
		cajaraza = new JTextField();
		cajaraza.setBounds(338, 193, 86, 20);
		contentPane.add(cajaraza);
		cajaraza.setColumns(10);
		
		cajaedad = new JTextField();
		cajaedad.setBounds(338, 233, 86, 20);
		contentPane.add(cajaedad);
		cajaedad.setColumns(10);
		
		JButton btnAgragarMascota = new JButton("Agregar Mascota");
		btnAgragarMascota.setBounds(90, 11, 115, 23);
		btnAgragarMascota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConexionMySQL conexion = new ConexionMySQL("root", "" , "centro_de_adopcon");
				try {
					conexion.conectar();
					String sentencia = "INSERT INTO mascotas (ChipMascota, Nombre, Especie, Raza, Edad ) VALUES ('" + cajachip.getText() + "','" + cajanombre.getText() + "','" + cajaespecie.getText()+ "','" + cajaraza.getText() + "','" + cajaedad.getText()+"')";
					conexion.ejecutarInsertDeleteUpdate(sentencia);
					conexion.desconectar();
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAgragarMascota);
		
		

		 
		 JLabel lblChipMascota = new JLabel("Chip Mascota :");
		 lblChipMascota.setFont(new Font("Tahoma", Font.PLAIN, 11));
		 lblChipMascota.setBounds(10, 75, 80, 14);
		 contentPane.add(lblChipMascota);
		 
		 cajachip = new JTextField();
		 cajachip.setBounds(338, 75, 86, 20);
		 contentPane.add(cajachip);
		 cajachip.setColumns(10);
		 
		 JLabel lblfotofondo = new JLabel("New label");
		 lblfotofondo.setIcon(new ImageIcon(Gestionar_Mascotas.class.getResource("/imagenes/fondoprincipal.jpg")));
		 lblfotofondo.setBounds(0, 0, 434, 261);
		 contentPane.add(lblfotofondo);
		/*
		 String[] columnNames = {"Nombre", "Especie", "Raza", "Edad"};
		  DefaultTableModel tableModel = new DefaultTableModel(columnNames, 3);
		  TablaDatos = new JTable(tableModel);
		TablaDatos.setBounds(10, 46, 414, 98);
		contentPane.add(TablaDatos);
        JScrollPane scrollPane = new JScrollPane(TablaDatos);
        */
	}
		 
		    }


