package com.app.Services;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.TaskDao;
import com.app.entities.Task;

@Service
@Transactional
public class TaskActionImpl implements TaskAction{
	
	@Autowired
	private TaskDao taskdao;

	@Override
	public Task register(Task task) {
		Task savetask = taskdao.save(task);
		return savetask;
	}

}
