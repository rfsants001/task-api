package com.example.demo.service;

import ch.qos.logback.core.status.Status;
import com.example.demo.dto.TaskDto;
import com.example.demo.enums.Priority;
import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Qualifier("taskServiceImpl")
@Service
public class TaskServiceImpl implements TaskRepository {
	
	private final TaskRepository taskRepository;
	
	@Autowired
	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	private TaskDto convertToDto(Task task) {
		TaskDto taskDto = new TaskDto();
		taskDto.setTitle(task.getTitle());
		taskDto.setDescription(task.getDescription());
		taskDto.setCreationDate(task.getCreationDate());
		taskDto.setDueDate(task.getDueDate());
		taskDto.setPriority(task.getPriority());
		taskDto.setStatus(task.getStatus());
		return taskDto;
	}
	
	private Task convertToEntity(TaskDto taskDto) {
		Task task = new Task();
		task.setTitle(taskDto.getTitle());
		task.setDescription(taskDto.getDescription());
		task.setCreationDate(taskDto.getCreationDate());
		task.setDueDate(taskDto.getDueDate());
		task.setPriority(taskDto.getPriority());
		task.setStatus(taskDto.getStatus());
		return task;
	}
	
	public TaskDto saveTask(TaskDto taskDto) {
		Task task = convertToEntity(taskDto);
		Task savedTask = taskRepository.save(task);
		return convertToDto(savedTask);
	}
	
	public TaskDto updateTask(String id, TaskDto taskDto) {
		Task task = taskRepository.findById(id).orElse(null);
		if (task != null) {
			task.setTitle(taskDto.getTitle());
			task.setDescription(taskDto.getDescription());
			task.setCreationDate(taskDto.getCreationDate());
			task.setDueDate(taskDto.getDueDate());
			task.setPriority(taskDto.getPriority());
			task.setStatus(taskDto.getStatus());
			
			Task updatedTask = taskRepository.save(task);
			return convertToDto(updatedTask);
		} else {
			throw new IllegalArgumentException("Tarefa não encontrada com o ID: " + id);
		}
	}
	
	public void deleteTaskById(String id) {
		Optional<Task> taskOptional = taskRepository.findById(id);
		if (taskOptional.isPresent()) {
			taskRepository.deleteById(id);
		}
		
	}
	
	@Override
	public Optional<TaskDto> findTaskById(String id) {
		Optional<Task> taskOptional = taskRepository.findById(id);
		return taskOptional.map(this::convertToDto);
	}
	
	@Override
	public <S extends Task> S save(S entity) {
		return null;
	}
	
	@Override
	public <S extends Task> List<S> saveAll(Iterable<S> entities) {
		return null;
	}
	
	@Override
	public Optional<Task> findById(String s) {
		return Optional.empty();
	}
	
	@Override
	public boolean existsById(String s) {
		return false;
	}
	
	@Override
	public List<Task> findAll() {
		return taskRepository.findAll();
	}
	
	@Override
	public List<Task> findAllById(Iterable<String> strings) {
		return null;
	}
	
	@Override
	public long count() {
		return 0;
	}
	
	@Override
	public void deleteById(String s) {
	
	}
	
	@Override
	public void delete(Task entity) {
	
	}
	
	@Override
	public void deleteAllById(Iterable<? extends String> strings) {
	
	}
	
	@Override
	public void deleteAll(Iterable<? extends Task> entities) {
	
	}
	
	@Override
	public void deleteAll() {
	
	}
	
	@Override
	public List<Task> findByTitle(String title) {
		return Collections.emptyList();
	}
	
	@Override
	public List<Task> findByStatus(Status status) {
		return Collections.emptyList();
	}
	
	@Override
	public List<Task> findByPriority(Priority priority) {
		return Collections.emptyList();
	}
	
	@Override
	public List<Task> findByDueDateBefore(LocalDate date) {
		return Collections.emptyList();
	}
	
	@Override
	public List<Task> findByPriorityAndStatus(Priority priority, Status status) {
		return Collections.emptyList();
	}
	
	@Override
	public List<Task> findByTitleContainingIgnoreCase(String keyword) {
		return Collections.emptyList();
	}
	
	@Override
	public <S extends Task> S insert(S entity) {
		return null;
	}
	
	@Override
	public <S extends Task> List<S> insert(Iterable<S> entities) {
		return Collections.emptyList();
	}
	
	@Override
	public <S extends Task> Optional<S> findOne(Example<S> example) {
		return Optional.empty();
	}
	
	@Override
	public <S extends Task> List<S> findAll(Example<S> example) {
		return Collections.emptyList();
	}
	
	@Override
	public <S extends Task> List<S> findAll(Example<S> example, Sort sort) {
		return Collections.emptyList();
	}
	
	@Override
	public <S extends Task> Page<S> findAll(Example<S> example, Pageable pageable) {
		return null;
	}
	
	@Override
	public <S extends Task> long count(Example<S> example) {
		return 0;
	}
	
	@Override
	public <S extends Task> boolean exists(Example<S> example) {
		return false;
	}
	
	@Override
	public <S extends Task, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
		return null;
	}
	
	@Override
	public List<Task> findAll(Sort sort) {
		return Collections.emptyList();
	}
	
	@Override
	public Page<Task> findAll(Pageable pageable) {
		return null;
	}
}
