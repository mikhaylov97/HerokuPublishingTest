package com.example.demo.service.impl;

import com.example.demo.service.api.MailSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderServiceImpl implements MailSenderService {

    @Value("${spring.mail.username}")
    private String TARGET;

    private final JavaMailSender javaMailSender;

    private static final Logger log = LoggerFactory.getLogger(MailSenderServiceImpl.class);

    public MailSenderServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail() {
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setFrom(TARGET);
        msg.setTo(TARGET);
        msg.setSubject("Тест");
        msg.setText("Тест");

        try {
            javaMailSender.send(msg);
        } catch (MailException e) {
            log.error("During sending email error is occurred: [" + e.getMessage() + "].");
        }
    }
}
