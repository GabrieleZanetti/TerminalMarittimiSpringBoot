package com.terminal.terminal.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "polizza")
public class Polizza 
{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "tipo_merce")
	private String tipoMerce;

	@Column(name = "peso_tot")
	private Double pesoTot;

	@OneToOne
	@JoinColumn(name = "porto_carico", referencedColumnName = "id", nullable = false)
	private Porto portoCarico;

	@OneToOne
	@JoinColumn(name = "porto_destinazione", referencedColumnName = "id", nullable = false)
	private Porto portoDestinazione;

	@OneToOne
	@JoinColumn(name = "id_fornitore", referencedColumnName = "id", nullable = false)
	private Fornitore fornitore;

	@OneToOne
	@JoinColumn(name = "id_viaggio", referencedColumnName = "id", nullable = false)
	private Viaggio viaggio;

    // Getter e Setter
    private Long getId() { return id; }
	private void setId(Long id) { this.id = id; }

	public String getTipoMerce() { return tipoMerce; }
	public void setTipoMerce(String tipoMerce) { this.tipoMerce = tipoMerce; }

	public Double getPesoTot() { return pesoTot; }
	public void setPesoTot(Double pesoTot) { this.pesoTot = pesoTot; }

	public Porto getPortoCarico() { return portoCarico; }
	public void setPortoCarico(Porto portoCarico) { this.portoCarico = portoCarico; }

	public Porto getPortoDestinazione() { return portoDestinazione; }
	public void setPortoDestinazione(Porto portoDestinazione) { this.portoDestinazione = portoDestinazione; }

	public Fornitore getFornitore() { return fornitore; }
	public void setFornitore(Fornitore fornitore) { this.fornitore = fornitore; }

	public Viaggio getViaggio() { return viaggio; }
	public void setViaggio(Viaggio viaggio) { this.viaggio = viaggio; }
}