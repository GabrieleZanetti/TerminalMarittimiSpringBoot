package com.terminal.terminal.Controllers;

import com.terminal.terminal.Entities.Nave;
import com.terminal.terminal.Services.NaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController //dico: questa classe è un controller REST e i metodi restituiranno auto la risposta come corpo della risposta HTTP
@RequestMapping("/api/nave") //tutte le richieste HTTP per gestire gli utenti avranno come prefisso /api/nave
public class NaveController 
{
	@Autowired
	private NaveService service;

	@GetMapping	//Questo metodo gestisce la lettura di tutti le navi
    public List<Nave> getAll() 
	{
        return service.getAll();
    }

	//Il decoratore @PathVariable estrae i parametri dinamici dall'URL di una richiesta HTTP e passarli come argomenti del metodo
    @GetMapping("/{id}")	//Questo metodo gestisce la lettura di una nave specifica
    public Optional<Nave> getById(@PathVariable Long id) 	
	{
        return service.getById(id);
    }

    @PostMapping	//Questo metodo gestisce la creazione di una nuova nave
    public Nave create(@RequestBody Nave nave) 
	{
        return service.create(nave);
    }

    @DeleteMapping("/{id}")	//Questo metodo gestisce la cancellazione di una nave specifica
    public void delete(@PathVariable Long id) 
	{
        service.delete(id);
    }
}
