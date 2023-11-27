package com.sparadrap.webapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Compose {
	
	@Id
	@ManyToOne
	@JoinColumn(name="Med_ID")
	private Ordonnance Ordonnance;
	
	@Id
	@ManyToOne
	@JoinColumn(name="Medi_ID")
	private Medicament Medicament;

	private int Compose_Qte;

}
