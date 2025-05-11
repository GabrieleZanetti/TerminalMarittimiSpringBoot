package com.terminal.terminal.Services;

import com.terminal.terminal.Entities.Buono;
import com.terminal.terminal.Repositories.BuonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BuonoService 
{
	@Autowired
	private BuonoRepository repo;

	public List<Buono> getAll() 
	{
		return repo.findAll();
	}

	public Optional<Buono> getById(Long id) 
	{
		return repo.findById(id);
	}

	public Buono create(Buono buono) 
	{
		return repo.save(buono);
	}

	public void delete(Long id) 
	{
		repo.deleteById(id);
	}

	public Optional<Buono> findByPolizzaId(Long id) 
	{
		return repo.findByPolizzaId(id);
	}

	public Optional<Buono> findByClienteId(Long id) 
	{
		return repo.findByClienteId(id);
	}
}
