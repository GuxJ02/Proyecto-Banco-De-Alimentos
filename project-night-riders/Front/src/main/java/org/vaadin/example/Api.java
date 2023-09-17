package org.vaadin.example;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class Api {
    private static final String urlPrefix = "http://backproyectos:8080/%s";
    //private static final String urlPrefix = "http://localhost:8080/%s";

    public String enviarDatosUsuarios(String datos) throws IOException, InterruptedException, URISyntaxException {
        String fullUrl = String.format(urlPrefix,"usuarioNuevo");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                .POST(HttpRequest.BodyPublishers.ofString(datos))
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }
    public String devolverPuntos() throws IOException, InterruptedException, URISyntaxException {
        String fullUrl = String.format(urlPrefix,"ultimosPuntos");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                 .GET()
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }

    public String enviarDatosEmail(String datos) throws IOException, InterruptedException, URISyntaxException {
        String fullUrl = String.format(urlPrefix,"correo");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                .POST(HttpRequest.BodyPublishers.ofString(datos))
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }




    public String getAlimentos() throws IOException, InterruptedException, URISyntaxException {
        String fullUrl = String.format(urlPrefix,"productos");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }

    public String ActualizarProductos(String datos) throws IOException, InterruptedException, URISyntaxException {
        String fullUrl = String.format(urlPrefix,"cantidadProducto");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                .POST(HttpRequest.BodyPublishers.ofString(datos))
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }
    public String ActualizarPuntos(String datos) throws IOException, InterruptedException, URISyntaxException {
        String fullUrl = String.format(urlPrefix,"menosPuntos");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                .POST(HttpRequest.BodyPublishers.ofString(datos))
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }


    public String getValoraciones() throws IOException, InterruptedException, URISyntaxException {
        String fullUrl = String.format(urlPrefix,"valoraciones");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }
    public String EnviarValoracion(String datos) throws IOException, InterruptedException, URISyntaxException {
        String fullUrl = String.format(urlPrefix,"comentario");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                .POST(HttpRequest.BodyPublishers.ofString(datos))
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }


}
