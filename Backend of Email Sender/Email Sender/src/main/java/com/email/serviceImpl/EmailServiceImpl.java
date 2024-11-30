package com.email.serviceImpl;

import com.email.services.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;


@Service
public class EmailServiceImpl implements EmailService
    {

        private JavaMailSender mailSender;

        private Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

        @Value("${spring.mail.username}")
        private String mailFrom;

        public EmailServiceImpl(JavaMailSender mailSender){
            this.mailSender = mailSender;
        }


        @Override
        public void sendEmail(String to, String subject, String message)
            {
                SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                simpleMailMessage.setTo(to);
                simpleMailMessage.setSubject(subject);
                simpleMailMessage.setText(message);
                simpleMailMessage.setFrom(mailFrom);
                mailSender.send(simpleMailMessage);
                logger.info("Email sent successfully to single person");

            }

        @Override
        public void sendEmail(String[] to, String subject, String message)
            {
                SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                simpleMailMessage.setTo(to);
                simpleMailMessage.setSubject(subject);
                simpleMailMessage.setText(message);
                simpleMailMessage.setFrom(mailFrom);
                mailSender.send(simpleMailMessage);
                logger.info("Email sent successfully to multiple persons");
            }

        @Override
        public void sendEmailWithHtml(String to, String subject, String htmlContent)
            {
                MimeMessage mimeMessage = mailSender.createMimeMessage();
                try
                    {
                        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
                        helper.setTo(to);
                        helper.setSubject(subject);
                        helper.setText(htmlContent,true);
                        helper.setFrom(mailFrom);
                        mailSender.send(mimeMessage);
                        logger.info("Email sent successfully with html content");
                    } catch (MessagingException e)
                    {
                        throw new RuntimeException("Fail to send the html email");
                    }


            }

        @Override
        public void sendEmailWithFile(String to, String subject, String message, File file)
            {
                MimeMessage mimeMessage = mailSender.createMimeMessage();
                try
                    {
                        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
                        helper.setTo(to);
                        helper.setSubject(subject);
                        helper.setText(message,true);
                        helper.setFrom(mailFrom);
                        helper.addAttachment(file.getName(),file);
                        mailSender.send(mimeMessage);
                        logger.info("Email sent successfully with file");
                    } catch (MessagingException e)
                    {
                        throw new RuntimeException("Fail to send the file email");
                    }
            }
    }
