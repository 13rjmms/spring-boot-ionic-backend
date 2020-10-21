package com.springboot.cursomc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "rest ok";
	}
	
	

}
