package com.terminal.terminal.Services;

import com.terminal.terminal.Entities.Camion;
import com.terminal.terminal.Repositories.CamionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CamionService 
{
    @Autowired	//Skippo il costruttore e crea un'istanza di CamionRepository automaticamente
    private CamionRepository repo;

    public List<Camion> getAll() 
	{
        return repo.findAll();
    }

    public Optional<Camion> getById(String targa) 
	{
        return repo.findById(targa);
    }

    public Camion create(Camion camion) 
	{
        return repo.save(camion);
    }

    public void delete(String targa) 
	{
        repo.deleteById(targa);
    }

    public Optional<Camion> findByAutistaId(Long id) 
	{
        return repo.findByAutistaId(id);
    }
}
