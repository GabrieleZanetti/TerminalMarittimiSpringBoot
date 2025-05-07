package com.terminal.terminal.Entities;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "fornitore")
public class Fornitore 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-incrementa l'ID nel DB
	private Long id;

	private String nome;
	private int giorni_gratis;
	@Column(name = "tariffa", precision = 10, scale = 2) //Definisco la colonna tariffa come DECIMAL(10,2)
	private BigDecimal tariffa; //Utilizzo BigDecimal per gestire i numeri decimali in modo preciso

	//Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getGiorniGratis() { return giorni_gratis; }
    public void setGiorniGratis(int giorni_gratis) { this.giorni_gratis = giorni_gratis; }

    public BigDecimal getTariffa() { return tariffa; }
    public void setTariffa(BigDecimal tariffa) { this.tariffa = tariffa; }
}

