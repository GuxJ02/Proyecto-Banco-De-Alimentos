package org.ufv.pro2.Back.de.proyectos2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class ComentarioTest {
    @Test
    public void testComentario() {  // Comprueba si los métodos devuelven la infromacion correcta
        // Datos esperados
        String texto = "texto";
        int puntuacion = 0;
        Comentario comentario = new Comentario(texto);
        assertEquals(comentario.getContenido(), texto);
    }
}
