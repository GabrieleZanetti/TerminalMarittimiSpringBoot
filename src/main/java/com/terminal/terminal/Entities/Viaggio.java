package com.terminal.terminal.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "viaggio")
public class Viaggio 
{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-incrementa l'ID nel DB
    private Long id;

	@Column(name = "data_partenza")
    private String dataPartenza;

	@Column(name = "data_allibramento")
    private String dataAllibramento;

	@Column(name = "linea")
    private String linea;

	@Column(name = "porto_partenza")
    private Porto portoPartenza;

	@Column(name = "porto_arrivo")
    private Porto portoArrivo;

	@ManyToOne
	@Column(name = "id_nave")
	@JoinColumn(name = "id_nave", referencedColumnName = "id", nullable = false)
    private Nave nave;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getDataPartenza() { return dataPartenza; }
    public void setDataPartenza (String dataPartenza) { this.dataPartenza = dataPartenza; }
    
    public String getDataAllibramento() { return dataAllibramento; }
    public void setDataAllibramento(String dataAllibramento) { this.dataAllibramento = dataAllibramento; }
    
    public String getLinea() { return linea; }
    public void setLinea(String linea) { this.linea = linea; }
    
    public Porto getPortoPartenza() { return portoPartenza; }
    public void setPortoPartenza(Porto portoPartenza) { this.portoPartenza = portoPartenza; }
    
    public Porto getPortoArrivo() { return portoArrivo; }
    public void setPortoArrivo(Porto portoArrivo) { this.portoArrivo = portoArrivo; }
    
    public Nave getNave() { return nave; }
    public void setNave(Nave nave) { this.nave = nave; }
}
