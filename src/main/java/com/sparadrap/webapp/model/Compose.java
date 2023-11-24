package com.sparadrap.webapp.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Compose {
	
	private Ordonnance Ordonnance;
	
	private Medicament Medicament;

	private int Compose_Qte;

}
