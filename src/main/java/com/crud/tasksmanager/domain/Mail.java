package com.crud.tasksmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Mail {

    private String mailTo;
    private String subject;
    private String message;
    private String toCc;
    private String mailType;

    public Mail(String mailTo, String subject, String message, String mailType) {
        this.mailTo = mailTo;
        this.subject = subject;
        this.message = message;
        this.mailTo = mailType;
    }
}
