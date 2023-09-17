package org.vaadin.example;

<<<<<<< HEAD
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.QueryParameters;
import com.vaadin.flow.router.RouterLink;
=======
>>>>>>> 99b35f76 (Se añade el front)
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
<<<<<<< HEAD
import com.vaadin.flow.component.applayout.DrawerToggle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;
=======
>>>>>>> 99b35f76 (Se añade el front)

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
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service
     *            The message service. Automatically injected Spring managed
     *            bean.
     */
<<<<<<< HEAD

    public MainView(@Autowired ProyectoService service) {

//        H1 title = new H1("Iniciar sesión");
//
//        // Campo de texto para el nombre de usuario
//        TextField usernameField = new TextField();
//        usernameField.setPlaceholder("Nombre de usuario");
//
//        // Campo de texto para la contraseña
//        PasswordField passwordField = new PasswordField();
//        passwordField.setPlaceholder("Contraseña");
//
//        // Botón de inicio de sesión
//        Button loginButton = new Button("Iniciar sesión");

        // Agregar componentes al layout








        VerticalLayout formulario = new VerticalLayout();
        Div container = new Div();
        container.addClassName("formulario");
        LoginForm loginForm = new LoginForm();

        loginForm.getStyle().set("display", "flex");
       loginForm.getStyle().set("flex-direction", "column");
        loginForm.getStyle().set("align-items", "center");
        loginForm.getStyle().set("justify-content", "center");



        loginForm.getStyle().set("max-width", "40%");
        loginForm.getStyle().set("margin", "0 auto");

        loginForm.getStyle().set("width", "100%");
        loginForm.getStyle().set("max-width", "400px");

        loginForm.getElement().getThemeList().add("#233348");
        loginForm.addClassName("rounded-borders");
        loginForm.addLoginListener(event -> {
            String username = event.getUsername();
            String password = event.getPassword();

            try {
              //int puntos= 1;
               int puntos = service.VerificaciónUsuario(username,password);
                    Puntos punto= new Puntos();
                    punto.setPuntos(puntos);
                Long id = 123L;
                if (puntos == -1){
                    Notification.show("Usuario no valido");



                    Page page = UI.getCurrent().getPage();
                    page.reload();
                    Label mensaje = new Label("Usuario incorrecto");
                    add(mensaje);
                    formulario.removeAll();

                Notification.show("Usuario no valido");
                }
                else if (puntos==-2){
                    UI.getCurrent().navigate("mainview2");
                }
                else {
                   /* formulario.setVisible(false); // Ocultar formulario
                    formulario.removeAll(); // Borrar formulario
                    container.removeAll();
                    UI.getCurrent().getElement().getStyle().set("background-color", "white"); // Cambiar color de fondo del body a blanco

*/                  UI.getCurrent().navigate("mainview3");

                    //QueryParameters params = QueryParameters.simple("id",  id.toString());
                    //UI.getCurrent().navigate("mainview2", params);
                }

            } catch (Exception e) {


            }


        });
        add(loginForm);
        // Prevent the example from stealing focus when browsing the
        // documentation
        loginForm.getElement().setAttribute("no-autofocus", "");
        formulario.add(loginForm);
        container.add(formulario);

        add(container);

        // Centrar el layout en la pantalla
        // setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setSizeFull();
    }


=======
    public MainView(@Autowired GreetService service) {

        // Use TextField for standard text input
        TextField textField = new TextField("Your name");
        textField.addThemeName("bordered");

        // Button click listeners can be defined as lambda expressions
        Button button = new Button("Say hello",
                e -> Notification.show(service.greet(textField.getValue())));

        // Theme variants give you predefined extra styles for components.
        // Example: Primary button has a more prominent look.
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        // You can specify keyboard shortcuts for buttons.
        // Example: Pressing enter in this view clicks the Button.
        button.addClickShortcut(Key.ENTER);

        // Use custom CSS classes to apply styling. This is defined in
        // shared-styles.css.
        addClassName("centered-content");

        add(textField, button);
    }

>>>>>>> 99b35f76 (Se añade el front)
}
