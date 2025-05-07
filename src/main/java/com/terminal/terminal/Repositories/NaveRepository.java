package com.terminal.terminal.Repositories;

import com.terminal.terminal.Entities.Nave;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface NaveRepository extends JpaRepository<Nave, Long> 
{
	//JPA riconosce dal nome del metodo che deve fare una query per trovare la nave con quel nome
    Optional<Nave> findByNome(String Nome); 
}
