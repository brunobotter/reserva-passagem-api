package br.com.bruno.reserva.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EnvioEmail {

    @Autowired
    private JavaMailSender mailSender;

    public void enviar(String emailTo, String assunto, String mensagem) { 
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(emailTo);
        email.setSubject(assunto);
        email.setText(mensagem);
        mailSender.send(email);
    }
}