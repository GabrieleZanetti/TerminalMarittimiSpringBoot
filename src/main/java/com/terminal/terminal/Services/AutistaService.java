package com.terminal.terminal.Services;

import com.terminal.terminal.Entities.Autista;
import com.terminal.terminal.Repositories.AutistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AutistaService 
{
    @Autowired	//Skippo il costruttore e crea un'istanza di AutistaRepository automaticamente
    private AutistaRepository repo;

    public List<Autista> getAll() 
	{
        return repo.findAll();
    }

    public Optional<Autista> getById(Long id) 
	{
        return repo.findById(id);
    }

    public Autista create(Autista Autista) 
	{
        return repo.save(Autista);
    }

    public void delete(Long id) 
	{
        repo.deleteById(id);
    }

    public Optional<Autista> findByNome(String nome) 
	{
        return repo.findByNome(nome);
    }

	public Optional<Autista> findByUserId(Long id) 
	{
        return repo.findByUserId(id);
    }
}
