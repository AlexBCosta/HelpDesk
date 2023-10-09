package com.alex.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.alex.helpdesk.domain.Chamado;
import com.alex.helpdesk.domain.Cliente;
import com.alex.helpdesk.domain.Tecnico;
import com.alex.helpdesk.domain.enums.Perfil;
import com.alex.helpdesk.domain.enums.Prioridade;
import com.alex.helpdesk.domain.enums.Status;
import com.alex.helpdesk.repositores.ChamadoRepository;
import com.alex.helpdesk.repositores.ClienteRepository;
import com.alex.helpdesk.repositores.TecnicoRepository;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class HelpdeskApplication implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception { // vai rodar sempre que estartar o sistema
		Tecnico tec1 = new Tecnico(null, "Valdir cezar", "046.059.864-62", "valdir@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);

		Cliente cli1 = new Cliente(null, "Alex Costa", "044.045.595-26", "alex.b.costa28@gmail.com", "abelhudo123");

		Chamado cha1 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1,
				cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(cha1));
	}

}
