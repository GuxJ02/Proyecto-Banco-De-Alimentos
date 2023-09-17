package org.vaadin.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductoTest {
    @Test
    public void testProducto() {
        Producto producto = new Producto("Producto 1", 10, 100);
        assertEquals("Producto 1", producto.getNombre());
        assertEquals(10, producto.getCantidad());
        assertEquals(100, producto.getPuntos());
    }
}
