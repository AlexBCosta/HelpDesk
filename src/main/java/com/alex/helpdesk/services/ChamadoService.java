package com.alex.helpdesk.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.helpdesk.domain.Chamado;
import com.alex.helpdesk.domain.Cliente;
import com.alex.helpdesk.domain.Tecnico;
import com.alex.helpdesk.domain.dtos.ChamadoDTO;
import com.alex.helpdesk.domain.enums.Prioridade;
import com.alex.helpdesk.domain.enums.Status;
import com.alex.helpdesk.repositores.ChamadoRepository;
import com.alex.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class ChamadoService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ChamadoRepository repository;

	@Autowired
	private TecnicoService tecnicoService;
	@Autowired
	private ClienteService clienteService;

	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Chamado não encontrado"));
	}

	public List<Chamado> findAll() {
		return repository.findAll();
	}

	public Chamado create(@Valid ChamadoDTO objDTO) {
		return repository.save(newChamado(objDTO));
	}

	private Chamado newChamado(ChamadoDTO objDTO) {
		Tecnico tecnico = tecnicoService.findById(objDTO.getTecnico());
		Cliente cliente = clienteService.findById(objDTO.getCliente());

		Chamado chamado = new Chamado();
		if (objDTO.getId() != null) {
			chamado.setId(objDTO.getId());
		}

		chamado.setTecnico(tecnico);
		chamado.setCliente(cliente);
		chamado.setPrioridade(Prioridade.toEnum(objDTO.getPrioridade()));
		chamado.setStatus(Status.toEnum(objDTO.getStatus()));
		chamado.setTitulo(objDTO.getTitulo());
		chamado.setObservacoes(objDTO.getObservacoes());
		return chamado;
	}

}
