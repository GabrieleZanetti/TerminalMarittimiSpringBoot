package com.terminal.terminal.Services;

import com.terminal.terminal.Entities.User;
import com.terminal.terminal.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService 
{
    @Autowired	//Skippo il costruttore e crea un'istanza di UserRepository automaticamente
    private UserRepository repo;

    public List<User> getAll() 
	{
        return repo.findAll();
    }

    public Optional<User> getById(Long id) 
	{
        return repo.findById(id);
    }

    public User create(User user) 
	{
        return repo.save(user);
    }

    public void delete(Long id) 
	{
        repo.deleteById(id);
    }

    public Optional<User> findByUsername(String username) 
	{
        return repo.findByUsername(username);
    }

	public Optional<User> findByUsernameAndEmail(String username, String email) 
	{
        return repo.findByUsernameAndEmail(username,email);
    }
}
