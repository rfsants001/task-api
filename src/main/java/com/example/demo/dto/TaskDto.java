package com.example.demo.dto;

import com.example.demo.enums.Priority;
import com.example.demo.enums.Status;

import java.time.LocalDate;

public class TaskDto {
	private String title;
	private String description;
	private LocalDate creationDate;
	private LocalDate dueDate;
	private Priority priority;
	private Status status;
	
	public TaskDto() {
	}
	
	public TaskDto(String title, String description, LocalDate creationDate, LocalDate dueDate, Priority priority, Status status) {
		this.title = title;
		this.description = description;
		this.creationDate = creationDate;
		this.dueDate = dueDate;
		this.priority = priority;
		this.status = status;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDate getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
	public LocalDate getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
	public Priority getPriority() {
		return priority;
	}
	
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
}
