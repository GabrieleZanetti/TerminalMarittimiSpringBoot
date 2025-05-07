package com.terminal.terminal.Repositories;

import com.terminal.terminal.Entities.Autista;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AutistaRepository extends JpaRepository<Autista, Long>
{
	Optional<Autista> findByNome(String nome); //JPA riconosce dal nome del metodo che deve fare una query per trovare l'autista con quel nome
	
	@Query("SELECT a FROM Autista a WHERE a.user.id = :id")
	Optional<Autista> findByUserId(@Param("id") Long id);
}
