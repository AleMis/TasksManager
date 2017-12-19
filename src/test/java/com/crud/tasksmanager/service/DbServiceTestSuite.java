package com.crud.tasksmanager.service;

import com.crud.tasksmanager.domain.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbServiceTestSuite {

    @Autowired
    private DbService dbService;

    @Test
    public void testSaveTask() {
        //Given
        Task task = new Task(1L, "Test", "test_task");

        //When
        dbService.saveTask(task);

        //Then
        Long id = task.getId();
        Optional<Task> readTask = dbService.getTaskById(id);
        assertTrue(readTask.isPresent());
        assertEquals(id, readTask.get().getId());

        //CleanUp
        dbService.delete(id);
    }
}