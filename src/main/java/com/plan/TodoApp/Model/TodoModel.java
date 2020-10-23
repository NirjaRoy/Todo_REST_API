package com.plan.TodoApp.Model;
import javax.persistence.*;  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@NamedQuery(name="find_all_task",query="select p from TodoModel p")
@Table(name="TodoTask")
public class TodoModel {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private int id;
	
	
	@Column(name="task_name")
	private String taskName;
	
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private Selectstatus status;

	public TodoModel() {}
	public TodoModel(int id, String taskName, Selectstatus status) {
		this.id =id;
		this.taskName = taskName;
		this.status = status;
	}

	public TodoModel(String taskName, Selectstatus status) {
		this.taskName = taskName;
		this.status = status;
	}

	// define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public Selectstatus getStatus() {
		return status;
	}

	public void setStatus(Selectstatus status) {
		this.status = status;
	}

	
	@Override
	public String toString() {
		return "TodoTask {id:" + id + ", taskName:" + taskName + ", Status:" + status + "}";
	}
}
