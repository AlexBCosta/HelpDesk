package com.alex.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.helpdesk.domain.Cliente;
import com.alex.helpdesk.repositores.ClienteRepository;
import com.alex.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Cliente não encontrado! Id: " + id));
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}
}
