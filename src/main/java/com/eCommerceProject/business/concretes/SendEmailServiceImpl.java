package com.eCommerceProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailServiceImpl implements SendEmailService{

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmails(String to, String body, String topic) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("tiklakapinda0@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(topic);
        simpleMailMessage.setText(body);
        javaMailSender.send(simpleMailMessage);
    }

}
