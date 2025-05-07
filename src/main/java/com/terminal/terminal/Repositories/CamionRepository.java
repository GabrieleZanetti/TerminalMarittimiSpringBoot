package com.terminal.terminal.Repositories;

import com.terminal.terminal.Entities.Camion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CamionRepository extends JpaRepository<Camion, String>
{
	@Query("SELECT c FROM Camion c WHERE c.autista.id = :id")
	Optional<Camion> findByAutistaId(@Param("id") Long id);
}
