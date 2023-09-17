package org.vaadin.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PuntosTest {
    @Test
    public void testPuntos() {
        Puntos puntos = new Puntos();
        puntos.setPuntos(100);
        assertEquals(100, puntos.getPuntos());
    }
}
