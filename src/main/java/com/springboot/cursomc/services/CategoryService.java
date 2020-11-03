package com.springboot.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.springboot.cursomc.dao.CategoryDAO;
import com.springboot.cursomc.dto.CategoryDTO;
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

	public Category update(Category obj) {
		findById(obj.getId());
		return categoryDAO.save(obj);
	}

	public void deleteById(Integer id) {
		categoryDAO.deleteById(id);

	}

	public List<Category> findAll() {
		return categoryDAO.findAll();
	}
	
	public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return categoryDAO.findAll(pageRequest);
	}
	
	public Category fromDTO(CategoryDTO objDto) {
		return new Category(objDto.getId(), objDto.getName());
	}
}
