package com.example.demo.controller;

import com.example.demo.dto.TaskDto;
import com.example.demo.model.Task;
import com.example.demo.service.TaskServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/tasks")
@AllArgsConstructor
@SpringBootApplication
public class TaskController {
	
	private final TaskServiceImpl taskService;
	
	@GetMapping
	public List<Task> findAll() {
		return taskService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<TaskDto> getTaskById(@PathVariable String id) {
		return taskService.findTaskById(id);
	}
	
	@PostMapping
	public TaskDto createTask(@RequestBody TaskDto taskDto) {
		taskDto.setCreationDate(LocalDate.now());
		return taskService.saveTask(taskDto);
	}
	
	@PutMapping("/{id}")
	public TaskDto updateTask(@PathVariable String id, @RequestBody TaskDto taskDto) {
		taskDto.setCreationDate(LocalDate.now());
		return taskService.updateTask(id, taskDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable String id) {
		taskService.deleteTaskById(id);
		return ResponseEntity.ok("Tarefa excluída com sucesso");
	}
}
