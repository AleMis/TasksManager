package com.crud.tasksmanager.service;

import com.crud.tasksmanager.domain.Task;
import com.crud.tasksmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {

    @Autowired
    TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Optional<Task> getTaskById(final Long taskId){
        return repository.getTaskById(taskId);
    }

    public void delete(final Long taskId) {

         repository.deleteTaskById(taskId);
    }

    public Task saveTask(final Task task) {
        return repository.save(task);
    }
}
