package com.springboot.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.cursomc.dao.CategoryDAO;
import com.springboot.cursomc.entitys.Category;
import com.springboot.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;

	public Category findById(Integer id) {
		Optional<Category> obj = categoryDAO.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Category.class.getName()));
	}
	
	
	public Category insert(Category obj) {
		obj.setId(null);
		return categoryDAO.save(obj);
	}
	
}
