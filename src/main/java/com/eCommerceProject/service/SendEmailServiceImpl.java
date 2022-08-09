package com.eCommerceProject.service;

import com.eCommerceProject.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendEmailServiceImpl implements SendEmailService{

    private final JavaMailSender javaMailSender;

    private final UserService userService;

    @Override
    public void sendEmails(String to, String body, String topic) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("tiklakapinda");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(topic);
        simpleMailMessage.setText(body);
        javaMailSender.send(simpleMailMessage);
    }

    @Override
    public void sendEmailAllUser(String body, String topic) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        userService.getAll().forEach(user -> {

            if (user.isNotificationPermission()) {
                simpleMailMessage.setTo("tiklakapinda");
                simpleMailMessage.setTo(user.getEMail());
                simpleMailMessage.setSubject(topic);
                simpleMailMessage.setText(body);
                javaMailSender.send(simpleMailMessage);
            }
        });
    }
}
