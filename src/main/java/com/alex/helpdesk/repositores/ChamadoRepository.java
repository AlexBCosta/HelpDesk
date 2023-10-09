package com.alex.helpdesk.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

}
