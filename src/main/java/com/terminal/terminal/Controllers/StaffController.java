package com.terminal.terminal.Controllers;

import com.terminal.terminal.Entities.Staff;
import com.terminal.terminal.Services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController //dico: questa classe è un controller REST e i metodi restituiranno auto la risposta come corpo della risposta HTTP
@RequestMapping("/api/staff") //tutte le richieste HTTP per gestire lo staff avranno come prefisso /api/staff
public class StaffController 
{
	@Autowired
	private StaffService service;

	@GetMapping	//Questo metodo gestisce la lettura di tutti i membri dello staff
	public List<Staff> getAll() 
	{
		return service.getAll();
	}

    @GetMapping("/{id}/user")
    public Optional<Staff> getByUserId(@PathVariable Long id)
    {
        return service.findByUserId(id);
    }
    
	//Il decoratore @PathVariable estrae i parametri dinamici dall'URL di una richiesta HTTP e passarli come argomenti del metodo
    @GetMapping("/{id}")	//Questo metodo gestisce la lettura di uno staff specifico
    public Optional<Staff> getById(@PathVariable Long id) 	
	{
        return service.getById(id);
    }

    @PostMapping	//Questo metodo gestisce la creazione di un nuovo membro dello staff
    public Staff create(@RequestBody Staff Staff) 
	{
        return service.create(Staff);
    }

    @DeleteMapping("/{id}")	//Questo metodo gestisce la cancellazione di un membro dello staff specifico
    public void delete(@PathVariable Long id) 
	{
        service.delete(id);
    }
}
