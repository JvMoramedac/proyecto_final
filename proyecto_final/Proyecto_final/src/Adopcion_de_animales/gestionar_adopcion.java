package Adopcion_de_animales;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class gestionar_adopcion extends JFrame {
    private JTextField cajaNombre;
    private JTextField cajaDNI;
    private JTextField cajaNTelefono;
    private JTextField cajaNombreMascota;
    private JTable tablaMascotas;
    private DefaultTableModel modeloTabla;

    public gestionar_adopcion() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
		setLocationRelativeTo(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnVolverAlMenu = new JButton("Volver Al Menú");
        btnVolverAlMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
            }
        });
        btnVolverAlMenu.setBounds(238, 11, 103, 23);
        contentPane.add(btnVolverAlMenu);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(27, 146, 46, 14);
        contentPane.add(lblNombre);

        JLabel lblDNI = new JLabel("D.N.I:");
        lblDNI.setBounds(27, 171, 46, 14);
        contentPane.add(lblDNI);

        JLabel lblTelefono = new JLabel("Nº. Telefono:");
        lblTelefono.setBounds(28, 208, 66, 14);
        contentPane.add(lblTelefono);

        JLabel lblNombreMascota = new JLabel("Chip Mascota :");
        lblNombreMascota.setBounds(29, 233, 87, 14);
        contentPane.add(lblNombreMascota);

        cajaNombre = new JTextField();
        cajaNombre.setBounds(203, 143, 86, 20);
        contentPane.add(cajaNombre);
        cajaNombre.setColumns(10);

        cajaDNI = new JTextField();
        cajaDNI.setBounds(203, 168, 86, 20);
        contentPane.add(cajaDNI);
        cajaDNI.setColumns(10);

        cajaNTelefono = new JTextField();
        cajaNTelefono.setBounds(203, 199, 86, 20);
        contentPane.add(cajaNTelefono);
        cajaNTelefono.setColumns(10);

        cajaNombreMascota = new JTextField();
        cajaNombreMascota.setBounds(203, 230, 86, 20);
        contentPane.add(cajaNombreMascota);
        cajaNombreMascota.setColumns(10);

        JButton btnAdoptarAnimal = new JButton("Adoptar Animal");
        btnAdoptarAnimal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConexionMySQL conexion = new ConexionMySQL("root", "", "centro_de_adopcon");
                try {
                    conexion.conectar();
                    String sentencia = "INSERT INTO adopcion (  Nombre, DNI, NTelefono, ChipMascota ) VALUES ('"+ cajaNombre.getText() + "','" + cajaDNI.getText()+ "','" + cajaNTelefono.getText() + "','" +  cajaNombreMascota.getText() + "')";
                    conexion.ejecutarInsertDeleteUpdate(sentencia);
                    String nombreMascota = cajaNombreMascota.getText();
                    String sentencia1 = "DELETE FROM mascotas WHERE ChipMascota = '" + nombreMascota + "'";
                    conexion.ejecutarInsertDeleteUpdate(sentencia1);
                    conexion.desconectar();
                    dispose();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnAdoptarAnimal.setBounds(88, 11, 140, 23);
        contentPane.add(btnAdoptarAnimal);

        // Tabla con datos de mascotas
        String[] columnas = {"Chip Mascota", "Nombre", "Edad", "Especie", "Raza"};
        modeloTabla = new DefaultTableModel(null, columnas);
        tablaMascotas = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaMascotas);
        scrollPane.setBounds(42, 37, 348, 98);
        contentPane.add(scrollPane);

        // Capturar clic en la tabla
        tablaMascotas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaMascotas.getSelectedRow();
                cajaNombreMascota.setText(modeloTabla.getValueAt(filaSeleccionada, 0).toString());
                cajaNombre.setText(modeloTabla.getValueAt(filaSeleccionada, 1).toString());
                cajaDNI.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
                cajaNTelefono.setText(modeloTabla.getValueAt(filaSeleccionada, 3).toString());
            }
        });
        // Botón para eliminar mascota
        JButton btnEliminarMascota = new JButton("Eliminar Mascota");
        btnEliminarMascota.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConexionMySQL conexion = new ConexionMySQL("root", "", "centro_de_adopcon");
                try {
                    conexion.conectar();
                    String nombreMascota = cajaNombreMascota.getText();
                    String sentencia = "DELETE FROM mascotas WHERE ChipMascota = '" + nombreMascota + "'";
                    conexion.ejecutarInsertDeleteUpdate(sentencia);
                    conexion.desconectar();

                    // Remover la fila de la tabla
                    for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                        if (modeloTabla.getValueAt(i, 0).equals(nombreMascota)) {
                            modeloTabla.removeRow(i);
                            break;
                        }
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnEliminarMascota.setBounds(88, 330, 140, 23);
        contentPane.add(btnEliminarMascota);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(gestionar_adopcion.class.getResource("/imagenes/fondoprincipal.jpg")));
        lblNewLabel.setBounds(0, 0, 434, 261);
        contentPane.add(lblNewLabel);
        cargarDatos();
    }
    private void cargarDatos() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "centro_de_adopcon");
        try {
            conexion.conectar();
            Connection conn = conexion.getConexion();
            PreparedStatement stmt = conn.prepareStatement("SELECT ChipMascota, Nombre, Edad, Especie, Raza FROM mascotas");
            ResultSet rs = stmt.executeQuery();

            modeloTabla.setRowCount(0);
            while (rs.next()) {
            	modeloTabla.addRow(new Object[]{rs.getString("ChipMascota"), rs.getString("Nombre"), rs.getString("Edad"), rs.getString("Especie"), rs.getString("Raza")});
            }
            conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

