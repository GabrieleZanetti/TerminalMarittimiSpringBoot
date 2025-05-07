package com.terminal.terminal.Services;

import com.terminal.terminal.Entities.Nave;
import com.terminal.terminal.Repositories.NaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NaveService 
{
	@Autowired //skippo il costruttore e inietto la repository
	private NaveRepository repo;

	public List<Nave> getAll() 
	{
        return repo.findAll();
    }

    public Optional<Nave> getById(Long id) 
	{
        return repo.findById(id);
    }

    public Nave create(Nave nave) 
	{
        return repo.save(nave);
    }

    public void delete(Long id) 
	{
        repo.deleteById(id);
    }

    public Optional<Nave> findByNome(String nome) 
	{
        return repo.findByNome(nome);
    }
}
