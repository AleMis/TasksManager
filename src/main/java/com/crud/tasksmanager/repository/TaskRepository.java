package com.crud.tasksmanager.repository;

import com.crud.tasksmanager.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    @Override
    List<Task> findAll();

    @Override
    Task save(Task task);

    void deleteTaskById(Long taskId);

    Optional<Task> getTaskById(Long id);

    @Override
    long count();
}
