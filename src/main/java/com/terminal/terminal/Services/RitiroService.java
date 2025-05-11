package com.terminal.terminal.Services;

import com.terminal.terminal.Entities.Ritiro;
import com.terminal.terminal.Repositories.RitiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RitiroService 
{
	@Autowired
	private RitiroRepository repo;

	public List<Ritiro> getAll() 
	{
		return repo.findAll();
	}

	public Optional<Ritiro> getById(Long id) 
	{
		return repo.findById(id);
	}

	public Ritiro create(Ritiro Ritiro) 
	{
		return repo.save(Ritiro);
	}

	public void delete(Long id) 
	{
		repo.deleteById(id);
	}

	public Optional<Ritiro> getByCamionTarga(String targa) 
	{
		return repo.findByCamionTarga(targa);
	}

	public Optional<Ritiro> getByAutistaId(Long id) 
	{
		return repo.findByAutistaId(id);
	}

	public Optional<Ritiro> getByBuonoId(Long id) 
	{
		return repo.findByBuonoId(id);
	}
}
