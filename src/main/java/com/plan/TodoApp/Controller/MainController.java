package com.plan.TodoApp.Controller;

import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.plan.TodoApp.DataFormatError;
import com.plan.TodoApp.TaskNotFoundException;
import com.plan.TodoApp.Model.Selectstatus;
import com.plan.TodoApp.Model.TodoModel;
import com.plan.TodoApp.TodoDao.TodoDao;
import com.plan.TodoApp.jpa.TaskJPARepository;

@RestController
public class MainController {
	@PersistenceContext
	private EntityManager em1;
	@Autowired
	private TodoDao dao;
	
	@Transactional
	@PostMapping("/createTask")
	public TodoModel createTask(@RequestBody TodoModel task) {
		if (task.getTaskName() == null) {
			throw new DataFormatError("Please Enter Task Name");
		}
		if (task.getTaskName().length() > 20 || task.getTaskName().length() < 2) {
			throw new DataFormatError("Your task name should have less tham 20 character and more than 1 character");
		}
		return (em1.merge(task));
	}

	
	@Transactional
	@PostMapping("/createTasks")
	public List<TodoModel> createTask(@RequestBody List<TodoModel> task) {
		return (List<TodoModel>) em1.merge(task);
	}
	
	@GetMapping("/getTask")
	public List<TodoModel> findAll() {
		TypedQuery<TodoModel> namedQuery = em1.createNamedQuery("find_all_task", TodoModel.class);
		return namedQuery.getResultList();
	}

	
	@Transactional
	@GetMapping("/getTaskById/{id}")
	public TodoModel findById(@PathVariable int id) {
		return dao.findById(id).orElseThrow(() -> new TaskNotFoundException("No task with this id exists"));

	}

	
	@Transactional
	@PutMapping("/update")
	public TodoModel updateTask(@RequestBody TodoModel task) {
		TodoModel tasks = dao.findById(task.getId())
				.orElseThrow(() -> new TaskNotFoundException("No task with this id exists"));
		if (task.getTaskName() == null && task.getStatus() == null) {
			throw new DataFormatError("Please enter either Task Name or Status to be updated");
		}
		if (task.getTaskName() != null) {
			tasks.setTaskName(task.getTaskName());
		}
		if (task.getStatus() != null) {
			tasks.setStatus(task.getStatus());
		}
		return (em1.merge(tasks));
	}

	
	@Transactional
	@DeleteMapping("/delete/{id}")
	public List<TodoModel> deleteTask(@PathVariable int id) {
		dao.findById(id).orElseThrow(() -> new TaskNotFoundException("No task with this id exists"));
		dao.deleteById(id); 
		//em1.remove(id);
		return (List<TodoModel>) dao.findAll();
	}

}
