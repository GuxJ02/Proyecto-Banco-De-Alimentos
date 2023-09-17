package org.ufv.pro2.Back.de.proyectos2;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.time.LocalDate;
import java.io.FileOutputStream;
import java.util.ArrayList;


public class PDFManager {
    public void fichero(ArrayList<Producto> productos){
        try {

            Document doc = new Document(PageSize.A4, 50, 50, 100, 72);

            PdfWriter writer = PdfWriter.getInstance(doc, new
                    FileOutputStream("./Productos/ListaProductos.pdf"));

            doc.open();

            Paragraph title = new Paragraph("Lista de productos");
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20f);
            doc.add(title);

            // Agrega una línea separadora
            LineSeparator lineSeparator = new LineSeparator();
            doc.add(lineSeparator);
            doc.add(new Paragraph("\n"));
            LocalDate fechaActual = LocalDate.now();
            String fechaActualComoString = fechaActual.toString();


            for ( Producto recorrer:productos) {
                String text = recorrer.getNombre();
                String text2 =String.valueOf(recorrer.getCantidad());

                Paragraph p = new Paragraph(text);
                p.add("   Cantidad:");
                p.add(text2);
                p.setAlignment(Element.ALIGN_JUSTIFIED);
                doc.add(p);


            }
            Paragraph p = new Paragraph("Ultima modificación: ");
            p.add(fechaActualComoString);
            doc.add(p);

            doc.close();
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}