package Adopcion_de_animales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Gestionar_MascotasTest {
    private Gestionar_Mascotas gestinarMascotas;

    @BeforeEach
    void setUp() {
        gestinarMascotas = new Gestionar_Mascotas();
    }

    @Test
    void testAsignarYRecuperarNombre() {
        gestinarMascotas.cajanombre.setText("Nube");
        assertEquals("Nube", gestinarMascotas.cajanombre.getText());
    }

    @Test
    void testAsignarYRecuperarEspecie() {
        gestinarMascotas.cajaespecie.setText("Gato");
        assertEquals("Gato", gestinarMascotas.cajaespecie.getText());
    }

    @Test
    void testAsignarYRecuperarRaza() {
        gestinarMascotas.cajaraza.setText("Siames");
        assertEquals("Siames", gestinarMascotas.cajaraza.getText());
    }

    @Test
    void testAsignarYRecuperarEdad() {
        gestinarMascotas.cajaedad.setText("3");
        assertEquals("3", gestinarMascotas.cajaedad.getText());
    }

    @Test
    void testAsignarYRecuperarChip() {
        gestinarMascotas.cajachip.setText("24567134");
        assertEquals("24567134", gestinarMascotas.cajachip.getText());
    }

    @Test
    void testAgregarMascotaMantieneDatos() {
        // Asignamos datos a los campos
        gestinarMascotas.cajanombre.setText("Javier");
        gestinarMascotas.cajaespecie.setText("Monos");
        gestinarMascotas.cajaraza.setText("Chimpacée");
        gestinarMascotas.cajaedad.setText("50");
        gestinarMascotas.cajachip.setText("123123");

     

        // Verificamos que los datos no se hayan modificado
        assertEquals("Javier", gestinarMascotas.cajanombre.getText());
        assertEquals("Monos", gestinarMascotas.cajaespecie.getText());
        assertEquals("Chimpacée", gestinarMascotas.cajaraza.getText());
        assertEquals("50", gestinarMascotas.cajaedad.getText());
        assertEquals("123123", gestinarMascotas.cajachip.getText());
    }
}