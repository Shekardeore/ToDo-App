package com.app.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Task;

public interface TaskDao extends JpaRepository<Task,Integer>{
	
	List<Task> findByUserId(String userId);

}
