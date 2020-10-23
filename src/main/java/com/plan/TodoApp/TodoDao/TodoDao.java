package com.plan.TodoApp.TodoDao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.plan.TodoApp.Model.TodoModel;

public interface TodoDao extends JpaRepository<TodoModel, Integer> {
	
	
}

