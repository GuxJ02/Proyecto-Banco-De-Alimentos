package org.ufv.pro2.Back.de.proyectos2;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.lang.reflect.Array;
import java.sql.*;
import java.lang.Class;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class LectorBBDD {
    int puntosFinal = -1;

    Usuario usuarioUltimo;

    //String connectionUrl = "jdbc:mysql://localhost:3306/productos?serverTimezone=UTC";
    String connectionUrl = "jdbc:mysql://aws.connect.psdb.cloud/nighriders?sslMode=VERIFY_IDENTITY";

    public ArrayList<Producto> crearProductos() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Producto producto;
        ArrayList<Producto> productos = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(connectionUrl, "dmtnzpsmt6q5dxppgkl3", "pscale_pw_sx8NevzVdZ1FzJHXM8px4hmcq77iK5p8VXgxvXUbuOL")) {
            PreparedStatement ps = con.prepareStatement("select nombre, cantidad, punto from producto");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                producto = new Producto(rs.getString("nombre"), rs.getInt("cantidad"), rs.getInt("punto"));
                productos.add(producto);
            }
            return productos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int comprobarUser(String datos) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        int i = -1;
        Gson gson = new Gson();
        Usuario user = gson.fromJson(datos, new TypeToken<Usuario>() {
        }.getType());

        try (Connection con = DriverManager.getConnection(connectionUrl, "dmtnzpsmt6q5dxppgkl3", "pscale_pw_sx8NevzVdZ1FzJHXM8px4hmcq77iK5p8VXgxvXUbuOL")) {
            PreparedStatement ps = con.prepareStatement("select contrasena, punto from usuario where nombre = '" + user.getNombre() + "';");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String a = rs.getString("contrasena");
                String b = user.getContra();
                if (a.equals(b)) {
                    i = rs.getInt("punto");
                    puntosFinal = i;
                    usuarioUltimo = new Usuario(user.getNombre(), user.getContra(), i);
                } else {

                }
            }
            return i;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void guardarComentario(String datos) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Gson gson = new Gson();
        Comentario comen = null;
        try {
            comen = gson.fromJson(datos, new TypeToken<Comentario>() {
            }.getType());
        } catch (JsonSyntaxException e) {
            // Si no se puede deserializar, tratar como string normal
            comen = new Comentario(datos);
        }

        try (Connection con = DriverManager.getConnection(connectionUrl, "dmtnzpsmt6q5dxppgkl3", "pscale_pw_sx8NevzVdZ1FzJHXM8px4hmcq77iK5p8VXgxvXUbuOL")) {
            Statement ps = con.createStatement();
            ps.executeUpdate("INSERT INTO comentario VALUES ('" + comen.getContenido() + "')");
        } catch (Exception e) {

        }
    }

    public int devolverUltPuntos() {
        return puntosFinal;
    }

    public void cambiarProductos(String datos) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Gson gson = new Gson();
        ArrayList<Producto> productos = gson.fromJson(datos, new TypeToken<ArrayList<Producto>>() {
        }.getType());
        try (Connection con = DriverManager.getConnection(connectionUrl, "dmtnzpsmt6q5dxppgkl3", "pscale_pw_sx8NevzVdZ1FzJHXM8px4hmcq77iK5p8VXgxvXUbuOL")) {
            for (int i = 0; i < 9; i++) {
                int j = i + 1;
                String sql = "update producto set cantidad = " + productos.get(i).getCantidad() + " where idproducto = " + j;
                Statement stmt = con.createStatement();
                int filasActualizadas = stmt.executeUpdate(sql);
                //PreparedStatement ps = con.prepareStatement("update producto set punto = " + productos.get(i).getPuntos() + " where idproducto = " + i);
                //ResultSet rs = ps.executeQuery();
            }
        } catch (Exception e) {

        }
    }

    public ArrayList<Comentario> mostrarComentarios() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ArrayList<Comentario> comentarios = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(connectionUrl, "dmtnzpsmt6q5dxppgkl3", "pscale_pw_sx8NevzVdZ1FzJHXM8px4hmcq77iK5p8VXgxvXUbuOL")) {
            PreparedStatement ps = con.prepareStatement("select contenido from comentario");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comentario comentario = new Comentario(rs.getString("contenido"));
                comentarios.add(comentario);
            }
            return comentarios;
        } catch (Exception e) {
            return null;
        }
    }

    public void quitarPuntos(String puntos) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Gson gson = new Gson();
        Puntos puntos1 = gson.fromJson(puntos, new TypeToken<Puntos>() {
        }.getType());
        try (Connection con = DriverManager.getConnection(connectionUrl, "dmtnzpsmt6q5dxppgkl3", "pscale_pw_sx8NevzVdZ1FzJHXM8px4hmcq77iK5p8VXgxvXUbuOL")) {
            String sql = "update usuario set punto = " + puntos1.getPuntos() + " where nombre = '" + usuarioUltimo.getNombre() + "';";
            Statement stmt = con.createStatement();
            int filasActualizadas = stmt.executeUpdate(sql);
            puntosFinal = puntos1.getPuntos();
        }

    }
}
