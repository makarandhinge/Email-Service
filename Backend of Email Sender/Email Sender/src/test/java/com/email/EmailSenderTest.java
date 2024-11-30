package com.email;

import com.email.services.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
public class EmailSenderTest
    {

        @Autowired
        private EmailService emailService;

//        @Test
//        void emailSendTest()
//            {
//                System.out.println("sending email");
//                emailService.sendEmail("mmh2212002@gmail.com", "This is Email from Spring boot", "This email is send " + "using spring boot while creating email service");
//
//            }

        //        @Test
        //        void sendHtmlInEmail()
        //            {
        //                String html = "" + "<h1 style='color:red;border:1px solid red;'>Welcome to My Programming " +
        //                        "ground</h1>" + "";
        //                emailService.sendEmailWithHtml("mmh2212002@gmail.com", "This is Email from Spring boot", html);
        //            }
//        @Test
//        void sendFileInEmail()
//            {
//                emailService.sendEmailWithFile("mmh2212002@gmail.com", "This is Email from Spring boot", "This email is " + "send " + "using spring boot while creating email service", new File("D:\\Project\\Email Sender\\src\\test\\java\\com\\email\\TestFiles\\Resume - 12.pdf"));
//            }
    }
