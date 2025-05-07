package com.terminal.terminal.Services;

import com.terminal.terminal.Entities.Porto;
import com.terminal.terminal.Repositories.PortoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PortoService 
{
    @Autowired	//Skippo il costruttore e crea un'istanza di PortoRepository automaticamente
    private PortoRepository repo;

    public List<Porto> getAll() 
	{
        return repo.findAll();
    }

    public Optional<Porto> getById(Long id) 
	{
        return repo.findById(id);
    }

    public Porto create(Porto porto) 
	{
        return repo.save(porto);
    }

    public void delete(Long id) 
	{
        repo.deleteById(id);
    }

    public Optional<Porto> findByNome(String nome) 
	{
        return repo.findByNome(nome);
    }

	public Optional<Porto> findByNazione(String nazione) 
	{
        return repo.findByNazione(nazione);
    }
}
