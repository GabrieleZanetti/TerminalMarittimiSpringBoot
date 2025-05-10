package com.terminal.terminal.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "nave")
public class Nave 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-incrementa l'ID nel DB
    private Long id;

	@Column(name = "nome")
	private String nome;

	//Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
 
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
 
}
