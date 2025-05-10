package com.terminal.terminal.Services;

import com.terminal.terminal.Entities.Cliente;
import com.terminal.terminal.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService 
{
	@Autowired //skippo il costruttore e inietto la repository
	private ClienteRepository repo;

	public List<Cliente> getAll() 
	{
        return repo.findAll();
    }

    public Optional<Cliente> getById(Long id) 
	{
        return repo.findById(id);
    }

    public Cliente create(Cliente cliente) 
	{
        return repo.save(cliente);
    }

    public void delete(Long id) 
	{
        repo.deleteById(id);
    }

    public Optional<Cliente> findByNome(String nome) 
	{
        return repo.findByNome(nome);
    }

	public Optional<Cliente> findByUserId(Long id) 
	{
		return repo.findByUserId(id);
	}
}
