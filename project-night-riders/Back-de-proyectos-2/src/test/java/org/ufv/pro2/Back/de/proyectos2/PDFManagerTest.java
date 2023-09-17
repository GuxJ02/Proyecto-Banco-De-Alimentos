package org.ufv.pro2.Back.de.proyectos2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
public class PDFManagerTest {
    PDFManager pdfManager;
    ArrayList<Producto> productos;

    public PDFManagerTest() throws IOException {
    }

    @BeforeEach
    public void inicializar() {
        pdfManager=new PDFManager();
        productos=new ArrayList<>();
        productos.add(new Producto("producto2",12, 0));

    }
    public boolean CrearFichero() throws IOException {
        pdfManager.fichero(productos);
        File file = new File("./Productos/ListaProductos.pdf");
        PDDocument document = PDDocument.load(file);
        String content = new PDFTextStripper().getText(document);
        document.close();
        Producto producto=productos.get(0);
        return content.contains(producto.getNombre());


    }
    @Test
    @DisplayName("Test comprobación-Fichero")//Comprueba si existe el fichero creado con la función CrearFichero()
    void Comprobacion() throws IOException {
        boolean comprobacion = CrearFichero();
        Assertions.assertTrue(comprobacion);
    }





}
