package org.vaadin.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.awt.geom.GeneralPath;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Service
public class ProyectoService implements Serializable {

    public int VerificaciónUsuario(String usuario, String contra) throws IOException, URISyntaxException, InterruptedException {

        Usuario user = new Usuario(usuario,contra,0);
        Gson gson = new Gson();
        String data = gson.toJson(user);
        Api api = new Api();
        return Integer.parseInt(api.enviarDatosUsuarios(data));

    }

    public int devolverPuntos() throws IOException, URISyntaxException, InterruptedException {

        Api api = new Api();
        return Integer.parseInt(api.devolverPuntos());

    }

    public void EnviarEmail(String datos) throws IOException, URISyntaxException, InterruptedException {
        Api api = new Api();
        api.enviarDatosEmail(datos);


    }
    public ArrayList<Producto> DarAlimentos() throws IOException, URISyntaxException, InterruptedException {

        Api api = new Api();
        String datos = api.getAlimentos();
        Gson geson = new Gson();
        ArrayList<Producto> productos = geson.fromJson(datos,new TypeToken<ArrayList<Producto>>() {}.getType());
        return productos;

    }

    public void ActualizaProducto(String datos) throws IOException, URISyntaxException, InterruptedException {
        Api api = new Api();
        api.ActualizarProductos(datos);


    }

    public ArrayList<Comentario> DarComentarios() throws IOException, URISyntaxException, InterruptedException {//Enviar Comentarios a Front

        Api api = new Api();
        String datos = api.getValoraciones();
        Gson geson = new Gson();
        ArrayList<Comentario> comentarios = geson.fromJson(datos,new TypeToken<ArrayList<Comentario>>() {}.getType());
        return comentarios;
    }
    public void EnviarComentario(String datos) throws IOException, URISyntaxException, InterruptedException {//EnviarComentarios aBBDD
        Api api = new Api();
        api.EnviarValoracion(datos);
    }
    public void ActualizaPunto(Puntos puntos) throws IOException, URISyntaxException, InterruptedException {//EnviarComentarios aBBDD
        Api api = new Api();
        Gson gson = new Gson();
        String datos = gson.toJson(puntos);
        api.ActualizarPuntos(datos);
    }
//ActualizarPuntos
}
