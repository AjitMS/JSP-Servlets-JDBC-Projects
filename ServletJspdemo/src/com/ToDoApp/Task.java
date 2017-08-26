package com.ToDoApp;

public class Task {

	
	private String name, date, priority;
	
	
	public Task() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public Task(String name, String date, String priority) {
		this.name = name;
		this.priority = priority;
		this.date = date;
	}
	
}
