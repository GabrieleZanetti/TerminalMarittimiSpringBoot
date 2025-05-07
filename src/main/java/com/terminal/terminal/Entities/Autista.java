package com.terminal.terminal.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "autista")
public class Autista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToOne	//La relazione è uno a uno
    @JoinColumn(name = "id_user", referencedColumnName = "id", unique = true, nullable = false)	//FK del campo id_user che va sull'id del tipo dell'oggetto User, unique e !nullable
    private User user;

    // Getter e Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}