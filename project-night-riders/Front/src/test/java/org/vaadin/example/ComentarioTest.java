package org.vaadin.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class ComentarioTest {

        @Test
        public void testComentario() {
            Comentario comentario = new Comentario("Comentario 1");
            assertEquals("Comentario 1", comentario.getContenido());
        }
}
