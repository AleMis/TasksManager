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

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        long size = taskRepository.count();
        String word = ONE_TASK;
        if(size>1) {
            word = MULTIPLE_TASKS;
        }
        simpleEmailService.send(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                "Currently in database you got: " + size + word));
    }
}
