package com.terminal.terminal.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.terminal.terminal.Entities.Fornitore;
import com.terminal.terminal.Services.FornitoreService;

import java.util.List;
import java.util.Optional;


@RestController //dico: questa classe è un controller REST e i metodi restituiranno auto la risposta come corpo della risposta HTTP
@RequestMapping("/api/fornitore") //tutte le richieste HTTP per gestire i fornitori avranno come prefisso /api/fornitore
public class FornitoreController 
{
	@Autowired 
	private FornitoreService service; 

	@GetMapping	//Questo metodo gestisce la lettura di tutti i fornitori
    public List<Fornitore> getAll() 
	{
        return service.getAll();
    }

	//Il decoratore @PathVariable estrae i parametri dinamici dall'URL di una richiesta HTTP e passarli come argomenti del metodo
    @GetMapping("/{id}")	//Questo metodo gestisce la lettura di un fornitore specifico
    public Optional<Fornitore> getById(@PathVariable Long id) 	
	{
        return service.getById(id);
    }

    @PostMapping	//Questo metodo gestisce la creazione di una nuovo fornitore
    public Fornitore create(@RequestBody Fornitore fornitore) 
	{
        return service.create(fornitore);
    }

    @DeleteMapping("/{id}")	//Questo metodo gestisce la cancellazione di una fornitore specifico
    public void delete(@PathVariable Long id) 
	{
        service.delete(id);
    }
	
}
