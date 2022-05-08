package com.eCommerceProject.business.concretes;

public interface SendEmailService {
    void sendEmails(String to, String body, String topic);
}
