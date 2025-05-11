package com.terminal.terminal.Repositories;

import com.terminal.terminal.Entities.Buono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface BuonoRepository extends JpaRepository<Buono,Long>
{
	@Query("SELECT b FROM Buono b WHERE b.polizza.id = :id")
	public Optional<Buono> findByPolizzaId(@Param("id") Long id);

	@Query("SELECT b FROM Buono b WHERE b.cliente.id = :id")
	public Optional<Buono> findByClienteId(@Param("id") Long id);
}
