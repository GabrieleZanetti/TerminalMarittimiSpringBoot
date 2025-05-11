package com.terminal.terminal.Controllers;

import com.terminal.terminal.Entities.Polizza;
import com.terminal.terminal.Services.PolizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController //dico: questa classe è un controller REST e i metodi restituiranno auto la risposta come corpo della risposta HTTP
@RequestMapping("/api/polizza") //tutte le richieste HTTP per gestire le polizze avranno come prefisso /api/polizza
public class PolizzaController 
{
	@Autowired
	private PolizzaService service;

	@GetMapping	//Questo metodo gestisce la lettura di tutte le polizze
	public List<Polizza> getAll() 
	{
		return service.getAll();
	}

	@GetMapping("/porto_partenza/{id}")	
	public Optional<Polizza> getByPortoPartenza(@PathVariable Long id) 
	{
		return service.findByPortoPartenzaId(id);
	}

	@GetMapping("/porto_arrivo/{id}")
	public Optional<Polizza> getByPortoArrivo(@PathVariable Long id) 
	{
		return service.findByPortoArrivoId(id);
	}
	
	//Il decoratore @PathVariable estrae i parametri dinamici dall'URL di una richiesta HTTP e passarli come argomenti del metodo
    @GetMapping("/{id}")	//Questo metodo gestisce la lettura di una polizza specifica
    public Optional<Polizza> getById(@PathVariable Long id) 	
	{
        return service.getById(id);
    }

    @PostMapping	//Questo metodo gestisce la creazione di una nuova polizza
    public Polizza create(@RequestBody Polizza polizza) 
	{
        return service.create(polizza);
    }

    @DeleteMapping("/{id}")	//Questo metodo gestisce la cancellazione di una polizza specifica
    public void delete(@PathVariable Long id) 
	{
        service.delete(id);
    }
}
