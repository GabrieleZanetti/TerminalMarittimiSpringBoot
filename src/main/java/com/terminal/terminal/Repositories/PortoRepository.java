package com.terminal.terminal.Repositories;

import com.terminal.terminal.Entities.Porto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PortoRepository extends JpaRepository<Porto, Long> 
{
	Optional<Porto> findByNome(String nome); 
	Optional<Porto> findByNazione(String nazione);
}
