package com.terminal.terminal.Repositories;

import com.terminal.terminal.Entities.Fornitore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.math.BigDecimal;

public interface FornitoreRepository extends JpaRepository<Fornitore, Long> 
{
    Optional<Fornitore> findByNome(String nome);	

	@Query("SELECT f FROM Fornitore f WHERE f.giorni_gratis = :giorni_gratis")
    Optional<Fornitore> findByGiorniGratis(@Param("giorni_gratis") int giorni_gratis); 
	
	@Query("SELECT f FROM Fornitore f WHERE f.tariffa = :tariffa")
	Optional<Fornitore> findByTariffa(@Param("tariffa") BigDecimal tariffa);

	@Query("SELECT f FROM Fornitore f WHERE f.tariffa < :tariffa")
	Optional<Fornitore> findByTariffaMinoreDi(@Param("tariffa") BigDecimal tariffa);

	@Query("SELECT f FROM Fornitore f WHERE f.tariffa > :tariffa")
	Optional<Fornitore> findByTariffaMaggioreDi(@Param("tariffa") BigDecimal tariffa);
}
