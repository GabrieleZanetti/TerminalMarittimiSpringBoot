package com.terminal.terminal.Repositories;

import com.terminal.terminal.Entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ViaggioRepository extends JpaRepository<Viaggio, Long> 
{	
	@Query("SELECT v FROM Viaggio v WHERE v.nave.id = :id")
	Optional<Viaggio> findByNaveId(@Param("id") Long id);

	@Query("SELECT v FROM Viaggio v WHERE v.portoPartenza.id = :id")
	Optional<Viaggio> findByPortoPartenzaId(@Param("id") Long id);

	@Query("SELECT v FROM Viaggio v WHERE v.portoArrivo.id = :id")
	Optional<Viaggio> findByPortoArrivoId(@Param("id") Long id);
}
