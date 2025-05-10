package com.terminal.terminal.Controllers;

import com.terminal.terminal.Entities.Viaggio;
import com.terminal.terminal.Services.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController //dico: questa classe è un controller REST e i metodi restituiranno auto la risposta come corpo della risposta HTTP
@RequestMapping("/api/viaggio") //tutte le richieste HTTP per gestire gli utenti avranno come prefisso /api/viaggio
public class ViaggioController 
{
    @Autowired
    private ViaggioService service;

    @GetMapping	//Questo metodo gestisce la lettura di tutti i viaggi
    public List<Viaggio> getAll() 
	{
        return service.getAll();
    }

    @GetMapping("/{id}/nave")
    public Optional<Viaggio> getBy(@PathVariable Long id)
    {
        return service.findByNaveId(id);
    }

    @GetMapping("/{id}/partenza")
    public Optional<Viaggio> getByPortoPartenza(@PathVariable Long id)
    {
        return service.findByPortoPartenzaId(id);
    }

	 @GetMapping("/{id}/arrivo")
    public Optional<Viaggio> getByPortoArrivo(@PathVariable Long id)
    {
        return service.findByPortoArrivoId(id);
    }

	//Il decoratore @PathVariable estrae i parametri dinamici dall'URL di una richiesta HTTP e passarli come argomenti del metodo
    @GetMapping("/{id}")	//Questo metodo gestisce la lettura di un viaggio specifico
    public Optional<Viaggio> getById(@PathVariable Long id) 	
	{
        return service.getById(id);
    }

    @PostMapping	//Questo metodo gestisce la creazione di un nuovo utente
    public Viaggio create(@RequestBody Viaggio Viaggio) 
	{
        return service.create(Viaggio);
    }

    @DeleteMapping("/{id}")	//Questo metodo gestisce la cancellazione di un utente specifico
    public void delete(@PathVariable Long id) 
	{
        service.delete(id);
    }
}
