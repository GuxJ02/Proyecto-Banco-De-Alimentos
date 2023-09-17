package org.ufv.pro2.Back.de.proyectos2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class EnvioEmail {


        //Importante hacer la inyección de dependencia de JavaMailSender:
        @Autowired
        private JavaMailSender mailSender;

        //Pasamos por parametro: destinatario, asunto y el mensaje
        public void sendEmail(String to, String subject, String content) {

            SimpleMailMessage email = new SimpleMailMessage();

            email.setTo(to);
            email.setSubject(subject);
            email.setText(content);

            mailSender.send(email);
        }

}
