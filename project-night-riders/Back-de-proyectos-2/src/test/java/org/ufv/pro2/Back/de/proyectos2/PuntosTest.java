package org.ufv.pro2.Back.de.proyectos2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class PuntosTest {
    Puntos puntos;
    Puntos puntos2;
    @BeforeEach
    public void inicializar() {
        puntos=new Puntos(12);
        puntos2=new Puntos();
        puntos2.setPuntos(14);
    }
    @Test
    @DisplayName("Test método-puntos1")//Comprueba si los métodos devuelven la información correcta mediante constructor.
    public void metodopuntos1() {
        assertEquals(puntos.getPuntos(),12);
    }
    @Test
    @DisplayName("Test método-puntos2")//Comprueba si los métodos devuelven la información correcta mediante set.
    public void metodopuntos2() {
        assertEquals(puntos2.getPuntos(),14);
    }
}
