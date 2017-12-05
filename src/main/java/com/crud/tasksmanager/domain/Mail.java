package com.crud.tasksmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mail {

    private String mailTo;
    private String subject;
    private String message;
    private String toCc;
}
