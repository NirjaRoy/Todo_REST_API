package com.plan.TodoApp.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.plan.TodoApp.Model.TodoModel;

@Repository
@Transactional
public class TaskJPARepository {
 
	@PersistenceContext
	EntityManager em;
	
	public TodoModel findById(int id) {
		return em.find(TodoModel.class, id);
	}
}
