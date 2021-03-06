package com.crud.tasksmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TasksmanagerApplication extends SpringBootServletInitializer{
//public class TasksmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksmanagerApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TasksmanagerApplication.class);
	}
}
