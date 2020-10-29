package com.springboot.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.cursomc.dao.RequestDAO;
import com.springboot.cursomc.entitys.Request;
import com.springboot.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class RequestService {

	@Autowired
	private RequestDAO requestDAO;

	public Request findById(Integer id) {
		Optional<Request> obj = requestDAO.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Request.class.getName()));
	}
}
