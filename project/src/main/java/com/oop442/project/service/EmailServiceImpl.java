package com.oop442.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.oop442.project.entity.EmailDetails;
import com.oop442.project.error.EmailNotSendException;

import org.springframework.beans.factory.annotation.Value;

@Service
public class EmailServiceImpl implements EmailService{
    
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public String sendSimpleMail(EmailDetails details) {
        try {
            SimpleMailMessage mailMessage= new SimpleMailMessage();
 
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());

            javaMailSender.send(mailMessage);
            return "Email has been send to : " + details.getRecipient();
        } catch (Exception e) {
            throw new EmailNotSendException(details.getRecipient());
        }
    }

    // public String sendMailWithAttachment(EmailDetails details) {
    //     MimeMessage mimeMessage
    //         = javaMailSender.createMimeMessage();
    //     MimeMessageHelper mimeMessageHelper;
 
    //     try {
    //         // Setting multipart as true for attachments to
    //         // be send
    //         mimeMessageHelper
    //             = new MimeMessageHelper(mimeMessage, true);
    //         mimeMessageHelper.setFrom(sender);
    //         mimeMessageHelper.setTo(details.getRecipient());
    //         mimeMessageHelper.setText(details.getMsgBody());
    //         mimeMessageHelper.setSubject(
    //             details.getSubject());
    //         // Adding the attachment
    //         FileSystemResource file
    //             = new FileSystemResource(
    //                 new File(details.getAttachment()));
 
    //         mimeMessageHelper.addAttachment(
    //             file.getFilename(), file);
            
    //         // Sending the mail
    //         javaMailSender.send(mimeMessage);
    //         return "Email has been send to : " + details.getRecipient();
    //     } catch (Exception e) {
    //         throw new EmailNotSendException(details.getRecipient());
    //     }
    // }
}
