package com.terminal.terminal.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.terminal.terminal.Entities.Buono;
import com.terminal.terminal.Services.BuonoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/buono")
public class BuonoController 
{
	@Autowired 
	private BuonoService service; 

	@GetMapping	//Questo metodo gestisce la lettura di tutti i Buono
    public List<Buono> getAll() 
	{
        return service.getAll();
    }

	@GetMapping("/polizza/{id}")
	public Optional<Buono> getByPolizzaId(@PathVariable Long id) 
	{
		return service.findByPolizzaId(id);
	}

	@GetMapping("/cliente/{id}")
	public Optional<Buono> getByClienteId(@PathVariable Long id) 
	{
		return service.findByClienteId(id);
	}

	//Il decoratore @PathVariable estrae i parametri dinamici dall'URL di una richiesta HTTP e passarli come argomenti del metodo
    @GetMapping("/{id}")	//Questo metodo gestisce la lettura di un buono specifico
    public Optional<Buono> getById(@PathVariable Long id) 	
	{
        return service.getById(id);
    }

    @PostMapping	//Questo metodo gestisce la creazione di un nuovo buono
    public Buono create(@RequestBody Buono buono) 
	{
        return service.create(buono);
    }

    @DeleteMapping("/{id}")	//Questo metodo gestisce la cancellazione di un buono specifico
    public void delete(@PathVariable Long id) 
	{
        service.delete(id);
    }
}
