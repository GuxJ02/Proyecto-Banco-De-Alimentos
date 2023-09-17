package org.ufv.pro2.Back.de.proyectos2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BBDDTest {
    LectorBBDD lector = new LectorBBDD();

    public BBDDTest() throws ClassNotFoundException {
    }

    public ArrayList<Producto> producto() throws ClassNotFoundException {
        return lector.crearProductos();
    }
    ArrayList producto2=producto();
    @Test
    @DisplayName("Test de productos en bbdd")//Comprueba si ha leído la base de datos y lo ha almancenado correctamente en la variable.
    public void metodoproductos(){
        //Datos esperados



        assertFalse(producto2.isEmpty());


    }
}
