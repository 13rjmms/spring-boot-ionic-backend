package com.springboot.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.cursomc.dao.ClientDAO;
import com.springboot.cursomc.entitys.Client;
import com.springboot.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientDAO ClientDAO;

	public Client findById(Integer id) {
		Optional<Client> obj = ClientDAO.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Client.class.getName()));
	}
}
