package com.crud.tasksmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TaskDto {

    private Long id;
    private String title;
    private String content;


}
