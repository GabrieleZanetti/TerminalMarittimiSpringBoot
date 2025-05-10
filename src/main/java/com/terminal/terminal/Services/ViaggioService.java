package com.terminal.terminal.Services;

import com.terminal.terminal.Entities.Viaggio;
import com.terminal.terminal.Repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ViaggioService 
{
    @Autowired	//Skippo il costruttore e crea un'istanza di ViaggioRepository automaticamente
    private ViaggioRepository repo;

    public List<Viaggio> getAll() 
	{
        return repo.findAll();
    }

    public Optional<Viaggio> getById(Long id) 
	{
        return repo.findById(id);
    }

    public Viaggio create(Viaggio viaggio) 
	{
        return repo.save(viaggio);
    }

    public void delete(Long id) 
	{
        repo.deleteById(id);
    }

    public Optional<Viaggio> findByNaveId(Long id) 
	{
        return repo.findByNaveId(id);
    }

	public Optional<Viaggio> findByPortoPartenzaId(Long id) 
	{
        return repo.findByPortoPartenzaId(id);
    }

	public Optional<Viaggio> findByPortoArrivoId(Long id) 
	{
        return repo.findByPortoPartenzaId(id);
    }
}
