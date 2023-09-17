package org.ufv.pro2.Back.de.proyectos2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {
    Usuario usuario;
    @BeforeEach
    public void inicializar() {
        usuario=new Usuario("carlos","libertad23",12);
    }
    @Test
    @DisplayName("Test método-nombre")//Comprueba si los métodos devuelven la informacion correcta
    public void metodoproducto(){
        //Datos esperados
        String nombreuser="carlos";


        assertEquals(usuario.getNombre(),nombreuser);


    }
    @Test
    @DisplayName("Test método-contraseña")//Comprueba si los métodos devuelven la informacion correcta
    public void metodoproducto2(){
        //Datos esperados

        String contrasena="libertad23";

        assertEquals(usuario.getContra(),contrasena);


    }


    @Test
    @DisplayName("Test método-puntos")//Comprueba si los métodos devuelven la infromacion correcta
    public void metodoproducto3(){
        //Datos esperados

        int  puntos=12;

        assertEquals(usuario.getPunto(),puntos);


    }
}
