package com.springboot.cursomc.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.cursomc.dto.CategoryDTO;
import com.springboot.cursomc.entitys.Category;
import com.springboot.cursomc.service.exceptions.DataIntegrityException;
import com.springboot.cursomc.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/{id}")
	public ResponseEntity<Category> find(@PathVariable Integer id) {

		Category obj = categoryService.findById(id);

		return ResponseEntity.ok().body(obj);
	}

	@PostMapping()
	public ResponseEntity<Void> insert(@RequestBody Category obj) {
		obj = categoryService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> insert(@RequestBody Category obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = categoryService.update(obj);

		return ResponseEntity.noContent().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		try {
			categoryService.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("It is not possible to exclude a category that contains products");

		}

		return ResponseEntity.noContent().build();

	}

	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll() {

		List<Category> list = categoryService.findAll();
		List<CategoryDTO> listDTO = list.stream().map(obj -> new CategoryDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
}
