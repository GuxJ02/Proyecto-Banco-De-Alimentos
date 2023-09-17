package org.ufv.pro2.Back.de.proyectos2;

import com.mysql.cj.protocol.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class ProyectoController {
    LectorBBDD lector = new LectorBBDD();
    PDFManager pdf=new PDFManager();
    @Autowired
    private EnvioEmail emailService;

    @GetMapping("/productos")
    public ArrayList<Producto> producto() throws ClassNotFoundException {
        return lector.crearProductos();
    }
    @PostMapping("/usuarioNuevo")
    public int devolverUser(@RequestBody String datos) throws ClassNotFoundException {
        return lector.comprobarUser(datos);
    }
    @PostMapping("/comentario")
    public void guardarComen(@RequestBody String datos) throws ClassNotFoundException {
         lector.guardarComentario(datos);
    }
    @PostMapping("/cambiarProducto")
    public void cambiarPro(@RequestBody String datos){
        //new LectorBBDD().cambiarProducto(datos);
    }
    @GetMapping("/ultimosPuntos")
    public int devolverPuntos(){
       return lector.devolverUltPuntos();
    }
    //@GetMapping("/valoraciones")
    //public ArrayList<Comentario> devolverComentarios(){
     //   return lector.mostrarComentarios();
    //}
    @PostMapping("/correo")
    public void verCorreo(@RequestBody String datos){
        String[] partes = datos.split("¬");
        emailService.sendEmail(partes[0], partes[1], partes[2]);
    }
    @PostMapping("/cantidadProducto")
    public void cambiarCantidad(@RequestBody String datos) throws SQLException, ClassNotFoundException {
        lector.cambiarProductos(datos);
        pdf.fichero(lector.crearProductos());
    }

    @GetMapping("/valoraciones")//De BBDD a Front
    public ArrayList<Comentario> devolverComentarios() throws ClassNotFoundException {
        return lector.mostrarComentarios();
    }

    @PostMapping("/menosPuntos")
    public void quitarPuntos(@RequestBody String puntos) throws SQLException, ClassNotFoundException {
        lector.quitarPuntos(puntos);
    }
}
