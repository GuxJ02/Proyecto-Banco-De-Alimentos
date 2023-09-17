package org.vaadin.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class UsuarioTest {

        @Test
        public void testUsuario() {
            Usuario usuario = new Usuario("Usuario 1", "1234");
            assertEquals("Usuario 1", usuario.getNombre());
            assertEquals("1234", usuario.getContra());
        }
}
