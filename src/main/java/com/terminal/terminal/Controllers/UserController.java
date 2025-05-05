package com.terminal.terminal.Controllers;

import com.terminal.terminal.Entities.User;
import com.terminal.terminal.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController //dico: questa classe è un controller REST e i metodi restituiranno auto la risposta come corpo della risposta HTTP
@RequestMapping("/api/users") //tutte le richieste HTTP per gestire gli utenti avranno come prefisso /api/users
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping	//Questo metodo gestisce la lettura di tutti gli utenti
    public List<User> getAll() 
	{
        return service.getAll();
    }

	//Il decoratore @PathVariable estrae i parametri dinamici dall'URL di una richiesta HTTP e passarli come argomenti del metodo
    @GetMapping("/{id}")	//Questo metodo gestisce la lettura di un utente specifico
    public Optional<User> getById(@PathVariable Long id) 	
	{
        return service.getById(id);
    }

    @PostMapping	//Questo metodo gestisce la creazione di un nuovo utente
    public User create(@RequestBody User user) 
	{
        return service.create(user);
    }

    @DeleteMapping("/{id}")	//Questo metodo gestisce la cancellazione di un utente specifico
    public void delete(@PathVariable Long id) 
	{
        service.delete(id);
    }
}
