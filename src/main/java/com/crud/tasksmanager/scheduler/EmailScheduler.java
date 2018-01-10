package com.crud.tasksmanager.scheduler;

import com.crud.tasksmanager.config.AdminConfig;
import com.crud.tasksmanager.domain.Mail;
import com.crud.tasksmanager.repository.TaskRepository;
import com.crud.tasksmanager.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Tasks: Once a day email";
    private static final String ONE_TASK = " task";
    private static final String MULTIPLE_TASKS = " tasks";
    private static final String MAIL_TYPE = "info";


    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Scheduled(cron = "0 * * * * *")
    public void sendInformationEmail() {
        long size = taskRepository.count();
        String word = size>1 ? MULTIPLE_TASKS : ONE_TASK;
        simpleEmailService.send(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                "Currently in database you got: " + size + word,
                MAIL_TYPE));
    }
}
