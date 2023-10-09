package com.alex.helpdesk.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
