package com.springboot.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.cursomc.dao.CategoryDAO;
import com.springboot.cursomc.entity.Category;


@Service
public class CategoryService {
	
	@Autowired
	private CategoryDAO categoryDAO;

	public Category findById(Integer id) {
		Optional<Category> obj = categoryDAO.findById(id); 
		return obj.orElse(null); 
	}
}
