package model;

import java.util.Date;

public class Task {

	private int id;
	private int id_project;
	private String name;
	private String description;
	private boolean completed;
	private String notes;
	private Date deadline;
	private Date createdAt;
	private Date updateAt;

	public Task(int id, int id_project, String name, String description, boolean completed, String notes, Date deadline,
			Date createdAt, Date updateAt) {
		super();
		this.id = id;
		this.id_project = id_project;
		this.name = name;
		this.description = description;
		this.completed = completed;
		this.notes = notes;
		this.deadline = deadline;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}
	
	public Task() {
		this.createdAt = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_project() {
		return id_project;
	}

	public void setId_project(int id_project) {
		this.id_project = id_project;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	@Override
	public String toString() {
		return "task [id=" + id + ", id_project=" + id_project + ", name=" + name + ", description=" + description
				+ ", completed=" + completed + ", notes=" + notes + ", deadline=" + deadline + ", createdAt="
				+ createdAt + ", updateAt=" + updateAt + "]";
	}

	
}
