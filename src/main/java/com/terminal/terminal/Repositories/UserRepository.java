package com.terminal.terminal.Repositories;

import com.terminal.terminal.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> 
{
    //JPA riconosce dal nome del metodo che deve fare una query per trovare l'utente con quel nome
    Optional<User> findByUsername(String username); 
    
    //Il decoratore @Query permette di scrivere una query personalizzata senza scrivere codice!
    //In questo caso, stiamo cercando un utente con un nome utente e una email specifici
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.email = :email")
    Optional<User> findByUsernameAndEmail(@Param("username") String username, @Param("email") String email);
}
