package com.terminal.terminal.Controllers;

import com.terminal.terminal.Entities.Cliente;
import com.terminal.terminal.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController //dico: questa classe è un controller REST e i metodi restituiranno auto la risposta come corpo della risposta HTTP
@RequestMapping("/api/cliente") //tutte le richieste HTTP per gestire gli autisti avranno come prefisso /api/Cliente
public class ClienteController 
{
	@Autowired
	private ClienteService service;

	@GetMapping	//Questo metodo gestisce la lettura di tutti i clienti
	public List<Cliente> getAll() 
	{
		return service.getAll();
	}

    @GetMapping("/{nome}")
    public Optional<Cliente> getByNome(@PathVariable String nome)
    {
        return service.findByNome(nome);
    }
    
	//Il decoratore @PathVariable estrae i parametri dinamici dall'URL di una richiesta HTTP e passarli come argomenti del metodo
    @GetMapping("/{id}")	//Questo metodo gestisce la lettura di un Cliente specifico
    public Optional<Cliente> getById(@PathVariable Long id) 	
	{
        return service.getById(id);
    }

    @PostMapping	//Questo metodo gestisce la creazione di un nuovo Cliente
    public Cliente create(@RequestBody Cliente Cliente) 
	{
        return service.create(Cliente);
    }

    @DeleteMapping("/{id}")	//Questo metodo gestisce la cancellazione di un Cliente specifico
    public void delete(@PathVariable Long id) 
	{
        service.delete(id);
    }
}
