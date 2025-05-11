package com.terminal.terminal.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "buono")
public class Buono 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "id_polizza", referencedColumnName = "id", nullable = false)
	private Polizza polizza;

	@OneToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
	private Cliente cliente;

	// Getters e Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public Polizza getPolizza() { return polizza; }
	public void setPolizza(Polizza polizza) { this.polizza = polizza; }

	public Cliente getCliente() { return cliente; }
	public void setCliente(Cliente cliente) { this.cliente = cliente; }
}

/*ALTER TABLE `buono`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `id_polizza` (`id_polizza`),
  ADD KEY `id_cliente` (`id_cliente`); 
  */
