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
        String[] columnas = {"Nombre", "Edad", "Especie", "Raza"};
        modeloTabla = new DefaultTableModel(null, columnas);
        tablaMascotas = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaMascotas);
        scrollPane.setBounds(10, 10, 560, 180);
        contentPane.add(scrollPane);

        // Capturar clic en la tabla
        tablaMascotas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaMascotas.getSelectedRow();
                cajaNombreMascota.setText(modeloTabla.getValueAt(filaSeleccionada, 0).toString());
                cajaNuevaEdad.setText(modeloTabla.getValueAt(filaSeleccionada, 1).toString());
                cajaNuevaEspecie.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
                cajaNuevaRaza.setText(modeloTabla.getValueAt(filaSeleccionada, 3).toString());
            }
        });

        JLabel lblNombreMascota = new JLabel("Nombre Mascota:");
        lblNombreMascota.setBounds(20, 200, 120, 14);
        contentPane.add(lblNombreMascota);

        cajaNombreMascota = new JTextField();
        cajaNombreMascota.setBounds(150, 197, 130, 20);
        contentPane.add(cajaNombreMascota);
        cajaNombreMascota.setColumns(10);

        JLabel lblNuevaEdad = new JLabel("Nueva Edad:");
        lblNuevaEdad.setBounds(20, 230, 120, 14);
        contentPane.add(lblNuevaEdad);

        cajaNuevaEdad = new JTextField();
        cajaNuevaEdad.setBounds(150, 227, 130, 20);
        contentPane.add(cajaNuevaEdad);
        cajaNuevaEdad.setColumns(10);

        JLabel lblNuevaEspecie = new JLabel("Nueva Especie:");
        lblNuevaEspecie.setBounds(20, 260, 120, 14);
        contentPane.add(lblNuevaEspecie);

        cajaNuevaEspecie = new JTextField();
        cajaNuevaEspecie.setBounds(150, 257, 130, 20);
        contentPane.add(cajaNuevaEspecie);
        cajaNuevaEspecie.setColumns(10);

        JLabel lblNuevaRaza = new JLabel("Nueva Raza:");
        lblNuevaRaza.setBounds(20, 290, 120, 14);
        contentPane.add(lblNuevaRaza);

        cajaNuevaRaza = new JTextField();
        cajaNuevaRaza.setBounds(150, 287, 130, 20);
        contentPane.add(cajaNuevaRaza);
        cajaNuevaRaza.setColumns(10);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(150, 320, 130, 23);
        btnActualizar.addActionListener(e -> actualizarMascota());
        contentPane.add(btnActualizar);

        cargarDatos();
    }

    private void cargarDatos() {
        ConexionMySQL conexion = new ConexionMySQL("root", "", "centro_de_adopcon");
        try {
            conexion.conectar();
            Connection conn = conexion.getConexion();
            PreparedStatement stmt = conn.prepareStatement("SELECT Nombre, Edad, Especie, Raza FROM mascotas");
            ResultSet rs = stmt.executeQuery();

            modeloTabla.setRowCount(0);
            while (rs.next()) {
                modeloTabla.addRow(new Object[]{rs.getString("Nombre"), rs.getString("Edad"), rs.getString("Especie"), rs.getString("Raza")});
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
            Connection conn = conexion.getConexion();
            String sql = "UPDATE mascotas SET Edad = ?, Especie = ?, Raza = ? WHERE Nombre = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cajaNuevaEdad.getText());
            pstmt.setString(2, cajaNuevaEspecie.getText());
            pstmt.setString(3, cajaNuevaRaza.getText());
            pstmt.setString(4, cajaNombreMascota.getText());

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "Mascota actualizada correctamente.");
                cargarDatos();  // Refrescar la tabla
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la mascota con el nombre proporcionado.");
            }
            conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
