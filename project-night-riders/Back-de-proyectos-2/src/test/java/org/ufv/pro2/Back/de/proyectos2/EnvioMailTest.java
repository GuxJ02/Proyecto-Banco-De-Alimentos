package org.ufv.pro2.Back.de.proyectos2;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@ExtendWith(MockitoExtension.class)
public class EnvioMailTest {
    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EnvioEmail envioEmail;

    @Test
    @DisplayName("Test envío de email")
    public void testEnvioEmail() {
        // Datos para el email
        String to = "ejemplo@gmail.com";
        String subject = "Asunto del email";
        String content = "Contenido del email";

        // Crear objeto SimpleMailMessage para el email
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(to);
        email.setSubject(subject);
        email.setText(content);

        // simulación de envío del email y verificar que el método send ha sido invocado
        envioEmail.sendEmail(to, subject, content);
        verify(mailSender, times(1)).send(email);
    }
}
