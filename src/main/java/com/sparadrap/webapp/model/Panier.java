package com.sparadrap.webapp.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Panier {
	
	private Achat Achat;
    private Medicament Medicament;
    private int Panier_Qte;
	
}
