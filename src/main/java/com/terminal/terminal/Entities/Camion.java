package com.terminal.terminal.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "camion")
public class Camion 
{

    @Id
    private String targa;

    @OneToOne
    @JoinColumn(name = "id_autista", referencedColumnName = "id", unique = true, nullable = false)
    private Autista autista;

    // Getter e Setter
    public String getTarga() { return targa; }
    public void setTarga(String targa) { this.targa = targa; }

    public Autista getAutista() { return autista; }
    public void setAutista(Autista autista) { this.autista = autista; }
}
