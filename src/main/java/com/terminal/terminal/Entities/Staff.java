package com.terminal.terminal.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Staff")
public class Staff 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "ruolo")
    @Enumerated(EnumType.STRING)
    private Lavoro lavoro;

	@OneToOne
    @Column(name = "id_user")
    @JoinColumn(name = "id_user", referencedColumnName = "id", unique = true, nullable = false)	
    private User user;
	
	public enum Lavoro 
	{
		OperatoreLogistica("Operatore Logistica"),
		Manutentore("Manutentore"),
		Coordinatore("Coordinatore"),
		Carrellista("Carrellista"),
		AddettoDocumentazione("Addetto alla Documentazione"),
		AddettoUfficioMerci("Addetto Ufficio Merci"),
		TecnicoSpedizioni("Tecnico delle Spedizioni"),
		TecnicoTrasporti("Tecnico dei Trasporti");

		private String nome;

		Lavoro(String nome) { this.nome = nome; }

		public String getNome(){ return nome; }
			
	}

	// Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Lavoro getLavoro() { return lavoro; }
    public void setLavoro(Lavoro lavoro) { this.lavoro = lavoro; }

    public User getUser() { return this.user; }
    public void setUser(User user) { this.user = user; }
	
}
