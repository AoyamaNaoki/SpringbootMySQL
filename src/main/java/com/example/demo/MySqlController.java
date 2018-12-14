package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class MySqlController {
	
	@RequestMapping("/")
	public String index() {
		String[] array = {"201021"};
		SelectEmployees.test(array);
		String s = SelectEmployees.getResult();
		return s;
	}
}