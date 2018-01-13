package com.crud.tasksmanager.service;

import com.crud.tasksmanager.domain.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SimpleEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);
    private static final String MAIL_BUILD = "build";
    private static final String MAIL_INFO = "info";

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailCreatorService mailCreatorService;

    public void send(final Mail mail) {
        LOGGER.info("Starting email preparation...");
        try {

            javaMailSender.send(createMimeMessage(mail));
            LOGGER.info("Email has been sent.");

        } catch (MailException e) {
            LOGGER.error("Failed to process email sending: ", e.getMessage(), e);
        }
    }

    private MimeMessagePreparator createMimeMessage(final Mail mail) {
        return mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(mail.getMailTo());
            messageHelper.setSubject(mail.getSubject());
            messageHelper.setText(setMessageType(mail), true);
        };
    }

    private String setMessageType(final Mail mail) {
        if(Objects.equals(mail.getMailType(), MAIL_BUILD)) {
            return mailCreatorService.buildTrelloCardEmail(mail.getMessage());
        }else if(Objects.equals(mail.getMailType(), MAIL_INFO)) {
            return mailCreatorService.informUserAboutNumberOfTasks(mail.getMessage());
        }else {
            return "not applicable";
        }
    }
}
