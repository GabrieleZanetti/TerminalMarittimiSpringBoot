package com.terminal.terminal.Controllers;

import com.terminal.terminal.Entities.Ritiro;
import com.terminal.terminal.Services.RitiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ritiro")
public class RitiroController 
{
	@Autowired
	private RitiroService service;

	@GetMapping	//Questo metodo gestisce la lettura di tutti i ritiri
	public List<Ritiro> getAll() 
	{
		return service.getAll();
	}


    @GetMapping("/camion/{targa}")	//Questo metodo gestisce la lettura di un ritiro data la trga del camion
    public Optional<Ritiro> getByCamionTarga(@PathVariable String targa) 	
    {
        return service.getByCamionTarga(targa);
    }

    @GetMapping("/autista/{id}")	//Questo metodo gestisce la lettura di un ritiro dato l'autista
    public Optional<Ritiro> getByAutistaId(@PathVariable Long id) 	
    {
        return service.getByAutistaId(id);
    }

    @GetMapping("/buono/{id}")	//Questo metodo gestisce la lettura di un ritiro dato il buono
    public Optional<Ritiro> getByBuonoId(@PathVariable Long id) 	
    {
        return service.getByBuonoId(id);
    }

	
	//Il decoratore @PathVariable estrae i parametri dinamici dall'URL di una richiesta HTTP e passarli come argomenti del metodo
    @GetMapping("/{id}")	//Questo metodo gestisce la lettura di un ritiro specifico
    public Optional<Ritiro> getById(@PathVariable Long id) 	
	{
        return service.getById(id);
    }

    @PostMapping	//Questo metodo gestisce la creazione di un nuovo ritiro
    public Ritiro create(@RequestBody Ritiro Ritiro) 
	{
        return service.create(Ritiro);
    }

    @DeleteMapping("/{id}")	//Questo metodo gestisce la cancellazione di un ritiro specifico
    public void delete(@PathVariable Long id) 
	{
        service.delete(id);
    }
}
