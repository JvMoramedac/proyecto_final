package Adopcion_de_animales;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class modificar_mascota extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField cajaNombreMascota, cajaNuevaEdad, cajaNuevaEspecie, cajaNuevaRaza;
    private JTable tablaMascotas;
    private DefaultTableModel modeloTabla;
    private JLabel lblNewLabel_1;
    private JTextField cajachip;
    private JLabel lblNewLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                modificar_mascota frame = new modificar_mascota();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public modificar_mascota() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 450);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Tabla con datos de mascotas
        String[] columnas = {"Chip Mascota", "Nombre", "Edad", "Especie", "Raza"};
        modeloTabla = new DefaultTableModel(null, columnas);
        tablaMascotas = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaMascotas);
        scrollPane.setBounds(10, 10, 560, 180);
        contentPane.add(scrollPane);

        // Capturar clic en la tabla
        tablaMascotas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaMascotas.getSelectedRow();
                cajachip.setText(modeloTabla.getValueAt(filaSeleccionada, 0).toString());
                cajaNombreMascota.setText(modeloTabla.getValueAt(filaSeleccionada, 1).toString());
                cajaNuevaEdad.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
                cajaNuevaEspecie.setText(modeloTabla.getValueAt(filaSeleccionada, 3).toString());
                cajaNuevaRaza.setText(modeloTabla.getValueAt(filaSeleccionada, 4).toString());
            }
        });

        JLabel lblNombreMascota = new JLabel("Nombre Mascota:");
        lblNombreMascota.setBounds(20, 236, 120, 14);
        contentPane.add(lblNombreMascota);

        cajaNombreMascota = new JTextField();
        cajaNombreMascota.setBounds(150, 233, 130, 20);
        contentPane.add(cajaNombreMascota);
        cajaNombreMascota.setColumns(10);

        JLabel lblNuevaEdad = new JLabel("Nueva Edad:");
        lblNuevaEdad.setBounds(20, 270, 120, 14);
        contentPane.add(lblNuevaEdad);

        cajaNuevaEdad = new JTextField();
        cajaNuevaEdad.setBounds(150, 264, 130, 20);
        contentPane.add(cajaNuevaEdad);
        cajaNuevaEdad.setColumns(10);

        JLabel lblNuevaEspecie = new JLabel("Nueva Especie:");
        lblNuevaEspecie.setBounds(20, 301, 120, 14);
        contentPane.add(lblNuevaEspecie);

        cajaNuevaEspecie = new JTextField();
        cajaNuevaEspecie.setBounds(150, 298, 130, 20);
        contentPane.add(cajaNuevaEspecie);
        cajaNuevaEspecie.setColumns(10);

        JLabel lblNuevaRaza = new JLabel("Nueva Raza:");
        lblNuevaRaza.setBounds(20, 332, 120, 14);
        contentPane.add(lblNuevaRaza);

        cajaNuevaRaza = new JTextField();
        cajaNuevaRaza.setBounds(150, 329, 130, 20);
        contentPane.add(cajaNuevaRaza);
        cajaNuevaRaza.setColumns(10);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(150, 360, 130, 23);
        btnActualizar.addActionListener(e -> actualizarMascota());
        contentPane.add(btnActualizar);
        
        lblNewLabel_1 = new JLabel("Chip Mascota :");
        lblNewLabel_1.setBounds(20, 201, 82, 14);
        contentPane.add(lblNewLabel_1);
        
        cajachip = new JTextField();
        cajachip.setBounds(150, 201, 130, 20);
        contentPane.add(cajachip);
        cajachip.setColumns(10);
        
        lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(modificar_mascota.class.getResource("/imagenes/fondoprincipal.jpg")));
        lblNewLabel.setBounds(0, 0, 584, 411);
        contentPane.add(lblNewLabel);

        cargarDatos();
        crearNuevoTrigger();  // Se llama al método para crear el trigger
    }

    private void crearNuevoTrigger() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "centro_de_adopcon");
        try {
            conexion.conectar();

            // Eliminar el trigger si ya existe
            String dropTrigger = "DROP TRIGGER IF EXISTS guardar_cambios_mascota;";
            conexion.ejecutarInsertDeleteUpdate(dropTrigger);

            // Crear el nuevo trigger
            String createTrigger = "CREATE TRIGGER guardar_cambios_mascota AFTER UPDATE ON mascotas " +
                                   "FOR EACH ROW BEGIN " +
                                   "INSERT INTO historial_cambios_nuevo (ChipMascota, Nombre_Anterior, Nombre_Nuevo, Edad_Anterior, Edad_Nueva, Especie_Anterior, Especie_Nueva, Raza_Anterior, Raza_Nueva, Fecha_Cambio) " +
                                   "VALUES (OLD.ChipMascota, OLD.Nombre, NEW.Nombre, OLD.Edad, NEW.Edad, OLD.Especie, NEW.Especie, OLD.Raza, NEW.Raza, NOW()); " +
                                   "END;";
            conexion.ejecutarInsertDeleteUpdate(createTrigger);

            conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    private void actualizarMascota() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "centro_de_adopcon");
        try {
            conexion.conectar();
            String sql = "UPDATE mascotas SET Nombre = '"+ cajaNombreMascota.getText() + "', Especie ='" + cajaNuevaEspecie.getText()+ "', Raza ='" + cajaNuevaRaza.getText() + "', Edad ='" + cajaNuevaEdad.getText()+"' WHERE ChipMascota = '"+ cajachip.getText() +"'";
            conexion.ejecutarInsertDeleteUpdate(sql);
            JOptionPane.showMessageDialog(this, "Mascota actualizada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
