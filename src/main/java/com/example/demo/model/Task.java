package com.example.demo.model;

import com.example.demo.enums.Priority;
import com.example.demo.enums.Status;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
public class Task {
	@Id
	private String id;
	private String title;
	private String description;
	private LocalDate creationDate;
	private LocalDate dueDate;
	private Priority priority;
	private Status status;
	
	public Task(String title, String description, LocalDate creationDate, LocalDate dueDate, Priority priority, Status status) {
		this.title = title;
		this.description = description;
		this.creationDate = creationDate;
		this.dueDate = dueDate;
		this.priority = priority;
		this.status = status;
	}
	
	public Task() {
	}
	
	public void markCompleted() {
		this.status = Status.COMPLETED;
	}
	
	public int getRemainingDays() {
		LocalDate today = LocalDate.now();
		return today.until(dueDate).getDays();
	}
	
	public boolean isOverdue() {
		LocalDate today = LocalDate.now();
		return dueDate.isBefore(today) && status == Status.PENDING;
	}
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
	
	public LocalDate getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
}
