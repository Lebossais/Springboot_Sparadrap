package com.sparadrap.webapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Panier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Panier_ID;

	@ManyToOne
	@JoinColumn(name="Achat_ID")
	private Achat Achat;

	@ManyToOne
	@JoinColumn(name="Medi_ID")
    private Medicament Medicament;
    
    private int Panier_Qte;
	
}
