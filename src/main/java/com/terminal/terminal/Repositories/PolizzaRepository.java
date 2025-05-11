package com.terminal.terminal.Repositories;

import com.terminal.terminal.Entities.Polizza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PolizzaRepository extends JpaRepository<Polizza, Long>
{
	@Query("SELECT p FROM Polizza p WHERE p.portoCarico.id = :id")
	Optional<Polizza> findByPortoPartenzaId(@Param("id") Long id);

	@Query("SELECT p FROM Polizza p WHERE p.portoDestinazione.id = :id")
	Optional<Polizza> findByPortoArrivoId(@Param("id") Long id);
}
