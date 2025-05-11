package com.terminal.terminal.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ritiro")
public class Ritiro 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "id_buono", referencedColumnName = "ID", nullable = false)
	private Buono buono;

	@OneToOne
	@JoinColumn(name = "targa_camion", referencedColumnName = "targa", nullable = false)
	private Camion camion;

	@OneToOne
	@JoinColumn(name = "id_autista", referencedColumnName = "ID", nullable = false)
	private Autista autista;

	//Getters e Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public Buono getBuono() { return buono; }
	public void setBuono(Buono buono) { this.buono = buono; }

	public Camion getCamion() { return camion; }
	public void setCamion(Camion camion) { this.camion = camion; }

	public Autista getAutista() { return autista; }
	public void setAutista(Autista autista) { this.autista = autista; }

	//Metodo che valida che il camion e l'autista sono lo stesso
	public boolean validaAutista() 
	{
		return autista.getId() == camion.getAutista().getId();
	}

}

/*
ALTER TABLE `ritiro`
ADD PRIMARY KEY (`ID`),
ADD KEY `id_buono` (`id_buono`),
ADD KEY `targa_camion` (`targa_camion`),
ADD KEY `id_autista` (`id_autista`); 
 */