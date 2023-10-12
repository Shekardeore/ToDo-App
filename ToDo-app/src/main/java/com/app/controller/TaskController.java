package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Services.Helper;
import com.app.Services.TaskAction;
import com.app.daos.TaskDao;
import com.app.daos.UserDao;
import com.app.entities.Task;
import com.app.entities.User;


@RestController
@CrossOrigin
@RequestMapping("/todo")
public class TaskController {
	
	@Autowired
	private TaskAction Taskaction;
		
	@Autowired
	private UserDao userdao;
	@Autowired
	private TaskDao taskdao;
	
	Task task=new Task();
	@Autowired
	Helper helper = new Helper();
	
	@PostMapping("/registerList")
	public ResponseEntity<?> getComplaint(@RequestBody Task task){
		System.out.println(" details"+task);
		//User user =userdao.findByUserId(Integer.parseInt(task.getUserId()));
		//Optional<User> user=userdao.findById(Integer.parseInt(task.getUserId()));
		task.setDate(helper.currentDateAndTime());
				
		Task saved = Taskaction.register(task);
			
			if(saved!=null) {
				return ResponseEntity.ok("Complaint registered successful");
			}else
		//return ResponseEntity.ok("Something went wrong");
				return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
			
	}
	
	@PostMapping("/viewTasks")
	public ResponseEntity<?> viewComplaint(@RequestBody String userId){
		String str = userId.substring(0,userId.length()-1);
		try {
			System.out.println(str);
			List<Task> getTask = taskdao.findByUserId(str);
			System.out.println("Its returning" +getTask);
			return ResponseEntity.ok(getTask);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}	
	}
	
	
	@PostMapping("/DeleteTask")
	public ResponseEntity<?> cancelTask(@RequestBody String Id){
		System.out.println(Id);
		String s=Id.substring(0,Id.length()-1);
		try {
			taskdao.deleteById(Integer.parseInt(s));
			return ResponseEntity.ok("Deleted successfully");
		} catch (Exception e) {
			return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
			
		}	
	}
	
/*	@GetMapping("/ViewAllTasks")
	public ResponseEntity<?> viewAllTasks(){
		try {
			List<Task> gettasks = taskdao.findAll();
			System.out.println(gettasks);
			return ResponseEntity.ok(gettasks);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}	
	}
	
	@PostMapping("/CompletedTask")
	public ResponseEntity<?> Completed(@RequestBody String Id){
		System.out.println(Id);
		System.out.println("In  completed");
		String s=Id.substring(0,Id.length()-1);
		try {
			taskdao.findById(Integer.parseInt(s));
			
			return ResponseEntity.ok("Completed successfully");
		} catch (Exception e) {
			return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
			
		}	
	}*/

}
