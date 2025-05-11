package com.terminal.terminal.Services;

import com.terminal.terminal.Entities.Polizza;
import com.terminal.terminal.Repositories.PolizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PolizzaService 
{
    @Autowired	//Skippo il costruttore e crea un'istanza di PolizzaRepository automaticamente
    private PolizzaRepository repo;

    public List<Polizza> getAll() 
	{
        return repo.findAll();
    }

    public Optional<Polizza> getById(Long id) 
	{
        return repo.findById(id);
    }

    public Polizza create(Polizza Polizza) 
	{
        return repo.save(Polizza);
    }

    public void delete(Long id) 
	{
        repo.deleteById(id);
    }

    public Optional<Polizza> findByPortoPartenzaId(Long id) 
	{
        return repo.findByPortoPartenzaId(id);
    }

	public Optional<Polizza> findByPortoArrivoId(Long id) 
	{
        return repo.findByPortoArrivoId(id);
    }
}
