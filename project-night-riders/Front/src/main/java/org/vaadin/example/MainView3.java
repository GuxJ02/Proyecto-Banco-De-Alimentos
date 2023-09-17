package org.vaadin.example;

import com.google.gson.Gson;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import javax.swing.*;


/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 * <p>
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView3 extends AppLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service
     *            The message service. Automatically injected Spring managed
     *            bean.
     */


    //SE CREAN LOS TABS GLOBALES
    Tab tabInicio = createTab(VaadinIcon.USER_HEART, "Inicio");
    Tab tabAlimentos = createTab(VaadinIcon.CART, "Ver Alimentos");
    Tab tabValoraciones = createTab(VaadinIcon.LIST, "Valoraciones");
    Tab tabContacto = createTab(VaadinIcon.PACKAGE, "Sobre Nosotros");

    //  int numero = numeroLabel;
    Label numeroLabel = new Label("10");

    //SE DEFINEN LOS DIVS DE CADA UNO DE LOS TABS
    Div contentINICIO = new Div();
    Div contentVerAlimentos = new Div();
    Div contentVALORACIONES = new Div();
    Div contentCONTACTO = new Div();
    public MainView3(@Autowired ProyectoService service) throws IOException, URISyntaxException, InterruptedException {


        UI.getCurrent().getElement().setAttribute("theme", "dark");

        DrawerToggle toggle = new DrawerToggle();

        //TITULO DE LA APP
        H1 title = new H1("BANCO DE ALIMENTOS 2");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");



        //SE AÑADEN LOS TABS
        Tabs tabs = new Tabs();
        tabs.add(tabInicio,
                tabAlimentos,
                tabValoraciones,
                tabContacto);

        tabs.setOrientation(Tabs.Orientation.VERTICAL);





        //SE RECIBE LA RESPUESTA DE LOS PUNTOS QUE TIENE EL USUARIO Y SE INTRODUCEN EN EL FRONT A LA VEZ QUE LOS TABS
        int punto= service.devolverPuntos();
        int puntoBueno= punto;
      //  int punto=1;
        AtomicReference<String> puntoS= new AtomicReference<>(String.valueOf(punto));
        Label puntoss = new Label(puntoS + " Puntos");
        puntoss.getElement().getStyle().set("margin-left", "77%");
        addToDrawer(tabs);
        addToNavbar(toggle, title,puntoss);



        //PESTAÑA INICIO
        H1 TituloInicio = new H1("Bienvenido");
        TituloInicio.getStyle().set("text-align", "center");
        VerticalLayout sobreNosotrosDiv2 = new VerticalLayout();


// Creamos un objeto Span con el contenido que queremos mostrar
        Span texto2 = new Span("Bienvendo a nuestra aplicacion BANCO DE ALIMENTOS 2.Administre y controle su banco de alimentos de manera eficiente y sencilla");

        // Creamos un objeto Image con la imagen que queremos mostrar
        Image imagen2 = new Image("https://www.compromisorse.com/upload/noticias/019/19190/Solidaridad.jpg", "Descripción de la imagen");



// Creamos un objeto VerticalLayout para el contenido del div
        VerticalLayout contenidoLayout2 = new VerticalLayout(texto2, imagen2);
        contenidoLayout2.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

// Ajustamos los estilos del div
        sobreNosotrosDiv2.setWidth("100%");
        sobreNosotrosDiv2.getStyle().set("padding", "20px");

// Ajustamos los estilos de la imagen
        imagen2.setWidth("50%");
        imagen2.setMaxHeight("50%");
// Ajustamos los estilos del texto
        texto2.getStyle().set("margin-top", "20px");

// Creamos un objeto FlexLayout para el layout responsive
        FlexLayout layout2 = new FlexLayout(contenidoLayout2);
        layout2.setWidth("100%");
        layout2.setFlexWrap(FlexLayout.FlexWrap.WRAP);
        layout2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layout2.setAlignItems(FlexComponent.Alignment.CENTER);



// Añadimos el layout responsive al div
        sobreNosotrosDiv2.add(layout2);
        contentINICIO.add(TituloInicio, new Hr());
// Añadimos el div a la página
        contentINICIO.add(sobreNosotrosDiv2);





/////fin INTERFAZ CONTACTO PARA CLIENTES:
        ///

        setContent(contentINICIO);






        //PESTAÑA VER ALIMENTOS
        H1 TituloAlimentos = new H1("Ver Alimentos");
        TituloAlimentos.getStyle().set("text-align", "center");


        VerticalLayout verticalLayout = new VerticalLayout();
        //verticalLayout.getStyle().set("border", "1px solid black"); // Añadir borde al VerticalLayout principal

        HorizontalLayout horizontalLayout1 = new HorizontalLayout();
        horizontalLayout1.setWidth("100%");
        // horizontalLayout1.getStyle().set("border", "1px solid black"); // Añadir borde al HorizontalLayout

        // horizontalLayout1.setAlignItems(FlexComponent.Alignment.CENTER);
        verticalLayout.add(horizontalLayout1);

        HorizontalLayout horizontalLayout2 = new HorizontalLayout();
        horizontalLayout2.setWidth("100%");

        // horizontalLayout2.getStyle().set("border", "1px solid black"); // Añadir borde al HorizontalLayout
        // horizontalLayout2.setAlignItems(FlexComponent.Alignment.CENTER);
        verticalLayout.add(horizontalLayout2);

        HorizontalLayout horizontalLayout3 = new HorizontalLayout();
        horizontalLayout3.setWidth("100%");
        verticalLayout.add(horizontalLayout3);

        HorizontalLayout horizontalLayout4 = new HorizontalLayout();
        horizontalLayout4.setWidth("100%");
        verticalLayout.add(horizontalLayout4);
        // Agregar más HorizontalLayouts al VerticalLayout si es necesario

        //https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.malatintamagazine.com%2Fwp-content%2Fuploads%2F2016%2F04%2FBanana6.png&f=1&nofb=1&ipt=1c8f38913e2cc2b11fdf969ba3da89b5d36beef08a2b921aada324be542a6594&ipo=images
    //https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimg2.freepng.es%2F20191111%2Fyuk%2Ftransparent-banana-family-banana-yellow-cooking-plantain-fruit-5dc9fcba8b0947.8407512315735185225695.jpg&f=1&nofb=1&ipt=33645906d89ad76fd94a960e2b78b069ed41166252621b526762f429baa58338&ipo=images
        Image images = new Image("http://aggie-horticulture.tamu.edu/vegetable/files/2011/10/apple26.jpg", "Descripción de la imagen");
        images.addClassName("imagenes");
        Image images2 = new Image("https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.malatintamagazine.com%2Fwp-content%2Fuploads%2F2016%2F04%2FBanana6.png&f=1&nofb=1&ipt=1c8f38913e2cc2b11fdf969ba3da89b5d36beef08a2b921aada324be542a6594&ipo=images\n", "Descripción de la imagen");
        images2.addClassName("imagenNaranja");
        Image images3 = new Image("https://purepng.com/public/uploads/large/purepng.com-ricericeseedgrainfood-1411528653188vpyef.png", "Descripción de la imagen");
        images3.addClassName("imagenes");
        Image images4 = new Image("https://comefruta.es/wp-content/uploads/zumo-naranja.jpg", "Descripción de la imagen");
        images4.addClassName("imagenNaranja");
        Image images5 = new Image("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.casagilo.es%2F1188-large_default%2Fleche-pascual-entera-1-l-brik.jpg&f=1&nofb=1&ipt=bd78a3931629bac815e6b1339f2ceb6bbb7eea8a24c8574c2b8dc97c9a848da2&ipo=images", "Descripción de la imagen");
        images5.addClassName("imagenes");
        Image images6 = new Image("http://comercialsantas.com/wp-content/uploads/2013/03/ConservasVegetales_garbanzos.png", "Descripción de la imagen");
        images6.addClassName("imagenes");
        Image images7 = new Image("https://www.ferminescribano.es/282-thickbox_default/zumo-brik-naranja-12-1l-juver.jpg", "Descripción de la imagen");
        images7.addClassName("imagenes");
        Image images8 = new Image("https://wongfood.vteximg.com.br/arquivos/ids/211336-750-750/Lenteja-Maxima-Bolsa-500-g-1-150462.jpg?v=636556212699200000", "Descripción de la imagen");
        images8.addClassName("imagenes");
        Image images9 = new Image("https://www.kikoalimentacion.com/wp-content/uploads/2016/06/c0098_judias_verdes-700x700.jpg", "Descripción de la imagen");
        images9.addClassName("imagenes");
        try {
            ArrayList<Producto> productos = service.DarAlimentos();
            int uno1= productos.get(0).getCantidad();
            int uno2= productos.get(1).getCantidad();
            int uno3= productos.get(2).getCantidad();
            int uno4= productos.get(3).getCantidad();
            int uno5= productos.get(4).getCantidad();
            int uno6= productos.get(5).getCantidad();
            int uno7= productos.get(6).getCantidad();
            int uno8= productos.get(7).getCantidad();
            int uno9= productos.get(8).getCantidad();


            TextField textField1 = new TextField();
            textField1.setMinLength(3);
            textField1.setMaxLength(3);
            textField1.getStyle().set("width", "8em");
            textField1.setValue("0"); //Aqui se pone el valor que se recibe de la base de datos
            textField1.setHelperText("Cantidad dispo: " + productos.get(0).getCantidad());

            TextField textField2 = new TextField();
            textField2.setMinLength(3);
            textField2.setMaxLength(3);
            textField2.getStyle().set("width", "8em");
            textField2.setValue("0"); //Aqui se pone el valor que se recibe de la base de datos
            textField2.setHelperText("Cantidad dispo: "+ productos.get(1).getCantidad());

            TextField textField3 = new TextField();
            textField3.setMinLength(3);
            textField3.setMaxLength(3);
            textField3.getStyle().set("width", "8em");
            textField3.setValue("0");
            textField3.setHelperText("Cantidad dispo: "+ productos.get(2).getCantidad());

            TextField textField4 = new TextField();
            textField4.setMinLength(3);
            textField4.setMaxLength(3);
            textField4.getStyle().set("width", "8em");
            textField4.setValue("0");
            textField4.setHelperText("Cantidad dispo: "+ productos.get(3).getCantidad());

            TextField textField5 = new TextField();
            textField5.setMinLength(3);
            textField5.setMaxLength(3);
            textField5.getStyle().set("width", "8em");
            textField5.setValue("0");
            textField5.setHelperText("Cantidad dispo: "+ productos.get(4).getCantidad());

            TextField textField6 = new TextField();
            textField6.setMinLength(3);
            textField6.setMaxLength(3);
            textField6.getStyle().set("width", "8em");
            textField6.setValue("0");
            textField6.setHelperText("Cantidad dispo:"+ productos.get(5).getCantidad());

            TextField textField7 = new TextField();
            textField7.setMinLength(3);
            textField7.setMaxLength(3);
            textField7.getStyle().set("width", "8em");
            textField7.setValue("0");
            textField7.setHelperText("Cantidad dispo: "+ productos.get(6).getCantidad());

            TextField textField8 = new TextField();
            textField8.setMinLength(3);
            textField8.setMaxLength(3);
            textField8.getStyle().set("width", "8em");
            textField8.setValue("0");
            textField8.setHelperText("Cantidad dispo: "+ productos.get(7).getCantidad());

            TextField textField9 = new TextField();
            textField9.setMinLength(3);
            textField9.setMaxLength(3);
            textField9.getStyle().set("width", "8em");
            textField9.setValue("0");
            textField9.setHelperText("Cantidad dispo: "+ productos.get(8).getCantidad());



            //vaadin:coin-piles

            Label Manzana = new Label("Manzana | "+ productos.get(1).getPuntos() + " Pt");
            Manzana.setClassName("nombresAlimentos");
            Label Platano = new Label("Platano  | "+ productos.get(2).getPuntos() + " Pt");
            Platano.setClassName("nombresAlimentos");
            Label Arroz = new Label("Arroz | "+ productos.get(0).getPuntos() + " Pt");
            Arroz.setClassName("nombresAlimentos");
            Label Naranja = new Label("Naranja | "+ productos.get(3).getPuntos() + " Pt");
            Naranja.setClassName("nombresAlimentos");
            Label Leche = new Label("Leche | "+ productos.get(4).getPuntos() + " Pt");
            Leche.setClassName("nombresAlimentos");
            Label Garbanzos = new Label("Garbanzos | "+ productos.get(5).getPuntos() + " Pt");
            Garbanzos.setClassName("nombresAlimentos");
            Label Zumo = new Label("Zumo | "+ productos.get(6).getPuntos() + " Pt");
            Zumo.setClassName("nombresAlimentos");
            Label Lentejas = new Label("Lentejas | "+ productos.get(7).getPuntos() + " Pt");
            Lentejas.setClassName("nombresAlimentos");
            Label Judias = new Label("Judias | "+ productos.get(8).getPuntos() + " Pt");
            Judias.setClassName("nombresAlimentos");
            /* Label arrozPuntos = new Label(String.valueOf("Disponibles: "));*/



            VerticalLayout verticalLayout1_1 = new VerticalLayout(); ///////////// sector 1.1
            verticalLayout1_1.setClassName("CajaPrincipal");

            HorizontalLayout horizontalLayout1_1 = new HorizontalLayout();
            horizontalLayout1_1.setClassName("CajaImagen");
            horizontalLayout1_1.add(images3);

            HorizontalLayout horizontalLayout1_2 = new HorizontalLayout();
            horizontalLayout1_2.setClassName("CajaDebajoImagen");

            VerticalLayout verticalLayout1_2_1 = new VerticalLayout();
            verticalLayout1_2_1.setClassName("CajaDebajoImagen_Alimento");
            verticalLayout1_2_1.add(Arroz);

            VerticalLayout verticalLayout1_2_2 = new VerticalLayout();
            verticalLayout1_2_2.setClassName("CajaDebajoImagen_Disponibles");

            verticalLayout1_2_2.add(textField1);

            verticalLayout1_1.add(horizontalLayout1_1,horizontalLayout1_2);
            horizontalLayout1_2.add(verticalLayout1_2_1,verticalLayout1_2_2);






            VerticalLayout verticalLayout1_2a = new VerticalLayout(); ///////////// sector 1.1
            verticalLayout1_2a.setClassName("CajaPrincipal");

            HorizontalLayout horizontalLayout1_1a = new HorizontalLayout();
            horizontalLayout1_1a.setClassName("CajaImagen");
            horizontalLayout1_1a.add(images);

            HorizontalLayout horizontalLayout1_2a = new HorizontalLayout();
            horizontalLayout1_2a.setClassName("CajaDebajoImagen");

            VerticalLayout verticalLayout1_2_1a = new VerticalLayout();
            verticalLayout1_2_1a.setClassName("CajaDebajoImagen_Alimento");
            verticalLayout1_2_1a.add(Manzana);

            VerticalLayout verticalLayout1_2_2a = new VerticalLayout();
            verticalLayout1_2_2a.setClassName("CajaDebajoImagen_Disponibles");

            verticalLayout1_2_2a.add(textField2);

            verticalLayout1_2a.add(horizontalLayout1_1a,horizontalLayout1_2a);
            horizontalLayout1_2a.add(verticalLayout1_2_1a,verticalLayout1_2_2a);





            VerticalLayout verticalLayout1_3b = new VerticalLayout(); ///////////// sector 1.1
            verticalLayout1_3b.setClassName("CajaPrincipal");

            HorizontalLayout horizontalLayout1_1b = new HorizontalLayout();
            horizontalLayout1_1b.setClassName("CajaImagen");
            horizontalLayout1_1b.add(images2);

            HorizontalLayout horizontalLayout1_2b = new HorizontalLayout();
            horizontalLayout1_2b.setClassName("CajaDebajoImagen");

            VerticalLayout verticalLayout1_2_1b = new VerticalLayout();
            verticalLayout1_2_1b.setClassName("CajaDebajoImagen_Alimento");
            verticalLayout1_2_1b.add(Platano);

            VerticalLayout verticalLayout1_2_2b = new VerticalLayout();
            verticalLayout1_2_2b.setClassName("CajaDebajoImagen_Disponibles");

            verticalLayout1_2_2b.add(textField3);

            verticalLayout1_3b.add(horizontalLayout1_1b,horizontalLayout1_2b);
            horizontalLayout1_2b.add(verticalLayout1_2_1b,verticalLayout1_2_2b);


            horizontalLayout1.add(verticalLayout1_1, verticalLayout1_2a,verticalLayout1_3b);







            VerticalLayout verticalLayout2_1 = new VerticalLayout();
            verticalLayout2_1.setClassName("CajaPrincipal");

            HorizontalLayout horizontalLayout2_1 = new HorizontalLayout();
            horizontalLayout2_1.setClassName("CajaImagen");
            horizontalLayout2_1.add(images4);

            HorizontalLayout horizontalLayout2_2 = new HorizontalLayout();
            horizontalLayout2_2.setClassName("CajaDebajoImagen");

            VerticalLayout verticalLayout2_2_1 = new VerticalLayout();
            verticalLayout2_2_1.setClassName("CajaDebajoImagen_Alimento");
            verticalLayout2_2_1.add(Naranja);

            VerticalLayout verticalLayout2_2_2 = new VerticalLayout();
            verticalLayout2_2_2.setClassName("CajaDebajoImagen_Disponibles");

            verticalLayout2_2_2.add(textField4);
            horizontalLayout2_2.add(verticalLayout2_2_1,verticalLayout2_2_2);
            verticalLayout2_1.add(horizontalLayout2_1,horizontalLayout2_2);





            VerticalLayout verticalLayout2_2 = new VerticalLayout();
            verticalLayout2_2.setClassName("CajaPrincipal");

            HorizontalLayout horizontalLayout2_1d = new HorizontalLayout();
            horizontalLayout2_1d.setClassName("CajaImagen");
            horizontalLayout2_1d.add(images5);

            HorizontalLayout horizontalLayout2_2d = new HorizontalLayout();
            horizontalLayout2_2d.setClassName("CajaDebajoImagen");

            VerticalLayout verticalLayout2_2_1d = new VerticalLayout();
            verticalLayout2_2_1d.setClassName("CajaDebajoImagen_Alimento");
            verticalLayout2_2_1d.add(Leche);

            VerticalLayout verticalLayout2_2_2d = new VerticalLayout();
            verticalLayout2_2_2d.setClassName("CajaDebajoImagen_Disponibles");

            verticalLayout2_2_2d.add(textField5);
            horizontalLayout2_2d.add(verticalLayout2_2_1d,verticalLayout2_2_2d);
            verticalLayout2_2.add(horizontalLayout2_1d,horizontalLayout2_2d);




            VerticalLayout verticalLayout2_3 = new VerticalLayout();
            verticalLayout2_3.setClassName("CajaPrincipal");

            HorizontalLayout horizontalLayout2_1e = new HorizontalLayout();
            horizontalLayout2_1e.setClassName("CajaImagen");
            horizontalLayout2_1e.add(images6);

            HorizontalLayout horizontalLayout2_2e = new HorizontalLayout();
            horizontalLayout2_2e.setClassName("CajaDebajoImagen");

            VerticalLayout verticalLayout2_2_1e = new VerticalLayout();
            verticalLayout2_2_1e.setClassName("CajaDebajoImagen_Alimento");
            verticalLayout2_2_1e.add(Garbanzos);

            VerticalLayout verticalLayout2_2_2e = new VerticalLayout();
            verticalLayout2_2_2e.setClassName("CajaDebajoImagen_Disponibles");

            verticalLayout2_2_2e.add(textField6);
            horizontalLayout2_2e.add(verticalLayout2_2_1e,verticalLayout2_2_2e);
            verticalLayout2_3.add(horizontalLayout2_1e,horizontalLayout2_2e);



            horizontalLayout2.add(verticalLayout2_1, verticalLayout2_2,verticalLayout2_3);





            VerticalLayout verticalLayout3_1 = new VerticalLayout();
            verticalLayout3_1.setClassName("CajaPrincipal");

            HorizontalLayout horizontalLayout3_1 = new HorizontalLayout();
            horizontalLayout3_1.setClassName("CajaImagen");
            horizontalLayout3_1.add(images7);

            HorizontalLayout horizontalLayout3_2 = new HorizontalLayout();
            horizontalLayout3_2.setClassName("CajaDebajoImagen");

            VerticalLayout verticalLayout3_2_1 = new VerticalLayout();
            verticalLayout3_2_1.setClassName("CajaDebajoImagen_Alimento");
            verticalLayout3_2_1.add(Zumo);

            VerticalLayout verticalLayout3_2_2 = new VerticalLayout();
            verticalLayout3_2_2.setClassName("CajaDebajoImagen_Disponibles");

            verticalLayout3_2_2.add(textField7);
            horizontalLayout3_2.add(verticalLayout3_2_1,verticalLayout3_2_2);
            verticalLayout3_1.add(horizontalLayout3_1,horizontalLayout3_2);


            VerticalLayout verticalLayout3_2 = new VerticalLayout();
            verticalLayout3_2.setClassName("CajaPrincipal");

            HorizontalLayout horizontalLayout3_1f = new HorizontalLayout();
            horizontalLayout3_1f.setClassName("CajaImagen");
            horizontalLayout3_1f.add(images8);

            HorizontalLayout horizontalLayout3_2f = new HorizontalLayout();
            horizontalLayout3_2f.setClassName("CajaDebajoImagen");

            VerticalLayout verticalLayout3_2_1f = new VerticalLayout();
            verticalLayout3_2_1f.setClassName("CajaDebajoImagen_Alimento");
            verticalLayout3_2_1f.add(Lentejas);

            VerticalLayout verticalLayout3_2_2f = new VerticalLayout();
            verticalLayout3_2_2f.setClassName("CajaDebajoImagen_Disponibles");

            verticalLayout3_2_2f.add(textField8);
            horizontalLayout3_2f.add(verticalLayout3_2_1f,verticalLayout3_2_2f);
            verticalLayout3_2.add(horizontalLayout3_1f,horizontalLayout3_2f);



            VerticalLayout verticalLayout3_3 = new VerticalLayout();
            verticalLayout3_3.setClassName("CajaPrincipal");

            HorizontalLayout horizontalLayout3_1g = new HorizontalLayout();
            horizontalLayout3_1g.setClassName("CajaImagen");
            horizontalLayout3_1g.add(images9);

            HorizontalLayout horizontalLayout3_2g = new HorizontalLayout();
            horizontalLayout3_2g.setClassName("CajaDebajoImagen");

            VerticalLayout verticalLayout3_2_1g = new VerticalLayout();
            verticalLayout3_2_1g.setClassName("CajaDebajoImagen_Alimento");
            verticalLayout3_2_1g.add(Judias);

            VerticalLayout verticalLayout3_2_2g = new VerticalLayout();
            verticalLayout3_2_2g.setClassName("CajaDebajoImagen_Disponibles");

            verticalLayout3_2_2g.add(textField9);
            horizontalLayout3_2g.add(verticalLayout3_2_1g,verticalLayout3_2_2g);
            verticalLayout3_3.add(horizontalLayout3_1g,horizontalLayout3_2g);



            horizontalLayout3.add(verticalLayout3_1, verticalLayout3_2,verticalLayout3_3);


            Button primaryButton = new Button("Realizar Compra");
            primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
            primaryButton.setClassName("boton");
            //  primaryButton.setWidth("70px");
            primaryButton.addClickListener(buttonClickEvent -> {

                int[] cantidadesElegidas = new int[9];
                try {
                    cantidadesElegidas[0] = Integer.parseInt(textField1.getValue());
                    cantidadesElegidas[1] = Integer.parseInt(textField2.getValue());
                    cantidadesElegidas[2] = Integer.parseInt(textField3.getValue());
                    cantidadesElegidas[3] = Integer.parseInt(textField4.getValue());
                    cantidadesElegidas[4] = Integer.parseInt(textField5.getValue());
                    cantidadesElegidas[5] = Integer.parseInt(textField6.getValue());
                    cantidadesElegidas[6] = Integer.parseInt(textField7.getValue());
                    cantidadesElegidas[7] = Integer.parseInt(textField8.getValue());
                    cantidadesElegidas[8] = Integer.parseInt(textField9.getValue());
                    ArrayList<Producto> productosNuevos = service.DarAlimentos();
                    int[] CantidadFinal = new int[9];
                    CantidadFinal[0] = productosNuevos.get(0).getCantidad() - cantidadesElegidas[0];
                    CantidadFinal[1] = productosNuevos.get(1).getCantidad() - cantidadesElegidas[1];
                    CantidadFinal[2] = productosNuevos.get(2).getCantidad() - cantidadesElegidas[2];
                    CantidadFinal[3] = productosNuevos.get(3).getCantidad() - cantidadesElegidas[3];
                    CantidadFinal[4] = productosNuevos.get(4).getCantidad() - cantidadesElegidas[4];
                    CantidadFinal[5] = productosNuevos.get(5).getCantidad() - cantidadesElegidas[5];
                    CantidadFinal[6] = productosNuevos.get(6).getCantidad() - cantidadesElegidas[6];
                    CantidadFinal[7] = productosNuevos.get(7).getCantidad() - cantidadesElegidas[7];
                    CantidadFinal[8] = productosNuevos.get(8).getCantidad() - cantidadesElegidas[8];
                    int comprobador = 0;
                    for (int i = 0; i <= 8; i++) {

                        if (CantidadFinal[i] < 0) {
                            comprobador = 1;
                        }


                    }
                    if (comprobador == 0) {
                        try {
                            int PuntosFinales = service.devolverPuntos();
                            int puntoPrueba=PuntosFinales;
                            PuntosFinales = PuntosFinales - (cantidadesElegidas[0] * productos.get(0).getPuntos() + cantidadesElegidas[1] * productos.get(1).getPuntos() + cantidadesElegidas[2] * productos.get(2).getPuntos()
                                    + cantidadesElegidas[3] * productos.get(3).getPuntos() + cantidadesElegidas[4] * productos.get(4).getPuntos() + cantidadesElegidas[5] * productos.get(5).getPuntos()
                                    + cantidadesElegidas[6] * productos.get(6).getPuntos() + cantidadesElegidas[7] * productos.get(7).getPuntos() + cantidadesElegidas[8] * productos.get(8).getPuntos());
                            if (PuntosFinales < 0 || puntoPrueba < PuntosFinales) {
                                Notification notificationMal2 = Notification
                                        .show("Error. Su saldo es insuficiente, o a introducido mal los datos");
                                notificationMal2.addThemeVariants(NotificationVariant.LUMO_ERROR);
                            }
                        else{
                            Puntos puntosFinales = new Puntos();
                            puntosFinales.setPuntos(PuntosFinales);
                            service.ActualizaPunto(puntosFinales);


                            int nuevoPunto = PuntosFinales;
                            puntoS.set(String.valueOf(nuevoPunto));

                            puntoss.setText(puntoS + " Puntos");
                            textField2.setHelperText("Cantidad dispo: " + CantidadFinal[1]);
                            textField1.setHelperText("Cantidad dispo: " + CantidadFinal[0]);

                            textField3.setHelperText("Cantidad dispo: " + CantidadFinal[2]);
                            textField4.setHelperText("Cantidad dispo: " + CantidadFinal[3]);
                            textField5.setHelperText("Cantidad dispo: " + CantidadFinal[4]);
                            textField6.setHelperText("Cantidad dispo: " + CantidadFinal[5]);
                            textField7.setHelperText("Cantidad dispo: " + CantidadFinal[6]);
                            textField8.setHelperText("Cantidad dispo: " + CantidadFinal[7]);
                            textField9.setHelperText("Cantidad dispo: " + CantidadFinal[8]);
                            ArrayList<Producto> productosActualizados = new ArrayList<>();

                            for (int i = 0; i < 9; i++) {
                                Producto productoNuevo = new Producto("Nombre", CantidadFinal[i], 1);
                                productosActualizados.add(productoNuevo);
                            }
                            Gson gson = new Gson();
                            String data = gson.toJson(productosActualizados);

                            try {
                                service.ActualizaProducto(data);

                                Notification notification = Notification
                                        .show("Cantidad actualizada con exito!");
                                notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                            } catch (Exception e) {
                                Notification notification = Notification
                                        .show("Cantidad NO actualizada con exito!");
                                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);

                            }
                        }
                            } catch (Exception E) {

                              }
                    } else {
                        Notification notificationMal = Notification
                                .show("Error. Ha seleccionado mas cantidad de la disponible en el banco");
                        notificationMal.addThemeVariants(NotificationVariant.LUMO_ERROR);
                    }

                } catch (Exception E) {
                    Notification notification = Notification
                            .show("Error. Debe poner en todos los alimentos que no vaya a comprar un 0");
                    notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                }

            });
            horizontalLayout4.add(primaryButton);

        }
        catch(Exception Io){}



// Agregar más VerticalLayouts dentro de cada HorizontalLayout si es necesario
/*
        // Agregar componentes al verticalLayout1_1
        verticalLayout1_1.add(new Button("Botón 1"), new Button("Botón 2"));

// Agregar componentes al verticalLayout1_2
        verticalLayout1_2.add(new TextField("Campo 1"), new TextField("Campo 2"));

// Agregar componentes a los otros VerticalLayouts según sea necesario*/





        contentVerAlimentos.add(TituloAlimentos, new Hr(), verticalLayout);






        //PESTAÑA VALORACIONES
        H1 TituloValoracion = new H1("Valoraciones");
        TituloValoracion.getStyle().set("text-align", "center");

        Grid<Comentario> grid = new Grid<>(Comentario.class);

        grid.setItems(service.DarComentarios());

        grid.getStyle().set("margin-left", "5%");
        grid.getStyle().set("margin-right", "5%");
        grid.getStyle().set("margin-top", "5%");
        grid.getStyle().set("margin-bottom", "5%");
        //Como cambiar titulo y letra de mi grid
        grid.setColumns("contenido");
        grid.getColumnByKey("contenido").setHeader(new H2("COMENTARIOS DE LOS CLIENTES:"));
        grid.getColumnByKey("contenido").setFlexGrow(1);
        grid.getColumnByKey("contenido").setAutoWidth(true);
        grid.getColumnByKey("contenido").setResizable(true);
        grid.getColumnByKey("contenido").setSortable(true);
        grid.getColumnByKey("contenido").setFrozen(true);

        //Pestaña valoraciones cliente
        FormLayout formLayout2 = new FormLayout();
        formLayout2.getStyle().set("margin-left", "5%");
        formLayout2.getStyle().set("margin-right", "5%");
        formLayout2.getStyle().set("margin-top", "5%");
        formLayout2.getStyle().set("margin-bottom", "5%");
        formLayout2.getStyle().set("border", "1px solid black");
        formLayout2.getStyle().set("border-radius", "10px");
        formLayout2.getStyle().set("padding", "10px");

        TextField comentarioField = new TextField("Comentario");
        comentarioField.setPlaceholder("Escribe aquí tu comentario");
        comentarioField.setRequired(true);
        formLayout2.add(comentarioField);

        Button enviarBtn = new Button("Enviar");
        enviarBtn.addClickListener(event -> {
            String comentario = comentarioField.getValue();
            try {
                service.EnviarComentario(comentario);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // grid.setItems(service.DarComentarios());
            comentarioField.clear();
            Notification notification = Notification
                    .show("Gracias por su mensaje!");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        });
        formLayout2.add(enviarBtn);

        //  contentVALORACIONES.add();



        contentVALORACIONES.add(TituloValoracion, new Hr(),formLayout2);





        //PESTAÑA CONTACTO
        H1 TituloContacto = new H1("Sobre nosotros");
        TituloContacto.getStyle().set("text-align", "center");
        contentCONTACTO.add(TituloContacto, new Hr());
///
        VerticalLayout sobreNosotrosDiv = new VerticalLayout();
// Creamos un objeto Span con el contenido que queremos mostrar
        Span texto = new Span("Somos un grupo de estudiantes de tercero de ingenieria Informática de la universidad Francisco de Vitoria, y esto es un proyecto para la asignatura de Proyectos 2");
        Span texto3 = new Span("Nuestro objetivo es desarrollar un gestor de bancos de alimentos que optimice el trabajo de los voluntarios,logrando asi llegar a mas gente que necesite de este tipo de servicios.");

        // Creamos un objeto Image con la imagen que queremos mostrar
        Image imagen = new Image("https://www.ufv.es/wp-content/uploads/2022/08/Summer-Campus.png", "Descripción de la imagen");



// Creamos un objeto VerticalLayout para el contenido del div
        VerticalLayout contenidoLayout = new VerticalLayout(texto,imagen,texto3);
        contenidoLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

// Ajustamos los estilos del div
        sobreNosotrosDiv.setWidth("100%");
        sobreNosotrosDiv.getStyle().set("padding", "20px");

// Ajustamos los estilos de la imagen
        imagen.setWidth("70%");
        imagen.setMaxHeight("70%");
// Ajustamos los estilos del texto
        texto.getStyle().set("margin-top", "20px");

// Creamos un objeto FlexLayout para el layout responsive
        FlexLayout layout = new FlexLayout(contenidoLayout);
        layout.setWidth("100%");
        layout.setFlexWrap(FlexLayout.FlexWrap.WRAP);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);



// Añadimos el layout responsive al div
        sobreNosotrosDiv.add(layout);

// Añadimos el div a la página
       contentCONTACTO.add(sobreNosotrosDiv);





/////fin INTERFAZ CONTACTO PARA CLIENTES:
        //SE ESCUCHA Y SE ALMACENA CUAL ES EL TAB AL QUE SE LE HA PULSADO Y EL TAB PULSADO SE ENVIA COMO VARIABLE A LA FUNCION SETCONTENT
        tabs.addSelectedChangeListener(
                event -> setContent(event.getSelectedTab()));



    }

//    private void aumentarNumero() {
//        numero++;
//        numeroLabel.setText(String.valueOf(numero));
//    }
//
//    private void disminuirNumero() {
//        numero--;
//        numeroLabel.setText(String.valueOf(numero));
//    }

    private void setContent(Tab tab) { //Función para que se ejecuten los diferentes tabs en las distintas pestañas

        if (tab == null) {  //Si no hay nada en el tab no retorna nada
            return;
        }
        if (tab.equals(tabInicio)) {   //Si da click en tabInicio se muestra el iinicio
            contentINICIO.setVisible(true); //Content se vuelve true entonces se ve
            contentVALORACIONES.setVisible(false);
            contentVerAlimentos.setVisible(false);
            contentCONTACTO.setVisible(false);
            setContent(contentINICIO);

        } else if(tab.equals(tabAlimentos)) {  //Si se le da click en tabAlimentos se muestra tab alimentos
            contentINICIO.setVisible(false); //Content se vuelve false entonces no se ve (es lo mismo que quitarlo del front)
            contentVALORACIONES.setVisible(false);
            contentVerAlimentos.setVisible(true);
            contentCONTACTO.setVisible(false);
            setContent(contentVerAlimentos);


        }
        else if(tab.equals(tabValoraciones)) {  //Si se le da click en tabAlimentos se muestra tab alimentos
            contentINICIO.setVisible(false); //Content se vuelve false entonces no se ve (es lo mismo que quitarlo del front)
            contentVALORACIONES.setVisible(true);
            contentVerAlimentos.setVisible(false);
            contentCONTACTO.setVisible(false);
            setContent(contentVALORACIONES);
        }
        else if(tab.equals(tabContacto)) {  //Si se le da click en tabAlimentos se muestra tab alimentos
            contentINICIO.setVisible(false); //Content se vuelve false entonces no se ve (es lo mismo que quitarlo del front)
            contentVALORACIONES.setVisible(false);
            contentVerAlimentos.setVisible(false);
            contentCONTACTO.setVisible(true);
            setContent(contentCONTACTO);


        }
    }
  /*Div textot = new Div();
            Label texto = new Label("Hola le has dado a inicio");
            textot.add(texto);
            setContent(textot);*/

    private Tab createTab(VaadinIcon viewIcon, String viewName) { //Cada tab que se crea se crea con un estilo especifico para que se muestre de manera correcta
        Icon icon = viewIcon.create();  //Se utiliza esta funcion para que los estilos se asignen a cada tab
        icon.getStyle().set("box-sizing", "border-box")
                .set("margin-inline-end", "var(--lumo-space-m)")
                .set("margin-inline-start", "var(--lumo-space-xs)")
                .set("padding", "var(--lumo-space-xs)");

        RouterLink link = new RouterLink();
        link.add(icon, new Span(viewName));
        // Demo has no routes
        // link.setRoute(viewClass.java);
        link.setTabIndex(-1);

        return new Tab(link);
    }


}
