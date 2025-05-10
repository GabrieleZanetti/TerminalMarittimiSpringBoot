package com.terminal.terminal.Repositories;

import com.terminal.terminal.Entities.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long>
{
	Optional<Cliente> findByNome(String nome);
	
	@Query("SELECT c FROM Cliente c WHERE c.user.id = :id")
	Optional<Cliente> findByUserId(@Param("id") Long id);
}
