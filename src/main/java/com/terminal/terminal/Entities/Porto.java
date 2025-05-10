package com.terminal.terminal.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "porto")
public class Porto 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "nazione")
    private String nazione;

   //Getter e Setter
   public Long getId() { return id; }
   public void setId(Long id) { this.id = id; }

   public String getNome() { return nome; }
   public void setNome(String nome) { this.nome = nome; }

   public String getNazione() { return nazione; }
   public void setNazione(String nazione) { this.nazione = nazione; }
}
