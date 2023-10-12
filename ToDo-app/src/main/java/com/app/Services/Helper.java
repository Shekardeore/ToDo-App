package com.app.Services;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class Helper {
	
	public String currentDateAndTime() {
    	Date date = new Date(); 
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	System.out.println(formatter.format(date));
    	return formatter.format(date);
    }

}
