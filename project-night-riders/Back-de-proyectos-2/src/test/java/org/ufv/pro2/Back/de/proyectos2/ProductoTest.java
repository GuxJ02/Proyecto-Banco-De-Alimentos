package org.ufv.pro2.Back.de.proyectos2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductoTest {
    Producto producto;
    @BeforeEach
    public void inicializar() {
        producto=new Producto("producto2",12, 0);
    }
    @Test
    @DisplayName("Test método-nombre")//Comprueba si los métodos devuelven la informacion correcta
    public void metodoproducto(){
        //Datos esperados
        String nombreproducto="producto2";

        assertEquals(producto.getNombre(),nombreproducto);


    }
    @Test
    @DisplayName("Test método-cantidad")//Comprueba si los métodos devuelven la informacion correcta
    public void metodoproducto2(){
        //Datos esperados

        int cantidad=12;

        assertEquals(producto.getCantidad(),cantidad);


    }


}
