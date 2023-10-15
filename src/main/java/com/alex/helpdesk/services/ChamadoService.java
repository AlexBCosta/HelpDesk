package com.alex.helpdesk.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.helpdesk.domain.Chamado;
import com.alex.helpdesk.repositores.ChamadoRepository;
import com.alex.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class ChamadoService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ChamadoRepository repository;

	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Chamado não encontrado"));
	}

	public List<Chamado> findAll() {
		return repository.findAll();
	}

}
