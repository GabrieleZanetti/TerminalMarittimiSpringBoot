package com.terminal.terminal.Controllers;

import com.terminal.terminal.Entities.Porto;
import com.terminal.terminal.Services.PortoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController //dico: questa classe è un controller REST e i metodi restituiranno auto la risposta come corpo della risposta HTTP
@RequestMapping("/api/porto") //tutte le richieste HTTP per gestire i porti avranno come prefisso /api/porto
public class PortoController 
{
	@Autowired
	private PortoService service;

	@GetMapping	//Questo metodo gestisce la lettura di tutti gli autisti
	public List<Porto> getAll() 
	{
		return service.getAll();
	}

	
	//Il decoratore @PathVariable estrae i parametri dinamici dall'URL di una richiesta HTTP e passarli come argomenti del metodo
    @GetMapping("/{id}")	//Questo metodo gestisce la lettura di un porto specifico
    public Optional<Porto> getById(@PathVariable Long id) 	
	{
        return service.getById(id);
    }

    @PostMapping	//Questo metodo gestisce la creazione di un nuovo porto
    public Porto create(@RequestBody Porto porto) 
	{
        return service.create(porto);
    }

    @DeleteMapping("/{id}")	//Questo metodo gestisce la cancellazione di un porto specifico
    public void delete(@PathVariable Long id) 
	{
        service.delete(id);
    }
}
