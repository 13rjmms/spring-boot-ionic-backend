package com.springboot.cursomc.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.cursomc.entitys.Category;
import com.springboot.cursomc.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Category obj = categoryService.findById(id);
		

		return ResponseEntity.ok().body(obj);
	}

}