package com.alex.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.helpdesk.domain.Chamado;
import com.alex.helpdesk.domain.Cliente;
import com.alex.helpdesk.domain.Tecnico;
import com.alex.helpdesk.domain.enums.Perfil;
import com.alex.helpdesk.domain.enums.Prioridade;
import com.alex.helpdesk.domain.enums.Status;
import com.alex.helpdesk.repositores.ChamadoRepository;
import com.alex.helpdesk.repositores.ClienteRepository;
import com.alex.helpdesk.repositores.TecnicoRepository;

@Service
public class DBServices {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;

	public void instanciaDB() {

		Tecnico tec1 = new Tecnico(null, "Valdir cezar", "046.059.864-62", "valdir@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Tecnico tec2 = new Tecnico(null, "ze roela", "teste", "teste@gmail.com", "teste");
		tec1.addPerfil(Perfil.TECNICO);

		Cliente cli1 = new Cliente(null, "Alex Costa", "044.045.595-26", "alex.b.costa28@gmail.com", "abelhudo123");

		Chamado cha1 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1,
				cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		tecnicoRepository.saveAll(Arrays.asList(tec2));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(cha1));
		
	}
}
