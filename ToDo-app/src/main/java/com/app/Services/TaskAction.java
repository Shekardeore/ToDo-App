package com.app.Services;

import org.springframework.stereotype.Service;

import com.app.entities.Task;
@Service
public interface TaskAction {

	Task register(Task task);

}
