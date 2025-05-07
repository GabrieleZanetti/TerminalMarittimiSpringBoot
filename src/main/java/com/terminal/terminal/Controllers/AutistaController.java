package com.terminal.terminal.Controllers;

import com.terminal.terminal.Entities.Autista;
import com.terminal.terminal.Services.AutistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController //dico: questa classe è un controller REST e i metodi restituiranno auto la risposta come corpo della risposta HTTP
@RequestMapping("/api/autista") //tutte le richieste HTTP per gestire gli autisti avranno come prefisso /api/autista
public class AutistaController 
{
	@Autowired
	private AutistaService service;

	@GetMapping	//Questo metodo gestisce la lettura di tutti gli autisti
	public List<Autista> getAll() 
	{
		return service.getAll();
	}

	
	//Il decoratore @PathVariable estrae i parametri dinamici dall'URL di una richiesta HTTP e passarli come argomenti del metodo
    @GetMapping("/{id}")	//Questo metodo gestisce la lettura di un autista specifico
    public Optional<Autista> getById(@PathVariable Long id) 	
	{
        return service.getById(id);
    }

    @PostMapping	//Questo metodo gestisce la creazione di un nuovo autista
    public Autista create(@RequestBody Autista autista) 
	{
        return service.create(autista);
    }

    @DeleteMapping("/{id}")	//Questo metodo gestisce la cancellazione di un autista specifico
    public void delete(@PathVariable Long id) 
	{
        service.delete(id);
    }
}
