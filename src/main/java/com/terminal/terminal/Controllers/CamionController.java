package com.terminal.terminal.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.terminal.terminal.Entities.Camion;
import com.terminal.terminal.Services.CamionService;

import java.util.List;
import java.util.Optional;


@RestController //dico: questa classe è un controller REST e i metodi restituiranno auto la risposta come corpo della risposta HTTP
@RequestMapping("/api/camion") //tutte le richieste HTTP per gestire i camion avranno come prefisso /api/Camion
public class CamionController 
{
	@Autowired 
	private CamionService service; 

	@GetMapping	//Questo metodo gestisce la lettura di tutti i fornitori
    public List<Camion> getAll() 
	{
        return service.getAll();
    }

	//Il decoratore @PathVariable estrae i parametri dinamici dall'URL di una richiesta HTTP e passarli come argomenti del metodo
    @GetMapping("/{id}")	//Questo metodo gestisce la lettura di un camion specifico
    public Optional<Camion> getById(@PathVariable String targa) 	
	{
        return service.getById(targa);
    }

    @PostMapping	//Questo metodo gestisce la creazione di una nuovo camion
    public Camion create(@RequestBody Camion camion) 
	{
        return service.create(camion);
    }

    @DeleteMapping("/{id}")	//Questo metodo gestisce la cancellazione di una camion specifico
    public void delete(@PathVariable String targa) 
	{
        service.delete(targa);
    }
	
}
