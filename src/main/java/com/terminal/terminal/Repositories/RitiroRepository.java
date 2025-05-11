package com.terminal.terminal.Repositories;

import com.terminal.terminal.Entities.Ritiro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RitiroRepository extends JpaRepository<Ritiro, Long>
{
	@Query("SELECT r FROM Ritiro r WHERE r.camion.targa = :targa")
	Optional<Ritiro> findByCamionTarga(@Param("targa") String targa);
	
	@Query("SELECT r FROM Ritiro r WHERE r.autista.id = :id")
	Optional<Ritiro> findByAutistaId(@Param("id") Long id);
	
	@Query("SELECT r FROM Ritiro r WHERE r.buono.id = :id")
	Optional<Ritiro> findByBuonoId(@Param("id") Long id);
	
}
