package com.sparadrap.webapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Panier {
	
	@Id
	@ManyToOne
	@JoinColumn(name="Achat_ID")
	private Achat Achat;
	
	@Id
	@ManyToOne
	@JoinColumn(name="Medi_ID")
    private Medicament Medicament;
    
    private int Panier_Qte;
	
}
