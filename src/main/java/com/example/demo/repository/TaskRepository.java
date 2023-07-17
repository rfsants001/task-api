package com.example.demo.repository;

import ch.qos.logback.core.status.Status;
import com.example.demo.dto.TaskDto;
import com.example.demo.enums.Priority;
import com.example.demo.model.Task;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Qualifier("taskRepository")
@Repository
public interface TaskRepository
				extends MongoRepository<Task, String> {
	
	Optional<TaskDto> findTaskById(String id);
	
	List<Task> findAll();
	
	List<Task> findByTitle(String title);
	
	List<Task> findByStatus(Status status);
	
	List<Task> findByPriority(Priority priority);
	
	List<Task> findByDueDateBefore(LocalDate date);
	
	List<Task> findByPriorityAndStatus(Priority priority, Status status);
	
	List<Task> findByTitleContainingIgnoreCase(String keyword);
	
}
