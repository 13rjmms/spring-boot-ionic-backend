package com.springboot.cursomc.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.cursomc.entitys.Request;
import com.springboot.cursomc.services.RequestService;

@RestController
@RequestMapping("/requests")
public class RequestController {

	@Autowired
	private RequestService requestService;

	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Request obj = requestService.findById(id);
		

		return ResponseEntity.ok().body(obj);
	}

}
